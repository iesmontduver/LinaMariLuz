/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ies.montduver.laformula1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jasb
 */
public class Formula1 {

    public static final String RESET = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String MORADO = "\033[35m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        int opcio;
        Circuit granPremi = null;
        List<Cotxe> cotxes = new ArrayList<Cotxe>();
        List<Box> pitLane = new ArrayList<Box>();

        /* Aquest mètode s'encarrega de crear les escuderies (5), els pilots (10), els cotxes (10) i els boxes de la linea pitLane (5).
           S'assigna un cotxe a un pilot i un box a cada escuderia. */
        crearEscuderies(cotxes, pitLane);

        do {

            opcio = -1;

            System.out.println("\n" + MORADO + "\t\t\t**** F O R M U L A  1  ****\n" + RESET);
            System.out.println("\t\t\t1. Establir un nou Gran Premi");
            System.out.println("\t\t\t2. Començar la carrera");
            System.out.println("\t\t\t3. Consultar qualificació");
            System.out.println("\t\t\t4. Eixir");
            opcio = Leer.leerEntero("\t\tIntrodueix una opcio (1-4): \n");

            switch (opcio) {
                case 1:
                    granPremi = crearGranPremi();
                    break;
                case 2:
                    //Començar la carrera
                    if (granPremi != null) {
                        Cotxe guanyador = GranPremi.correr(granPremi, cotxes, pitLane);

                        int hores = (int) (guanyador.getTempsCarrera() / 3600);
                        int minuts = (int) ((guanyador.getTempsCarrera() - (hores * 3600)) / 60);
                        double segons = ((int) (guanyador.getTempsCarrera() - (hores * 3600) - (minuts * 60)) * 100.0) / 100.0;

                        System.out.println(BLUE + "\n\t\t\t I EL GUANYADOR DEL GRAN PREMI ÉS..." + RESET);
                        Thread.sleep(2000);
                        System.out.println("\n\t\t" + RED + guanyador.getPilot().getNom() + " !!!" + RESET + " amb un temps total de " + RED + hores + "h:" + minuts + "':" + segons + "\"\n\n\n" + RESET);

                        granPremi = null;
                    } else {
                        JOptionPane.showMessageDialog(null, "Encara no s'ha creat el circuit (opció 1).");
                    }
                    break;
                case 3:
                    mostrarQualify(cotxes);
                    Thread.sleep(3000);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opció incorrecta.");
            }

        } while (opcio != 4);

    }

    private static Circuit crearGranPremi() {
        Circuit circuit = new Circuit(Leer.leerTextoConDialogo("Quin és el nom del circuit?"), Leer.leerTextoConDialogo("En quin pais es troba?"), Leer.leerTextoConDialogo("Quina ciutat?"), Integer.parseInt(Leer.leerTextoConDialogo("Indica la distància del circuit en metres")), Integer.parseInt(Leer.leerTextoConDialogo("Quantes voltes han de donar per a completar-lo?")));

        return circuit;
    }

    private static void mostrarQualify(List<Cotxe> cotxes) {

        List<Cotxe> listaAux = new ArrayList<Cotxe>(cotxes); //copia de la original 
        List<Cotxe> qualificacio = new ArrayList<Cotxe>();

        while (!listaAux.isEmpty()) {
            Iterator<Cotxe> co = listaAux.iterator();
            Cotxe lider = co.next();

            while (co.hasNext()) {
                Cotxe el_cotxe = co.next();

                if (el_cotxe.getPilot().getPunts() > lider.getPilot().getPunts()) {
                    lider = el_cotxe;
                }
            }
            qualificacio.add(lider);
            listaAux.remove(listaAux.indexOf(lider));
        }
        System.out.println(MORADO + "\n\t\t     QUALIFICACIÓ DEL MUNDIAL DE PILOTS " + RESET);
        System.out.println("\n\t\t\t*****************************");
        for (int i = 0; i < qualificacio.size(); i++) {

            System.out.println("\t\t\t|" + BLUE + qualificacio.get(i).getPilot().getNom() + RESET + "\t | " + GREEN + qualificacio.get(i).getPilot().getPunts() + RESET + " punts |");
            if (i != (qualificacio.size() - 1)) {
                System.out.println("\t\t\t|---------------------------|");
            }
        }
        System.out.println("\t\t\t*****************************");

    }

    private static void crearEscuderies(List<Cotxe> cotxes, List<Box> pitLane) {

        /* TO DO: 
           S’ha de completar el mètode per a crear instancies de: 
            • les escuderies (5),
            • els boxes  (5) per a cada escuderia,
            • els pilots (10), dos pilots per cada escuderia
            • els cotxes (10), un conduit per cadascun dels pilots.
        
            He deixat implementat un exemple de cada i com s'afegeix a les llistes de cotxes i el pitLane
            
         */
        //Crear 5 escuderies
        Escuderia McLaren = new Escuderia("McLaren", 125000000.0, 0);
        Escuderia Ferrari = new Escuderia("Ferrari", 100000000.0, 0);
        Escuderia Mercedes = new Escuderia("Mercedes", 140000000.0, 0);
        Escuderia RedBull = new Escuderia("Red Bull", 135000000.0, 0);
        Escuderia Toyota = new Escuderia("Toyota", 130000000.0, 0);

        //Crear els boxes de cada escuderia i afegir-los al pitLane
        Box box_ML = new Box(McLaren, 12);
        pitLane.add(box_ML);
        Box box_FR = new Box(Ferrari, 15);
        pitLane.add(box_FR);
        Box box_MC = new Box(Mercedes, 11);
        pitLane.add(box_MC);
        Box box_RB = new Box(RedBull, 14);
        pitLane.add(box_RB);
        Box box_TY = new Box(Toyota, 10);
        pitLane.add(box_TY);

        //Crear 10 pilots; 2 per escuderia
        Pilot Norris = new Pilot("L. Norris", McLaren, 4, 0,50000);
        Pilot Piastri = new Pilot("O. Piastri", McLaren, 81, 0, 500000);
        Pilot Leclerc = new Pilot("C.Leclerc", Ferrari, 16, 0,60000);
        Pilot Sainz = new Pilot("C.Sainz", Ferrari, 55,0, 60000);
        Pilot Hamilton = new Pilot("L. Hamilton", Mercedes, 44,0,40000);
        Pilot Russell = new Pilot("G. Russell", Mercedes, 63,0,40000);
        Pilot Verstappen = new Pilot("M. Verstappen", RedBull, 1,0,61000);
        Pilot Perez = new Pilot("S.Perez", RedBull, 11,0,62000);
        Pilot Salo = new Pilot("M.Salo", Toyota, 3,0,45000);
        Pilot Zonta = new Pilot("R. Zonta", Toyota, 42,0,45000);

        //Montar els 10 cotxes i afegir-los a la llista de cotxes
        Cotxe c4 = new Cotxe(McLaren, new Rodes("Michelín"), new Motor(), new Xasis(McLaren.getNom(),"F1", "Blanco", 500, 4 ));
        cotxes.add(c4);
        Cotxe c81 = new Cotxe(McLaren, new Rodes("Michelín"), new Motor(), new Xasis(McLaren.getNom(), "F1", "Blanco"));
        cotxes.add(c81);
        Cotxe c16 = new Cotxe(Ferrari, new Rodes("Michelín"), new Motor(), new Xasis(Ferrari.getNom(), "F1", "Roig"));
        cotxes.add(c16);
        Cotxe c55 = new Cotxe(Ferrari, new Rodes("Michelín"), new Motor(), new Xasis(Ferrari.getNom(), "F1", "Roig"));
        cotxes.add(c55);
        Cotxe c44 = new Cotxe(Mercedes, new Rodes("Michelín"), new Motor(), new Xasis(Mercedes.getNom(), "F1", "Verd"));
        cotxes.add(c44);
        Cotxe c63 = new Cotxe(Mercedes, new Rodes("Michelín"), new Motor(), new Xasis(Mercedes.getNom(), "F1", "Verd"));
        cotxes.add(c63);
        Cotxe c1 = new Cotxe(RedBull, new Rodes("Michelín"), new Motor(), new Xasis(RedBull.getNom(), "F1", "Blau"));
        cotxes.add(c1);
        Cotxe c11 = new Cotxe(RedBull, new Rodes("Michelín"), new Motor(), new Xasis(RedBull.getNom(), "F1", "Blau"));
        cotxes.add(c11);
        Cotxe c3 = new Cotxe(Toyota, new Rodes("Michelín"), new Motor(), new Xasis(McLaren.getNom(), "F1", "Gris"));
        cotxes.add(c3);
        Cotxe c42 = new Cotxe(Toyota, new Rodes("Michelín"), new Motor(), new Xasis(McLaren.getNom(), "F1", "Gris"));
        cotxes.add(c42);

        //Assignar un cotxe a cada pilot 
        c4.setPilot(Norris);
        c81.setPilot(Piastri);
        c16.setPilot(Leclerc);
        c55.setPilot(Sainz);
        c44.setPilot(Hamilton);
        c63.setPilot(Russell);
        c1.setPilot(Verstappen);
        c11.setPilot(Perez);
        c3.setPilot(Salo);
        c42.setPilot(Zonta);

    }
}
