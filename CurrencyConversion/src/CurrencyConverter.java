public class CurrencyConverter {
    // Convert a currency to another
    public static Double convert(Double amount, Double exchangeValue) {
        double price;
        price = amount * exchangeValue;
        price = Math.round(price * 100d) / 100d;
        return price;
    }
}
