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
     * **Ajout d'une demande d'authorisation****************
     */
    public void ajoutAuth(Statement s, String mailE, String mailR, String descrip, int duree) {
        try {
            int statut = s.executeUpdate("INSERT INTO demande (emetteur, recepteur,descrip,durevalid) VALUES ('" + mailE + "','" + mailR + "','" + descrip + "','" + duree + "')");
            System.out.println("Demande ajoutée avec succes");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int ajoutFichier(Statement s, String mailE, String mailR) {
        int idf = 0;
        int idE;
        int idR;
        try {
            ResultSet result = s.executeQuery("SELECT id FROM utilisateur WHERE mail='" + mailE + "'");
            result.next();
            idE = result.getInt("id");

            ResultSet result2 = s.executeQuery("SELECT id FROM utilisateur WHERE mail='" + mailR + "'");
            result2.next();
            idR = result2.getInt("id");

            int statut = s.executeUpdate("INSERT INTO fichier(emetteur, recepteur) VALUES ('" + idE + "','" + idR + "')");

            ResultSet result3 = s.executeQuery("SELECT id FROM fichier WHERE emetteur='" + idE + "' AND recepteur='" + idR + "'");
            result3.next();
            idf = result3.getInt("id");
            System.out.println("fichier ajouté avec succès");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return idf;
    }

    public void supprimeFic(Statement s, String mailE, String mailR) {
        try {
            int state = s.executeUpdate("DELETE FROM fichier WHERE mailE='" + mailE + "' AND mailR='" + mailR + "'");

        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    public String verifieReponseDMD(Statement s, String mailE, String mailR) {
        String reponse = null;
        int idDmd = 0;
        try {
            ResultSet result = s.executeQuery("SELECT id FROM demande WHERE emetteur='" + mailE + "' AND recepteur='" + mailR + "'");
            result.next();
            idDmd = result.getInt("id");
            if (idDmd == 0) {

                reponse = "Vous n'avez pas de demande d'autorisation de troc ";

            } else {
                ResultSet result2 = s.executeQuery("SELECT reponse FROM auto WHERE iddemde='" + idDmd + "'");
                result2.next();
                reponse = result2.getString("reponse");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reponse;
    }

    public void ajoutMessage(Statement s, String type, int msgid, int fichierid, int typemsg, int dureev, String dte) {
        try {
            int statut = s.executeUpdate("INSERT INTO message (type,msgid,fichier,propo,dmd,accpt,auth,dureevalid,dte) VALUES ('" + type + "','" + msgid + "','" + fichierid + "',0,'" + typemsg + "',0,0,'" + dureev + "','" + dte + "')");

            String msgType = type;
            if (msgType == "dmdAuth") {
                int statutauth = s.executeUpdate("INSERT INTO message (auth) VALUES ('" + typemsg + "')");
            }
            if (msgType == "dmndePropo") {
                int statutpropo = s.executeUpdate("INSERT INTO message (dmd) VALUES ('" + typemsg + "')");
            }
            if (msgType == "accepAuth") {
                int statutauth = s.executeUpdate("INSERT INTO message (acc) VALUES ('" + typemsg + "')");
            }
            if (msgType == "accPropo") {
                int statutauth = s.executeUpdate("INSERT INTO message (propo) VALUES ('" + typemsg + "')");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int ajoutPropo(Statement s, String titre, String type) {

        int idPropo = 0;
        try {
            int statut = s.executeUpdate("INSERT INTO propo (titre,type) VALUES ('" + titre + "', '" + type + "')");

            ResultSet result = s.executeQuery("SELECT id FROM propo WHERE titre='" + titre + "' AND type='" + type + "'");
            result.next();
            idPropo = result.getInt("id");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return idPropo;
    }

    // Reponse a la demande d'autorisation
    public void repAuto(Statement s, String answer, int idF) {
        try {
            int statu = s.executeUpdate("INSERT INTO auto (reponse,iddemde) VALUES ('" + answer + "','" + idF + "')");
            System.out.println("!!! REPONSE RECU !!!");
        } catch (SQLException n) {
            System.out.println(n);
        }

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
