package dao;

import entity.Etudiant;

import java.util.ArrayList;

public interface IEtudiant extends Repository<Etudiant> {
    ArrayList<Etudiant> getEtudiantByClassName(String classe);
}
