package com.company;
import com.company.Exception.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws Sexception, DateException, TropDActivite, MauvaisNumeroDActivite{
        boolean continuer = true;
        Etudiant []etudiants = new Etudiant[10];

        while (continuer){
            try{
                Personne prof0 = new Personne("Leclerc", "Christophe", 'm', 1969, 20,5);
                Personne prof1 = new Personne("Pirotte", "Cécile", 'f', 1975, 12,5);
                Personne prof2 = new Personne("Dubisy", "Carole", 'f', 1959, 30,5);

                ActiviteApprentissage acti0 = new ActiviteApprentissage("Java", prof2);
                ActiviteApprentissage acti1 = new ActiviteApprentissage("Math", prof0);
                ActiviteApprentissage acti2 = new ActiviteApprentissage("C", prof1);

                Etudiant etu0 = new Etudiant("Michaux", "William", 'm', 1997,16,3, 2, "infoGestion");

                try{
                    etu0.ajouterActiviteApprentissage(acti0);
                    etu0.ajouterActiviteApprentissage(acti1);
                    etu0.ajouterActiviteApprentissage(acti2);
                } catch (TropDActivite tropDActivite){
                    JOptionPane.showMessageDialog(null, tropDActivite.getMessage(), "Section erronée", JOptionPane.ERROR_MESSAGE);
                }

                try{
                    System.out.println(etu0.getActivitesApprentissage(4));
                } catch (MauvaisNumeroDActivite mauvaisNumeroDActivite){
                    JOptionPane.showMessageDialog(null, mauvaisNumeroDActivite.getMessage(), "Section erronée", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SectionException sectionException) {
                JOptionPane.showMessageDialog(null, sectionException.getMessage(), "Section erronée", JOptionPane.ERROR_MESSAGE);
            } catch (Sexception sexception){
                JOptionPane.showMessageDialog(null, sexception.getMessage(), "Sexe erroné", JOptionPane.ERROR_MESSAGE);
            } catch (DateException dateException) {
                JOptionPane.showMessageDialog(null, dateException.getMessage(), "Date erronée", JOptionPane.ERROR_MESSAGE);
            } catch (AnneeException anneeException) {
                JOptionPane.showMessageDialog(null, anneeException.getMessage(), "Année erronée", JOptionPane.ERROR_MESSAGE);
            }
            /*finally {
                int reply = JOptionPane.showConfirmDialog(null, "Voulez vous inscrire un autre étudiant ?", "Continuer ?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.NO_OPTION){
                    continuer = false;
                }
            }*/
            //System.out.println(Etudiant.getpctFilles() + "%");
            continuer = false; //NE JAMAIS FAIRE CA HEIN !
        }
        System.exit(0);
    }
}
