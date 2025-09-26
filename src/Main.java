import view.ClientView;
import view.ConseillerView;
import view.ContratView;
import view.SinistreView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Gérer les Conseillers");
            System.out.println("2. Gérer les Clients");
            System.out.println("3. Gérer les Contrats");
            System.out.println("4. Gérer les Sinistres");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // vider le buffer

            switch (choix) {
                case 1:
                    new ConseillerView().index();
                    break;
                case 2:
                    new ClientView().index();
                    break;
                case 3:
                    new ContratView().index();
                    break;
                case 4:
                    new SinistreView().index();
                    break;
                case 0:
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
