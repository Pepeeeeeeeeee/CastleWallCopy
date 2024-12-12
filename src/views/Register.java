package views;

import managers.AuthManager;
import models.Player;

import java.util.Scanner;

public class Register extends AuthManager {
    public Scanner sc = new Scanner(System.in);
    public boolean registerMenu(){
        System.out.println("Register");
        System.out.println();
        System.out.println();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.println();
        System.out.print("Confirm Password: ");
        String passwordConf = sc.nextLine();
        System.out.println();
        Player player = register(name, password, passwordConf);
        return player != null;
    }
}
