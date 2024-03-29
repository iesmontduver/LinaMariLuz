/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.montduver.laformula1;

/**
 *
 * @author jasb
 */
public class Rodes {

    private int numero;
    private String marca;
    private int tipo_neumatic; //1-Blando, 2-Medio , 3- Duro, 4- Lluvia, 5-Lluvia extrema

    public Rodes(String marca) {
        this.marca = marca;
        this.numero = 4;
        this.tipo_neumatic = (int) (Math.random() * 4) + 1;
    }

    public Rodes(int numero, String marca, int tipo_neumatic) {
        this.numero = numero;
        this.marca = marca;
        this.tipo_neumatic = tipo_neumatic;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /* TO DO: Tornarà un String segons el valor (int) de l’atribut tipo_neumatic*/
    public String getTipo_neumatic() {
        
          String paraula;

        switch (tipo_neumatic) {
            case 1:
                paraula=("Blandes");
                break;
            case 2:
                paraula=("Medias");
                break;
            case 3:
               paraula=("Duras");
                break;
            case 4:
                paraula=("Lluvia");
                break;
            case 5:
                paraula=("Lluvia extrema");
                break;
            default:

                paraula=("Desconegudes");
              
        }
        
         return paraula;
         
    }

    public void setTipo_neumatic(int tipo_neumatic) {
        this.tipo_neumatic = tipo_neumatic;
    }

}
