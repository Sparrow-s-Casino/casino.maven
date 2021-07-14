package com.github.zipcodewilmington.casino.card;

public class Card {
    private cardValue cardValue;
    private suitValue suitValue;

    public Card(suitValue suitValue, cardValue cardValue){
        this.cardValue = cardValue;
        this.suitValue = suitValue;
    }

    public String toString(){
        return this.suitValue.toString() + ":" + this.cardValue.toString();
    }

    public cardValue getCardValue(){
        return this.cardValue;
    }
}
public enum cardValue {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE
}
public enum suitValue {
    CLUBS,
    DIAMOND,
    SPADE,
    HEART
}
