public class Purchase implements Comparable {
    private int date;
    private String category;
    private int sum;

    public Purchase(int date, String category, int sum) {
        this.date = date;
        this.category = category;
        this.sum = sum;
    }

    @Override
    public int compareTo(Object o) {
        Purchase p = (Purchase) o;
        if (date < p.date) {
            return -1;
        } else if (date == p.date){
            return 1;
        } else return 0;
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
