import java.util.List;

public class Identifier {
    private String status;
    private int code;
    private List<Block> blocks;

    /*
    Initialize
     */
    public Identifier(String status, int code) {
        this.status = status;
        this.code = code;
    }

    /*
    Assign
     */
    public void addBlock(Block block) {
        blocks.add(block);
    }

    /*
    Reduce
     */
    private void reduce() {

    }

}
