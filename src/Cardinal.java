import java.util.List;

public class Cardinal {
    private final String name;
    private String vote;

    public Cardinal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getVote() {
        return vote;
    }

    // Cardinal decides who to vote for
    public void vote(List<Cardinal> allCardinals, Cardinal leader1, Cardinal leader2, int roundNumber, String popularCandidate) {
        double chance = Math.random();

        if (roundNumber <= 2) {
            // Early rounds: normal distribution
            if (chance < 0.6) {
                vote = leader1.getName();
            } else if (chance < 0.9) {
                vote = leader2.getName();
            } else {
                // Random third choice
                Cardinal randomCardinal;
                do {
                    randomCardinal = allCardinals.get((int) (Math.random() * allCardinals.size()));
                } while (
                        randomCardinal.getName().equals(this.name) ||
                                randomCardinal.getName().equals(leader1.getName()) ||
                                randomCardinal.getName().equals(leader2.getName())
                );
                vote = randomCardinal.getName();
            }
        } else {
            // Later rounds: cardinals sway toward the popular candidate
            if (Math.random() < 0.8) {
                vote = popularCandidate;
            } else {
                // A few remain stubborn
                vote = (Math.random() < 0.5) ? leader1.getName() : leader2.getName();
            }
        }
    }
}
