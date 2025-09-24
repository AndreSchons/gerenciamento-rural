package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;
import Model.Farm;
import Model.Farmland;

public class FarmDAO {

    public Farm save(Farm farm) {
        String sql = "INSERT INTO farm (name, location, total_area) VALUES (?,?,?)";
        try (Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, farm.getFarmName());
            stmt.setString(2, farm.getLocation());
            stmt.setDouble(3, farm.getTotalArea());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if(rs.next()) {
                    farm.setFarmId(rs.getInt(1));
                }
            } 
                FarmlandDAO farmlandDAO = new FarmlandDAO();
                for(Farmland farmland : farm.getFarmlands()) {
                    farmlandDAO.save(farmland);
                }

             sql = "INSERT INTO farmlands_farm (id_farm, id_farmland) VALUES (?,?)";
             try (PreparedStatement stmt2 = conexao.prepareStatement(sql)) {
                 stmt2.setInt(1, farm.getFarmId());
                 for(Farmland farmland : farm.getFarmlands()) {
                    stmt2.setInt(2, farmland.getFarmlandId());
                    stmt2.addBatch();
                 }
                    stmt2.executeBatch();
                }
                return farm;
            } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
}
