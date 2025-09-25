package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;
import Model.AgriculturalInputs;
import Model.Farmland;

public class FarmlandDAO {

    public Farmland save(Farmland farmland){
        String sql = "INSERT INTO farmland (name, area, id_farm, id_crop) VALUES (?,?,?,?)";
        try (Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, farmland.getFarmlandName());
            stmt.setDouble(2, farmland.getArea());
            stmt.setInt(3, farmland.getFarm().getFarmId());
            stmt.setInt(4, farmland.getCrop().getCropId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    farmland.setFarmlandId(rs.getInt(1));
                }
            }
            return farmland;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addInputsOnFarmland(Farmland farmland){
        String sql = "INSERT INTO inputs_farmland (id_input, id_farmland) VALUES (?,?)";
        try(Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)){
            getByName(farmland);
            AgriculturalInputsDAO inputsDAO = new AgriculturalInputsDAO();
            System.out.println(farmland.getFarmlandId());
            for(AgriculturalInputs agriculturalInputs : farmland.getInputs()){
                inputsDAO.save(agriculturalInputs);
                if(agriculturalInputs.getInputId() == 0) {
                    throw new RuntimeException("Input ID not generated");
                }
                stmt.setInt(1, agriculturalInputs.getInputId());
                stmt.setInt(2, farmland.getFarmlandId());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getByName(Farmland farmland){
        String sql = "SELECT id FROM farmland WHERE name = ?";
        try(Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, farmland.getFarmlandName());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                farmland.setFarmlandId(rs.getInt("id"));
            }
            return farmland.getFarmlandId();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        
    }
}
