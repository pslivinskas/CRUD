import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {
    public static void main(String[] args) {
        ArrayList<String> popularNames = new ArrayList<>();
        popularNames.add("Tomas");
        popularNames.add("Saulius");
        popularNames.add("Laimis");
        popularNames.add("Jonas");
        popularNames.add("Petras");
        System.out.println("Sveiki atvykę į populiariausių lietuviškų vardų sąrašą");

        boolean shouldGo = true;
        Scanner sc = new Scanner(System.in);

        while (shouldGo) {
            intro();
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Iveskite teisingą skaičiaus formatą");
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    show(popularNames);
                    break;
                case 2:
                    add(sc, popularNames);
                    break;
                case 3:
                    edit(sc, popularNames);
                    break;
                case 4:
                    delete(sc, popularNames);
                    break;
                case 5:
                    System.out.println("Iki kito karto");
                    shouldGo = false;
                    break;
            }
        }
    }

    public static void intro() {
        System.out.println("Pasirinkite ką norite daryti");
        System.out.println("1. Pamatyti vardus.");
        System.out.println("2. Pridėti vardą.");
        System.out.println("3. Redaguoti vardą");
        System.out.println("4. Ištrinti vardą");
        System.out.println("5. Išeiti iš programos");
    }

    public static void show(ArrayList<String> popularNames) {
        for (int i = 0; i < popularNames.size(); i++) {
            System.out.println((i + 1) + ". " + popularNames.get(i));
        }
    }

    public static void add(Scanner sc, ArrayList<String> popularNames) {
        System.out.println("Įveskite vardą");
        popularNames.add(sc.nextLine());
        System.out.println("Ačiū, vardas pridėtas");
    }

    public static void delete(Scanner sc, ArrayList<String> popularNames) {
        System.out.println("Kelintą vardą norite ištrinti?");
        int inp = sc.nextInt();
        sc.nextLine();
        popularNames.remove(inp - 1);
        System.out.println("Vardas sėkmingai ištrintas");
    }

    public static void edit(Scanner sc, ArrayList<String> popularNames) {
        System.out.println("Įveskite vardo, kurį norite redaguoti numerį");
        int pos = 0;
        while (true) {
            try {
                pos = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Įveskite teisingą skaičių");
            }
        }
        sc.nextLine();
        System.out.println("Jūs norite redaguoti vardą '" + popularNames.get(pos - 1) + "' pozicijoje " + pos);
        System.out.println("Įveskite naują vardą");
        popularNames.set(pos - 1, sc.nextLine());
        System.out.println("Ačiū, vardas pakoreguotas");
    }
}





