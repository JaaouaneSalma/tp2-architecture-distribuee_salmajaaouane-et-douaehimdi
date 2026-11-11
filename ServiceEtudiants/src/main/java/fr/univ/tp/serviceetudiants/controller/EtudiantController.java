package fr.univ.tp.serviceetudiants.controller;

import fr.univ.tp.serviceetudiants.model.Etudiant;
import fr.univ.tp.serviceetudiants.repository.EtudiantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantRepository repo;

    public EtudiantController(EtudiantRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Etudiant> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Etudiant get(@PathVariable int id) {
        return repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant non trouvé"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Etudiant create(@RequestBody Etudiant e) {
        e.setId(null); // l'id est toujours généré par le serveur
        return repo.save(e);
    }

    @PutMapping("/{id}")
    public Etudiant update(@PathVariable int id, @RequestBody Etudiant e) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant non trouvé");
        }
        e.setId(id);
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.delete(id);
    }
}