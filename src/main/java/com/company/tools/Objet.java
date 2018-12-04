/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.tools;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qbiss
 */
public final class Objet {

    public ArrayList<Parametres> lp = new ArrayList<>();
    public int nbParam = 0;

    public void addParam(int type) {
        Parametres p = new Parametres(type);
        lp.add(p);
        nbParam++;

    }

    public void afficherParam() {
        int i;
        for (i = 0; i < nbParam; i++) {
            System.out.println("" + lp.get(i).nom);
            System.out.println("" + lp.get(i).valeur);
        }
    }

    public void deleteParam(int type) {
        nbParam--;
        if (nbParam - 1 > 0) {
            Parametres p = lp.get(nbParam - 1);
            p.removeParam(type);
            lp.remove(nbParam-1);
        }
    }

    public Objet(int type) {
        this.addParam(type);
        nbParam++;
    }
}
