import java.util.ArrayList;

public class TestPersonne {
    public static Etudiant rechercherparNom(Etudiant[] etudiants, String nom) {
        for (Etudiant e : etudiants) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Etudiant[] etudiants = {
                new Etudiant(1, "Baptiste", 21, "Master"),
                new Etudiant(2, "Thomas", 22, "L3"),
                new Etudiant(3, "Matteo", 22, "L3"),
                new Etudiant(4, "Léopaul", 19, "L2"),
                new Etudiant(5, "Rémi", 18, "L1")
        };

        System.out.println("Liste des etudiants :");
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }

        int ageMax = etudiants[0].getAge();
        for (Etudiant e : etudiants) {
            if (e.getAge() > ageMax) {
                ageMax = e.getAge();
            }
        }

        ArrayList<Etudiant> plusAges = new ArrayList<>();
        for (Etudiant e : etudiants) {
            if (e.getAge() >= ageMax) {
                plusAges.add(e);
            }
        }

        System.out.println("\nEtudiant(s) le(s) plus age(s) :");
        for (Etudiant e : plusAges) {
            System.out.println(e);
        }

        String nomRecherche = "Matteo";
        Etudiant resultat = rechercherparNom(etudiants, nomRecherche);

        System.out.println("\nRecherche par nom (" + nomRecherche + ") :");
        if (resultat != null) {
            System.out.println(resultat);
        } else {
            System.out.println("Aucun étudiant trouvé.");
        }
    }
}
