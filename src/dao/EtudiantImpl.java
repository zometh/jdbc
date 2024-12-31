package dao;

import entity.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EtudiantImpl implements IEtudiant{
    private static final Connection cnx = new DB().getConnection();

    @Override
    public ArrayList<Etudiant> getEtudiantByClassName(String classe) {
        return null;
    }

    @Override
    public int add(Etudiant entity) {
        try{
            String sql = "INSERT INTO etudiant(prenom, nom, matricule, moyenne,idc) VALUES(?, ?, ?, ?, ?) ";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);

            preparedStatement.setString(1,entity.getPrenom());
            preparedStatement.setString(2,entity.getNom());
            preparedStatement.setString(3,entity.getMatricule());
            preparedStatement.setDouble(4,entity.getMoyenne());
            preparedStatement.setInt(5,entity.getIdC());
            preparedStatement.executeUpdate();
            sql = "UPDATE classe SET effectif = effectif + 1 WHERE id = ?";
            preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getIdC());
            preparedStatement.executeUpdate();
            return 1;

        }catch (SQLException e){
            //System.err.println("Erreur SQL : " + e.getMessage());

            throw new RuntimeException();
        }
    }

    @Override
    public int update(Etudiant entity) {
        try{
            String sql = "UPDATE etudiant SET nom = ?, prenom = ?, matricule = ?," +
                    " moyenne = ? WHERE id = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, entity.getNom());
            preparedStatement.setString(2, entity.getPrenom());
            preparedStatement.setString(3, entity.getMatricule());
            preparedStatement.setDouble(4, entity.getMoyenne());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.executeUpdate();
            return 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(Etudiant entity) {
        try{
            String sql = "DELETE FROM etudiant WHERE id = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
            sql = "UPDATE classe SET effectif = effectif - 1 WHERE id = ?";
            preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getIdC());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public ArrayList<Etudiant> list() {
        try{
            String sql = "SELECT * FROM etudiant";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            ResultSet rset = preparedStatement.executeQuery();
            ArrayList<Etudiant> etudiants = new ArrayList<>();
            while(rset.next()){
                Etudiant etudiant = new Etudiant(
                        rset.getInt("id"),
                        rset.getString("matricule"),
                        rset.getString("prenom"),
                        rset.getString("nom"),
                        rset.getDouble("moyenne"),
                        rset.getInt("idc")
                );
                etudiants.add(etudiant);
            }
            return etudiants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Etudiant get(int id) {
        try{
            String sql = "SELECT * FROM etudiant WHERE id = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rset = preparedStatement.executeQuery();
            Etudiant etudiant = null;
            while (rset.next()){
                etudiant = new Etudiant(
                        rset.getInt("id"),
                        rset.getString("matricule"),
                        rset.getString("prenom"),
                        rset.getString("nom"),
                        rset.getDouble("moyenne"),
                        rset.getInt("idc")
                );
            }
            return etudiant;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
