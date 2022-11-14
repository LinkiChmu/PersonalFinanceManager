import java.io.Serializable;

public class Purchase implements Comparable<Purchase>, Serializable {
    private int date;
    private String category;
    private int sum;
    private static final long serialVersionUID = 29L;

    public Purchase(int date, String category, int sum) {
        this.date = date;
        this.category = category;
        this.sum = sum;
    }

    @Override
    public int compareTo(Purchase p) {
        return Integer.compare(date, p.date);
    }

    @Override
    public String toString() {
        return date + " " + category + " = " + sum;
    }

    public int getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public int getSum() {
        return sum;
    }
}
