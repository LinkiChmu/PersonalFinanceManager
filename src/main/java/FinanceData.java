import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceData implements Serializable {
    protected List<Purchase> log;

    public FinanceData() {
        this.log = new ArrayList<>();
    }

    public void logExpense(int date, int sum, String category) {
        log.add(new Purchase(date, category, sum));
    }

    public List<Purchase> getLog() {
        return log;
    }

    public static FinanceData config(File binFile) throws IOException, ClassNotFoundException {
        if (binFile.exists()) {
            return loadFromBinFile(binFile);
        } else {
            return new FinanceData();
        }
    }

    public static FinanceData loadFromBinFile(File binFile) throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(binFile))) {
            return (FinanceData) in.readObject();
        }
    }

    public void saveBin(File binFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binFile))) {
            out.writeObject(this);
        }
    }
}
