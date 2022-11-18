/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetePrincipalParaEjecutarElPrograma;

import apartadoB.crearFicheroXml;
import apartadoE.crearXmlFicheroBin;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Morad
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {

        Scanner sc = new Scanner(System.in);

        int opcion = menu(sc);

        File f = new File("FichPersona.dat");
        while (opcion != 6) {
            switch (opcion) {
                case 1:
                    apartadoA.ApartadoA.escribir();
                    apartadoA.ApartadoA.leer();

                    break;
                case 2:
                    crearFicheroXml.crearFicheroXml();
                    break;
                case 3:
                    apartadoC.leerXmlSAX.leerXMLyMostrar();
                    break;
                case 4:
                    apartadoD.EjercicoDeBinario.escribirBinario();
                    apartadoD.EjercicoDeBinario.leerBinario();

                    break;

                case 5:
                    crearXmlFicheroBin.crearFicheroXml();
                    break;
                default:
                    System.out.println("Operacion incorrecta");

                    break;
            }
            opcion = menu(sc);
        }

    }

    private static int menu(Scanner sc) {
        int opcion;
        System.out.println("1)Crear Fichero persona y mostrar");
        System.out.println("2)Crear xml con personas del fichero dat");
        System.out.println("3)Leer con sax y mostrar informacion");
        System.out.println("4)Escribir y mostrar Fichero Binario");
        System.out.println("5)Generar xml del fichero binario");
        System.out.println("6)Salir");

        opcion = sc.nextInt();
        return opcion;

    }

}
