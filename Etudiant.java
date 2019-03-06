package com.company;

import com.company.Exception.*;


public class Etudiant extends Personne{
    private int annee;
    private String section;
    private ActiviteApprentissage [] activites;
    private static int nbEtudiants = 0;
    private static double nbFilles = 0;
    private final int NB_ACTIVITE_MAX = 5;
    private int nbActi;

    public Etudiant(String nom, String prenom, char sexe, int annee, int jour, int mois, int annee1, String section) throws DateException, Sexception, AnneeException, SectionException {
        super(nom, prenom, sexe, annee, jour, mois);
        try{
            this.setAnnee(annee1);
            this.setSection(section);
            this.activites = new ActiviteApprentissage[NB_ACTIVITE_MAX];
            this.nbActi = 0;
            nbEtudiants++;
            if (this.getSexe() == 'f'){
                nbFilles++;
            }
        } catch(AnneeException anneeException){
            throw anneeException;
        } catch (SectionException sectionException) {
            throw sectionException;
        }
    }

    public void setAnnee(int annee) throws AnneeException{
        if (annee <= 0 || annee > 3){
            throw new AnneeException(annee);
        } else {
            this.annee = annee;
        }
    }

    public static int getNbEtudiants() {
        return nbEtudiants;
    }

    public static double getpctFilles() {
        return (nbFilles/getNbEtudiants())*100;
    }

    public void setSection(String section) throws SectionException{
        if(!section.equals("compta") && !section.equals("droit") && !section.equals("market") && !section.equals("infoGestion") && !section.equals("technoInfo")){
            throw new SectionException(section);
        } else {
            this.section = section;
        }
    }

    public String nomUtilisateur(){
        return this.section.substring(0,2) + this.annee + this.getNom() + this.getPrenom().substring(0,1);
    }

    @Override
    public String toString(){
        return super.toString() + " est " + ((this.getSexe() == 'f') ? "inscrite " : "inscrit ") + "en " + this.annee + "e " + this.section + "\nSon nom d'utilisateur est "  + this.nomUtilisateur();
    }

    public void ajouterActiviteApprentissage(ActiviteApprentissage activite) throws TropDActivite{
        if (this.nbActi == NB_ACTIVITE_MAX){
            throw new TropDActivite();
        } else {
            this.activites[nbActi] = activite;
            nbActi++;
        }
    }

    public ActiviteApprentissage getActivitesApprentissage(int index) throws MauvaisNumeroDActivite {
        if(index < 0 || index > nbActi){
            throw new MauvaisNumeroDActivite(index, this.nbActi);
        } else {
            return this.activites[index];
        }
    }
}
