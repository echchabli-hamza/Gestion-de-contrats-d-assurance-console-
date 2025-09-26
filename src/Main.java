import Type.TypeContract;
import Type.TypeSinistre;
import dao.ClientDao;
import dao.ConseillerDao;
import dao.ContratDao;
import dao.SinistreDao;
import model.Client;
import model.Conseiller;
import view.ClientView;
import view.ConseillerView;
import model.Sinistre;
import service.ClientService;
import service.ConseillerService;
import service.ContratService;
import view.ContratView;
import view.SinistreView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        SinistreView sd = new SinistreView();

        //    ContratDao cd = new ContratDao();
//
//        Contrat c = new Contrat( Date.valueOf("2025-09-01") , Date.valueOf("2025-09-01"), TypeContract.AUTOMOBILE );
//
//        Contrat c1 = new Contrat( Date.valueOf("2025-09-01") , Date.valueOf("2025-09-01"), TypeContract.AUTOMOBILE );
//
//        Contrat c2 = new Contrat( Date.valueOf("2025-09-01") , Date.valueOf("2025-09-01"), TypeContract.AUTOMOBILE );
//
//        Contrat c3 = new Contrat( Date.valueOf("2025-09-01") , Date.valueOf("2025-09-01"), TypeContract.AUTOMOBILE );
//
//        Contrat c4 = new Contrat( Date.valueOf("2025-09-01") , Date.valueOf("2025-09-01"), TypeContract.AUTOMOBILE );
//
//
//
//
//
//        System.out.println(c.getId());
//
//        cd.createContrat(c1 , 6);
//
//        cd.createContrat(c2 , 6);
//
//        cd.createContrat(c3 , 6);


        sd.index();

    }


}