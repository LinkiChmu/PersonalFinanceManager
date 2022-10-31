public class Purchase {
    private String date;
    private String category;
    private int sum;

    public Purchase(String date, String category, int sum) {
        this.date = date;
        this.category = category;
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public int getSum() {
        return sum;
    }
}
