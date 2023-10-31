package sn.isi.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    // pour la connexion
    private Connection cnx;
    // pour les resultats des requetes de type select
    private ResultSet rs;
    // pour les requetes prepares
    private PreparedStatement pstm;
    // pour les resultats des requetes de type mise a jour ( insert, update....)
    private int ok;

    private void ouvrirConnexion() {
        String url = "jdbc:mysql://localhost:3306/jdbc ";
        String mysqluser = "root";
        String mysqlpassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, mysqluser, mysqlpassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void initPrepar(String sql) {
        try{
            ouvrirConnexion();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public ResultSet executeSelect() {
        try {
            rs = pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public int executeMaj() {
        try {
            ok = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }
}
