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


    public HashMap<Integer, Client> getClientsByConseillerId(int conseillerId) {
        HashMap<Integer, Client> clientsMap = new HashMap<>();
        String sql = "SELECT client_id, nom, prenom, email, conseiller_id FROM Client WHERE conseiller_id = ?";

        try {
            PreparedStatement prmp = conn.prepareStatement(sql);
            prmp.setInt(1, conseillerId);

            ResultSet rs = prmp.executeQuery();
            while (rs.next()) {
                Client c = new Client(rs.getString("nom"),rs.getString("prenom"), rs.getString("email"), rs.getInt("client_id"), rs.getInt("conseiller_id"));
                clientsMap.put(c.getClientId(), c);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return clientsMap;
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


    public List<Client> getClientsByNom(String nom) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client WHERE nom = ?";

        try {
            PreparedStatement prmp = conn.prepareStatement(sql);
            prmp.setString(1, nom);

            ResultSet rs = prmp.executeQuery();
            while (rs.next()) {
                Client c = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getInt("client_id"), rs.getInt("conseiller_id"));
                clients.add(c);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return clients;
    }


    public Optional<Client> getClientById(int clientId) {
        String sql = "SELECT * FROM Client WHERE client_id = ?";

        try {
            PreparedStatement prmp = conn.prepareStatement(sql);
            prmp.setInt(1, clientId);

            ResultSet rs = prmp.executeQuery();
            if (rs.next()) {
                Client c = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getInt("client_id"), rs.getInt("conseiller_id"));
                return Optional.of(c);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return Optional.empty();
    }


    public HashMap<Integer , Client> getAllClient(int conseiller_id){


        HashMap<Integer , Client> liste = new HashMap<>();

        String query = "SELECT * FROM client WHERE conseiller_id = ?;";

        try {

            PreparedStatement prmp = conn.prepareStatement(query);

            prmp.setInt(1 , conseiller_id);

            ResultSet res= prmp.executeQuery();

            while(res.next()){

                Client obj = new Client(res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getInt("client_id"), res.getInt("conseiller_id"));



                liste.put(res.getInt("client_id") , obj);

            }

        }catch (SQLException s){
            System.out.println("SQL Error" + s.getMessage());
        }

        return liste;
    }

}
