package dao;

import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;

import Type.TypeContract;
import model.Contrat;
import util.DB;


public class ContratDao {


    Connection conn ;



    public ContratDao(){

        conn = DB.getInstance().getConnection();

    }


    public boolean createContrat(Contrat c ) {
        String sql = "INSERT INTO Contrat (contrat_id, typecontrat, client_id, date_debut, date_fin) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, c.getId());
            pstmt.setString(2, c.getType().name());
            pstmt.setInt(3,  c.getclientId());
            pstmt.setDate(4, c.getDateDebut());
            pstmt.setDate(5, c.getDateFin());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error creating contrat: " + e.getMessage());
            return false;
        }
    }



    public boolean deleteById(int id) {
        String sql = "DELETE FROM Contrat WHERE contrat_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting contrat: " + e.getMessage());
            return false;
        }
    }





    public List<Contrat> getAllContrats() {
        List<Contrat> contrats = new ArrayList<>();
        String sql = "SELECT * FROM Contrat";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Contrat c = new Contrat(

                        rs.getInt("contrat_id"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        TypeContract.valueOf(rs.getString("typecontrat") ), rs.getInt("client_id")
                );


                contrats.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching contrats: " + e.getMessage());
        }

        return contrats;
    }







}
