package in.pbehre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static boolean gameOver= false;
    public static String WinnerName = "";
    public static Scanner scan = new Scanner(System.in);
    public static char [][] gameBoard;

    public static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    public static ArrayList<Integer> cpuPos = new ArrayList<Integer>();

    public static ArrayList<Integer> availPos = new ArrayList<Integer>();
    public static void main( String[] args )
    {
        sopl("Welcome to TicTacToe in Java");
        gameBoard = new char[][] {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };
        printGameBoard();

        availPos.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
        while(!gameOver)
        {
            playATurn();
            printGameBoard();
        }
        sopl("Game over!");
        sopl("Winner: " + WinnerName);
    }

    public static void playATurn()
    {
        sop("Enter your placement[1-9]: ");
        int pos = scan.nextInt();
        placePeice(pos, "Player");
        placePeice(cpuTurn(), "CPU");
        checkWinner();
    }

    public static int cpuTurn()
    {
        Random rand = new Random();
        int pos = rand.nextInt(availPos.size()-1);
        return availPos.get(pos);
    }

    public static void checkWinner()
    {
        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer>  middleRow  = Arrays.asList(4,5,6);
        List<Integer>  botRow = Arrays.asList(7,8,9);

        List<Integer>  leftCol = Arrays.asList(1,4,6);
        List<Integer>  middleCol  = Arrays.asList(2,5,8);
        List<Integer>  rightCol = Arrays.asList(3,6,9);

        List<Integer>  cross1 = Arrays.asList(1,5,9);
        List<Integer>  cross2 = Arrays.asList(6,5,3);

        List<List<Integer> > winning = new ArrayList<List<Integer> >();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List<Integer> l : winning)
        {
            if(playerPos.containsAll(l))
            {
                gameOver = true;
                WinnerName = "Player";
                return;
            } else if(cpuPos.containsAll(l))
            {
                gameOver = true;
                WinnerName = "CPU";
                return;
            } else if(playerPos.size() + cpuPos.size() == 9)
            {
                gameOver = true;
                WinnerName = "No Winner";
                return;
            }
        }
    }
    
    public static void placePeice(int pos, String user)
    {
        char symbol = ' ';
        if(user.equals("Player") && pos >=1 && pos <= 9)
        {
            playerPos.add(pos);
            symbol = 'X';
        } else if(user.equals("CPU")  && pos >=1 && pos <= 9) {
            cpuPos.add(pos);
            symbol = 'O';
        }
        availPos.remove(availPos.indexOf(pos));
        switch (pos) {
            case 1:
                if(gameBoard[0][0] == ' ')
                {
                    gameBoard[0][0] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 2:
                if(gameBoard[0][2] == ' ')
                {
                    gameBoard[0][2] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 3:
                if(gameBoard[0][4] == ' ')
                {
                    gameBoard[0][4] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 4:
                if(gameBoard[2][0] == ' ')
                {
                    gameBoard[2][0] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 5:
                if(gameBoard[2][2] == ' ')
                {
                    gameBoard[2][2] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 6:
                if(gameBoard[2][4] == ' ')
                {
                    gameBoard[2][4] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 7:
                if(gameBoard[4][0] == ' ')
                {
                    gameBoard[4][0] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 8:
                if(gameBoard[4][2] == ' ')
                {
                    gameBoard[4][2] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            case 9:
                if(gameBoard[4][4] == ' ')
                {
                    gameBoard[4][4] = symbol;
                } else {
                    wrongTurn();
                }
                break;
            default:
                break;
        }
    }
    
    public static void wrongTurn()
    {
        sopl("Invalid Turn, please try again.");
        playATurn();
    }
    public static void printGameBoard()
    {
        for(char[] row: gameBoard)
        {
            for(char col: row)
            {
                sop(col);
            }
            sopl("");
        }
    }

    public static void sopl(Object o)
    {
        System.out.println(o);
    }
    public static void sop(Object o)
    {
        System.out.print(o);
    }
}
