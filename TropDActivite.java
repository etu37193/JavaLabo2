package com.company.Exception;

public class TropDActivite extends Exception {
    public TropDActivite() {
    }

    @Override
    public String getMessage(){
        return "Le nombre d'activité max est déjà atteint";
    }
}
