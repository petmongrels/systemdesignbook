package petmongrels.sdb.anttasks.domain;

public class BuildTarget {
    String name;

    public BuildTarget(String name) {
        this.name = name;
    }

    public String targetFor(Module module) {
        return String.format("%s.%s", module, name);
    }

    public boolean needsClasspath() {
        return name.equals("compile") || name.equals("test");
    }
}
