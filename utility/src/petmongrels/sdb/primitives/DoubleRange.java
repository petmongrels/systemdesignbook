package petmongrels.sdb.primitives;

public class DoubleRange {
    double minimum;
    double maximum;

    private DoubleRange() {
    }

    public DoubleRange(double minimum, double maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public boolean fallsWithin(double value) {
        return value >= minimum && value <= maximum;
    }

    public boolean fallsOutside(double value) {
        return !fallsWithin(value);
    }
}
