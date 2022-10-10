package com.example.emplacementservice.Repository;

import com.example.emplacementservice.entitie.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface EmplacementRepository extends JpaRepository<Emplacement,Long> {
    @RestResource(path = "/emplacementByNomEmplacement")
    Emplacement findEmplacementByNomEmplacement(String nomEmplacement);
}
