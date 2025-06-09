import java.util.*;

public class Conclave {
    private final List<Cardinal> cardinals;
    private final Cardinal leader1;
    private final Cardinal leader2;
    private final int MAX_ROUNDS = 6;

    public Conclave(List<Cardinal> cardinals) {
        this.cardinals = cardinals;

        // Pick 2 distinct leaders randomly
        this.leader1 = pickRandomLeader();
        Cardinal tempLeader;
        do {
            tempLeader = pickRandomLeader();
        } while (tempLeader == leader1);
        this.leader2 = tempLeader;

        System.out.println("Leading candidates:");
        System.out.println("- " + leader1.getName());
        System.out.println("- " + leader2.getName());
        System.out.println();
    }

    private Cardinal pickRandomLeader() {
        return cardinals.get(new Random().nextInt(cardinals.size()));
    }

    public void startElection() {
        int round = 1;

        while (round <= MAX_ROUNDS) {
            System.out.println("=== Round " + round + " ===");

            // Step 1: Collect votes
            Map<String, Integer> voteCount = new HashMap<>();
            for (Cardinal c : cardinals) {
                c.vote(cardinals, leader1, leader2, round, getCurrentFrontRunner(voteCount));
                String votedFor = c.getVote();
                voteCount.put(votedFor, voteCount.getOrDefault(votedFor, 0) + 1);
            }

            // Step 2: Show results
            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                System.out.printf("%-20s : %3d votes\n", entry.getKey(), entry.getValue());
            }

            // Step 3: Check for winner
            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                if (entry.getValue() >= Math.ceil(2.0 * cardinals.size() / 3)) {
                    System.out.println("\n🎉 New Pope elected: " + entry.getKey() + " with " + entry.getValue() + " votes.");
                    return;
                }
            }

            round++;
            System.out.println();
        }

        System.out.println("❌ No Pope elected after " + MAX_ROUNDS + " rounds. The conclave is deadlocked.");
    }

    private String getCurrentFrontRunner(Map<String, Integer> voteCount) {
        return voteCount.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(leader1.getName());
    }
}
