package petmongrels.sdb.anttasks;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;

import java.util.Vector;

public class CallForModuleTask extends Task {
    String module;

    public void setName(String module) {
        this.module = module;
    }

    @Override
    public void execute() throws BuildException {
        super.execute();
        Vector vector = getDependencies(module);
        for(Object dependency : vector) {
            Target owningTarget = getOwningTarget();
            String targetToExecute = String.format("%s.%s", dependency, owningTarget.toString());
            if(owningTarget.toString().equals("compile")) defineClasspathProperty(dependency.toString());
            getProject().executeTarget(targetToExecute);
        }
    }

    private void defineClasspathProperty(String moduleName) {
        Vector dependencies = getDependencies(moduleName);
        StringBuilder builder = new StringBuilder();
        for(Object dependency : dependencies) {
            builder.append("../out/production/").append(dependency).append(";");
        }
        builder.append("../out/production/").append(moduleName);
        if(builder.length() != 0) {
            getProject().log("", Project.MSG_INFO);
            getProject().log("[call-for-module] dependent.source.classpath = " + builder.toString(), Project.MSG_INFO);
            getProject().setProperty("dependent.source.classpath", builder.toString());
        }
    }

    private Vector getDependencies(String name) {
        Project project = getProject();
        Vector vector = project.topoSort(name, project.getTargets(), false);
        vector.removeElementAt(vector.size() - 1);
        return vector;
    }
}
