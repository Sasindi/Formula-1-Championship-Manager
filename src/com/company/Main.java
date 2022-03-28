package com.company;

import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Table t1 = new Table();//object to get the GUI part
        Formula1ChampionshipManager f1 = new Formula1ChampionshipManager(); //object to access the Formula1ChampionshipManager methods
        Scanner input =new Scanner(System.in);

        f1.fileRead();  //load the saved details from file

        String menuToCheck;
        while(true) {
            System.out.println("\n_____________Menu_____________\n");
            System.out.println("1 -   Create a driver");
            System.out.println("2 -   Delete the driver and the team");
            System.out.println("3 -   Change the driver for the team");
            System.out.println("4 -   Exit");
            System.out.println("5 -   Display driver details");
            System.out.println("6 -   Display driver table");
            System.out.println("7 -   Add a race");
            System.out.println("8 -   Save data into a file");
            System.out.println("9-    GUI");

            System.out.println("Enter the menu number : ");
            menuToCheck = input.nextLine();

            // system will display error message when user input anything other than a integer as menu number
            try {
                int menu = Integer.parseInt(menuToCheck);

                if (menu == 1) {
                    f1.createDriver();
                }else if (menu == 2) {
                    f1.deleteDriverAndTeam();
                }else if (menu == 3) {
                    f1.changeTheDriver();
                }else if (menu == 4) {
                    break;
                }else if (menu == 5) {
                    f1.displayDriver();
                }else if (menu == 6) {
                    f1.displayDriverTable();
                }else if (menu == 7) {
                    f1.addRace();
                }else if (menu == 8) {
                    f1.saveDetails();
                }else if (menu == 9) {
                    t1.interface1();
                }else{
                    System.out.println("\n************   Menu number is invalid!   ************\n");
                }
            }catch(Exception e) {
                System.out.println("\n---------------------Invalid input!!---------------------\n");
            }

        }
    }
}
