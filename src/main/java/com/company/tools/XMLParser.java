package com.company.tools;

import com.mycompany.interfacegraphique.InterfaceAcc;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

    
    public static void AfficherAcc(String fileName){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File("src/main/java/com/company/tools/" + fileName);
            
            Document xml = builder.parse(fileXML);
            
            Element root = xml.getDocumentElement();
            
            InterfaceAcc.messageTroc.setText("Acceptez vous detroquer avec : " + root.getElementsByTagName("NmIE").item(0).getTextContent() + "?");
           
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        // Nous récupérons une instance de factory qui se chargera de nous fournir
        // un parseur
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Création de notre parseur via la factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File("./src/main/java/com/company/tools/xml.xml");

            // parsing de notre fichier via un objet File et récupération d'un
            // objet Document
            // Ce dernier représente la hiérarchie d'objet créée pendant le parsing
            Document xml = builder.parse(fileXML);

            // Via notre objet Document, nous pouvons récupérer un objet Element
            // Ce dernier représente un élément XML mais, avec la méthode ci-dessous,
            // cet élément sera la racine du document
            Element root = xml.getDocumentElement();

            NodeList nodes = root.getChildNodes();
            int nbNode = nodes.getLength();
            for (int i = 0; i < nbNode; i++) {
                Node n = nodes.item(i);
                NodeList nodes2 = n.getChildNodes();
                int nbNode2 = nodes2.getLength();

                for (int j = 0; j < nbNode2; j++) {
                    Node n2 = nodes2.item(j);

                    System.out.println("*   Enfant N°" + (j + 1) + " : " + n2.getNodeName() + " - " + n2.getNodeValue());
                }
                System.out.println("* Enfant N°" + (i + 1) + " : " + n.getNodeName() + " - " + n.getNodeValue());
            }
            
            System.out.println(root.getLastChild().getNodeName());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
