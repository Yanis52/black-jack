package blackjack;

import java.util.*;

import cartes.*;

public class Party {
    /*
     * Class représentant une partie de blackjack
     */
    private Deck deck;
    private ArrayList<Hand> listHand;
    private ArrayList<Integer> listSumHand;

    private Hand dealerHand;
    private Integer sumDealerHand;

    private int NB_CARD_INITIAL_DRAW = 2;
    private int AS_VALUE;
    private HashMap<String, Integer> RELATION_NUMBER_VALUE;

    public Party(int AS_VALUE, String deckStyle) {
        this.deck = DeckFactory.get52DeckCard(deckStyle);

        this.listHand = new ArrayList<>();
        this.listSumHand = new ArrayList<>();

        this.dealerHand = new Hand();
        this.dealerHand.changeShowHand();
        this.sumDealerHand = 0;

        this.AS_VALUE = 11;

        this.generateRELATION_NUMBER_VALUE();
    }

    // Getter
    public Deck getDeck() {
        return this.deck;
    }

    public int getAsValue() {
        return this.AS_VALUE;
    }

    public ArrayList<Hand> getListHand() {
        return this.listHand;
    }

    public ArrayList<Integer> getListSumHand() {
        return listSumHand;
    }

    public Hand getDealerHand() {
        return this.dealerHand;
    }

    // Methods -------------

    public void generateRELATION_NUMBER_VALUE() {
        /*
         * Génére dans la HashMap RELATION_NUMBER_VALUE la relation entre les "values"
         * d'une carte et leurs valeurs numériques au blackjack
         */
        this.RELATION_NUMBER_VALUE = new HashMap<>();

        for (int i = 2; i < 11; i++) {
            this.RELATION_NUMBER_VALUE.put(Integer.toString(i), i);
        }

        this.RELATION_NUMBER_VALUE.put("as", this.AS_VALUE);

        ArrayList<String> figure = new ArrayList<>(Arrays.asList("valet", "reine", "roi"));
        for (String f : figure) {
            this.RELATION_NUMBER_VALUE.put(f, 10);
        }
    }

    public void addHand(Hand h) {
        /*
         * Ajoute une main dans la partie
         */
        this.listHand.add(h);
    }

    public void initialDraw() {
        /*
         * Tirage initial de 2 cartes par personne et d'une carte pour le croupier
         */
        for (Hand h : this.listHand) {
            for (int i = 0; i < NB_CARD_INITIAL_DRAW; i++) {
                h.addCard(this.deck.drawCard());
            }
        }

        this.dealerHand.addCard(this.deck.drawCard());
    }

    public void getSumHandValue() {
        /*
         * Permet d'inserer dans les attributs correspondant la somme des mains des
         * joueurs et du croupier
         */
        while (this.listSumHand.size() != 0) {
            this.listSumHand.remove(0);
        }

        for (Hand h : this.listHand) {

            int sum = 0;
            for (Card c : h.getHand()) {
                sum += this.RELATION_NUMBER_VALUE.get(c.getValue());
            }
            this.listSumHand.add(sum);
        }

    }

    public int getSumHandValueOfOneHand(Hand h) {
        /*
         * Retouner la valeur de la main donnée
         */
        for (Hand hand : this.listHand) {
            if (hand.compareTo(h) == 0) {
                int sum = 0;
                int as = 0;
                for (Card c : h.getHand()) {
                    sum += this.RELATION_NUMBER_VALUE.get(c.getValue());
                    if (c.getValue().equals("as")) {
                        as++;
                    }
                }
                if (sum > 21) {
                    sum -= 10 * as;
                }
                return sum;
            }
        }
        return -1;
    }

    public int getSumDealerHand() {
        /*
         * Calcul la somme des cartes du croupier
         */
        int sumDealer = 0;
        for (Card c : this.dealerHand.getHand()) {
            sumDealer += this.RELATION_NUMBER_VALUE.get(c.getValue());
        }

        this.sumDealerHand = sumDealer;
        return this.sumDealerHand;
    }

