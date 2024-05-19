import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class task4 {

    private static final String API_KEY = "28eafa48dd4842aaf305c64f";

    private static double getExchangeRate(String SampleCurrency, String TargetCurrency) {
        String urlString = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, SampleCurrency);
        double ExRate = 0.0;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                ExRate = jsonResponse.getJSONObject("conversion_rates").getDouble(TargetCurrency);
            } else {
                System.out.println("Error: Unable to fetch exchange rate.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ExRate;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter currency to exchange : ");
        String SampleCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter Target currency      : ");
        String TargetCurrency = scanner.nextLine().toUpperCase();

        double ExRate = getExchangeRate(SampleCurrency, TargetCurrency);

        if (ExRate > 0) {
            System.out.print("Enter Rate in " + SampleCurrency + ": ");
            double Rate = scanner.nextDouble();

            double convertedAmount = Rate * ExRate;
            System.out.printf("%.2f %s is equivalent to %.2f %s%n", Rate, SampleCurrency, convertedAmount, TargetCurrency);
        } else {
            System.out.println("Please try again later.");
        }

        scanner.close();
    }
}
