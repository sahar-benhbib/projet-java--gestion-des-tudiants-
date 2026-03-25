import java.util.Scanner;

public class GestionEtudiants {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n--- Menu Étudiant ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Quitter");
            System.out.print("Choix: ");
            int choix = sc.nextInt();
            sc.nextLine(); 

            switch (choix) {
                case 1:
                    ajouterEtudiant(sc);
                    break;
                case 2:
                    continuer = false;
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        sc.close();
    }

    public static void ajouterEtudiant(Scanner sc) {
        System.out.print("Nom de l'étudiant: ");
        String nom = sc.nextLine();

        int age;
        while (true) {
            try {
                System.out.print("Âge: ");
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erreur: entrez un nombre valide.");
            }
        }

        double[] notes = new double[4];
        for (int i = 0; i < notes.length; i++) {
            while (true) {
                try {
                    System.out.print("Note " + (i + 1) + ": ");
                    notes[i] = Double.parseDouble(sc.nextLine());
                    if (notes[i] >= 0 && notes[i] <= 20) break;
                    else System.out.println("La note doit être entre 0 et 20.");
                } catch (NumberFormatException e) {
                    System.out.println("Erreur: entrez un nombre valide.");
                }
            }
        }

        double moyenne = calculerMoyenne(notes);
        String mention = analyserMoyenne(moyenne);

        System.out.println("\n--- Résultat Étudiant ---");
        System.out.println("Nom: " + nom);
        System.out.println("Âge: " + age);
        System.out.print("Notes: ");
        for (double n : notes) System.out.print(n + " ");
        System.out.println("\nMoyenne: " + moyenne);
        System.out.println("Mention: " + mention);
    }

    public static double calculerMoyenne(double[] liste) {
        double somme = 0;
        for (double n : liste) somme += n;
        return Math.round((somme / liste.length) * 100.0) / 100.0;
    }

    public static String analyserMoyenne(double moyenne) {
        if (moyenne >= 16) return "Excellent";
        else if (moyenne >= 14) return "Très bien";
        else if (moyenne >= 12) return "Bien";
        else if (moyenne >= 10) return "Passable";
        else return "Refusé";
    }
}