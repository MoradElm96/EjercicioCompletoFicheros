/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoD;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Morad
 */
public class EjercicoDeBinario {

    static int numeroDepartamento;
    static String nombre, Localidad;

    static File f = new File("departamentos.bin");

   

    public static void escribirBinario() {
        try {

            FileOutputStream fos = new FileOutputStream(f, true);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(1);
            dos.writeUTF("Hotel 1");
            dos.writeUTF("Mostoles");
            dos.writeInt(2);
            dos.writeUTF("Hotel 2");
            dos.writeUTF("Madrid");
            dos.writeInt(3);
            dos.writeUTF("Hotel 3");
            dos.writeUTF("Aranjuez");

            System.out.println("...Datos guardados con exito");
            dos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public static ArrayList<Departamento> leerBinario() {
        
        ArrayList<Departamento> listaDepartamento = new ArrayList();
        
        try {

            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);

            try {
                while (true) {
                    numeroDepartamento = dis.readInt();
                    nombre = dis.readUTF();
                    Localidad = dis.readUTF();

                    Departamento dep = new Departamento(numeroDepartamento, nombre, Localidad);
                    listaDepartamento.add(dep);
                    System.out.println("Numero Departamento: " + numeroDepartamento + " Nombre: " + nombre + " Localidad: " + Localidad);

                    
                    
                    
                }

            } catch (EOFException eof) {
                System.out.println("Fin del fichero");
            }
            System.out.println("Datos leidos con exito");
            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listaDepartamento;
    }
}
