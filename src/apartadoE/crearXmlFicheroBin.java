/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartadoE;

import apartadoD.Departamento;
import java.io.File;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Morad
 */
public class crearXmlFicheroBin {

    public static void crearFicheroXml() {

        File f = new File("DepartamentosEnXML.xml");
       

        ArrayList<Departamento> lista = new ArrayList();

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            doc.normalize();

            Element raiz = doc.createElement("Departamentos");
            doc.appendChild(raiz);

            lista = apartadoD.EjercicoDeBinario.leerBinario();
            for (int i = 0; i < lista.size(); i++) {
                Element departamento = doc.createElement("departamento");
                raiz.appendChild(departamento);
                Attr atributo = doc.createAttribute("id");
                atributo.setValue(String.valueOf(i));
                departamento.setAttributeNode(atributo);

                Element numD = doc.createElement("numeroDepartamento");
                numD.setTextContent(String.valueOf(lista.get(i).getNumDep()));
                departamento.appendChild(numD);

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(lista.get(i).getNombre());
                departamento.appendChild(nombre);

                Element localidad = doc.createElement("localidad");
                localidad.setTextContent(lista.get(i).getLocalidad());
                departamento.appendChild(localidad);

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
