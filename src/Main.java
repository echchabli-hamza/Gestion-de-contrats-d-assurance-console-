import Type.TypeSinistre;
import dao.ClientDao;
import dao.ConseillerDao;
import dao.SinistreDao;
import model.Client;
import model.Conseiller;
import model.Sinistre;

import java.sql.Date;
import java.util.HashMap;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        ConseillerDao cd = new ConseillerDao();

        Optional res = cd.getConseillerById(6);




        System.out.println(res.toString());






    }



}