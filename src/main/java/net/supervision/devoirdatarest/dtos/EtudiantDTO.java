package net.supervision.devoirdatarest.dtos;

import net.supervision.devoirdatarest.enums.Genre;

//record est une classe qui fournit automatiquement les getters (sans setter) et constructeur par defaut
public record EtudiantDTO (
     String nom,
     String prenom,
     Genre genre,
     Long centreId
)
{}
