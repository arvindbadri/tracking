
public class Range {
    protected int start;
    protected int end;
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
        return this.start == other.start && this.end == other.end;
    }
    public Boolean isSubsetOf(Range other) {
        return this.start >= other.start && this.end  <= other.end;
    }
    public Boolean isSupersetOf(Range other) {
        return other.isSubsetOf(this);
    }
    public Boolean startsBefore(Range other) {
        return this.start < other.start;
    }
    public Boolean overlapsWith(Range other) {
        return Math.max(this.start, other.start) <= Math.min(this.end, other.end);
    }
}
