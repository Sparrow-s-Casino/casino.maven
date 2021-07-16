package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;


/**
 * Created by leon on 7/21/2020.
 */
public class Slots implements GameInterface {

     public static void main(String[] arg) { playSlots(); }

    public static void playSlots() {
         Random generator = new Random();
         Scanner console = new Scanner(System.in);

         int playerInput;
         int bet = 10;
         int wheel1;
         int wheel2;
         int wheel3;






        System.out.println("\uD83D\uDD34              \uD83D\uDD35           \uD83D\uDD34                 \uD83D\uDD34               \uD83D\uDFE1                                      \uD83D\uDFE2            \uD83D\uDFE1         \uD83D\uDD34             \uD83D\uDFE2");
        System.out.println("  \uD83D\uDD35                        \uD83D\uDFE1                                                               \uD83D\uDD35                \uD83D\uDFE3");
        System.out.println("           \uD83D\uDD35      \uD83D\uDFE2                      \uD83D\uDD35    \uD83D\uDFE2          \uD83D\uDD34                    \uD83D\uDFE1                                   \uD83D\uDFE3                          \uD83D\uDD35 ");
        System.out.println("                 \uD83D\uDFE3             \uD83D\uDD35                                  \uD83D\uDD34              \uD83D\uDFE2                     \uD83D\uDFE3 ");
        System.out.println("\uD83D\uDD34         \uD83D\uDFE1                                      \uD83D\uDFE3   ==============   SLOT MACHINE     ============     \uD83D\uDFE2                      \uD83D\uDD35            \uD83D\uDFE1                     \uD83D\uDD35             \uD83D\uDFE2      \uD83D\uDFE1         \uD83D\uDFE3");
        System.out.println("               \uD83D\uDD35      \uD83D\uDD34");
        System.out.println("  \uD83D\uDFE2                                         \uD83D\uDD35                \uD83D\uDFE3                         \uD83D\uDFE2                           \uD83D\uDFE2             \uD83D\uDFE2      \uD83D\uDD34      \uD83D\uDFE1");
        System.out.println("          \uD83D\uDD35   \uD83D\uDFE2            \uD83D\uDFE1        \uD83D\uDD34        \uD83D\uDFE3                 \uD83D\uDD35              \uD83D\uDFE3                      \uD83D\uDD34          \uD83D\uDFE3");
        System.out.println("                               \uD83D\uDFE1           \uD83D\uDFE3                   \uD83D\uDD35                                      \uD83D\uDFE1 ");

         System.out.println(" ");
         System.out.println("      ____________________");
         System.out.println("     /___________________/|");
         System.out.println("     |  ⚜️ JACKPOT ⚜️   |  |");
         System.out.println("     |   ------------- | o|");
         System.out.println("     |  |   |   |   |  |/ |");
         System.out.println("     |  | 7⃣ | 7⃣ | 7⃣ |__/  |");
         System.out.println("     |  |   |   |   |  |  |");
         System.out.println("     |  -------------  |  |");
         System.out.println("     |      |    |     |  |");
         System.out.println("     |                 |  |");
         System.out.println("     |                 |  /");
         System.out.println("     |                 | / ");
         System.out.println("     |_________________|/   ");

        System.out.println(" ");
        System.out.println(" ");



         do {

             System.out.println("cash:" + '$' + bet);
             System.out.println("PRESS 1 TO PULL OR 2 TO QUIT");

             playerInput = console.nextInt();
             if (playerInput == 2){
                 System.out.println("THANKS FOR PLAYING");
             }
           else { //{ if (playerInput > 2){
               //System.out.println("ERROR");
            // }



                 wheel1 = generator.nextInt(8) + 1; //range
                 wheel2 = generator.nextInt(8) + 1;
                 wheel3 = generator.nextInt(8) + 1;


                 System.out.println(wheel1 + " " + '|'  + " " +  wheel2 +  " " + '|' + " " +  wheel3);

                 if (wheel1 == wheel2 && wheel1 == wheel3) {
                     System.out.println("YOU WIN $15 ☺︎!!!");
                     bet += 15;

                 } else if (wheel1 == wheel2 || wheel1 == wheel3 || wheel2 == wheel3) {
                     System.out.println("YOU WIN $7 ☺︎!!!");
                     bet += 7;
                 } else {

                     System.out.println("YOU LOOSE $5 !!");
                     bet -= 3;
                 }


             }
             }
             while (playerInput == 1) ;
         }


    public void add(PlayerInterface player) {

    }

    public void remove(PlayerInterface player) {

    }

    public void run() { playSlots(); }
}
















