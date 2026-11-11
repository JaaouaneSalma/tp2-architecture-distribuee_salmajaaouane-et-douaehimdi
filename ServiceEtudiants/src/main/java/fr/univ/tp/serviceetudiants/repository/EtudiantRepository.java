package fr.univ.tp.serviceetudiants.repository;

import fr.univ.tp.serviceetudiants.model.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EtudiantRepository {

    private final Map<Integer, Etudiant> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public List<Etudiant> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Etudiant> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    public Etudiant save(Etudiant e) {
        if (e.getId() == null) {
            e.setId(seq.getAndIncrement());
        }
        store.put(e.getId(), e);
        return e;
    }

    public boolean existsById(int id) {
        return store.containsKey(id);
    }

    public void delete(int id) {
        store.remove(id);
    }
}