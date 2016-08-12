
public class TestMain {
    public static void main(String[] args) {
        Table o = new Table();
        o.addBlock("1 10 A 1");
        o.addBlock("11 20 A 1");
        o.addBlock("21 30 A 1");
        System.out.println(o.getBlocks());
        System.out.println(new Range(1,10).overlapsWith(new Range(10, 15)));
    }
}
