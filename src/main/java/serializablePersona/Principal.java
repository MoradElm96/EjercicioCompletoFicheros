package serializablePersona;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 *
 * @author alumnotd
 */
public class Principal {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        File f = new File("personas.obj");

           // escribir(f);


            leer(f);

       
            
        }
    

    private static void escribir(File f) {

        Persona p1 = new Persona("Morad", 26);
        Persona p2 = new Persona("Lebron James", 38);
        Persona p3 = new Persona("The rock", 50);
        Persona p4 = new Persona("Kevin hart", 45);

        try {
            if (!f.exists()) 
                crearFichero(f);
            

            FileOutputStream fos = new FileOutputStream(f);
            ClaseOutput oos = new ClaseOutput(fos);

            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.writeObject(p4);
            System.out.println("volcado exitoso");

            oos.close();
            fos.close();

        } catch (FileNotFoundException fi) {
            System.out.println(fi.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void crearFichero(File f) throws IOException, FileNotFoundException {
       if(f.exists()){
            System.out.println("El fichero ya esta creado");
            
        } else {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Fichero creado");
            oos.close();
            fos.close();
            
        }
    }

    private static void leer(File f) throws FileNotFoundException, IOException, ClassNotFoundException {

        Persona p=null;
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                p = (Persona) ois.readObject();
                System.out.println(p.toString());
            }
        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        }
        
        ois.close();
        fis.close();
    }
}
