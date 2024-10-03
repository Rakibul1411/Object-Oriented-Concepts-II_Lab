package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {
	private String name;
	private String shortName;
	private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();
	
	// "Currency" Constructor
	public Currency(String nameValue, String shortNameValue) {
		this.name = nameValue;
		this.shortName = shortNameValue;
	}
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	// Setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter for shortName
	public String getShortName() {
		return this.shortName;
	}
	
	// Setter for shortName
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	// Getter for exchangeValues
	public HashMap<String, Double> getExchangeValues() {
		return this.exchangeValues;
	}
	
	// Setter for exchangeValues
	public void setExchangeValues(String key, Double value) {
		this.exchangeValues.put(key, value);
	}
	
	// Set default values for a currency
	public void defaultValues() {
		String currency = this.name;
		
		switch (currency) {	
			case "US Dollar":
				this.exchangeValues.put("USD", 1.00);
				this.exchangeValues.put("EUR", 0.95);
				this.exchangeValues.put("GBP", 0.82);
				this.exchangeValues.put("BDT", 110.0);
				this.exchangeValues.put("CAD", 1.39);
				this.exchangeValues.put("JPY", 151.21);
				this.exchangeValues.put("IRR", 42237.50);
				this.exchangeValues.put("CNY", 7.32);
				this.exchangeValues.put("KWD", 0.31);
				this.exchangeValues.put("PKR", 281.10);
				break;
			case "Euro":
				this.exchangeValues.put("USD", 1.06);
				this.exchangeValues.put("EUR", 1.00);
				this.exchangeValues.put("GBP", 0.87);
				this.exchangeValues.put("BDT", 110.0);
				this.exchangeValues.put("CAD", 1.47);
				this.exchangeValues.put("JPY", 159.92);
				this.exchangeValues.put("IRR", 44651.37);
				this.exchangeValues.put("CNY", 7.59);
				this.exchangeValues.put("KWD", 0.33);
				this.exchangeValues.put("PKR", 297.19);
				break;
			case "British Pound":
				this.exchangeValues.put("USD", 1.21);
				this.exchangeValues.put("EUR", 1.15);
				this.exchangeValues.put("GBP", 1.00);
				this.exchangeValues.put("BDT", 133.85);
				this.exchangeValues.put("CAD", 1.69);
				this.exchangeValues.put("JPY", 183.68);
				this.exchangeValues.put("IRR", 51289.42);
				this.exchangeValues.put("CNY", 8.89);
				this.exchangeValues.put("KWD", 0.38);
				this.exchangeValues.put("PKR", 341.38);
				break;
			case "Bangladeshi Taka":
				this.exchangeValues.put("USD", 0.0091);
				this.exchangeValues.put("EUR", 0.0086);
				this.exchangeValues.put("GBP", 0.0075);
				this.exchangeValues.put("BDT", 1.00);
				this.exchangeValues.put("CAD", 0.013);
				this.exchangeValues.put("JPY", 1.37);
				this.exchangeValues.put("IRR", 383.28);
				this.exchangeValues.put("CNY", 0.066);
				this.exchangeValues.put("KWD", 0.0028);
				this.exchangeValues.put("PKR", 2.55);
				break;
			case "Canadian Dollar":
				this.exchangeValues.put("USD", 0.72);
				this.exchangeValues.put("EUR", 0.68);
				this.exchangeValues.put("GBP", 0.59);
				this.exchangeValues.put("BDT", 79.41);
				this.exchangeValues.put("CAD", 1.00);
				this.exchangeValues.put("JPY", 108.90);
				this.exchangeValues.put("IRR", 30426.42);
				this.exchangeValues.put("CNY", 5.27);
				this.exchangeValues.put("KWD", 0.22);
				this.exchangeValues.put("PKR", 202.49);
				break;
			case "Japanese Yen":
				this.exchangeValues.put("USD", 0.0066);
				this.exchangeValues.put("EUR", 0.0063);
				this.exchangeValues.put("GBP", 0.0054);
				this.exchangeValues.put("BDT", 0.73);
				this.exchangeValues.put("CAD", 0.0092);
				this.exchangeValues.put("JPY", 1.00);
				this.exchangeValues.put("IRR", 279.33);
				this.exchangeValues.put("CNY", 0.047);
				this.exchangeValues.put("KWD", 0.0020);
				this.exchangeValues.put("PKR", 1.86);
				break;
			case "Iranian Rial":
				this.exchangeValues.put("USD", 0.000024);
				this.exchangeValues.put("EUR", 0.000022);
				this.exchangeValues.put("GBP", 0.000020);
				this.exchangeValues.put("BDT", 0.0026);
				this.exchangeValues.put("CAD", 0.000033);
				this.exchangeValues.put("JPY", 0.0036);
				this.exchangeValues.put("IRR", 1.00);
				this.exchangeValues.put("CNY", 0.00017);
				this.exchangeValues.put("KWD", 0.0000073);
				this.exchangeValues.put("PKR", 0.0067);
				break;
			case "Chinese Yuan Renminbi":
				this.exchangeValues.put("USD", 0.14);
				this.exchangeValues.put("EUR", 0.13);
				this.exchangeValues.put("GBP", 0.11);
				this.exchangeValues.put("BDT", 15.06);
				this.exchangeValues.put("CAD", 0.19);
				this.exchangeValues.put("JPY", 20.66);
				this.exchangeValues.put("IRR", 5771.25);
				this.exchangeValues.put("CNY", 1.00);
				this.exchangeValues.put("KWD", 0.042);
				this.exchangeValues.put("PKR", 38.41);
				break;
			case "Kuwaiti Dinar":
				this.exchangeValues.put("USD", 3.23);
				this.exchangeValues.put("EUR", 3.06);
				this.exchangeValues.put("GBP", 2.66);
				this.exchangeValues.put("BDT", 356.51);
				this.exchangeValues.put("CAD", 4.49);
				this.exchangeValues.put("JPY", 489.08);
				this.exchangeValues.put("IRR", 136608.92);
				this.exchangeValues.put("CNY", 23.67);
				this.exchangeValues.put("KWD", 1.00);
				this.exchangeValues.put("PKR", 909.16);
				break;
			case "Pakistani Rupee":
				this.exchangeValues.put("USD", 0.0036);
				this.exchangeValues.put("EUR", 0.0034);
				this.exchangeValues.put("GBP", 0.0029);
				this.exchangeValues.put("BDT", 0.39);
				this.exchangeValues.put("CAD", 0.0049);
				this.exchangeValues.put("JPY", 0.54);
				this.exchangeValues.put("IRR", 150.26);
				this.exchangeValues.put("CNY", 0.026);
				this.exchangeValues.put("KWD", 0.0011);
				this.exchangeValues.put("PKR", 1.00);
				break;

		}
	}
	
	// Initialize currencies
	public static ArrayList<Currency> init() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();
				
		currencies.add( new Currency("US Dollar", "USD") );
		currencies.add( new Currency("Euro", "EUR") );
		currencies.add( new Currency("British Pound", "GBP") );
		currencies.add( new Currency("Bangladeshi Taka", "BDT") );
		currencies.add( new Currency("Canadian Dollar", "CAD") );
		currencies.add( new Currency("Japanese Yen", "JPY") );
		currencies.add( new Currency("Iranian Rial", "IRR") );
		currencies.add( new Currency("Chinese Yuan Renminbi", "CNY") );
		currencies.add( new Currency("Kuwaiti Dinar", "KWD") );
		currencies.add( new Currency("Pakistani Rupee", "PKR") );
		
		for (Integer i =0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}		
		
		return currencies;
	}
	
	// Convert a currency to another
	public static Double convert(Double amount, Double exchangeValue) {
		Double price;
		price = amount * exchangeValue;
		price = Math.round(price * 100d) / 100d;
		
		return price;
	}
}