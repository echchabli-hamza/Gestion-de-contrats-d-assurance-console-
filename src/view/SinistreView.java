package view;

import Type.TypeSinistre;
import model.Sinistre;
import service.SinistreService;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SinistreView {

    private SinistreService sinistreService;
    private Scanner scanner;

    public SinistreView() {
        this.sinistreService = new SinistreService();
        this.scanner = new Scanner(System.in);
    }

    public void index() {
        while (true) {
            System.out.println("\n--- Menu Sinistre ---");
            System.out.println("1. Ajouter un sinistre");
            System.out.println("2. Supprimer un sinistre par ID");
            System.out.println("3. Calculer le coût total des sinistres d’un client par ID client");
            System.out.println("4. Rechercher un sinistre par ID");
            System.out.println("5. Afficher les sinistres d’un contrat par ID contrat");
            System.out.println("6. Afficher les sinistres triés par montant décroissant");
            System.out.println("7. Afficher les sinistres par ID client");
            System.out.println("8. Afficher les sinistres avant une date donnée");
            System.out.println("9. Afficher les sinistres dont le coût est supérieur à un montant donné");
            System.out.println("10. Quitter");
            System.out.print("Votre choix: ");

            int choice = readInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSinistre();
                    break;
                case 2:
                    deleteSinistre();
                    break;
                case 3:
                    totalCoutByClient();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    listByContratId();
                    break;
                case 6:
                    listSortedByMontant();
                    break;
                case 7:
                    listByClientId();
                    break;
                case 8:
                    listBeforeDate();
                    break;
                case 9:
                    listAboveMontant();
                    break;
                case 10:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private void addSinistre() {
        System.out.print("ID du contrat associé: ");
        int contratId = readInt();
        scanner.nextLine();

        System.out.print("Date du sinistre (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine().replace("/", "-");
        Date date = Date.valueOf(dateStr);

        System.out.print("Montant du sinistre: ");
        double montant = readDouble();
        scanner.nextLine();

        System.out.print("Description du sinistre: ");
        String description = scanner.nextLine();

        System.out.print("Description du TYPE => : ACCIDENT_VOITURE  , ACCIDENT_MAISON,  MALADIE  ");
        String type = scanner.nextLine();


        Sinistre sinistre = new Sinistre(date, montant, description , TypeSinistre.valueOf(type), contratId);

        boolean success = sinistreService.createSinistre(sinistre);
        System.out.println(success ? "Sinistre ajouté avec succès." : "Erreur lors de l’ajout.");
    }

    private void deleteSinistre() {
        System.out.print("ID du sinistre à supprimer: ");
        int id = readInt();
        scanner.nextLine();

        boolean success = sinistreService.deleteSinistreById(id);
        System.out.println(success ? "Sinistre supprimé." : "Sinistre non trouvé.");
    }

    private void totalCoutByClient() {
        System.out.print("ID du client: ");
        int clientId = readInt();
        scanner.nextLine();

        double total = sinistreService.getTotalCoutByClientId(clientId);
        System.out.println("Coût total des sinistres pour le client " + clientId + " = " + total);
    }

    private void searchById() {
        System.out.print("ID du sinistre: ");
        int id = readInt();
        scanner.nextLine();

        Optional<Sinistre> sinistre = sinistreService.getSinistreById(id);
        if(sinistre.isPresent()) {
            System.out.println(sinistre.get());
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private void listByContratId() {
        System.out.print("ID du contrat: ");
        int contratId = readInt();
        scanner.nextLine();

        List<Sinistre> sinistres = sinistreService.getSinistresByContratId(contratId);
        if (sinistres.isEmpty()) {
            System.out.println("Aucun sinistre trouvé pour ce contrat.");
        } else {
            sinistres.forEach(System.out::println);
        }
    }

    private void listSortedByMontant() {
        List<Sinistre> sinistres = sinistreService.getSinistresSortedByMontantDesc();
        if (sinistres.isEmpty()) {
            System.out.println("Aucun sinistre enregistré.");
        } else {
            sinistres.forEach(System.out::println);
        }
    }

    private void listByClientId() {
        System.out.print("ID du client: ");
        int clientId = readInt();
        scanner.nextLine();

        List<Sinistre> sinistres = sinistreService.getSinistresByClientId(clientId);
        if (sinistres.isEmpty()) {
            System.out.println("Aucun sinistre trouvé pour ce client.");
        } else {
            sinistres.forEach(System.out::println);
        }
    }

    private void listBeforeDate() {
        System.out.print("Date limite (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine().replace("/", "-");
        Date date = Date.valueOf(dateStr);

        List<Sinistre> sinistres = sinistreService.getSinistresBeforeDate(date);
        if (sinistres.isEmpty()) {
            System.out.println("Aucun sinistre trouvé avant cette date.");
        } else {
            sinistres.forEach(System.out::println);
        }
    }

    private void listAboveMontant() {
        System.out.print("Montant minimum: ");
        double montant = readDouble();
        scanner.nextLine();

        List<Sinistre> sinistres = sinistreService.getSinistresAboveMontant(montant);
        if (sinistres.isEmpty()) {
            System.out.println("Aucun sinistre trouvé au-dessus de ce montant.");
        } else {
            sinistres.forEach(System.out::println);
        }
    }



    private double readDouble() {
        while (true) {
            try {
                double value = scanner.nextDouble();

                return value;
            } catch (InputMismatchException e) {
                System.out.println(" Erreur : Entrez un nombre valide (double).");
                scanner.nextLine();
            }
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
