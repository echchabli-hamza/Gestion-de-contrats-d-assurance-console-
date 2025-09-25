package service;

import dao.ClientDao;
import dao.ConseillerDao;
import model.Client;
import model.Conseiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConseillerService {

           private ConseillerDao cs;
           private ClientDao cd;

    public ConseillerService(){


        this.cs = new ConseillerDao() ;
        this.cd = new ClientDao() ;

    }


    public boolean addConseiller(Conseiller c) {
        return cs.createConseiller(c);
    }


    public boolean deleteConseillerbyId(int id){
        return cs.deleteById(id);
    }


    public Optional<Conseiller> getByIt(int id){

        return cs.getConseillerById(id);

    }

    public List<Client> getclientByconseillerId(int id){


        List<Client> res = cd.getAllClients().stream().filter(n -> { return n.getConseillerID() == id ; }).collect(Collectors.toList());

        return res;

    }






}
