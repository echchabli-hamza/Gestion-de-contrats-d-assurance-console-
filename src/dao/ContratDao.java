package dao;

import  java.sql.Connection;

import model.Contrat;
import util.DB;


public class ContratDao {


    Connection conn ;



    public ContratDao(){

        conn = DB.getInstance().getConnection();

    }









}
