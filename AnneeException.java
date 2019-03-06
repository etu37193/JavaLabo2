package com.company.Exception;

public class AnneeException extends Exception {
    private int annee;

    public AnneeException(int annee){
        this.annee = annee;
    }

    @Override
    public String getMessage(){
        return "L'année doit être comprise entre 1 et 3. Votre entrée : " + this.annee;
    }
}
