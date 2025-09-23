package dao;

import model.Sinistre;
import util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SinistreDao {

    private Connection conn;

    public SinistreDao() {
        this.conn = DB.getInstance().getConnection();
    }

    public boolean createSinistre(Sinistre s ) {
        String sql = "INSERT INTO Sinistre (sinistre_id, contrat_id, date, montant, description, type) VALUES (?, ?, ?, ?, ?, ?)";

        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, s.getId());
            pstmt.setInt(2, s.getContrat_id() );
            pstmt.setDate(3, s.getDate());
            pstmt.setDouble(4, s.getMontant());
            pstmt.setString(5, s.getDescription());
            pstmt.setString(6, s.getType().name());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error creating Sinistre: " + e.getMessage());
            return false;
        }
    }







}
