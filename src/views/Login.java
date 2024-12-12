package views;

import managers.AuthManager;
import models.Player;

import java.util.Scanner;

public class Login extends AuthManager {
    public Scanner sc = new Scanner(System.in);
    public boolean loginMenu(){
        System.out.println("Login");
        System.out.println();
        System.out.println();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.println();
        Player player = login(name, password);
        return player != null;
    }
}
