import java.util.*;
public class Cardinal {
    private String name;
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

    // Кардинал делает выбор (обычно за одного из лидеров)
    public void decideVote(List<Cardinal> candidates, Cardinal leader1, Cardinal leader2) {
        double chance = Math.random();
        if (chance < 0.60) {
            vote = leader1.getName();
        } else if (chance < 0.90) {
            vote = leader2.getName();
        } else {
            // 10% случайных голосов
            Cardinal chosen;
            do {
                chosen = candidates.get((int) (Math.random() * candidates.size()));
            } while (chosen.getName().equals(this.name) ||
                    chosen.getName().equals(leader1.getName()) ||
                    chosen.getName().equals(leader2.getName()));
            vote = chosen.getName();
        }
    }


}
