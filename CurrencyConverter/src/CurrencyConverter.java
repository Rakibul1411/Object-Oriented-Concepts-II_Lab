import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "BDT");

        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the currency converter!");

        System.out.println("Currency converting FROM?");
        System.out.println("1:USD (US Dollar)\t 2:CAD (Canadian Dollar)\t 3:EUR (Euro)\t 4:HKD (Honk Kong Dollar)\t 5:BDT (Bangladeshi Taka)");
        fromCode = currencyCodes.get(sc.nextInt());

        System.out.println("Currency converting TO?");
        System.out.println("1:USD (US Dollar)\t 2:CAD (Canadian Dollar)\t 3:EUR (Euro)\t 4:HKD (Honk Kong Dollar)\t 5:BDT (Bangladeshi Taka)");
        toCode = currencyCodes.get(sc.nextInt());

        System.out.println("Amount you wish to convert?");
        amount = sc.nextFloat();

        sendHttpGETRequest(fromCode, toCode, amount);

        System.out.println("Thank you for using the currency converter!");
    }
    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {

        String access_key = "2c06c5e02d8884312f6ea5710a540432";

        String GET_URL = "https://api.exchangeratesapi.io/v1/latest?access_key=" + access_key + "&base=" + fromCode + "&symbols=" + toCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("rates").getDouble(toCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount + " " + fromCode + " = " + amount/exchangeRate + " " + toCode);

        }
        else{
            System.out.println("GET request failed");
        }
    }
}