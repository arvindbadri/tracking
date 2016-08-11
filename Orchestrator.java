import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orchestrator {
    List<Block> blocks;
    public Orchestrator() {
        blocks = new ArrayList<>();
    }
    private void addBlock(Block block) {
        resolveConflictsAndAdd(block);
        reduce();
    }
    public void addBlock(String line) {
        Scanner sc = new Scanner(line);
        int start = sc.nextInt();
        int end = sc.nextInt();
        String identifier = sc.next();
    }
}
