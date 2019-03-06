package com.company;

public class MauvaisNumeroDActivite extends Exception {
    private int mauvaisNumero;
    private int numeroEffectif;

    public MauvaisNumeroDActivite(int mauvaisNumero, int numeroEffectif) {
        this.mauvaisNumero = mauvaisNumero;
        this.numeroEffectif = numeroEffectif;
    }

    @Override
    public String getMessage(){
        String content = "";
        if (mauvaisNumero < 0){
            content += "Vous avez entré un nombre inférieur à 0";
        } else {
            content += "Vous avez entré: " + this.mauvaisNumero + ", or le nombre d'activités de cet étudiant est de " + this.numeroEffectif;
        }

        return content;
    }
}
