package dao;


import model.Conseiller;
import util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ConseillerDao {


    private Connection conn;

    public ConseillerDao() {
        this.conn = DB.getInstance().getConnection();
    }


    public boolean createConseiller(Conseiller c){

        String url = "INSERT INTO Conseiller ( conseiller_id ,nom , prenom , email  ) values (? ,?,?,?)";


        try{

            PreparedStatement prmp = conn.prepareStatement(url);

            prmp.setInt(1 ,c.getConseillerId());
            prmp.setString(2 , c.getNom());
            prmp.setString(3 , c.getPernom());
            prmp.setString(4 , c.getEmail());

            int res=prmp.executeUpdate();
            return res >0;

        } catch (SQLException e) {
            System.out.println("Error :"+e.getMessage());
            return false ;
        }

    }

    public ArrayList<Conseiller> getAll(){


        ArrayList<Conseiller> listeCr = new ArrayList<>();

        String url ="Select * from Conseiller";


        try {
            PreparedStatement prmp = conn.prepareStatement(url);

            ResultSet res = prmp.executeQuery();

            while(res.next()){
                Conseiller cr = new Conseiller(res.getString("nom") , res.getString("prenom") , res.getString("email") , res.getInt("conseiller_id"));

               System.out.println(cr.toString());
                listeCr.add(cr);

            }

        }
        catch(SQLException e){
            System.out.println("SQL Error" + e.getMessage());

        }

        return listeCr;

    }

    public boolean deleteById(int conseillerId) {
        String sql = "DELETE FROM Conseiller WHERE conseiller_id = ?";
        try {
            PreparedStatement prmp = conn.prepareStatement(sql);
            prmp.setInt(1, conseillerId);

            int res = prmp.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }



    public Optional<Conseiller> getConseillerById(int conseillerId) {
        String sql = "SELECT conseiller_id, nom, prenom, email FROM Conseiller WHERE conseiller_id = ?";
        try {
            PreparedStatement prmp = conn.prepareStatement(sql);
            prmp.setInt(1, conseillerId);

            ResultSet rs = prmp.executeQuery();
            if (rs.next()) {
                Conseiller c = new Conseiller(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("conseiller_id"));

                return Optional.of(c);

            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return Optional.empty();
    }





}
