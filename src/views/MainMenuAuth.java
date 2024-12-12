package views;

import java.util.Scanner;

public class MainMenuAuth {
    private final Scanner scanner = new Scanner(System.in);
    public int menu(){
        System.out.println("Welcome to Castle Wall!");
        System.out.println();
        System.out.println();
        System.out.println("[1] Start Game");
        System.out.println("[2] Restart Game");
        System.out.println("[3] Game Rules");
        System.out.println("[4] Leader Board");
        System.out.println("[5] Exit");
        return scanner.nextInt();
    }
}
