public class MoneyHolding {
	private String iso;
	private double holdingAmt;
	private double sgdValue;
	private double threshold;

	public MoneyHolding(String iso, double holdingAmt, double sgdValue, double threshold) {
		super();
		this.iso = iso;
		this.holdingAmt = holdingAmt;
		this.sgdValue = sgdValue;
		this.threshold = threshold;
	}

	public String getIso() {
		return iso;
	}

	public double getHoldingAmt() {
		return holdingAmt;
	}

	public double getSgdValue() {
		return sgdValue;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public void setHoldingAmt(double holdingAmt) {
		this.holdingAmt = holdingAmt;
	}


}
