package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.PigMenus;

import java.util.Random;
import java.util.Scanner;


public class Pig {

    Casino casino = new Casino();
    public static String PURPLE = "\u001B[35m";

    public static void main(String[] args) throws InterruptedException {
        Pig pig = new Pig();
        pig.run();
    }

    private int currentTurn;
    private int dieValue;
    private int turnScore;
    public int pOneTotal;
    public int pTwoTotal;
    public String rollAnswer;
    public Scanner input = new Scanner(System.in);
    // ThreadLocalRandom current = ThreadLocalRandom.current();

    public Pig() {
    }

    public void welcomeToPig() throws InterruptedException {
        PigMenus.welcomeScreen();
        Scanner input = new Scanner(System.in);
        String areYouGonnaPlay = input.next();
        if (areYouGonnaPlay.equals("q")) {
            casino.run();

        } else if (areYouGonnaPlay.equals("y")) {
            secondPlayerLoginOrCreate();
        }

    }

    public void secondPlayerLoginOrCreate() throws InterruptedException {
        PigMenus.secondPlayerMenu();
        Scanner input = new Scanner(System.in);
        String loginOrCreate = input.next();
        switch (loginOrCreate) {
            case "l":
                playerTwoLogin();
                break;
            case "c":
                input.nextLine();
                System.out.println("Please create your login");
                playerTwoCreate();
                break;
            case "q":
                casino.run();
                break;
            default:
                System.out.println("That is not a valid option!");
        }

        }


    public void theRules() throws InterruptedException {
        PigMenus.pigRules();
        Scanner input = new Scanner(System.in);
        String start = input.next();
        if (start.equals("s")) {
            PigMenus.itsPlayerOnesTurn();
            Thread.sleep(1000);
            playerTurn();
        } else if (start.equals("q")) {
            casino.run();
        }

    }

    public String currentStateOfTheGame() {
        PigMenus.currentStateScreen();
        return "|*****                    Player 1 has " + pOneTotal + " points.                  *****|\n" +
                "|*****                    Player 2 has " + pTwoTotal + " points.                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n";
    }
public int rollDie() {
    Random generator = new Random();
    dieValue = generator.nextInt(6) + 1;
    turnScore += dieValue;
    // dieValue = ThreadLocalRandom.current().nextInt(1, 7);
    return dieValue;
}

public void badLuck() throws InterruptedException {
    currentTurn++;
    turnScore = 0;
    PigMenus.youRolledAOne();
    Thread.sleep(2000);
    tallyTotal();

}
    public String start(){
        System.out.println( "" +
                "|**********************************************************************|\n" +
                "|*****     Please enter 'r' to roll, 'h' to hold, or q to quit    *****|\n" +
                "|**********************************************************************|\n");

        return rollAnswer = input.next();

    }

