import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CalculStat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> liste = new ArrayList<>();

        System.out.println("Entrée des nombres (vide pour finir) :");

        while (true) {
            String ligne = scanner.nextLine().trim();

            if (ligne.isEmpty()) {
                break;
            }

            try {
                double valeur = Double.parseDouble(ligne);
                liste.add(valeur);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        if (liste.isEmpty()) {
            System.out.println("Aucune valeur saisie");
            return;
        }

        double[] tableau = new double[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            tableau[i] = liste.get(i);
        }

        double min = tableau[0];
        double max = tableau[0];
        double somme = 0;

        for (double v : tableau) {
            if (v < min) min = v;
            if (v > max) max = v;
            somme += v;
        }

        double moyenne = somme / tableau.length;

        Arrays.sort(tableau);

        System.out.println("Minimum  : " + min);
        System.out.println("Maximum : " + max);
        System.out.println("Somme : " + somme);
        System.out.println("Moyenne : " + moyenne);
        System.out.println("\nTableau trié : " + Arrays.toString(tableau));

        scanner.close();
    }
}