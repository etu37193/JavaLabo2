package com.company.Exception;

public class Sexception extends Exception {
    private char sexe;

    public Sexception(char sexe){
        this.sexe = sexe;
    }

    @Override
    public String getMessage(){
        return "Le sexe doit être f,F ou m,M et pas " + this.sexe;
    }
}
