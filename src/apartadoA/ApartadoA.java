/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoA;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morad
 */
public class ApartadoA {

   
static File f = new File("FichPersonas.dat");
    

//Crea un fichero “FichPersona.dat”, que almacene varios objetos persona.
    public static void leer() throws ClassNotFoundException, FileNotFoundException, IOException {

        
        
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {

            while (true) {

                Persona persona = (Persona) ois.readObject();
                System.out.println(persona.mostrar());
              

            }

        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        }
        ois.close();
        fis.close();

    }

    public static ArrayList<Persona> leer2(File f) throws ClassNotFoundException, FileNotFoundException, IOException {

        ArrayList<Persona> listaPersonas = new ArrayList();
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {

            while (true) {

                Persona persona = (Persona) ois.readObject();
                //System.out.println(persona.toString());
                listaPersonas.add(persona);

            }

        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        }
        ois.close();
        fis.close();

        return listaPersonas;
    }

    public static void escribir() {

        Persona p1 = new Persona("Freddy Vega", 30);
        Persona p2 = new Persona("Morad", 26);
        Persona p3 = new Persona("Kevin hart", 45);
        Persona p4 = new Persona("Jamie Fox", 42);
        Persona p5 = new Persona("The rock", 50);
        Persona p6 = new Persona("50 cent", 47);
        Persona p7 = new Persona("Lebron James", 38);

        if (!f.exists()) {
            try {
                crearFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(f, true);
            ClaseOutput oos = new ClaseOutput(fos);

            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.writeObject(p4);
            oos.writeObject(p5);
            oos.writeObject(p6);
            oos.writeObject(p7);

            System.out.println("volcado exitoso");

            oos.close();
            fos.close();

        } catch (FileNotFoundException fi) {
            System.out.println(fi.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void crearFichero() throws FileNotFoundException, IOException {
        if (f.exists()) {
            System.out.println("El fichero ya esta creado");

        } else {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Fichero creado");
            oos.close();
            fos.close();

        }
    }

}
