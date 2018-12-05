/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.tools;

import static com.company.tools.Parametres.posYCurrentAffichParamProp;
import static com.company.tools.Parametres.posYCurrentAffichParamDesire;
import static com.company.tools.Parametres.sizeYParam;
import com.mycompany.interfacegraphique.InterfaceAffichProp;
import static com.mycompany.interfacegraphique.InterfaceAffichProp.iap;
import com.mycompany.interfacegraphique.InterfaceCreaProp;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.icp;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.pan;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.sizeY;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author qbiss
 */
public final class Objet {

    public String type;
    public ArrayList<Parametres> lp = new ArrayList<>();
    public static int nbParam = 0;
    public JLabel TexteTypeObjAdd;
    public JLabel TexteParamObjAdd;
    public static int posYObjetProp = 310;
    public static int posYObjetDesire = 310;
    public static int sizeYObjt = 60;
    public JLabel TexteAffichType;
    public JLabel TexteAffichDesc;
    public static int posYObjAffichProp = 180;
    public static int posYObjAffichDesire = 180;

    public void setType(String type) {
        this.type = type;
    }

    public void removeAllParam() {
        int i;
        for (i = 0; i < nbParam; i++) {
            pan.remove(lp.get(i).TexteNom);
            pan.remove(lp.get(i).TexteValeur);
        }
        pan.repaint();
    }


    public void deleteParam(int type) {
        nbParam--;
        if (nbParam - 1 > 0) {
            Parametres p = lp.get(nbParam - 1);
            p.removeParam(type);
            lp.remove(nbParam-1);
        }
    }
    public void afficherObj(int type, int nbObjet) {
        Dimension d = new Dimension(1570, sizeY + sizeYObjt);
        if (type == 0) {
            this.TexteParamObjAdd = new JLabel();
            this.TexteTypeObjAdd = new JLabel();

            this.TexteTypeObjAdd.setText("Objet  n°" + (nbObjet + 1) + " : " + this.type);
            this.TexteTypeObjAdd.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteTypeObjAdd.setLocation(530, posYObjetProp);

            this.TexteParamObjAdd.setText("Cet objet à " + this.nbParam + " paramètre(s)!");
            this.TexteParamObjAdd.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteParamObjAdd.setLocation(530, posYObjetProp + 30);

            if (posYObjetProp >= posYObjetDesire) {
                InterfaceCreaProp.pan.add(this.TexteTypeObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, posYObjetProp, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteParamObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, posYObjetProp + 30, 250, 20));

                Dimension df = new Dimension(1570, sizeY + sizeYObjt);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYObjetProp += sizeYObjt;
                sizeY += sizeYObjt;
            } else {
                InterfaceCreaProp.pan.add(this.TexteTypeObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, posYObjetProp, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteParamObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, posYObjetProp + 30, 250, 20));

                Dimension df = new Dimension(1570, sizeY);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYObjetProp += sizeYObjt;
            }

            icp.revalidate();


        }

        if (type == 1) {
            this.TexteParamObjAdd = new JLabel();
            this.TexteTypeObjAdd = new JLabel();

            this.TexteTypeObjAdd.setText("Objet  n°" + (nbObjet + 1) + " : " + this.type);
            this.TexteTypeObjAdd.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteTypeObjAdd.setLocation(1050, posYObjetDesire);

            this.TexteParamObjAdd.setText("Cet objet à " + this.nbParam + " paramètre(s)!");
            this.TexteParamObjAdd.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteParamObjAdd.setLocation(1050, posYObjetDesire + 30);

            if (posYObjetDesire >= posYObjetProp) {

                InterfaceCreaProp.pan.add(this.TexteTypeObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, posYObjetDesire, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteParamObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, posYObjetDesire + 30, 250, 20));

                Dimension df = new Dimension(1570, sizeY + sizeYObjt);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYObjetDesire += sizeYObjt;
                sizeY += sizeYObjt;
            } else {
                InterfaceCreaProp.pan.add(this.TexteTypeObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, posYObjetDesire, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteParamObjAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, posYObjetDesire + 30, 250, 20));

                Dimension df = new Dimension(1570, sizeY);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYObjetDesire += sizeYObjt;
            }

            icp.revalidate();

        }
    }

    public void afficheObjProp(int type, String typeO, NodeList nl, int nb) {
        int j;
        Parametres p = new Parametres();

        if (type == 0) {
            this.TexteAffichType = new JLabel();
            this.TexteAffichDesc = new JLabel();

            this.TexteAffichType.setText("Type de l'objet n°" + nb + " : " + typeO);
            this.TexteAffichDesc.setText("Descritpion de l'objet n°" + nb + " : ");

            this.TexteAffichType.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteAffichType.setLocation(560, posYObjAffichProp);

            this.TexteAffichDesc.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteAffichDesc.setLocation(560, posYObjAffichProp + 30);

            InterfaceAffichProp.pan.add(this.TexteAffichType, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, posYObjAffichProp, 250, 20));
            InterfaceAffichProp.pan.add(this.TexteAffichDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, posYObjAffichProp + 30, 250, 20));

            posYCurrentAffichParamProp = posYObjAffichProp + 2 * sizeYParam;

            for (j = 0; j < nl.getLength(); j++) {
                Element elem2 = (Element) nl.item(j);
                p.afficherParamProp(0, elem2.getElementsByTagName("Nom").item(0).getTextContent(), elem2.getElementsByTagName("Valeur").item(0).getTextContent());
            }

            posYObjAffichProp = posYCurrentAffichParamProp + sizeYParam;

            Dimension df = new Dimension(1570, posYObjAffichProp);
            iap.setSize(df);
            iap.setPreferredSize(df);
            InterfaceAffichProp.pan.setSize(df);
            InterfaceAffichProp.pan.setPreferredSize(df);

            iap.revalidate();

        }

        if (type == 1) {
            this.TexteAffichType = new JLabel();
            this.TexteAffichDesc = new JLabel();

            this.TexteAffichType.setText("Type de l'objet n°" + nb + " : " + typeO);
            this.TexteAffichDesc.setText("Descritpion de l'objet n°" + nb + " : ");

            this.TexteAffichType.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteAffichType.setLocation(1060, posYObjAffichDesire);

            this.TexteAffichDesc.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteAffichDesc.setLocation(1060, posYObjAffichDesire + 30);

            InterfaceAffichProp.pan.add(this.TexteAffichType, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, posYObjAffichDesire, 250, 20));
            InterfaceAffichProp.pan.add(this.TexteAffichDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, posYObjAffichDesire + 30, 250, 20));

            posYCurrentAffichParamDesire = posYObjAffichDesire + 2 * sizeYParam;

            for (j = 0; j < nl.getLength(); j++) {
                Element elem2 = (Element) nl.item(j);
                p.afficherParamProp(1, elem2.getElementsByTagName("Nom").item(0).getTextContent(), elem2.getElementsByTagName("Valeur").item(0).getTextContent());
            }

            posYObjAffichDesire = posYCurrentAffichParamDesire + sizeYParam;
            Dimension df;
            if(posYObjAffichDesire >= posYObjAffichProp){
                df = new Dimension(1570, posYObjAffichDesire);
            }
            else{
                df = new Dimension(1570, posYObjAffichProp);
            }
            
            iap.setSize(df);
            iap.setPreferredSize(df);
            InterfaceAffichProp.pan.setSize(df);
            InterfaceAffichProp.pan.setPreferredSize(df);

            iap.revalidate();

        }

    }

}
