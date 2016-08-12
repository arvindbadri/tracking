
public class TestMain {
    public static void main(String[] args) {
        Table o = new Table();
        o.addBlock("1 1000 A 1");
        o.addBlock("1 500 A 2");
        o.addBlock("250 750 A 3");
        System.out.println(o.getBlocks());
        System.out.println(new Range(1,10).overlapsWith(new Range(10, 15)));
    }
}
