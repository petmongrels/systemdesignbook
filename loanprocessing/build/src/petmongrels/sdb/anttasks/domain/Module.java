package petmongrels.sdb.anttasks.domain;

import java.util.*;

public class Module {
    String name;
    List<Module> dependentModules = new ArrayList<Module>();

    public Module(String name, Dependencies dependencies) {
        this.name = name;
        ArrayList<String> list = toList(dependencies.of(name));
        for (String target : list) {
            if (target.startsWith("-")) continue;
            this.dependentModules.add(new Module(target, dependencies));
        }
    }

    private ArrayList<String> toList(Vector dependencies) {
        ArrayList<String> list = new ArrayList<String>();
        for (Object obj : dependencies) {
            list.add(obj.toString());
        }
        return list;
    }

    public List<Module> dependencies() {
        return dependentModules;
    }

    public Dictionary<String, Classpath> getClassPathsFor(BuildTarget buildTarget) {
        Dictionary<String, Classpath> dictionary = new Hashtable<String, Classpath>();
        if (buildTarget.needsClasspath()) {
            dictionary.put(ClasspathNames.SOURCE, classpathForDependentModules("production"));
            dictionary.put(ClasspathNames.SUCCOR, dictionary.get(ClasspathNames.SOURCE).append(classpathForDependentModules("succor")).append(this, "production"));
            dictionary.put(ClasspathNames.TEST, dictionary.get(ClasspathNames.SUCCOR).append(this, "succor").append(this, "test"));
        }
        return dictionary;
    }

    private Classpath classpathForDependentModules(String type) {
        Classpath classpath = new Classpath();
        for (Module dependency : dependentModules) {
            classpath.append(dependency, type);
        }
        return classpath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (name != null ? !name.equals(module.name) : module.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }

    public String name() {
        return name;
    }
}
