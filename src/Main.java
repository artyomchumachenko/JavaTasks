import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // init game board

        boolean playerNotWin = true;
        boolean compNotWin = true;
        int pos;
        int secondPos;
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        do {
            printGameBoard(gameBoard);
            System.out.println("Введите вашу позицию (1 - 9)");
            do {
                pos = scanner.nextInt();
                scanner.nextLine();
            } while (checkPosition(gameBoard, pos));
            choosePlace(gameBoard, pos, "player");
            printGameBoard(gameBoard);
            playerNotWin = !gameIsEnd(gameBoard, pos, "player");
            if (!playerNotWin) {
                break;
            }
            do {
                secondPos = scanner.nextInt();
                scanner.nextLine();
            } while (checkPosition(gameBoard, secondPos));
            choosePlace(gameBoard, secondPos, "comp");
            compNotWin = !gameIsEnd(gameBoard, pos, "comp");
            if (!compNotWin) {
                break;
            }
        } while (true);
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void choosePlace(char[][] gameBoard, int pos, String whoChoose) {
        char symbol = ' ';

        if (whoChoose.equals("player")) {
            symbol = 'X';
        } else if (whoChoose.equals("comp")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static boolean checkPosition(char[][] gameBoard, int pos) {
        boolean notFreePosition = false;
        switch (pos) {
            case 1:
                if (gameBoard[0][0] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 2:
                if (gameBoard[0][2] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 3:
                if (gameBoard[0][4] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 4:
                if (gameBoard[2][0] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 5:
                if (gameBoard[2][2] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 6:
                if (gameBoard[2][4] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 7:
                if (gameBoard[4][0] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 8:
                if (gameBoard[4][2] != ' ') {
                    notFreePosition = true;
                }
                break;
            case 9:
                if (gameBoard[4][4] != ' ') {
                    notFreePosition = true;
                }
                break;
            default:
                break;
        }
        return notFreePosition;
    }

    public static boolean gameIsEnd(char[][] gameBoard, int currPosition, String whoStep) {
        boolean gameWasEnd = false;
        char symbol = ' ';
        if (whoStep.equals("player")) {
            symbol = 'X';
        } else if (whoStep.equals("comp")) {
            symbol = 'O';
        }
        switch (currPosition) {
            case 1:
                if (
                        (gameBoard[0][2] == symbol && gameBoard[0][4] == symbol)
                        || (gameBoard[2][2] == symbol && gameBoard[4][4] == symbol)
                        || (gameBoard[2][0] == symbol && gameBoard[4][0] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 2:
                if (
                        (gameBoard[0][0] == symbol && gameBoard[0][4] == symbol)
                                || (gameBoard[2][2] == symbol && gameBoard[4][2] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 3:
                if (
                        (gameBoard[0][0] == symbol && gameBoard[0][2] == symbol)
                                || (gameBoard[2][2] == symbol && gameBoard[4][0] == symbol)
                                || (gameBoard[2][4] == symbol && gameBoard[4][4] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 4:
                if (
                        (gameBoard[0][0] == symbol && gameBoard[4][0] == symbol)
                                || (gameBoard[2][2] == symbol && gameBoard[2][4] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 5:
                if (
                        (gameBoard[0][0] == symbol && gameBoard[4][4] == symbol)
                                || (gameBoard[0][4] == symbol && gameBoard[4][0] == symbol)
                                || (gameBoard[0][2] == symbol && gameBoard[4][2] == symbol)
                                || (gameBoard[2][0] == symbol && gameBoard[2][4] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 6:
                if (
                        (gameBoard[0][4] == symbol && gameBoard[4][0] == symbol)
                                || (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 7:
                if (
                        (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol)
                                || (gameBoard[4][2] == symbol && gameBoard[4][4] == symbol)
                                || (gameBoard[2][2] == symbol && gameBoard[0][4] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 8:
                if (
                        (gameBoard[4][0] == symbol && gameBoard[4][4] == symbol)
                                || (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            case 9:
                if (
                        (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol)
                                || (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol)
                                || (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol)
                ) {
                    gameWasEnd = true;
                    System.out.println(symbol + " is win!");
                }
                break;
            default:
                break;
        }
        return gameWasEnd;
    }
}
