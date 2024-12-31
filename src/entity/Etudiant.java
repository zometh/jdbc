package entity;

import dao.ClasseImpl;

import java.time.LocalDateTime;

public class Etudiant {
    private int id;
    private String matricule;
    private String prenom;
    private String nom;
    private double moyenne;
    private int idC;
    private static final ClasseImpl imp = new ClasseImpl();
    public Etudiant(int id,String matricule, String prenom, String nom, double moyenne, int idC) {
        this.id = id;
        setPrenom(prenom);
        setNom(nom);
        setMoyenne(moyenne);
        setIdC(idC);
        setMatricule(matricule);

    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public  Etudiant(){

    }
    public int getId() {
        return id;
    }



    public String getMatricule() {
        return matricule;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMoyenne() {
        return this.moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void generateMatricule(){

        LocalDateTime localDateTime = LocalDateTime.now();
        ClasseImpl impl = new ClasseImpl();
        Classe classe = impl.get(this.idC);

        this.matricule =  "ET@"
                + localDateTime.getYear()
                + localDateTime.getMonth()
                + localDateTime.getDayOfMonth()
                + localDateTime.getHour()
                + localDateTime.getMinute()
                + classe.getNom()
                ;
    }
    public int getIdC() {
        return this.idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    @Override
    public String toString() {

        Classe classe = imp.get(this.idC);
        String infos = String.format(
                "Id: %d - Prenom: %s - Nom: %s - Matricule: %s - Moyenne: %f - Classe: %s",
                getId(), getPrenom(), getNom(), getMatricule(), getMoyenne(), classe.getNom()
        );
        return infos;
    }
}
