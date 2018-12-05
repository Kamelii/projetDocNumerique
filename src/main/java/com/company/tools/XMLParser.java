package com.company.tools;

import com.mycompany.interfacegraphique.InterfaceAcc;
import com.mycompany.interfacegraphique.InterfaceAffichProp;
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

    public static void AfficherAcc(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File("src/main/java/com/company/tools/" + fileName);

            Document xml = builder.parse(fileXML);

            Element root = xml.getDocumentElement();

            String text = root.getElementsByTagName("NmIE").item(0).getTextContent();

            InterfaceAcc.messageTroc.setText("Acceptez vous detroquer avec : " + text + "?");

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void AfficherProp(String fileName) {
        int i,j;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();

            File fileXML = new File("src/main/java/com/company/tools/" + fileName);

            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();

            String nomE = root.getElementsByTagName("NmIE").item(0).getTextContent();
            String nomR = root.getElementsByTagName("NmIR").item(0).getTextContent();
            String duree = root.getElementsByTagName("DureeValideMsg").item(0).getTextContent();
            String mailE = root.getElementsByTagName("MailDest").item(0).getTextContent();
            String mailR = root.getElementsByTagName("MailExp").item(0).getTextContent();
            String titreP = root.getElementsByTagName("TitreP").item(0).getTextContent();

            InterfaceAffichProp.nomEmetteur.setText("Nom de l'émetteur : " + nomE);
            InterfaceAffichProp.nomRecepteur.setText("Nom du récepteur : " + nomR);
            InterfaceAffichProp.duree.setText("Durée de validité : " + duree + " jour(s)");
            InterfaceAffichProp.mailEmetteur.setText("Mail de l'émetteur : " + mailE);
            InterfaceAffichProp.mailRecepteur.setText("Mail du récepteur : " + mailR);
            InterfaceAffichProp.titreProp.setText("Titre de la proposition : " + titreP);

            Objet o = new Objet();
            Element elem1 = (Element) root.getElementsByTagName("Offre").item(0);
            
            NodeList nl  = elem1.getElementsByTagName("Objet");
            
            for (i = 0; i < nl.getLength(); i++) {
                Element elem = (Element) nl.item(i);
                NodeList nl2 = elem.getElementsByTagName("Parametre");
                o.afficheObjProp(0, elem.getElementsByTagName("Type").item(0).getTextContent(), nl2, i+1);
            }
            
            elem1 = (Element) root.getElementsByTagName("Demande").item(0);
            nl  = elem1.getElementsByTagName("Objet");
            
            for (i = 0; i < nl.getLength(); i++) {
                Element elem = (Element) nl.item(i);
                NodeList nl2 = elem.getElementsByTagName("Parametre");
                o.afficheObjProp(1, elem.getElementsByTagName("Type").item(0).getTextContent(), nl2, i+1);
            }
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int recupererIdMsg(String Fichier){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        int idmsg=0;
        try{

            DocumentBuilder builder = factory.newDocumentBuilder();

            File fileXML = new File("src/main/java/com/company/tools/" + Fichier);

            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            NodeList elem =  root.getElementsByTagName("Message");
            String msgid = elem.item(0).getAttributes().getNamedItem("MsgId").getNodeValue();
            idmsg= Integer.parseInt(msgid);
           
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } 
    return idmsg;
    }

 public static String recupererEmetteur(String Fichier){

 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       String Emetteur=null;
        try{

            DocumentBuilder builder = factory.newDocumentBuilder();

            File fileXML = new File("src/main/java/com/company/tools/" + Fichier);

            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            Emetteur = root.getElementsByTagName("MailExp").item(0).getTextContent();

         
           
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } 
    return Emetteur;
    }

 public static String recupererRecepteur(String Fichier){

 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       String recepteur=null;
        try{

            DocumentBuilder builder = factory.newDocumentBuilder();

            File fileXML = new File("src/main/java/com/company/tools/" + Fichier);

            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
           recepteur = root.getElementsByTagName("MailDest").item(0).getTextContent();

         
           
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } 
    return recepteur;
    }
}