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
}
