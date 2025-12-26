package net.supervision.appresttemplate.controller;

import net.supervision.appresttemplate.services.ServiceEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/etudiants")
public class ControllerEtudiant {
    @Autowired
    private ServiceEtudiant serviceEtudiant;

    @GetMapping
    public List<Map<String, Object>> getAllEtudiants() {
        return serviceEtudiant.getAllEtudiants();
    }

    @GetMapping("/{p}")
    public Map<String, Object> getEtudiantById(@PathVariable("p") Integer id) {
        return serviceEtudiant.getEtudiantById(id);
    }

    @PostMapping
    public void addEtudiant(@RequestBody Map<String, Object> etudiant) {
        serviceEtudiant.addEtudiant(etudiant);
    }

    @PutMapping("/{p}")
    public String updateEtudiant(@PathVariable("p") Integer id, @RequestBody Map<String, Object> etudiant) {
        return serviceEtudiant.updateEtudiant(id, etudiant);
    }

    @DeleteMapping("/{p}")
    public String deleteEtudiant(@PathVariable("p") Integer id) {
        return serviceEtudiant.deleteEtudiant(id);
    }

    @GetMapping("/nom/{n}")
    public List<Map<String, Object>> getEtudiantsParNom(@PathVariable("n") String nom) {
        return serviceEtudiant.getEtudiantsByName(nom);
    }

    @GetMapping("/{p}/{s}/{t}") //http://localhost:8081/etudiants/0/2/nom,desc
    public List<Map<String, Object>> getEtudiants(@PathVariable("p") int page, @PathVariable("s") int size, @PathVariable("t") String sort) {
        return serviceEtudiant.getEtudiants(page, size, sort);
    }
}