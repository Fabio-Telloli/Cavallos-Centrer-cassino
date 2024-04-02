package BlackJack;
class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        if (rank.equals("Ace"))
            return 11;
        else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King"))
            return 10;
        else
            return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return rank + " di " + suit;
    }
}