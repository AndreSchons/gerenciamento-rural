package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;
import Model.Crop;

public class CropDAO {

    public Crop save(Crop crop) {
        String sql = "INSERT INTO crop (name, variety, season, expectedGrowthTime) VALUES (?,?,?,?)";
        try (Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, crop.getCropName());
            stmt.setString(2, crop.getVariety());
            stmt.setString(3, crop.getSeason());
            stmt.setInt(4, crop.getExpectedGrowthTime());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if(rs.next()) {
                    crop.setCropId(rs.getInt(1));
                }
            }
            return crop;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
