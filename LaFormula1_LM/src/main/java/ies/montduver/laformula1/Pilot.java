/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.montduver.laformula1;

/**
 *
 * @author aderosgor
 */
public class Pilot {
    
    private String nom;
    private Escuderia escuderia;
    private int numero;
    private int pilot;
    private double sou;

    public Pilot(String nom, Escuderia escuderia, int numero, int pilot, double sou) {
        this.nom = nom;
        this.escuderia = escuderia;
        this.numero = numero;
        this.pilot = pilot;
        this.sou = sou;
        
    }

    public String getNom() {
        return nom;
    }

    public Escuderia getEscuderia() {
        return escuderia;
    }

    public int getNumero() {
        return numero;
    }

    public int getPilot() {
        return pilot;
    }

    public double getSou() {
        return sou;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }
    
    
}
