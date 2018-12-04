/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.tools;

import com.mycompany.interfacegraphique.InterfaceCreaProp;
import javax.swing.JTextField;

/**
 *
 * @author qbiss
 */
public class Parametres {

    String nom;
    String valeur;
    public JTextField TexteNom;
    public JTextField TexteValeur;
    public static int posYCurrentParamProp = 250;
    public static int posYCurrentParamDesire = 250;
    public static int sizeYParam = 30;

    public Parametres(int type) {

        if (type == 0) {
            this.TexteNom = new JTextField();
            this.TexteValeur = new JTextField();

            this.TexteNom.setLocation(550, posYCurrentParamProp);
            this.TexteNom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            this.TexteNom.setText("Nom");
            this.TexteNom.setSize(150, 25);

            this.TexteValeur.setLocation(710, posYCurrentParamProp);
            this.TexteValeur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            this.TexteValeur.setText("Valeur");
            this.TexteValeur.setSize(150, 25);

            InterfaceCreaProp.pan.setSize(1570, InterfaceCreaProp.sizeY + 10);
            InterfaceCreaProp.pan.add(this.TexteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, posYCurrentParamProp, 150, 25));
            InterfaceCreaProp.pan.add(this.TexteValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, posYCurrentParamProp, 150, 25));
            posYCurrentParamProp += sizeYParam;
        }

        if (type == 1) {
            this.TexteNom = new JTextField();
            this.TexteValeur = new JTextField();

            this.TexteNom.setLocation(1060, posYCurrentParamDesire);
            this.TexteNom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            this.TexteNom.setText("Nom");
            this.TexteNom.setSize(150, 25);

            this.TexteValeur.setLocation(1220, posYCurrentParamDesire);
            this.TexteValeur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            this.TexteValeur.setText("Valeur");
            this.TexteValeur.setSize(150, 25);

            InterfaceCreaProp.pan.setSize(1570, InterfaceCreaProp.sizeY + 10);
            InterfaceCreaProp.pan.add(this.TexteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, posYCurrentParamDesire, 150, 25));
            InterfaceCreaProp.pan.add(this.TexteValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, posYCurrentParamDesire, 150, 25));

            posYCurrentParamDesire += sizeYParam;

        }

    }
    
    public void removeParam(int type){
        InterfaceCreaProp.pan.setSize(1570, InterfaceCreaProp.sizeY - 10);
        InterfaceCreaProp.pan.remove(this.TexteNom);
        InterfaceCreaProp.pan.remove(this.TexteValeur);
        posYCurrentParamProp -= sizeYParam;
        
        
    }

}
