/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.montduver.laformula1;

/**
 *
 * @author aderosgor
 */
public class Motor {
    
    private String tipo;
    private double cilindrada;
    private int potencia;

    public Motor(String tipo, double Cilindrada, int potencia) {
        this.tipo = tipo;
        this.cilindrada = Cilindrada;
        this.potencia = potencia;
        
    }

    public String getTipo() {
        return tipo;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCilindrada(double Cilindrada) {
        this.cilindrada = Cilindrada;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    
}
