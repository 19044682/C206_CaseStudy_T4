import java.time.LocalDate;

public class history {

	public LocalDate date;
	public String type;
	public double amt_in;
	public String ccy_out;
	public double amt_out;
	public double rate;
	public String ccy_in;

	public history(LocalDate date, String type, String ccy_in, double amt_in, String ccy_out, double amt_out,
			double rate) {
		this.ccy_in = ccy_in;
		this.rate = rate;
		this.date = date;
		this.type = type;
		this.amt_in = amt_in;
		this.ccy_out = ccy_out;
		this.amt_out = amt_out;
	}

	public String getType() {
		return type;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getCcy_in() {
		return ccy_in;
	}

	public double getAmt_in() {
		return amt_in;
	}

	public String getCcy_out() {
		return ccy_out;
	}

	public double getAmt_out() {
		return amt_out;
	}

	public double getRate() {
		return rate;
	}

}
