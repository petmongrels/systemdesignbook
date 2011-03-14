package petmongrels.sdb.anttasks;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;

import java.util.*;

public class CallForModuleTask extends Task {
    String module;

    public void setName(String module) {
        this.module = module;
    }

    @Override
    public void execute() throws BuildException {
        super.execute();
        Hashtable allTargets = getProject().getTargets();
        Target target = (Target) allTargets.get(module);
        Enumeration dependencies = target.getDependencies();
        while(dependencies.hasMoreElements()) {
            String dependency = (String) dependencies.nextElement();
            Target owningTarget = getOwningTarget();
            String targetToExecute = String.format("%s.%s.%s", dependency, owningTarget.toString(), dependency);
            getProject().executeTarget(targetToExecute);
        }
    }
}
