/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.tools;

import com.mycompany.interfacegraphique.InterfaceCreaProp;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author DELL XPS
 */
public class XmlTools {

    public boolean creerAuth(String nomE, String nomR, int dureeV, String emailE, String emailR, String descDmd) {
        try {
            Date now = new Date();
            
            String ficId = ""+ (Math.random()%1000);
            StringWriter stringWriter = new StringWriter();
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter
                    = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("Fichier");
            xMLStreamWriter.writeStartElement("Header");
            xMLStreamWriter.writeStartElement("FicId");
            xMLStreamWriter.writeCharacters(ficId);
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("NmIE");
            xMLStreamWriter.writeCharacters(nomE);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("NmIR");
            xMLStreamWriter.writeCharacters(nomR);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("MailExp");
            xMLStreamWriter.writeCharacters(emailE);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("MailDest");
            xMLStreamWriter.writeCharacters(emailR);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndElement();

            //start of body
            xMLStreamWriter.writeStartElement("Body");
            //start of colMess
            xMLStreamWriter.writeStartElement("CollMess");
            xMLStreamWriter.writeAttribute("NbOfTxs", "1");
            xMLStreamWriter.writeStartElement("Message");
            xMLStreamWriter.writeAttribute("MsgId", "m"+ Math.random()%1000);
            xMLStreamWriter.writeStartElement("Dte");
            xMLStreamWriter.writeCharacters(now.toString());
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("DureeValideMsg");
            xMLStreamWriter.writeCharacters(Integer.toString(dureeV));
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("Dmd");
            xMLStreamWriter.writeStartElement("DescDmd");
            xMLStreamWriter.writeCharacters(descDmd);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("DateDebut");
            xMLStreamWriter.writeCharacters(now.toString());
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("DateFin");
            xMLStreamWriter.writeCharacters(now.toString());
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndElement();
            //end of colMess
            xMLStreamWriter.writeEndElement();
            //end of body
            xMLStreamWriter.writeEndElement();
            //end of fichier
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            generateXmlFile("dmd_" + ficId + ".xml", xmlString);
            stringWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean creerProp(String nomE, String nomR, int dureeV, String emailE, String emailR, String TitreP) {
        try {
            Date now = new Date();
            String ficId = UUID.randomUUID().toString().replace("-", "");
            StringWriter stringWriter = new StringWriter();
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter
                    = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("Fichier");
            xMLStreamWriter.writeStartElement("Header");
            xMLStreamWriter.writeStartElement("FicId");
            xMLStreamWriter.writeCharacters(ficId);
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("FicId");
            xMLStreamWriter.writeCharacters(UUID.randomUUID().toString());
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("NmIE");
            xMLStreamWriter.writeCharacters(nomE);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("NmIR");
            xMLStreamWriter.writeCharacters(nomR);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("MailExp");
            xMLStreamWriter.writeCharacters(emailE);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("MailDest");
            xMLStreamWriter.writeCharacters(emailR);
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndElement();

            //start of body
            xMLStreamWriter.writeStartElement("Body");
            //start of colMess
            xMLStreamWriter.writeStartElement("CollMess");
            xMLStreamWriter.writeAttribute("NbOfTxs", "1");
            xMLStreamWriter.writeStartElement("Message");
            xMLStreamWriter.writeAttribute("MsgId", "m" + UUID.randomUUID().toString());
            xMLStreamWriter.writeStartElement("Dte");
            xMLStreamWriter.writeCharacters(now.toString());
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("DureeValideMsg");
            xMLStreamWriter.writeCharacters(Integer.toString(dureeV));
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeStartElement("Prop");
            xMLStreamWriter.writeStartElement("TitreP");
            xMLStreamWriter.writeCharacters(TitreP);
            xMLStreamWriter.writeEndElement();

            if (InterfaceCreaProp.estCheckPropose == 0) {
                xMLStreamWriter.writeStartElement("Offre");
                xMLStreamWriter.writeStartElement("Objet");
                
                xMLStreamWriter.writeStartElement("Type");
                xMLStreamWriter.writeCharacters(InterfaceCreaProp.texteTypeObjPropose.getText());
                xMLStreamWriter.writeEndElement();
                
                xMLStreamWriter.writeStartElement("Description");
                xMLStreamWriter.writeCharacters(InterfaceCreaProp.texteDescriptObjPropose.getText());
                xMLStreamWriter.writeEndElement();
                
                xMLStreamWriter.writeEndElement();
                xMLStreamWriter.writeEndElement();

            }
            
            if (InterfaceCreaProp.estCheckDesire == 0) {
                xMLStreamWriter.writeStartElement("Demande");
                xMLStreamWriter.writeStartElement("Objet");
                
                xMLStreamWriter.writeStartElement("Type");
                xMLStreamWriter.writeCharacters(InterfaceCreaProp.texteTypeObjDesire.getText());
                xMLStreamWriter.writeEndElement();
                
                xMLStreamWriter.writeStartElement("Description");
                xMLStreamWriter.writeCharacters(InterfaceCreaProp.texteDescriptObjDesire.getText());
                xMLStreamWriter.writeEndElement();
                
                xMLStreamWriter.writeEndElement();
                xMLStreamWriter.writeEndElement();

            }
            
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndElement();

            //end of colMess
            xMLStreamWriter.writeEndElement();
            //end of body
            xMLStreamWriter.writeEndElement();
            //end of fichier
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            generateXmlFile("dmdProposition_" + ficId + ".xml", xmlString);
            stringWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean generateXmlFile(String fileName, String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

//         Write the parsed document to an xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File file = new File(fileName);
            if (file.createNewFile()) {
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
}