    public boolean handChoice(Hand h, int choice) {
        /*
         * Permet d'appliquer le choix du joueur
         * 2 choix :
         * 1) hit : tirer une carte
         * Return : true -> le joueur peut continuer à faire des choix
         * 2) stand : ne veut pas d'autre carte
         * Return : false -> Indique que le joueur ne fera plus de choix
         */

        if (choice == 1) {
            h.addCard(this.deck.drawCard());
            this.getSumHandValue();
            return true;
        } else {
            return false;
        }
    }

    public void handTurn(Hand h) {
        /*
         * Méthode uniquement utilisable pour jouer en console
         * Permet de demander le choix à l'utilisateur et de l'appliquer
         */
        // Uniquement pour console
        int choice = this.askChoiceConsole(h);

        while (handChoice(h, choice)) {
            choice = this.askChoiceConsole(h);
        }
    }

    public int askChoiceConsole(Hand h) {
        /*
         * Méthode uniquement utilisable pour jouer en console
         * Permet de faire le choix depuis un input utilisateur
         * Return:
         * int 1 ou 2 => hit ou stand
         */

        try {
            Scanner myObj = new Scanner(System.in);

            System.out.println(this.dealerHand.getHand());
            System.out.println(h.getHand());
            System.out.println("Enter choice 1 = hit - 2 = stand");

            String choice = myObj.nextLine();

            return Integer.valueOf(choice);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void allHandTurn() {
        /*
         * Méthode uniquement utilisable pour jouer en console
         * Permet de faire jouer tous les utilisateurs chacun leurs tour
         */
        for (Hand h : this.listHand) {
            handTurn(h);
        }
    }

    public void dealerTurn() {
        /*
         * Permet de jouer le tour du croupier
         */
        while (this.sumDealerHand < 16) {
            Card drawedCard = this.deck.drawCard();
            this.dealerHand.addCard(drawedCard);
            this.getSumDealerHand();
        }

    }

    public void AIPlayerTurn(Hand h) {
        /*
         * Fixe la manière de jouer des IA
         */
        while (getSumHandValueOfOneHand(h) < 15) {
            Card drawedCard = this.deck.drawCard();
            h.addCard(drawedCard);
        }
    }

    public String checkWhoWin() {
        /*
         * Vérifie les conditions de victoire du croupier et des joueurs
         */
        if (this.sumDealerHand > 21) {
            return "Tous les joueurs ont gagnes, le croupier a + de 21 !";
        }

        int maxVal = -1;
        int maxId = -1;

        ArrayList<Integer> otherMaxId = new ArrayList<>();

        getSumHandValue();
        for (int i = 0; i < this.listHand.size(); i++) {
            if (this.listSumHand.get(i) <= 21 && this.listSumHand.get(i) > this.sumDealerHand
                    && this.listSumHand.get(i) >= maxVal) {

                if (this.listSumHand.get(i) == maxVal) {
                    otherMaxId.add(i);
                } else {
                    maxVal = this.listSumHand.get(i);
                    maxId = i;
                }
            }
        }
        if (maxId == -1) {
            return "Le croupier a gagne";

        } else {
            if (otherMaxId.size() == 0) {
                return "Le joueur " + maxId + " a gagne ";
            } else {
                String winners = maxId + ", ";
                for (int i : otherMaxId) {
                    winners += i + ", ";
                }

                return "Les joueurs " + winners + " ont gagnes !";
            }
        }
    }

    public void completeTurn() {
        /*
         * Permet de jouer un tour de table complet
         */
        this.allHandTurn();
        this.dealerTurn();

        this.checkWhoWin();
    }

    public void launchGame() {
        /*
         * Méthode uniquement utilisable pour jouer en console
         * Permet de jouer une partie
         */
        this.initialDraw();
        this.getSumHandValue();
        this.getSumDealerHand();

        // completeTurn();

    }

}
