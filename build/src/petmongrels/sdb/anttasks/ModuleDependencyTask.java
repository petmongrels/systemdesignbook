package petmongrels.sdb.anttasks;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import java.util.Arrays;
import java.util.List;

public class ModuleDependencyTask extends Task {
    String module;
    String commaSeparatedList = "";

    public void setModule(String module) {
        this.module = module;
    }

    public void setOn(String commaSeparatedList) {
        this.commaSeparatedList = commaSeparatedList;
    }

    @Override
    public void execute() throws BuildException {
        super.execute();
        String[] dependeeModules = commaSeparatedList.split(",");
        List<String> dependeeModuleList = Arrays.asList(dependeeModules);
        ObjectFactory.ModuleDependencyMap.add(module, dependeeModuleList);
        //resolve cyclic dependencies
    }
}
