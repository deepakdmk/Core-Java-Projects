import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {

        char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        printBoard(board);

        while (checkWin(board)) {
            playerMove(board);
            printBoard(board);
            cpuMove(board);
            printBoard(board);
        }
    }


    static boolean checkWin(char[] board) {


        if (board[0] == 'X' && board[1] == 'X' && board[2] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[0] == 'X' && board[3] == 'X' && board[6] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[1] == 'X' && board[4] == 'X' && board[7] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[2] == 'X' && board[5] == 'X' && board[8] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[3] == 'X' && board[4] == 'X' && board[5] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[6] == 'X' && board[7] == 'X' && board[8] == 'X') {
            System.out.println("Player wins");
            return false;
        } else if (board[0] == 'O' && board[1] == 'O' && board[2] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[0] == 'O' && board[3] == 'O' && board[6] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[1] == 'O' && board[4] == 'O' && board[7] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[2] == 'O' && board[5] == 'O' && board[8] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[3] == 'O' && board[4] == 'O' && board[5] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[6] == 'O' && board[7] == 'O' && board[8] == 'O') {
            System.out.println("CPU wins");
            return false;
        } else if (board[0] != '0' && board[1] != '1' && board[2] != '2' && board[3] != '3' && board[4] != '4' && board[5] != '5' && board[6] != '6' && board[7] != '7' && board[8] != '8') {
            System.out.println("Game ends in tie");
            return false;
        }
        return true;

    }

    static void playerMove(char[] board) {
        boolean check = true;
        while (check) {
            System.out.println("Choose position:");
            Scanner in = new Scanner(System.in);
            int position = in.nextInt();

            if (board[position] == 'O' || board[position] == 'X') {
                System.out.println("Position already taken, choose a number that is still available");
            } else {
                selectPosition(position, board, "user");
                check = false;
            }
        }
    }

    static void cpuMove(char[] board) {
    boolean check=board[0] == '0' || board[1] == '1'  ||  board[2] == '2'  ||
            board[3] == '3'  ||  board[4] == '4'  ||  board[5] == '5'  ||
            board[6] == '6'  ||  board[7] == '7'  ||  board[8] == '8';

    while(check){
            Random r = new Random();
            int position = r.nextInt(9);
            System.out.println("PC chose: " + position);

            if (board[position] == 'O' || board[position] == ('X')) {
                System.out.println("Position already taken, CPU will retry");
            } else {
                selectPosition(position, board, "pc");
                check=false;
            }
        }

    }

    static void printBoard(char[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }


    static void selectPosition(int position, char[] board, String player) {
        char symbol;
        if (player.equals("user")) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }
        switch (position) {
            case 0:
                board[0] = symbol;
                break;
            case 1:
                board[1] = symbol;
                break;
            case 2:
                board[2] = symbol;
                break;
            case 3:
                board[3] = symbol;
                break;
            case 4:
                board[4] = symbol;
                break;
            case 5:
                board[5] = symbol;
                break;
            case 6:
                board[6] = symbol;
                break;
            case 7:
                board[7] = symbol;
                break;
            case 8:
                board[8] = symbol;
                break;
            default:
                System.out.println("Please enter a valid number");
        }

    }
}



