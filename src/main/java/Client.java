import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;


public class Client {
    private static final int PORT = 8989;
    private static final String HOST = "localhost";
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<String> expenseNames = List.of("булка", "колбаса", "сухарики",
                "курица", "стрижка", "шампунь", "мыло", "акции",
                "коммуналка", "тапки", "шапка", "тренировка");
        int[] prices = {400, 100, 900, 150, 300, 500, 800, 1000, 200, 1100, 700};
        String formattedDate = LocalDate.now().format(dateFormatter);
        JSONObject obj = new JSONObject();
        try (
                Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))
        ) {
            obj.put("sum", prices[RANDOM.nextInt(prices.length)]);
            obj.put("date", formattedDate);
     //             obj.put("date", "2020.10.31");
            obj.put("title", expenseNames.get(RANDOM.nextInt(expenseNames.size())));

            String msg = obj.toJSONString();
            out.println(msg);

            String response = in.readLine();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
