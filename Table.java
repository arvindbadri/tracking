import java.util.*;

public class Table {
    private List<Block> blocks;

    public List<Block> getBlocks() {
        return blocks;
    }
    public Table() {
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
        String identifier = sc.nextLine();
        addBlock(new Block(start, end, identifier));
    }
    private void sort() {
        Collections.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return o1.getStart() - o2.getStart();
            }
        });
    }
    private void resolveConflictsAndAdd(Block block) {
        blocks.add(block);
    }
    private void reduce() {

    }
}