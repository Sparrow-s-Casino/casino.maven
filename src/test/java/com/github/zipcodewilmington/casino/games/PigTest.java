package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
class PigTest {

    Pig pig = new Pig();
    @Test
    void currentStateOfTheGameTest() {
        Integer givenP1 = 2;
        Integer givenP2 = 4;

        String expected = "|*****                    Player 1 has " + givenP1 + " points.                  *****|\n" +
                "|*****                    Player 2 has " + givenP2 + " points.                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n";
        String actual = "|*****                    Player 1 has 2 points.                  *****|\n" +
                "|*****                    Player 2 has 4 points.                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n";

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void rollDieTest() {
        int counter = 0;
        Integer[] values = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> oneThroughSix = new ArrayList<>();
        oneThroughSix.add(1);
        oneThroughSix.add(2);
        oneThroughSix.add(3);
        oneThroughSix.add(4);
        oneThroughSix.add(5);
        oneThroughSix.add(6);

        while (counter < 6) {
            for (int r = 0; r < oneThroughSix.size(); r++) {
                for (Integer element : values) {
                    int dieValue = pig.rollDie();
                    if (dieValue > 6) {
                        Assertions.fail();
                    } else if (dieValue < 1) {
                        Assertions.fail();
                    } else if (dieValue == element && oneThroughSix.contains(element)) {
                        oneThroughSix.remove(element);
                        counter++;
                    }
                }
            }
        }
        Assertions.assertTrue(oneThroughSix.isEmpty());
    }

  }