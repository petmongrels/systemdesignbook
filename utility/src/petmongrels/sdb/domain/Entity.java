package petmongrels.sdb.domain;

public class Entity implements Identifiable {
    long id;

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }
}
