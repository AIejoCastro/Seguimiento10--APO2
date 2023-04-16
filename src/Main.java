import model.Controller;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Controller controller = new Controller();

    public static void main(String[] args) throws IOException {
        controller.load();
        menu();
        controller.save();
    }

    public static void menu() {
        int menu = 0;
        while (menu != 5) {
            System.out.println("Welcome to the scoreboard of the Olympic Games" +
                    "\nPlease select one option: " +
                    "\n1. Insert a country" +
                    "\n2. Show medals" +
                    "\n3. Show all medals" +
                    "\n4. Show countries" +
                    "\n5. Exit");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    System.out.println(controller.showMedals());
                    break;
                case 3:
                    System.out.println(controller.showAllMedals());
                    break;
                case 4:
                    System.out.println(controller.sort());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

    public static void addCountry() {
        int g = 0;
        int s = 0;
        int b = 0;
        boolean add = true;
        String name = "";
        System.out.println("Please insert the data with the following format (Name::Medal::Quantity)");
        sc.nextLine();
        String input = sc.nextLine();
        String[] data = input.split("::");
        name = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i].equalsIgnoreCase("gold")) {
                g = Integer.parseInt(data[i + 1]);
            } else if (data[i].equalsIgnoreCase("silver")) {
                s = Integer.parseInt(data[i + 1]);
            } else if (data[i].equalsIgnoreCase("bronze")) {
                b = Integer.parseInt(data[i + 1]);
            }
        }
        controller.addCountry(name, g, s, b);
    }
}