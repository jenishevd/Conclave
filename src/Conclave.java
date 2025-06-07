import java.util.*;
import java.util.*;

public class Conclave {
    private List<Cardinal> cardinals;
    private Cardinal leader1;
    private Cardinal leader2;



    public Conclave(List<Cardinal> cardinals) {
        this.cardinals = cardinals;

        this.leader1 = pickLeader();
        do {
            this.leader2 = pickLeader();
        } while (leader2 == leader1);

        System.out.println("Leading candidates:");
        System.out.println("Leader 1: " + leader1.getName());
        System.out.println("Leader 2: " + leader2.getName());


    }

    private Cardinal pickLeader() {
        Random rand = new Random();
        return cardinals.get(rand.nextInt(cardinals.size()));
    }



    public void startElection() {
        int round = 1;
        while (true) {
            System.out.println("=== Round " + round + " ===");

            // Все голосуют
            for (Cardinal c : cardinals) {
                c.decideVote(cardinals, leader1, leader2);
            }

            // Подсчёт голосов
            Map<String, Integer> votes = new HashMap<>();
            for (Cardinal c : cardinals) {
                votes.put(c.getVote(), votes.getOrDefault(c.getVote(), 0) + 1);
            }

            // Вывод результатов
            for (Map.Entry<String, Integer> entry : votes.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
            }

            // Проверка на победу
            for (Map.Entry<String, Integer> entry : votes.entrySet()) {
                if (entry.getValue() >= Math.ceil(2.0 * cardinals.size() / 3)) {
                    System.out.println("New Pope elected: " + entry.getKey());
                    return;
                }
            }

            round++;
            System.out.println();
        }
    }
}
