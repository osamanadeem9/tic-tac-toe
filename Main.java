
/*
Name: Osama Nadeem      Section: BSCS-7C
CMS # 207376
*/

package TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("|------------------------|");
        System.out.println("| Welcome to Tic Tac Toe |");
        System.out.println("|------------------------|\n\n");
        System.out.println("Enter the respective values as given in pattern to place your value in the TicTacToe grid\n\n");

        TicTacToe t1 = new TicTacToe();     // creates a TicTacToe object
        System.out.println("You want to play");
        System.out.println("\t1) Against human player");
        System.out.println("\t2) Against the computer\n\n");
        System.out.print("Enter 1 for human player and 2 for computer: ");
        int choice = scan.nextInt();    //asks user if he wants to play against another human player or against computer

        if (choice == 1) {      //playing against another human player
            while (true) {
                t1.playerTurn();
                if (t1.checkBoardFull() == true) {
                    System.out.println("Draw");
                    break;
                }
            }
        } else if (choice == 2) {   //playing against computer player
            System.out.print("Would you like to go first(Enter 1 for yes and 2 for No)? ");
            int ch = scan.nextInt();    //asks user if he wants to go first or second

            if (ch == 1) {  //if user goes first
                while (true) {
                    //runs playerTurn and then computerTurn method and stops when a player wins or game draws

                    t1.playerTurn();

                    t1.computerTurn();

                }
            } else if (ch == 2) {   //if computer goes first
                while (true) {  //runs computerTurn and then playerTurn method and stops when a player wins or game draws
                    t1.computerTurn();

                    t1.playerTurn();

                }
            }
        }
    }
}
