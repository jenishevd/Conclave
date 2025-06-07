import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        List<Cardinal> cardinals = new ArrayList<>();
        for (int i = 1; i <= 135; i++) {
            cardinals.add(new Cardinal("Cardinal " + i));
        }

        Conclave conclave = new Conclave(cardinals);
        conclave.startElection();
    }
}
