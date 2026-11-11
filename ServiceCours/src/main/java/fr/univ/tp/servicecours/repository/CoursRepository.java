package fr.univ.tp.servicecours.repository;

import fr.univ.tp.servicecours.model.Cours;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CoursRepository {

    private final Map<Integer, Cours> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public List<Cours> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Cours> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    public Cours save(Cours c) {
        if (c.getId() == null) {
            c.setId(seq.getAndIncrement());
        }
        store.put(c.getId(), c);
        return c;
    }

    public boolean existsById(int id) {
        return store.containsKey(id);
    }

    public void delete(int id) {
        store.remove(id);
    }
}