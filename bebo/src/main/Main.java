package main;

import consoleInterface.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu;
        do {
            Menu.printMenu();
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    // TODO
                    break;
                case 2:
                    // TODO
                    break;
                case 3:
                    // TODO
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (menu != 4);
    }
}