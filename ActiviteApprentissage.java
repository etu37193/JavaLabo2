package com.company;
import com.company.Exception.*;

public class ActiviteApprentissage {
    private String libelle;
    private Personne professeur;

    public ActiviteApprentissage(String libelle, Personne professeur) {
        this.libelle = libelle;
        this.professeur = professeur;
    }

    public Personne getProfesseur(){
        return this.professeur;
    }

    @Override
    public String toString(){
        return "L'activité d'apprentissage " + this.libelle + " donnée par " + this.professeur;
    }
}
