package net.supervision.devoirdatarest.controller;

import net.supervision.devoirdatarest.dtos.EtudiantDTO;
import net.supervision.devoirdatarest.model.Centre;
import net.supervision.devoirdatarest.model.Etudiant;
import net.supervision.devoirdatarest.repository.CentreRepository;
import net.supervision.devoirdatarest.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private CentreRepository centreRepository;
    @QueryMapping
    public List<Etudiant> getEtudiants() {
        return etudiantRepository.findAll();
    }
    @QueryMapping
    public Etudiant getEtudiant(@Argument Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }
    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantDTO etudiantDTO) {
        Etudiant etudiant = new Etudiant();
        dtoToEtudiant.toEtudiant(etudiant,etudiantDTO);
        etudiantRepository.save(etudiant);
        return etudiant;
    }
    @MutationMapping
    public Etudiant updateEtudiant(@Argument Long id, @Argument EtudiantDTO etudiantDTO) {
        if (etudiantRepository.findById(id).isPresent()) {
            Etudiant etudiant = etudiantRepository.findById(id).get();
            dtoToEtudiant.toEtudiant(etudiant,etudiantDTO);
            return etudiantRepository.save(etudiant);
        }
        return null;
    }
    @MutationMapping
    public String deleteEtudiant(Long id){
        if(etudiantRepository.findById(id).isPresent()){
            Etudiant et=etudiantRepository.findById(id).get();
            etudiantRepository.deleteById(id);
            return String.format("l'étudiant %s est bien supprimé !",id);
        }
        return String.format("l'étudiant %s n'existe pas !",id);
    }

    public List<Centre> getAllCentres(){
        return centreRepository.findAll();
    }
    public Centre getCentreById(Long id){
        return centreRepository.findById(id).orElse(null);
    }




}

