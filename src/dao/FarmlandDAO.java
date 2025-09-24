package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;
import Model.Farmland;

public class FarmlandDAO {

    public Farmland save(Farmland farmland) {
        String sql = "INSERT INTO farmland (name, area, id_farm, id_crop) VALUES (?,?,?,?)";
        try (Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, farmland.getFarmlandName());
            stmt.setDouble(2, farmland.getArea());
            stmt.setInt(3, farmland.getFarm().getFarmId());
            stmt.setInt(4, farmland.getCrop().getCropId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if(rs.next()) {
                    farmland.setFarmlandId(rs.getInt(1));
                }
            }
            return farmland;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
