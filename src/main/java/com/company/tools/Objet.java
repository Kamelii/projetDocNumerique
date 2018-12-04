/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.tools;

import static com.company.tools.Parametres.positionCurrentBouton;
import com.mycompany.interfacegraphique.InterfaceCreaProp;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.icp;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.pan;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.sizeY;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author qbiss
 */
public final class Objet {

    private String type;
    public ArrayList<Parametres> lp = new ArrayList<>();
    public static int nbParam = 0;
    public JLabel TexteTypeObjAdd;
    public JLabel TexteParamObjAdd;
    public static int posYObjetProp = 310;
    public static int posYObjetDesire = 310;
    public static int sizeYObjt = 60;
    
    public void setType(String type){
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

            this.TexteTypeObjAdd.setText("Objet  n°" + (nbObjet+1) + " : " + this.type);
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

}
