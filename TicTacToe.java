import java.util.*;
public class TicTacToe {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        while (true) { 
            
        char[][] board= new char[3][3];
        
        //Creating an Empty Board and Printing it
        initializeBoard(board);
        printBoard(board);

        //Ask Player X to enter row & column, fill the spot with X on board and print board  
        char currentPlayer = 'X';
        int moves = 0; // Counting how many moves have been made

        while (moves < 9) { // max only 9 moves possible 
            printBoard(board);
            System.out.println("Player " + currentPlayer + "'s Turn:");

            int row, col;
            while (true) {
                System.out.print("Enter row (0, 1, or 2): ");
                row = scan.nextInt();
                System.out.print("Enter column (0, 1, or 2): ");
                col = scan.nextInt();

                // Validating move : wrong row/col number or if place is already occupied
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    break; 
                } else {
                    System.out.println("Invalid move! Try again :)");
                }
            }

            // Checking if current player won
            if (isWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                return; // Ending
            }

            // Switching player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            moves++;
        }

        if (moves == 9 && !isWinner(board,'X') && !isWinner(board, 'O')) {
                printBoard(board);
                System.out.println("🤝 It's a draw!");
            }
        // Replay option
            System.out.print("Do you want to play again? (y/n): ");
            char choice = scan.next().toLowerCase().charAt(0);
            if (choice != 'y') {
                System.out.println("Thanks for playing! See you again👋");
                break;
            }
        }

        scan.close();
    }

    //Emptying the board
    public static void initializeBoard(char[][] board){
        for(int i = 0; i<3 ; i++){
            for(int j=0; j<3; j++){
                board[i][j] = ' ' ;
            }
        }
    }

    //Printing the current state of the board
    public static void printBoard(char[][] board){
        System.out.println("Current Board: ");
        for(int i=0; i<3; i++){
            System.out.print(" ");
            for(int j=0; j<3 ; j++){
                System.out.print(board[i][j]);
                if(j<2) 
                    System.out.print(" | ");
                else
                    System.out.println();
            }
            if(i<2)
                System.out.println("---+---+---");
        }
    }

    // Check if the current player has won
    public static boolean isWinner(char[][] board, char player) {
        // Checking rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Checking columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Checking diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

}

