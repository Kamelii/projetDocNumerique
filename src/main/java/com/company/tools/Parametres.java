/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.tools;

import com.mycompany.interfacegraphique.InterfaceAffichProp;
import static com.mycompany.interfacegraphique.InterfaceAffichProp.iap;
import static com.mycompany.interfacegraphique.InterfaceAffichProp.sizeYAffich;
import com.mycompany.interfacegraphique.InterfaceCreaProp;

import javax.swing.JTextField;

import static com.mycompany.interfacegraphique.InterfaceCreaProp.icp;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.pan;
import static com.mycompany.interfacegraphique.InterfaceCreaProp.sizeY;
import java.awt.Dimension;
import javax.swing.JLabel;


/**
 *
 * @author qbiss
 */
public class Parametres {

    String nom;
    String valeur;
    public JLabel TexteNom;
    public JLabel TexteValeur;
    public JLabel TexteParam;
    public static int posYCurrentParamProp = 310;
    public static int posYCurrentParamDesire = 310;
    public static int posYCurrentAffichParamProp = 240;
    public static int posYCurrentAffichParamDesire = 240;
    public static int sizeYParam = 30;
    public static int positionCurrentBouton = 310;

    public Parametres(String nom, String valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }
    
    public Parametres(){
        
    }
    
    
    public void afficherParam(int type, int nbParam) {
        Dimension d = new Dimension(1570, sizeY + sizeYParam);
        if (type == 0) {
            this.TexteNom = new JLabel();
            this.TexteValeur = new JLabel();

            this.TexteNom.setText("Paramètre n°" + nbParam + " : " + this.nom);
            this.TexteNom.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteNom.setLocation(530, posYCurrentParamProp);

            this.TexteValeur.setText(this.valeur);
            this.TexteValeur.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteValeur.setLocation(790, posYCurrentParamProp);

            if (posYCurrentParamProp >= posYCurrentParamDesire){
                InterfaceCreaProp.pan.add(this.TexteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, posYCurrentParamProp, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, posYCurrentParamProp, 70, 20));

                Dimension df = new Dimension(1570, sizeY + sizeYParam);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYCurrentParamProp += sizeYParam;
                InterfaceCreaProp.posYBouton += sizeYParam;
                sizeY += sizeYParam;
            }
            else{
                InterfaceCreaProp.pan.add(this.TexteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, posYCurrentParamProp, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, posYCurrentParamProp, 70, 20));

                Dimension df = new Dimension(1570, sizeY);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYCurrentParamProp += sizeYParam;
            }
            
            icp.revalidate();
        }

        if (type == 1) {
            this.TexteNom = new JLabel();
            this.TexteValeur = new JLabel();

            this.TexteNom.setText("Paramètre n°" + nbParam + " : " + this.nom);
            this.TexteNom.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteNom.setLocation(1050, posYCurrentParamDesire);

            this.TexteValeur.setText(this.valeur);
            this.TexteValeur.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteValeur.setLocation(1300, posYCurrentParamDesire);

            if (posYCurrentParamDesire >= posYCurrentParamProp) {

                InterfaceCreaProp.pan.add(this.TexteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, posYCurrentParamDesire, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, posYCurrentParamDesire, 70, 20));

                Dimension df = new Dimension(1570, sizeY + sizeYParam);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYCurrentParamDesire += sizeYParam;
                sizeY += sizeYParam;
            } else {
                InterfaceCreaProp.pan.add(this.TexteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, posYCurrentParamDesire, 250, 20));
                InterfaceCreaProp.pan.add(this.TexteValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, posYCurrentParamDesire, 70, 20));

                Dimension df = new Dimension(1570, sizeY);
                icp.setSize(df);
                icp.setPreferredSize(df);
                pan.setSize(d);
                pan.setPreferredSize(d);

                posYCurrentParamDesire += sizeYParam;
                
                icp.revalidate();
            }
        }


    }
    
    public void removeParam(int type){
        InterfaceCreaProp.pan.setSize(1570, InterfaceCreaProp.sizeY - 10);
        InterfaceCreaProp.pan.remove(this.TexteNom);
        InterfaceCreaProp.pan.remove(this.TexteValeur);
        posYCurrentParamProp -= sizeYParam;
        

    }
    
    public void afficherParamProp(int type,String nom,String valeur){
        Dimension d = new Dimension(1570, sizeYAffich + sizeYParam);
        if(type==0){
            
            
            this.TexteParam= new JLabel();
            
            System.out.println("" + nom + " : " + valeur);
            this.TexteParam.setText("" + nom + " : " + valeur);
            this.TexteParam.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteParam.setLocation(580, posYCurrentAffichParamProp);
            
            

            if (posYCurrentAffichParamProp >= posYCurrentAffichParamDesire) {

                InterfaceAffichProp.pan.add(this.TexteParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, posYCurrentAffichParamProp, 250, 20));

                posYCurrentAffichParamProp += sizeYParam;
                sizeYAffich += sizeYParam;
                
                iap.revalidate();
                
            } else {
                InterfaceAffichProp.pan.add(this.TexteParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, posYCurrentAffichParamProp, 250, 20));

                posYCurrentAffichParamProp += sizeYParam;
                
                iap.revalidate();
            }
            
            
        }
        
         if(type==1){
            
            
            this.TexteParam= new JLabel();
            
            System.out.println("" + nom + " : " + valeur);
            this.TexteParam.setText("" + nom + " : " + valeur);
            this.TexteParam.setFont(new java.awt.Font("Arial", 1, 14));
            this.TexteParam.setLocation(1080, posYCurrentAffichParamDesire);
            
            

            if (posYCurrentAffichParamDesire >= posYCurrentAffichParamProp) {

                InterfaceAffichProp.pan.add(this.TexteParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, posYCurrentAffichParamDesire, 250, 20));

                posYCurrentAffichParamDesire += sizeYParam;
                sizeYAffich += sizeYParam;
                
                iap.revalidate();
                
            } else {
                InterfaceAffichProp.pan.add(this.TexteParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, posYCurrentAffichParamDesire, 250, 20));

                posYCurrentAffichParamDesire += sizeYParam;
                
                iap.revalidate();
            }
            
            
        }
        
    }

}
