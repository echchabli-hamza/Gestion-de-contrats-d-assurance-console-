package view;

import model.Contrat;
import model.Client;
import Type.TypeContract;
import service.ContratService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ContratView {

    private ContratService contratService;
    private Scanner scanner;

    public ContratView() {
        this.contratService = new ContratService();
        this.scanner = new Scanner(System.in);
    }

    public void index() {
        while (true) {
            System.out.println("\n--- Menu Contrat ---");
            System.out.println("1. Ajouter un contrat");
            System.out.println("2. Supprimer un contrat par ID");
            System.out.println("3. Rechercher un contrat par ID");
            System.out.println("4. Afficher les contrats d'un client par ID");
            System.out.println("5. Afficher tous les contrats");
            System.out.println("6. Quitter");
            System.out.print("Votre choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContrat();
                    break;
                case 2:
                    deleteContrat();
                    break;
                case 3:
                    searchContratById();
                    break;
                case 4:
                    listContratsByClientId();
                    break;
                case 5:
                    listAllContrats();
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private void addContrat() {
        System.out.print("ID du client: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type de contrat (ex: AUTOMOBILE , IMMOBILIER , MALADIE: ");
        String type = scanner.nextLine();

        System.out.print("Date début (YYYY-MM-DD): ");
        Date dateDebut = Date.valueOf(scanner.nextLine());

        System.out.print("Date fin (YYYY-MM-DD): ");
        Date dateFin = Date.valueOf(scanner.nextLine());


        Contrat contrat = new Contrat(dateDebut, dateFin, TypeContract.valueOf(type), clientId);

        boolean success = contratService.addContrat(contrat);
        System.out.println(success ? "Contrat ajouté avec succès !" : "Erreur lors de l'ajout.");
    }

    private void deleteContrat() {
        System.out.print("ID du contrat à supprimer: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean success = contratService.deleteContrat(id);
        System.out.println(success ? "Contrat supprimé." : "Contrat non trouvé.");
    }

    private void searchContratById() {
        System.out.print("ID du contrat à rechercher: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Contrat> contrat = contratService.getContratById(id);
        if(contrat.isPresent()) {
            System.out.println(contrat.get());
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private void listContratsByClientId() {
        System.out.print("ID du client: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        List<Contrat> contrats = contratService.getContratsByClientId(clientId);
        if (contrats.isEmpty()) {
            System.out.println("Aucun contrat trouvé pour ce client.");
        } else {
            contrats.forEach(System.out::println);
        }
    }

    private void listAllContrats() {
        List<Contrat> contrats = contratService.getAllContrats();
        if (contrats.isEmpty()) {
            System.out.println("Aucun contrat enregistré.");
        } else {
            contrats.forEach(System.out::println);
        }
    }
}
