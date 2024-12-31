package entity;

public class Classe {
    private int id;
    private String nom;
    private int effectif;

    public Classe(int id, String nom, int effectif) {
        this.id = id;
        setNom(nom);
        this.effectif = 0;
        this.effectif = effectif;
    }
    public Classe(){};
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }
    @Override
    public String toString(){
        return String.format("Id: %d - Nom: %s - Effectif: %d", this.getId(), this.getNom(), this.getEffectif());
    }
}
