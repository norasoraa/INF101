package no.UiB.CrashCourse.examTasks.cards;

import java.util.ArrayList;

public class InheritedArrayCardPile extends ArrayList<Card> {
    
    public static InheritedArrayCardPile createFullDeck() {
        InheritedArrayCardPile deck = new InheritedArrayCardPile();
        for (CardSuit suit : CardSuit.ALL_SUITS) {
            for (CardRank rank : CardRank.ALL_RANKS) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    @Override
    public boolean add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        return super.add(card);
    }
}
