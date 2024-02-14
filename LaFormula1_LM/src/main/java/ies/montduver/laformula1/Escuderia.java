/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.montduver.laformula1;

/**
 *
 * @author aderosgor
 */
public class Escuderia {
    
    private String nom;
    private double pressupost;
    private int punts;

    public Escuderia(String nom, double pressupost, int punts) {
        this.nom = nom;
        this.pressupost = pressupost;
        this.punts = punts;
    }

    public String getNom() {
        return nom;
    }

    public double getPressupost() {
        return pressupost;
    }

    public int getPunts() {
        return punts;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPressupost(double pressupost) {
        this.pressupost = pressupost;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }
    
    
}
