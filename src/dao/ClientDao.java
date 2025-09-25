package dao;

import  util.DB;
import model.Client ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class ClientDao {

    private Connection conn;

    public ClientDao(){

        this.conn = DB.getInstance().getConnection();

    }


    public boolean createClient(Client c){


        String url = "insert into Client ( client_id ,nom , Preonm , email , conseiller_id ) values (? ,?,?,? ,?)" ;


        try {


            PreparedStatement prmp = conn.prepareStatement(url);

            prmp.setInt(1 ,c.getClientId());
            prmp.setString(2 , c.getNom());
            prmp.setString(3 , c.getPernom());
            prmp.setString(4 , c.getEmail());
            prmp.setInt(5 ,c.getConseillerID());

            int res = prmp.executeUpdate();
            return res > 0;

        }
        catch(SQLException e){

            System.out.println("SQL Error : " + e.getMessage());

            return false;

        }

    }





    public boolean deleteClient(int clientId, int conseillerId) {
    String sql = "DELETE FROM Client WHERE client_id = ? AND conseiller_id = ?";
    try {
        PreparedStatement prmp = conn.prepareStatement(sql);

        prmp.setInt(1, clientId);
        prmp.setInt(2, conseillerId);

        int res = prmp.executeUpdate();

        return res > 0;

    } catch (SQLException e) {

        System.out.println("SQL Error: " + e.getMessage());
        return false;
    }
}








    public ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                Client c = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getInt("client_id"), rs.getInt("conseiller_id"));

                clients.add(c);

            }

        } catch (SQLException e) {

            System.err.println("Error fetching clients: " + e.getMessage());

        }

        return clients;

    }




}
