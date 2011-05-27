package petmongrels.sdb.loan.domain;

import petmongrels.sdb.domain.Entity;

public class Fund extends Entity {
    String name;

    public String name() {
        return name;
    }

    public Fund name(String name) {
        this.name = name;
        return this;
    }
}
