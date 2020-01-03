
/*
Name: Osama Nadeem      Section: BSCS-7C
CMS # 207376
*/


package TicTacToe;

import java.util.Scanner;
import java.util.Random;


public class TicTacToe {

    private static final int ROW = 3, COL = 3;

    public enum value {
        X, O, EMPTY() {         // CROSS, NOUGHT AND EMPTY
            public String toString() {      //Displays "-" instead of EMPTY
                return "-";
            }
        }
    }
    private value board[][];            // declares a board of array values
    private value turn = value.X;       // initializes a turn variable that contains the value of current player playing

    public boolean isDraw = false;      // initializes isDraw variable to false that changes to true if game is draw
    String ch;
    int r, c;

    Scanner sc = new Scanner(System.in);    //scanner object for taking user input
    Random rand = new Random();            // ramdom object for generating random number

    public TicTacToe() {
        board = new value[3][3];    // makes a value array of 3-by-3
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                board[i][j] = value.EMPTY;     //initializes board values to empty
                System.out.print("|\t" + (i + 1) + " " + (j + 1) + "\t");
            }
            System.out.println("|\n\n-------------------------------------------------");
        }
    }

    public void printBoard() {
        // prints the board on screen
        for (int i = 0; i < ROW; i++) {
            System.out.println();
            for (int j = 0; j < COL; j++) {
                System.out.print("|\t " + board[i][j] + "\t");
            }
            System.out.println("|\n\n-------------------------------------------------");
        }
    }

    public void playerTurn() {  //playerTurn method runs when human player is playing the game
        System.out.print("Enter the values in the form 'x<space>y' e.g. (1 2): ");
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;   //inputs values from the user
        validateInput();       // if input values are already occupied, it asks the user to enter new values
        board[r][c] = turn;

        printBoard();

        if (checkWin() == true) {   // at every turn it asks if the game is won by the player or not
            System.out.println("Game over. " + turn + " player won!!");

            System.exit(0);     // stops the game if game is won
        }

        if (checkBoardFull() == true) {     //stops the game if board is full
            System.out.println("Game DRAW!!!!");
            System.exit(0);
        }

        changePlayer();     // changes player after the turn 
    }

    public void computerTurn() {
        System.out.println("\nNow computer's turn:");
        r = rand.nextInt(3);    //generates random values for computer's turn
        c = rand.nextInt(3);
        while (board[r][c] != value.EMPTY) {    //validates the computer input that the select place is empty or not
            r = rand.nextInt(3);
            c = rand.nextInt(3);
        }
        board[r][c] = turn;
        printBoard();
        if (checkWin() == true) {
            System.out.println("Game over. " + turn + " Computer won!!");
            System.exit(0);
        }
        if (checkBoardFull() == true) {
            System.out.println("Game DRAW!!!!");

            System.exit(0);
        }

        changePlayer();

    }

    public void validateInput() {   //asks player to re-enter the value input if selected place is not empty
        
        while (r>2 || c>2) {    // asks user to re-enter values if the input is invalid / exceeds array values
            System.out.println("Invalid input!!");
            System.out.print("Enter the values again(x y): ");
            r = sc.nextInt() - 1;
            c = sc.nextInt() - 1;
        }
        while (board[r][c] != value.EMPTY) {
            System.out.println("Invalid input!!");
            System.out.print("Enter the values again(x y): ");
            r = sc.nextInt() - 1;
            c = sc.nextInt() - 1;
        }
        
    }

    public void changePlayer() {    //changes player after every turn
        turn = (turn == value.X) ? value.O : value.X;
    }

    public boolean checkBoardFull() {   //checks if all the squares are filled and returns true or false
        int q = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] != value.EMPTY) {
                    q++;
                }
            }
        }
        if (checkWin()) {
            q = 0;
        }
        if (q == 0) {
            return false;
        } else if (q == 9) {
            return true;
        }
        return false;
    }

    public boolean checkRows() {    //checks if any row has 3 X's or 3 O's and then returns true
        for (int i = 0; i < ROW; i++) {
            if ((board[i][0] == value.X && board[i][1] == value.X && board[i][2] == value.X)
                    || (board[i][0] == value.O && board[i][1] == value.O && board[i][2] == value.O)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCols() {    //checks if any column has 3 X's or 3 O's and then returns true
        for (int i = 0; i < COL; i++) {
            if ((board[0][i] == value.X && board[1][i] == value.X && board[2][i] == value.X)
                    || (board[0][i] == value.O && board[1][i] == value.O && board[2][i] == value.O)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals() {   //checks if any diagonal has 3 X's or 3 O's and then returns true

        if ((board[0][0] == value.X && board[1][1] == value.X && board[2][2] == value.X)
                || (board[0][2] == value.X && board[1][1] == value.X && board[2][0] == value.X)
                || (board[0][0] == value.O && board[1][1] == value.O && board[2][2] == value.O)
                || (board[0][2] == value.O && board[1][1] == value.O && board[2][0] == value.O)) {
            return true;
        }
        return false;
    }

    public boolean checkWin() { //checks if any of the checkRows, checkCols or checkDiagonals methods is true and then returns true
        if (checkRows() == true || checkCols() == true || checkDiagonals() == true) {
            return true;
        } else {
            return false;
        }
    }
}
