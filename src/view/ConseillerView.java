package view;

import model.Client;
import model.Conseiller;
import service.ConseillerService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConseillerView {

    private ConseillerService conseillerService;
    private Scanner scanner;

    public ConseillerView() {
        this.conseillerService = new ConseillerService();
        this.scanner = new Scanner(System.in);
    }

    public void index() {
        while (true) {
            System.out.println("\n===== Menu Conseiller =====");
            System.out.println("1. Ajouter un conseiller (ID auto)");
            System.out.println("2. Supprimer un conseiller par ID");
            System.out.println("3. Rechercher un conseiller par ID");
            System.out.println("4. Afficher les clients d’un conseiller par ID");
            System.out.println("5. Quitter");
            System.out.print("Votre choix: ");

            int choice = readInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addConseiller();
                    break;
                case 2:
                    deleteConseiller();
                    break;
                case 3:
                    searchConseiller();
                    break;
                case 4:
                    listClientsByConseiller();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }

        }
    }

    private void addConseiller() {
        System.out.print("Nom du conseiller: ");
        String nom = scanner.nextLine();

        System.out.print("Prénom du conseiller: ");
        String prenom = scanner.nextLine();

        System.out.print("Prénom du email: ");
        String email = scanner.nextLine();

        Conseiller c = new Conseiller(nom, prenom, email);

        if (conseillerService.addConseiller(c)) {
            System.out.println(" Conseiller ajouté avec succès.");
        } else {
            System.out.println(" Erreur lors de l’ajout.");
        }
    }

    private void deleteConseiller() {
        System.out.print("ID du conseiller à supprimer: ");
        int id = readInt();
        scanner.nextLine();

        if (conseillerService.deleteConseillerbyId(id)) {
            System.out.println(" Conseiller supprimé avec succès.");
        } else {
            System.out.println(" Aucun conseiller trouvé avec cet ID.");
        }
    }

    private void searchConseiller() {
        System.out.print("ID du conseiller à rechercher: ");
        int id = readInt();
        scanner.nextLine();

        Optional<Conseiller> conseiller = conseillerService.getByIt(id);
        if (conseiller.isPresent()) {
            Conseiller c = conseiller.get();
            System.out.println(" Conseiller  : " + c.getConseillerId() + " nom : " + c.getNom() + " prenom :" + c.getPernom());
        } else {
            System.out.println(" Aucun conseiller trouvé.");
        }
    }

    private void listClientsByConseiller() {
        System.out.print("ID du conseiller: ");
        int id = readInt();
        scanner.nextLine();

        List<Client> clients = conseillerService.getclientByconseillerId(id);
        if (clients.isEmpty()) {
            System.out.println(" Aucun client trouvé pour ce conseiller.");
        } else {
            System.out.println(" Clients du conseiller " + id + " :");
            clients.forEach(c -> System.out.println(c.getClientId() + " nom : " + c.getNom() + " prenom :" + c.getPernom()));
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
