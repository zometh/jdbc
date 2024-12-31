package main;

import dao.EtudiantImpl;

import entity.Etudiant;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {


        EtudiantImpl impl = new EtudiantImpl();
        ArrayList<Etudiant> etudiants = impl.list();
        etudiants.forEach(System.out::println);


    }
}
