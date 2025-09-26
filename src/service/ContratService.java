package service;

import dao.ContratDao;
import model.Contrat;
import Type.TypeContract;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContratService {

    private ContratDao contratDao;


    public ContratService() {
        this.contratDao = new ContratDao();
    }


    public boolean addContrat(Contrat c){

        return contratDao.createContrat(c);

    }


    public Optional<Contrat> getContratById(int id) {
        List<Contrat> contrats = contratDao.getAllContrats();
        return contrats.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }



    public boolean deleteContrat(int id) {
        return contratDao.deleteById(id);
    }


    public List<Contrat> getContratsByClientId(int clientId) {
        List<Contrat> contrats = contratDao.getAllContrats();

        return contrats.stream()
                .filter(c -> c.getclientId() == clientId)
                .collect(Collectors.toList());
    }


    public List<Contrat> getAllContrats() {
        return contratDao.getAllContrats();
    }
 }
