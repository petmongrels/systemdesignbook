package petmongrels.sdb.domain;

import java.util.ArrayList;
import java.util.List;

public class Identities<E> {
    List<Long> data;

    public Identities(List<E> identifiables) {
        data = new ArrayList<Long>();
        for(E e : identifiables)
            data.add(((Identifiable) e).getId());
    }

    public boolean contains(Identities<E> identities) {
        return data.containsAll(identities.data);
    }
}
