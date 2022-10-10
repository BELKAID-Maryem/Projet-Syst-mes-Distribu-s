package com.example.emplacementservice.web;

import com.example.emplacementservice.Repository.EmplacementRepository;
import com.example.emplacementservice.entitie.Emplacement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EmplacementController {
    private EmplacementRepository emplacementRepository;

    public EmplacementController(EmplacementRepository emplacementRepository) {
        this.emplacementRepository = emplacementRepository;
    }

    @GetMapping(path = "/emplacements")
    public List<Emplacement> getEmplacements(){
        return emplacementRepository.findAll();
    }

    @GetMapping(path = "/emplacements/{id}")
    public Emplacement getEmplacement(@PathVariable(name = "id") Long id){
        return emplacementRepository.findById(id).get();
    }

    @PostMapping(path = "/emplacements")
    public Emplacement addEmplacement(@RequestBody Emplacement emplacement){
        return emplacementRepository.save(emplacement);
    }

    @PutMapping(path = "/emplacements/{id}")
    public Emplacement updateEmplacement(@PathVariable(name = "id") Long id, @RequestBody Emplacement emplacement){
        emplacement.setIdEmplacement(id);
        return emplacementRepository.save(emplacement);
    }

    @GetMapping(path = "/getEmplacementByNomEmplacement/{nomEmplacement}")
    public Emplacement getEmplacementByNomEmplacement(@PathVariable(name = "nomEmplacement") String nomEmplacement){
        return emplacementRepository.findEmplacementByNomEmplacement(nomEmplacement);
    }

    @DeleteMapping(path = "/emplacements/{id}")
    public void deleteFamille(@PathVariable(name = "id") Long id){
        emplacementRepository.deleteById(id);
    }

}
