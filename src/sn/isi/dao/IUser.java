package sn.isi.dao;

import sn.isi.entities.User;

import java.util.List;

public  interface IUser {
    public int add (User user);
    public void update (User user);
    public void delete (User user);
    public void read (User user);
    public List<User> list();
}
