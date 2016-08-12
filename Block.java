import java.util.ArrayList;
import java.util.List;

public class Block extends Range {
    private String identifier;

    public Block(int start, int end, String identifier) {
        super(start, end);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "" + start + " " + end + " " + identifier;
    }

    public List<Block> impose(Block otherBlock) {
        List<Block> resultBlocks = new ArrayList<>(3);
        if (isSame(otherBlock)) {
            resultBlocks.add(otherBlock);
        }
        else if (isSubsetOf(otherBlock)) {
            resultBlocks.add(otherBlock);
        }
        else if (isSupersetOf(otherBlock)) {
            resultBlocks.add(new Block(start, otherBlock.getStart() - 1, identifier));
            resultBlocks.add(otherBlock);
            resultBlocks.add(new Block(otherBlock.getEnd() + 1, end, identifier));
        }
        else if (overlapsWith(otherBlock)) {
            if (startsBefore(otherBlock)) {
                resultBlocks.add(new Block(start, otherBlock.getStart() - 1, identifier));
                resultBlocks.add(otherBlock);
            }
            else {
                resultBlocks.add(otherBlock);
                resultBlocks.add(new Block(otherBlock.getEnd() + 1, end, identifier));
            }
        }
        else {
            if (startsBefore(otherBlock)) {
                resultBlocks.add(this);
                resultBlocks.add(otherBlock);
            }
            else {
                resultBlocks.add(otherBlock);
                resultBlocks.add(this);
            }
        }
        return resultBlocks;
    }
}
