import java.time.LocalDate;

public class CurrencyClass {

	public String iso;
	public String currencyName;
	public LocalDate date;
	private double buyRate;
	private double sellRate;

	public CurrencyClass(String iso, String currencyName, double buyRate, double sellRate, LocalDate date) {
		super();
		this.iso = iso;
		this.currencyName = currencyName;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
		this.date = date;

	}

	public String getIso() {
		return iso;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public double getBuyRate() {
		return buyRate;
	}

	public double getSellRate() {
		return sellRate;
	}

	public LocalDate getDate() {
		LocalDate datetime = LocalDate.now();
		datetime.toString();
		return date;
	}

	public String toString() {
		String CurrencyInfo = String.format("%-10s %-30s %-10.4f %-10.4f", iso, currencyName, buyRate, sellRate);
		return CurrencyInfo;
	}

}