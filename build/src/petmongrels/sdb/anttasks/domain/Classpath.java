package petmongrels.sdb.anttasks.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classpath {
    List<ClasspathElement> classpathElements = new ArrayList<ClasspathElement>();

    public Classpath(ClasspathElement ... elements) {
        classpathElements.addAll(Arrays.asList(elements));
    }

    public Classpath append(Module module, String type) {
        classpathElements.add(new ClasspathElement(type, module.name()));
        return this;
    }

    public Classpath append(Classpath classpath) {
        classpathElements.addAll(classpath.classpathElements);
        return this;
    }

    public boolean contains(String type, String moduleName) {
        return classpathElements.contains(new ClasspathElement(type, moduleName));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ClasspathElement classpathElement : classpathElements)
            builder.append(classpathElement.toString());
        return builder.toString();
    }
}
