package petmongrels.sdb.anttasks.domain;

public class ClasspathElement {
    String moduleName;
    String type;

    public ClasspathElement(String type, String moduleName) {
        this.moduleName = moduleName;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("../out/%s/%s;", type, moduleName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClasspathElement that = (ClasspathElement) o;

        if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moduleName != null ? moduleName.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
