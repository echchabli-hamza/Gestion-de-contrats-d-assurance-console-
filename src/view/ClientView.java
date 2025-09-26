package view;

import model.Client;
import service.ClientService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClientView {

    private final ClientService clientService;
    private final Scanner scanner;

    public ClientView() {
        this.clientService = new ClientService();
        this.scanner = new Scanner(System.in);
    }

    public void index() {
        while (true) {
            System.out.println("\n=== Menu Client ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client");
            System.out.println("3. Rechercher un client par nom");
            System.out.println("4. Rechercher un client par ID");
            System.out.println("5. Afficher clients par ID du conseiller");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option: ");

            int choice = readInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    deleteClient();
                    break;
                case 3:
                    searchClientByNom();
                    break;
                case 4:
                    searchClientById();
                    break;
                case 5:
                    listClientsByConseiller();
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private void addClient() {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("ID du conseiller: ");
        int conseillerId = readInt();
        scanner.nextLine();

        Client client = new Client(nom, prenom, email, conseillerId);
        if (clientService.addClient(client)) {
            System.out.println("Client ajouté avec succès !");
        } else {
            System.out.println("Erreur lors de l'ajout du client.");
        }
    }

    private void deleteClient() {
        System.out.print("ID du client à supprimer: ");
        int clientId = readInt();
        System.out.print("ID du conseiller: ");
        int conseillerId = readInt();
        scanner.nextLine();

        if (clientService.deleteClient(clientId, conseillerId)) {
            System.out.println("Client supprimé avec succès !");
        } else {
            System.out.println("Erreur lors de la suppression du client.");
        }
    }

    private void searchClientByNom() {
        System.out.print("Nom du client à rechercher: ");
        String nom = scanner.nextLine();

        List<Client> results = clientService.searchClientsByNom(nom);
        if (results.isEmpty()) {
            System.out.println("Aucun client trouvé avec ce nom.");
        } else {
            System.out.println("Clients trouvés (triés par nom):");
            results.stream()
                    .sorted((c1, c2) -> c1.getNom().compareToIgnoreCase(c2.getNom()))
                    .forEach(System.out::println);
        }
    }

    private void searchClientById() {
        System.out.print("ID du client: ");
        int clientId = readInt();
        scanner.nextLine();

        Optional<Client> client = clientService.getClientById(clientId);
        if(client.isPresent()) {
            System.out.println(client.get());
        } else {
            System.out.println("Client non trouvé.");
        }

    }

    private void listClientsByConseiller() {
        System.out.print("ID du conseiller: ");
        int conseillerId = readInt();
        scanner.nextLine();

        List<Client> clients = clientService.getAllClients().stream()
                .filter(c -> c.getConseillerID() == conseillerId)
                .collect(Collectors.toList());

        if (clients.isEmpty()) {
            System.out.println("Aucun client pour ce conseiller.");
        } else {
            System.out.println("Clients du conseiller " + conseillerId + ":");
            clients.forEach(System.out::println);
        }
    }


    private int readInt() {
        while (true) {
            try {

                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println(" Erreur : Entrez un nombre entier valide.");
                scanner.nextLine();
            }
        }
    }
}
