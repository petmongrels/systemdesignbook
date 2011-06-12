package petmongrels.sdb.anttasks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import petmongrels.sdb.anttasks.domain.*;

import java.util.Dictionary;
import java.util.Vector;

import static org.testng.Assert.assertEquals;

@Test
public class ModuleTest implements Dependencies {
    Module module;
    Vector dependentModules;

    @BeforeMethod
    public void setup() {
        dependentModules = new Vector();
        dependentModules.add("bar");
        dependentModules.add("baz");
        dependentModules.add("-quack");
        module = new Module("foo", this);
    }

    public void dependencies() {
        assertEquals(2, module.dependencies().size());
        assertEquals(false, module.dependencies().contains("-quack"));
    }

    public void getClassPathForCompileTarget() {
        Dictionary<String, Classpath> classpaths = module.getClassPathsFor(new BuildTarget("compile"));
        assertEquals(true, classpaths.get(ClasspathNames.SOURCE).contains("production", "bar"));

        assertEquals(true, classpaths.get(ClasspathNames.SUCCOR).contains("succor", "bar"));
        assertEquals(true, classpaths.get(ClasspathNames.SUCCOR).contains("production", "bar"));

        assertEquals(true, classpaths.get(ClasspathNames.TEST).contains("succor", "bar"));
        assertEquals(true, classpaths.get(ClasspathNames.TEST).contains("production", "baz"));
        assertEquals(true, classpaths.get(ClasspathNames.TEST).contains("test", "foo"));
        assertEquals(false, classpaths.get(ClasspathNames.TEST).contains("test", "bar"));
    }

    public void getClassPathForNonCompileTarget() {
        assertEquals(0, module.getClassPathsFor(new BuildTarget("config")).size());
    }

    public Vector of(String name) {
        return dependentModules;
    }
}