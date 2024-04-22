package exercise3;

enum CardSuit {
    HEARTS {
        @Override
        public String toString() {
            return "Hearts";
        }
    },
    DIAMONDS {
        @Override
        public String toString() {
            return "Diamonds";
        }
    },
    CLUBS {
        @Override
        public String toString() {
            return "Clubs";
        }
    },
    SPADES {
        @Override
        public String toString() {
            return "Spades";
        }
    };

    @Override
    public abstract String toString();
}

class Demo {

    public static void main(String[] args) {
        // Reminder - take input strings from the array args.
        // TODO: Delete line below and write your own solution.
        for (String arg : args) {
            CardSuit cardSuit = CardSuit.valueOf(arg);
            System.out.println(cardSuit);
        }
    }

}


