package views;

import java.util.Scanner;

public class LevelSelector {
    public int levelSelector() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Levels");
        System.out.println();
        System.out.println();
        System.out.println("[1] Level 1");
        System.out.println("[2] Level 2");
        System.out.println("[3] Level 3");
        System.out.println("[4] Level 4");
        System.out.println("[5] Level 5");
        System.out.println("[6] Level 6");
        System.out.println("[7] Level 7");
        System.out.println("[8] Level 8");
        System.out.println("[9] Level 9");
        System.out.println("[10] Level 10");
        System.out.print("Select Level: ");
        return sc.nextInt();
    }
}
