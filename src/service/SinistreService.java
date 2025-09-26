package service;

import dao.SinistreDao;
import dao.ContratDao;
import model.Sinistre;
import model.Contrat;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SinistreService {

    private SinistreDao sinistreDao;
    private ContratDao contratDao;

    public SinistreService() {
        this.sinistreDao = new SinistreDao();
        this.contratDao = new ContratDao();
    }

    public boolean createSinistre(Sinistre s) {
        return sinistreDao.createSinistre(s);
    }

    public List<Sinistre> getAllSinistres() {
        return sinistreDao.getAll();
    }

    public Optional<Sinistre> getSinistreById(int id) {
        return sinistreDao.getAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public List<Sinistre> getSinistresByContratId(int contratId) {
        return sinistreDao.getAll().stream()
                .filter(s -> s.getContrat_id() == contratId)
                .collect(Collectors.toList());
    }

    public boolean deleteSinistreById(int id) {
        return sinistreDao.deleteSinistreById(id);
    }

    public double getTotalCoutByClientId(int clientId) {
        List<Integer> contratsIds = contratDao.getAllContrats().stream()
                .filter(c -> c.getclientId() == clientId)
                .map(Contrat::getId)
                .collect(Collectors.toList());

        return sinistreDao.getAll().stream()
                .filter(s -> contratsIds.contains(s.getContrat_id()))
                .mapToDouble(Sinistre::getMontant)
                .sum();
    }

    public List<Sinistre> getSinistresSortedByMontantDesc() {
        return sinistreDao.getAll().stream()
                .sorted(Comparator.comparingDouble(Sinistre::getMontant).reversed())
                .collect(Collectors.toList());
    }


    public List<Sinistre> getSinistresByClientId(int clientId) {
        List<Integer> contratsIds = contratDao.getAllContrats().stream()
                .filter(c -> c.getclientId() == clientId)
                .map(Contrat::getId)
                .collect(Collectors.toList());

        return sinistreDao.getAll().stream()
                .filter(s -> contratsIds.contains(s.getContrat_id()))
                .collect(Collectors.toList());
    }


    public List<Sinistre> getSinistresBeforeDate(Date date) {
        return sinistreDao.getAll().stream()
                .filter(s -> s.getDate().before(date))
                .collect(Collectors.toList());
    }


    public List<Sinistre> getSinistresAboveMontant(double montant) {
        return sinistreDao.getAll().stream()
                .filter(s -> s.getMontant() > montant)
                .collect(Collectors.toList());
    }
}
