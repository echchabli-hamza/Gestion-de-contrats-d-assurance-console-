package service;


import dao.ClientDao;
import model.Client;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientService {

    private ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDao();
    }


    public boolean addClient(Client client) {
        return clientDao.createClient(client);
    }

    public boolean deleteClient(int clientId, int conseillerId) {
        return clientDao.deleteClient(clientId, conseillerId);
    }


    public Optional<Client> getClientById(int clientId) {
        return clientDao.getClientById(clientId);
    }


    public List<Client> searchClientsByNom(String nom) {
        List<Client> clients = clientDao.getAllClients();
        return clients.stream()
                .filter(c -> c.getNom().equalsIgnoreCase(nom))
                .collect(Collectors.toList());
    }


    public List<Client> sortClientsByNom() {
        List<Client> clients = clientDao.getAllClients();
        return clients.stream()
                .sorted(Comparator.comparing(Client::getNom))
                .collect(Collectors.toList());
    }


    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

}
