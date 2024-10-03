package no.UiB.CrashCourse.examTasks.cards;

import java.util.ArrayList;

public class ComposedArrayCardPile {

    ArrayList<Card> pile = new ArrayList<>();

    public static ComposedArrayCardPile createFullDeck() {
        ComposedArrayCardPile deck = new ComposedArrayCardPile();
        for (CardSuit suit : CardSuit.ALL_SUITS) {
            for (CardRank rank : CardRank.ALL_RANKS) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        pile.add(card);
    }
}
