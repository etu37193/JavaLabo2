package com.company.Exception;

public class SectionException extends Exception {
    private String section;

    public SectionException(String section){
        this.section = section;
    }

    @Override
    public String getMessage(){
        return this.section  + " n'existe pas";
    }
}
