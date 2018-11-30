package com.company.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverManage {

    /**
     * *******recuprer mail à partir d'une demande***************************
     */
    public String recupuser(Statement s, int id) {
        String mail = null;
        try {
            ResultSet result = s.executeQuery("SELECT emetteur FROM demande WHERE id='" + id + "'");
            result.next();
            mail = result.getString("emetteur");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return mail;
    }

    /**
     * *** récuprére d'id d'une demande******
     */
    public int recupID(Statement s, String emailE, String emailR) {
        int id = 0;
        try {
            ResultSet result = s.executeQuery("SELECT id FROM demande WHERE emetteur='" + emailE + "'AND recepteur='" + emailR + "'");
            result.next();
            id = result.getInt("id");

        } catch (SQLException e) {
            System.out.print(e);
        }
        return id;
    }

    public int exist(Statement s, String mailR) {
        int e = 0;
        boolean b;
        try {
            ResultSet result = s.executeQuery("SELECT * FROM utilisateur WHERE  mail='" + mailR + "'");
            if (result.next()) {

                e = result.getInt(1);
            }

        } catch (SQLException k) {
            System.out.println(k);
        }
        return e;
    }

    /**
     * **Ajout d'une demande s'authorisation****************
     */
    public void ajoutAuth(Statement s, String mailE, String mailR, int duree) {
        try {
            String descri = "je veux troquer avec toi";

            int statut = s.executeUpdate("INSERT INTO demande (emetteur, recepteur,descrip,durevalid) VALUES ('" + mailE + "','" + mailR + "','" + descri + "','" + duree + "')");
            System.out.println("Demande ajoutée avec succes");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int ajoutFichier(Statement s, String mailE, String mailR) {
       int idf=0;
        try {
            
    int statut = s.executeUpdate("INSERT INTO demande (emetteur, recepteur) VALUES ('" + mailE + "','" + mailR + "',)");
    ResultSet result= s.executeQuery("SELECT id FROM fichier WHERE emetteur='"+mailE+"' AND recepteur='"+mailR+"'");
    result.next();
    idf= result.getInt("id");
     System.out.println("fichier ajouté avec succès");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return idf;
    }
    
    public void ajoutMessage(Statement s,String type, int msgid, int fichierid,int dureev){
        
    }

    public Statement ConnectionDB() {
        try {
            Connection connexion = null;
            String url = "jdbc:mysql://localhost/troc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String utilisateur = "root";
            String motDePasse = "";
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            System.out.println("Connexion réussie !");

            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();
            System.out.println("Objet requête créé !");
            return statement;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public static void main(String[] args) {
        DriverManage D = new DriverManage();
        D.ConnectionDB();
        /* Connexion à la base de données */

    }
}
