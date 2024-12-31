package dao;

import entity.Classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseImpl implements IClasse{

    private final Connection cnx = new DB().getConnection();

    @Override
    public int add(Classe entity) {
        String sql = "INSERT INTO classe(nom, effectif) VALUES ( ?, ?) ";
        try{
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, entity.getNom());
            preparedStatement.setInt(2, entity.getEffectif());
            preparedStatement.executeUpdate();
            return  1;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public int update(Classe entity) {
        try{
            String sql = "UPDATE classe SET nom = ?, effectif = ? WHERE id = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1,entity.getNom());
            preparedStatement.setInt(2, entity.getEffectif());
            preparedStatement.setInt(3,entity.getId());
            preparedStatement.executeUpdate();
            return  1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(Classe entity) {
        try{
            String sql = "DELETE FROM classe WHERE id = ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1,entity.getId());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Classe> list() {
        ArrayList<Classe> allClasses = new ArrayList<Classe>();
        try{
            String sql = "SELECT * FROM classe";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                int effectif = resultSet.getInt("effectif");
                Classe classe = new Classe(id, nom, effectif);
                allClasses.add(classe);
            }
            return allClasses;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Classe get(int id) {
        try{
            String sql = "SELECT * FROM classe WHERE id =?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Classe classe = new Classe();
            while (resultSet.next()){
                int cId = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                int effectif = resultSet.getInt("effectif");
                classe.setId(cId);
                classe.setNom(nom);
                classe.setEffectif(effectif);
            }
            return classe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
