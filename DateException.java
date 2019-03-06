package com.company.Exception;

public class DateException extends Exception{
    private int mois;

    public DateException(int mois){
        this.mois = mois;
    }

    @Override
    public String getMessage(){
        return "Le mois doit être compris entre 0 et 11 et vous avez entré " + this.mois;
    }
}
