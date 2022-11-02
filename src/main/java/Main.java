import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final int PORT = 8989;
    private static final Gson GSON = new Gson();
    private static File binFile = new File("data.bin");

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FinanceData financeData = FinanceData.config(binFile);
        Map<String, String> categories = loadFromTxtFile(new File("categories.tsv"));

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
                {
                    String strJson = in.readLine();
                    System.out.println(strJson);

                    JsonObject jsonObject = JsonParser.parseString(strJson).getAsJsonObject();
                    String expense = jsonObject.get("title").getAsString();
                    String date = jsonObject.get("date").getAsString();
                    int sum = jsonObject.get("sum").getAsInt();
                    int year = Integer.parseInt(date.substring(0,4));
                    int month = Integer.parseInt(date.substring(5,7));
                    int day = Integer.parseInt(date.substring(8));
                    int dateAsInt = year * 10_000 + month * 100 + day;

                    String category = defineCategory(expense, categories);
                    financeData.logExpense(dateAsInt, sum, category);

                    MaximalCategory maxCategory = new MaxCategory();
                    MaximalCategory maxYearCategory = new MaxYearCategory(year);
                    MaximalCategory maxMonthCategory = new MaxMonthCategory(year, month);
                    MaximalCategory maxDayCategory = new MaxDayCategory(year, month, day);

                    maxCategory.extractDataFromLog(financeData);
                    maxYearCategory.extractDataFromLog(financeData);
                    maxMonthCategory.extractDataFromLog(financeData);
                    maxDayCategory.extractDataFromLog(financeData);

                    FinanceStatistics financeStatistics = new FinanceStatistics(
                            maxCategory, maxYearCategory, maxMonthCategory, maxDayCategory);

                    out.println(GSON.toJson(financeStatistics));
                    financeData.saveBin(binFile);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't start server");
            e.printStackTrace();
        }
    }

    public static Map<String, String> loadFromTxtFile(File txtFile) throws IOException {
        Map<String, String> categories = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(txtFile))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] line = s.split("(?U)\\W+");
                categories.put(line[0], line[1]);
            }
        }
        return categories;
    }

    public static String defineCategory(String expense, Map<String, String> categories) {
        return categories.getOrDefault(expense, "другое");
    }
}
