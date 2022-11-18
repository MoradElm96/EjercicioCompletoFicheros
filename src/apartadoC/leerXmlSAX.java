/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoC;

import apartadoA.Persona;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Morad
 */
public class leerXmlSAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       
        leerXMLyMostrar();
        
        
    }

    public static void leerXMLyMostrar() throws IOException, ParserConfigurationException, SAXException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        
        Manejador m = new Manejador();
        File f = new File("PersonasEnXML.xml");
        sp.parse(f, m);
        
        ArrayList<Persona> listaPersonas = m.obtenerLista();
        
        for (Persona listaPersona : listaPersonas) {
            
            System.out.println(listaPersona.toString());
        }
    }
}
