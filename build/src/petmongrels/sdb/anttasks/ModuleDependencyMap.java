package petmongrels.sdb.anttasks;

import java.util.HashMap;
import java.util.List;

public class ModuleDependencyMap {
    private HashMap<String, List<String>> dependencyMap = new HashMap<String, List<String>>();

    public void add(String dependent, List<String> dependeeModuleList) {
        dependencyMap.put(dependent, dependeeModuleList);
    }
}
