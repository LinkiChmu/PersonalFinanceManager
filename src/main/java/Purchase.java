public class Purchase implements Comparable {
    private int date;
    private String category;
    private int sum;

    public Purchase(String date, String category, int sum) {
        String[] parts = date.split("(?U)\\W+");
        this.date = (Integer.parseInt(parts[0]) * 10_000) +
                (Integer.parseInt(parts[1]) * 100) + (Integer.parseInt(parts[2]));
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
