package sn.isi.dao;

import sn.isi.entities.User;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements  IUser {
    private DB db = new DB();

    @Override
    public int add(User user) {
        String sql = "INSERT INTO user VALUES(NULL, ?)";
        int ok = 0;
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1, user.getNom());
            db.getPstm().setString(2, user.getPrenom());
            db.getPstm().setString(3, user.getEmail());
            db.getPstm().setString(4, user.getPassword());
            db.getPstm().setInt(5, user.getUser().getId());
            ok = db.executeMaj();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM etudiant";
        try{
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));


                //Gestion de la classe
                //User  user = new User(rs.getInt(6), null);
                user.setUser(user);

                users.add(user);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void read(User user) {

    }


}
