package com.github.zipcodewilmington.casino;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.StrictStubs.class)
class PigMenusTest {
    @Mock
    PigMenus mock;

    @BeforeEach
    public void openMocks(){
        mock = mock(PigMenus.class);
    }


    @Test
    void welcomeScreenTest() {

      when(mock.equals(new PigMenus())).thenCallRealMethod();
      doCallRealMethod().when(mock).welcomeScreen();
      verify(mock).welcomeScreen();

    }

    @Test
    void secondPlayerMenu() {
    }

    @Test
    void pigRules() {
    }

    @Test
    void currentStateScreen() {
    }

    @Test
    void youRolledAOne() {
    }

    @Test
    void youRolledATwo() {
    }

    @Test
    void youRolledAThree() {
    }

    @Test
    void youRolledAFour() {
    }

    @Test
    void youRolledAFive() {
    }

    @Test
    void youRolledASix() {
    }

    @Test
    void itsPlayerOnesTurn() {
    }

    @Test
    void itsPlayerTwosTurn() {
    }

    @Test
    void playerOneWon() {
    }

    @Test
    void playerTwoWon() {
    }
}