    public void turnUpdate() throws InterruptedException {
        whatDidYouRoll();
        Thread.sleep(1000);
        checkingForMidTurnWinner();
        System.out.println(PURPLE + "" +

                "|*****                    Player earned " + turnScore + " points                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
        Thread.sleep(2000);
        playerTurn();

    }

    public void playerTurn() throws InterruptedException {

        switch (start()) {
            case "r":
                rollDie();
                if (dieValue == 1) {
                    badLuck();
                } else {
                    turnUpdate();
                }
                break;
            case "h":
                currentTurn++;
                tallyTotal();
                break;
            case "q":
                casino.run();
                break;
            default:
                System.out.println("That is not a valid choice!");
        }
    }

    public void whatDidYouRoll()  {
       switch(dieValue) {
           case 2:
               PigMenus.youRolledATwo();
               break;
           case 3:
               PigMenus.youRolledAThree();
               break;
           case 4:
               PigMenus.youRolledAFour();
               break;
           case 5:
               PigMenus.youRolledAFive();
               break;
           case 6:
               PigMenus.youRolledASix();
               break;
           default:
               System.out.println("Oops! That's not valid!");
               rollDie();
       }

    }

    public void tallyTotal() throws InterruptedException {
        if (currentTurn % 2 == 0) {
            pOneTotal += turnScore;
        } else {
            pTwoTotal += turnScore;
        }
        nextTurn();

    }

    public void checkingForMidTurnWinner() throws InterruptedException {
        if (currentTurn % 2 == 0) {
            pTwoTotal += turnScore;
        } else {
            pOneTotal += turnScore;
        }
        getWinner();
        if (!getWinner()){
            getWinnerIsFalseMidTurn();
        }

    }

    public void getWinnerIsFalseMidTurn(){
        if (currentTurn % 2 == 0) {
            pTwoTotal -= turnScore;
        } else {
            pOneTotal -= turnScore;
        }
    }

    public void nextTurn() throws InterruptedException {
            turnScore = 0;
            whosTurnIsIt();
            System.out.println(currentStateOfTheGame());
            Thread.sleep(2000);
            playerTurn();

    }

    public void whosTurnIsIt() throws InterruptedException {
        if (currentTurn % 2 == 0) {
            PigMenus.itsPlayerTwosTurn();
            Thread.sleep(2000);
        } else {
            PigMenus.itsPlayerOnesTurn();
            Thread.sleep(2000);
        }

    }

    public boolean getWinner() throws InterruptedException {
        if (pOneTotal >= 10) {
            player1Wins();
            return true;
        } else if (pTwoTotal >= 10) {
            player2Wins();
            return true;
        }
        return false;
    }

    public void player1Wins() throws InterruptedException {
        Thread.sleep(2000);
        PigMenus.playerOneWon();
        System.out.println("|*****                    Player 1 has " + pOneTotal + " points.                 *****|\n" +
                "|*****                    Player 2 has " + pTwoTotal + " points.                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
        Thread.sleep(2000);
        doYouWantToPlayAgain();

    }

    public void player2Wins() throws InterruptedException {
        Thread.sleep(2000);
        PigMenus.playerTwoWon();
        System.out.println("|*****                    Player 1 has " + pOneTotal + " points.                  *****|\n" +
                "|*****                    Player 2 has " + pTwoTotal + " points.                 *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
        Thread.sleep(2000);
        doYouWantToPlayAgain();

    }

    public void doYouWantToPlayAgain() throws InterruptedException {
        System.out.println("Do you want to play again?\n" + "Enter 'y' to start again\n" + "Enter 'q' to quit to the main menu\n");
        String playAgain = input.next();
        if (playAgain.equals("y")) {
            startAgain();
        } else if (playAgain.equals("q")) {
            casino.run();
        }

    }

    public void startAgain() throws InterruptedException {
        pOneTotal = 0;
        pTwoTotal = 0;
        currentTurn = 1;
        turnScore = 0;

        PigMenus.itsPlayerOnesTurn();
        Thread.sleep(2000);
        playerTurn();


    }



    public void run() throws InterruptedException {
        currentTurn = 1;
        pOneTotal = 0;
        pTwoTotal = 0;
        turnScore =0;

        welcomeToPig();

        while (!(getWinner())) {
            playerTurn();
        }

    }

    public void playerTwoLogin() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Player 2's name: ");
        String playerTwosName = input.next();
        System.out.println("Please enter " + playerTwosName + " password: ");
        input.next();
        System.out.println("Enjoy the game " + playerTwosName);
        Thread.sleep(1000);
        System.out.println("Here come the rules!");
        Thread.sleep(1000);
        theRules();

    }

    public void playerTwoCreate() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String playerTwosName = input.next();
        System.out.println(playerTwosName + " please enter your desired password: ");
        input.next();
        System.out.println("Thank you for creating an account & enjoy your game!");
        Thread.sleep(1000);
        System.out.println( "Here come the rules!");
        Thread.sleep(1000);
        theRules();

    }

}













