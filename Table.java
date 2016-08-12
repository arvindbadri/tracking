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
    /*
    For all blocks in list, impose the newest block on them.
     */
    private void resolveConflictsAndAdd(Block newBlock) {
        if (blocks.size() == 0) {
            blocks.add(newBlock);
        }
        List<Block> newList = new ArrayList<>();
        for (Block existingBlock : blocks) {
            newList.addAll(existingBlock.impose(newBlock));
        }
        blocks = newList;
    }
    /*
    Reduce the given list of blocks to the simplest list.
     */
    private void reduce() {
        removeDuplicates();
        removeInvalids();
        sort();
        coalesce();
        removeDuplicates();
        sort();
    }

    private void coalesce() {
        for (int i = 0 ; i < blocks.size() - 1 ; i++) {
            if (blocks.get(i).getIdentifier().equals(blocks.get(i + 1).getIdentifier())) {
                if (blocks.get(i+1).getStart() == blocks.get(i).getEnd() + 1) {
                    blocks.add(new Block(blocks.get(i).getStart(), blocks.get(i+1).getEnd(), blocks.get(i).getIdentifier()));
                    blocks.remove(i + 1);
                    blocks.remove(i);
                }
            }
        }
    }

    private void removeInvalids() {
        List<Block> newList = new ArrayList<>();
        for (Block existingBlock : blocks) {
            if (existingBlock.getStart() <= existingBlock.getEnd()) {
                newList.add(existingBlock);
            }
        }
        blocks = newList;
    }

    private void removeDuplicates() {
        Set<Block> blockSet = new HashSet<>(blocks);
        blocks = new ArrayList<>(blockSet);
    }
}
