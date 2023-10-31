package sn.isi.dao;

import sn.isi.entities.Profil;


import java.util.List;

public interface Iprofil {
    public void add (Profil profil);
    public List<Profil> list();
    public void update (Profil profil);
    public void delete (Profil profil);

}
