import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Currency {
    private String name;
    private String shortName;
    private final HashMap<String, Double> exchangeValues = new HashMap<>();

    // "Currency" Constructor
    public Currency(String nameValue, String shortNameValue) {
        this.name = nameValue;
        this.shortName = shortNameValue;
        initExchangeValuesFromFile();
    }

    // Getter and Setter methods...

    // Getter and Setter methods...

    // Getter and Setter methods...

    // Initialize exchange values from file
    private void initExchangeValuesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("exchange_rates.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 3) {
                    String currencyCode = parts[0];
                    double exchangeRate = Double.parseDouble(parts[2]);
                    exchangeValues.put(currencyCode, exchangeRate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ... (Other methods remain unchanged)

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        ArrayList<Currency> currencies = Currency.init();
        for (Currency currency : currencies) {
            System.out.println(currency.getName() + " - Exchange Values: " + currency.getExchangeValues());
        }
    }
}
