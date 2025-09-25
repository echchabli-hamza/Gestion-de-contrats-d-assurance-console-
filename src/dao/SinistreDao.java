package dao;

import Type.TypeSinistre;
import model.Sinistre;
import util.DB;

import java.sql.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

public class SinistreDao {

    private Connection conn;

    public SinistreDao() {
        this.conn = DB.getInstance().getConnection();
    }

    public boolean createSinistre(Sinistre s ) {
        String sql = "INSERT INTO Sinistre (sinistre_id, contrat_id, date, montant, description, type) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

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







    public ArrayList<Sinistre> getAll(){

        String query = "SELECT * FROM sinistre";

        ArrayList<Sinistre> liste = new ArrayList<>();


        try(PreparedStatement pstmt = conn.prepareStatement(query)) {

           ResultSet res= pstmt.executeQuery();

           while (res.next()){

               Sinistre s= new Sinistre(res.getInt("sinistre_id") , res.getDate("date"),res.getDouble("montant") , res.getString("description"), TypeSinistre.valueOf(res.getString("type")),res.getInt("contrat_id"));

               liste.add(s);

           }

          }catch(SQLException s){

            System.out.println("Error : " + s.getMessage());

          }

        return liste ;

    }







}
