package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;
import Model.AgriculturalInputs;

public class AgriculturalInputsDAO {

    public AgriculturalInputs save(AgriculturalInputs agriculturalInputs) {
        String sql = "INSERT INTO agricultural_inputs (name, type_input, quantity, application_method) VALUES (?,?,?,?)";
        try (Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, agriculturalInputs.getInputName());
            stmt.setString(2, agriculturalInputs.getInputType());
            stmt.setDouble(3, agriculturalInputs.getQuantity());
            stmt.setString(4, agriculturalInputs.getApplicationMethod());
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    agriculturalInputs.setInputId(rs.getInt(1));
                }
            }
            return agriculturalInputs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
}
