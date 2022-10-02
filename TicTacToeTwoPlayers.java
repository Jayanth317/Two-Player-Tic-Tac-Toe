import java.util.Random;
import java.util.Scanner;

class TicTacToeTwoPlayers {

    public static void PrintBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public static void PlayerX(char[][] board, Scanner sc) {
        String userInput;
        while (true) {
            System.out.println("Player 1 turn :X");
            System.out.print("Enter location (1-9) : ");
            System.out.println(" ");
            userInput = sc.nextLine();
            if (isValidMove(board, userInput))
                break;
            else
                System.out.println(userInput + " is already filled");
        }
        BoxFill(board, userInput, 'X');
        PrintBoard(board);
    }

    public static void PlayerO(char[][] board, Scanner sc) {
        String userInput;
        while (true) {
            System.out.println("Player 2 turn :O");
            System.out.print("Enter location (1-9) : ");
            System.out.println(" ");
            userInput = sc.nextLine();
            if (isValidMove(board, userInput))
                break;
            else
                System.out.println(userInput + " is already filled");
        }
        BoxFill(board, userInput, 'O');
        PrintBoard(board);
    }

    public static boolean isValidMove(char[][] board, String location) {
        switch (location) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    public static void BoxFill(char[][] board, String position, char Cross) {
        switch (position) {
            case "1":
                board[0][0] = Cross;
                break;
            case "2":
                board[0][1] = Cross;
                break;
            case "3":
                board[0][2] = Cross;
                break;
            case "4":
                board[1][0] = Cross;
                break;
            case "5":
                board[1][1] = Cross;
                break;
            case "6":
                board[1][2] = Cross;
                break;
            case "7":
                board[2][0] = Cross;
                break;
            case "8":
                board[2][1] = Cross;
                break;
            case "9":
                board[2][2] = Cross;
                break;
            default:
                System.out.println(" :/ ");
                break;
        }
    }
    public static boolean isGameOver(char[][] board) {
        //To check if player 1 is the winner
        if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
            PrintBoard(board);
            System.out.println("Player 1 wins B)");
            return true;
        }

        //To check if player 2 is the winner
        if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
            PrintBoard(board);
            System.out.println("Player 2 wins B)");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == ' ')
                    return false;
            }
        }
        System.out.println(" ");
        PrintBoard(board);
        System.out.println("The game ends in a tie !!");
        return true;
    }

    public static void StartGame(char[][] board){
        Scanner sc = new Scanner(System.in);
        while (true) {
            // Player 1 turn 
            PlayerX(board, sc);
            if (isGameOver(board))
                break;
            // Player 2 turn 
            PlayerO(board,sc);
            if (isGameOver(board))
                break;
        }
    }

    public static void main(String[] args) {
        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };
        
        StartGame(board);
    }
}