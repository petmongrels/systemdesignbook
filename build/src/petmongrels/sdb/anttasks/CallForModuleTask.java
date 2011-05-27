package petmongrels.sdb.anttasks;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import petmongrels.sdb.anttasks.domain.BuildTarget;
import petmongrels.sdb.anttasks.domain.Classpath;
import petmongrels.sdb.anttasks.domain.Dependencies;
import petmongrels.sdb.anttasks.domain.Module;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Vector;

public class CallForModuleTask extends Task implements Dependencies {
    Module module;

    public void setName(String name) {
        this.module = new Module(name, this);
    }

    @Override
    public void execute() throws BuildException {
        super.execute();

        BuildTarget owningBuildTarget = new BuildTarget(getOwningTarget().toString());
        for (Module dependentModule : module.dependencies()) {
            Dictionary<String, Classpath> classpaths = dependentModule.getClassPathsFor(owningBuildTarget);
            setClasspathProperty(classpaths);
            getProject().executeTarget(owningBuildTarget.targetFor(dependentModule));
        }
    }

    private void setClasspathProperty(Dictionary<String, Classpath> classpaths) {
        Enumeration<String> keys = classpaths.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String propertyName = String.format("dependent.%s.classpath", key);
            getProject().log(String.format("[call-for-module] %s = %s", propertyName, classpaths.get(key)), Project.MSG_DEBUG);
            getProject().setProperty(propertyName, classpaths.get(key).toString());
        }
    }

    public Vector of(String name) {
        Project project = getProject();
        Vector vector = project.topoSort(name, project.getTargets(), false);
        vector.removeElementAt(vector.size() - 1);
        return vector;
    }
}
