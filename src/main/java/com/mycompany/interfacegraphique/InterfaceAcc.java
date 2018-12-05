
package com.mycompany.interfacegraphique;


import com.company.tools.DriverManage;
import static com.mycompany.interfacegraphique.InterfaceAut.setU;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.company.tools.XMLParser;
import com.company.tools.XmlTools;

public class InterfaceAcc extends java.awt.Frame {

    static DriverManage setR=new DriverManage();
    String type="accepAuto";
    String fichier= "xml.xml";
    XMLParser p= new XMLParser();
    String emetteur= p.recupererEmetteur(fichier);
    String recepteur= p.recupererRecepteur(fichier);
    int msgId= p.recupererIdMsg(fichier);
    
    public InterfaceAcc() {
        initComponents();
    }

  
  
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void boutonAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAccepterActionPerformed

        String acc = "Accepte";
        Statement s = setR.ConnectionDB();
        setR.repAuto(s, acc);
        int idF=setR.ajoutFichier(s,emetteur,recepteur);
        
        JOptionPane.showMessageDialog(null, "Demande acceptée");
    }//GEN-LAST:event_boutonAccepterActionPerformed

    private void boutonRefuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonRefuserActionPerformed
        String ref = "Refuse";
        Statement s = setR.ConnectionDB();
        setR.repAuto(s, ref);
        setR.supprimeFic(s,emetteur, recepteur);
        JOptionPane.showMessageDialog(null, "Demande Refusée");

         XmlTools xmlTools = new XmlTools();
         
        xmlTools.accepterAuth("xml.xml");
    }//GEN-LAST:event_boutonAccepterActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Statement s = setU.ConnectionDB();
            System.out.println("connexion réussie");

            new InterfaceAcc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonAccepter;
    private javax.swing.JButton boutonRefuser;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel messageTroc;
    private javax.swing.JLabel titreFenetreAcc;
    // End of variables declaration//GEN-END:variables
}
