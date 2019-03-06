package com.company;
import com.company.Exception.*;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Personne {
    private String nom;
    private String prenom;
    private char sexe;
    private GregorianCalendar dateNaissance;

    public Personne(String nom, String prenom, char sexe, int annee, int jour, int mois) throws DateException, Sexception{
        this.nom = nom;
        this.prenom = prenom;
        try {
            this.setDateNaissance(annee, jour, mois);
        }
        catch (DateException exception){
            throw exception;
        }
        try {
            this.setSexe(sexe);
        } catch (Sexception sexception){
            throw sexception;
        }
    }

    public void setDateNaissance(int annee, int jour, int mois) throws DateException {
        if(mois < 0 || mois > 11){
            throw new DateException(mois);
        } else {
            this.dateNaissance = new GregorianCalendar(annee, mois, jour);
        }
    }

    public void setSexe(char sexe) throws Sexception{
        if (Character.toLowerCase(sexe) != 'f' && Character.toLowerCase(sexe) != 'm'){
            throw new Sexception(sexe);
        } else {
            this.sexe = Character.toLowerCase(sexe);
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge(){
        GregorianCalendar mnt = new GregorianCalendar();

        int distance = mnt.get(Calendar.YEAR) - this.dateNaissance.get(Calendar.YEAR);
        if (mnt.get(Calendar.DAY_OF_YEAR) <= this.dateNaissance.get(Calendar.DAY_OF_YEAR)) {
            distance--;
        }
        return distance;

    }
    public char getSexe(){
        return this.sexe;
    }

    public String getDateNaissance() {
        return this.dateNaissance.get(GregorianCalendar.DATE)+"/"+this.dateNaissance.get(GregorianCalendar.MONTH)+"/"+this.dateNaissance.get(GregorianCalendar.YEAR);
    }

    @Override
    public String toString() {
        return this.nom + " " + this.prenom + " (" + this.getAge() + " ans)";
    }
}
