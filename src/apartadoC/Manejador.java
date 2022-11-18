/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoC;

import apartadoA.Persona;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Morad
 */
public class Manejador extends DefaultHandler {
    ArrayList<Persona> listaPer = new ArrayList();
    Persona persona;
    StringBuilder sb = new StringBuilder();
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length); 
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
        
            case "nombre":
                persona.setNombre(sb.toString());
                break;
            case "edad":
                persona.setEdad(Integer.parseInt(sb.toString()));
                break;
            
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
switch(qName){
        
    case "persona":
        persona = new Persona();
        listaPer.add(persona);
            
        persona.setId(Integer.parseInt(attributes.getValue("id")));
        
        break;
        
    case "nombre":
    case "edad":
        
        sb.delete(0, sb.length());
        break;
        
        }

    }

    public ArrayList<Persona> obtenerLista(){
        return listaPer;
    }
   
    
    
}
