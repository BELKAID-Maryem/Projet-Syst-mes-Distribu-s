package com.example.emplacementservice.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Emplacement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmplacement;
    String nomEmplacement;
}
