
public class Range {
    int start;
    int end;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Boolean isSame(Range other) {
        return false;
    }
    public Boolean isSubsetOf(Range other) {
        return false;
    }
    public Boolean isSupersetOf(Range other) {
        return other.isSubsetOf(this);
    }
    public Boolean startsBefore(Range other) {
        return false;
    }
    public Boolean overlapsWith(Range other) {
        return false;
    }
}
