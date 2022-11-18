/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoB;

import apartadoA.ApartadoA;
import apartadoA.Persona;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Morad
 */
public class crearFicheroXml {
    public static void main(String[] args) {
        
        crearFicheroXml();
        
        
    }

    public static void crearFicheroXml(){
       
        File f = new File("PersonasEnXML.xml");
        File f1 = new File("FichPersonas.dat");
        
        ApartadoA ap = new ApartadoA();
        ArrayList<Persona> lista = new ArrayList();
        
        try{
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            doc.normalize();
            
            
            Element raiz = doc.createElement("Personas");
            doc.appendChild(raiz);
            
            try {
                
                lista = apartadoA.ApartadoA.leer2(f1);
                
                
                for (int i = 0; i <lista.size(); i++) {
                    Element persona = doc.createElement("persona");
                    raiz.appendChild(persona);
                    Attr atributo = doc.createAttribute("id");
                    atributo.setValue(String.valueOf(i));
                    persona.setAttributeNode(atributo);
                    
                    Element nombre = doc.createElement("nombre");
                    nombre.setTextContent(lista.get(i).getNombre());
                    persona.appendChild(nombre);
                    
                    Element edad = doc.createElement("edad");
                    edad.setTextContent(String.valueOf(lista.get(i).getEdad()));
                    persona.appendChild(edad);
                    
                    
                }
                
                
                
                
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(crearFicheroXml.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(crearFicheroXml.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
