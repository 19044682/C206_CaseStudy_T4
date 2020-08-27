import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<CurrencyClass> currencyList = new ArrayList<CurrencyClass>();
		ArrayList<MoneyHolding> holdingList = new ArrayList<MoneyHolding>();
		ArrayList<history> transHistory = new ArrayList<history>();

		int option = 0;
		while (option != 16) {
			System.out.println("MONEY EXCHANGE MANAGEMENT SYSTEM");
			System.out.println("=================================");
			System.out.println("1. Add Currency");
			System.out.println("2. Delete Currency");
			System.out.println("3. Update Currency");
			System.out.println("4. View Currency List");
			System.out.println("5. View Holdings");
			System.out.println("6. Add Holdings");
			System.out.println("7. Delete Holdings");
			System.out.println("8. Update Holdings");
			System.out.println("9. Search ISO");
			System.out.println("10. Update ISO");
			System.out.println("11. Search Currency");
			System.out.println("12. Convert Currency");
			System.out.println("13. Add Threshold");
			System.out.println("14. View Transaction Summary");
			System.out.println("15. Add Transaction");
			System.out.println("16. Quit");

			option = Helper.readInt("Enter Option > ");

			if (option == 1) {
				C206_CaseStudy.addCurrency(currencyList);
			} else if (option == 2) {
				C206_CaseStudy.deleteCurrency(currencyList);
			} else if (option == 3) {
				C206_CaseStudy.updateCurrency(currencyList);
			} else if (option == 4) {
				C206_CaseStudy.viewCurrency(currencyList);
			} else if (option == 5) {
				C206_CaseStudy.viewHoldings(holdingList);
			} else if (option == 6) {
				C206_CaseStudy.addHoldings(holdingList);
			} else if (option == 7) {
				C206_CaseStudy.deleteHoldings(holdingList);
			} else if (option == 8) {
				C206_CaseStudy.updateHoldings(holdingList);
			} else if (option == 9) {
				C206_CaseStudy.searchISO(holdingList);
			} else if (option == 10) {
				C206_CaseStudy.updateISO(holdingList);
			} else if (option == 11) {
				C206_CaseStudy.searchCurrency(currencyList);
			} else if (option == 12) {
				C206_CaseStudy.convertCurrency(currencyList);
			} else if (option == 13) {
				C206_CaseStudy.addThreshold(holdingList);
			} else if (option == 14) {
				C206_CaseStudy.viewTransactionsSummary(transHistory);
			} else if (option == 15) {
				C206_CaseStudy.addTransaction(transHistory);
			} else if (option == 16) {
				System.out.println("Thank you and Good Bye!");
			} else {
				System.out.println("Invalid Option!");
			}
		}

	} // Main
	
	public static void viewCurrency(ArrayList<CurrencyClass> currencyList) {
		System.out.println(String.format("%-10s %-30s %-10s %-10s %8s\n", "ISO", "Currency Name", "Buy Rate",
				"Sell Rate", "Date Added"));
		for (int i = 0; i < currencyList.size(); i++) {
			CurrencyClass t = currencyList.get(i);
			System.out.println(currencyList.get(i).toString() + t.getDate());
		}
	}

	public static void addCurrency(ArrayList<CurrencyClass> currencyList) {
		String iso = Helper.readString("ISO: ");
		String cn = Helper.readString("Currency Name: ");
		Double br = Helper.readDouble("Buy Rate: ");
		Double sr = Helper.readDouble("Sell Rate: ");

		currencyList.add(new CurrencyClass(iso, cn, br, sr, LocalDate.now()));
		System.out.println("New currency added.");
		System.out.println(String.format("%-10s %-30s %-10s %-10s %8s\n", "ISO", "Currency Name", "Buy Rate",
				"Sell Rate", "Date Added"));
		for (int i = 0; i < currencyList.size(); i++) {
			CurrencyClass t = currencyList.get(i);
			System.out.println(currencyList.get(i).toString() + t.getDate());
		} // view all currencies

	} // add currencies method

	public static void deleteCurrency(ArrayList<CurrencyClass> currencyList) {
		boolean isDeleted = false;
		String iso1 = Helper.readString("ISO of currency to delete: ");
		for (int i = 0; i < currencyList.size(); i++) {
			CurrencyClass t = currencyList.get(i);
				if (iso1.equalsIgnoreCase(t.getIso())) {
					currencyList.remove(i);
					isDeleted = true;
					System.out.println(String.format("%-10s %-30s %-10s %-10s %8s\n", "ISO", "Currency Name", "Buy Rate",
							"Sell Rate", "Date Added"));
					for (int x = 0; x < currencyList.size(); x++) {
						CurrencyClass y = currencyList.get(x);
						System.out.println(currencyList.get(x).toString() + y.getDate());
				} 
				
				}
			
			} // for
		
		if (isDeleted == true) {
			System.out.println("Currency deleted.");
		}
		
		else {
			System.out.println("Currency not found.");
		}
	}

	public static void updateCurrency(ArrayList<CurrencyClass> currencyList) {
		boolean isDeleted = false;
		String updateiso = Helper.readString("Enter currency (ISO) to update: ");
		Double buy = Helper.readDouble("New buy rate: ");
		Double sell = Helper.readDouble("New sell rate: ");
		for (int i = 0; i < currencyList.size(); i++) {
			CurrencyClass t = currencyList.get(i);
			if (updateiso.equalsIgnoreCase(t.getIso())) {
				currencyList.add(new CurrencyClass(updateiso, t.getCurrencyName(), buy, sell, LocalDate.now()));
				currencyList.remove(i);
				isDeleted = true;
				System.out.println(String.format("%-10s %-30s %-10s %-10s %8s\n", "ISO", "Currency Name", "Buy Rate",
						"Sell Rate", "Date Added"));
				for (int x = 0; x < currencyList.size(); x++) {
					CurrencyClass y = currencyList.get(x);
					System.out.println(currencyList.get(x).toString() + y.getDate());
			}

		} // for

		if (isDeleted == true) {
			System.out.println("Currency updated.");
			
		} else {
			System.out.println("Currency unable to update.");
		}
		}
	} // update currencies method

	public static void viewHoldings(ArrayList<MoneyHolding> holdingList) {

		Helper.line(40, "-");
		System.out.println("VIEW ALL Transaction");
		Helper.line(40, "-");

		double range = Helper.readDouble("Enter Threshold range > ");

		String output = String.format("%-10s %-15s %-10s %-10s \n", "ISO", "HOLDINGS", "SGD VALUE", "THRESHOLD");
		for (int i = 0; i < holdingList.size(); i++) {
			MoneyHolding t = holdingList.get(i);
			if (range > t.getThreshold()) {
				output += String.format("%-10s %-15.2f %-10.2f %-10.2f \n", t.getIso(), t.getHoldingAmt(),
						t.getSgdValue(), t.getThreshold());
			}

		}
		System.out.println(output);
	}

	public static void searchISO(ArrayList<MoneyHolding> holdingList) {
		Helper.line(40, "-");
		System.out.println("Search Transaction");
		Helper.line(40, "-");

		String ISO = Helper.readString("Enter ISO > ");
		String output = String.format("%-10s %-15s %-10s %-10s \n", "ISO", "HOLDINGS", "SGD VALUE", "THRESHOLD");

		for (int i = 0; i < holdingList.size(); i++) {
			MoneyHolding t = holdingList.get(i);
			if (ISO.equalsIgnoreCase(t.getIso())) {
				output += String.format("%-10s %-15.2f %-10.2f %-10.2f \n", t.getIso(), t.getHoldingAmt(),
						t.getSgdValue(), t.getThreshold());
			}
		}
		System.out.println(output);
	}

	public static void updateISO(ArrayList<MoneyHolding> holdingList) {

		Helper.line(40, "-");
		System.out.println("Update Transaction");
		Helper.line(40, "-");

		String ISO = Helper.readString("Enter ISO > ");
		double newAmt = Helper.readDouble("Enter New Amount > ");
		String output = String.format("%-10s %-15s %-10s %-10s \n", "ISO", "HOLDINGS", "SGD VALUE", "THRESHOLD");
		for (int i = 0; i < holdingList.size(); i++) {
			MoneyHolding t = holdingList.get(i);
			if (ISO.equalsIgnoreCase(t.getIso())) {
				t.setThreshold(newAmt);
			}
			output += String.format("%-10s %-15.2f %-10.2f %-10.2f \n", t.getIso(), t.getHoldingAmt(), t.getSgdValue(),
					t.getThreshold());
		}
		System.out.println(output);
	}

	public static void searchCurrency(ArrayList<CurrencyClass> currencyList) {
		System.out.println(String.format("%-10s %-30s %-10s %-10s\n", "ISO", "Currency Name", "Buy Rate", "Sell Rate"));

		for (int i = 0; i < currencyList.size(); i++) {
			System.out.println(currencyList.get(i).toString());
		}

		String currencySearch = Helper.readString("Enter currency to search > ");

		boolean isFound = false; // to indicate whether object has been found
		{
			for (int i = 0; i < (currencyList).size(); i++) {
				if (currencyList.get(i) != null && currencyList.get(i).getIso().equalsIgnoreCase(currencySearch)) {
					isFound = true;
					System.out.println(currencyList.get(i));
					break;

				}
			}

			if (isFound == false) {
				System.out.println("No such currency was found");
			}
		}
	}

	// currency convert
	public static String convertCurrency(ArrayList<CurrencyClass> currencyList) {
		String currencyinput = Helper.readString("Input CURRENCY (E.G. USD) > ");
		String amount = Helper.readString("Input AMOUNT > ");
		String confirm = Helper.readString("Are you sure? (YES/NO) > ");
		String output = String.format("%10s %10s\n", "BUY RATE", "SELL RATE");

		int b = 0;
		try {
			b = Integer.parseInt(amount);
		} catch (Exception e) {
			System.out.println("No match found");
			return "";
		}
		boolean found = false;

		for (CurrencyClass i : currencyList) {
			String CURRENCY = i.getIso();
			if (CURRENCY.toUpperCase().contains(currencyinput.toUpperCase())) {
				found = true;
				int BUYRATE = (int) (b * i.getBuyRate());
				int SELLRATE = (int) (b * i.getSellRate());
				output += String.format("%10s %10s", BUYRATE, SELLRATE);
			}
		}

		if (found == true && confirm.equalsIgnoreCase("Yes")) {
			System.out.println(output);
		} else {
			System.out.println("No match found, or error input");
		}

		return output;

	}

	public static void viewTransactionsSummary(ArrayList<history> transHistory) {
		int duration = 0;
		String choice = "";
		while (duration < 1) {
			Helper.line(40, "=");
			System.out.println("1. View Transaction Summary for Last Week");
			System.out.println("2. View Transaction Summary for Last 2 Weeks");
			System.out.println("3. View Transaction Summary for Yesterday");
			System.out.println("4. View Transaction Summary for Last 2 Days");
			System.out.println("5. View Transaction Summary for Last 3 Days");
			Helper.line(40, "=");
			choice = Helper.readString("Enter Choice > ");
			switch (choice) {
			case "1":
				duration = 7;
				break;
			case "2":
				duration = 14;
				break;
			case "3":
				duration = 1;
				break;
			case "4":
				duration = 2;
				break;
			case "5":
				duration = 3;
				break;
			default:
				System.out.println("Invalid input, please try again!");
				duration = 0;
			}
		}
		String output = String.format("%-5s %-5s %-20s\n", "CCY", "TYPE", "NUMBER OF TRANSACTIONS");
		if (transHistory.isEmpty()) {
			System.out.println("There are no transaction added.");
		} else {
			HashMap<String, Integer> summary = new HashMap<String, Integer>();
			LocalDate today = LocalDate.now();
			for (int i = 0; i < transHistory.size(); i++) {
				history t = transHistory.get(i);
				if (!t.getDate().isBefore(today.minusDays(duration))) {
					String key = t.getCcy_in() + "." + t.getType();

					if (summary.containsKey(key)) {
						Integer val = summary.get(key);
						summary.replace(key, val + 1);
					} else {
						summary.putIfAbsent(key, 1);
					}
				}
			}
			Object[] objKeySet = summary.keySet().toArray();
			String[] keySet = new String[objKeySet.length];
			System.arraycopy(objKeySet, 0, keySet, 0, objKeySet.length);
			for (int i = 0; i < summary.size(); i++) {
				String[] ccyType = keySet[i].toString().split(".");
				String ccy = keySet[i].substring(0, keySet[i].indexOf("."));
				String type = keySet[i].substring(keySet[i].indexOf(".") + 1);
				Integer val = summary.get(keySet[i]);
				output += String.format("%-5s %-5s %-5s %-20s\n", ccy, type, ccyType, val);
			}
			System.out.println(output);
		}
	}

	public static void addHoldings(ArrayList<MoneyHolding> moneyList) {
		double CurrentFloat = 100000;
		String Currency = Helper.readString("Currency (ISO): ");
		double add1 = Helper.readDouble("Value: ");

		String output = String.format("%-10s \n", "Holding Amount: ");
		// double total =+ (hold1.getholdingAmt());
		double add2 = add1 + CurrentFloat;
		if (add2 > CurrentFloat) {
			CurrentFloat = add2;
		}
		for (int i = 0; i < moneyList.size(); i++) {
			MoneyHolding t = moneyList.get(i);
			if (Currency.equalsIgnoreCase(t.getIso())) {
				t.setHoldingAmt(CurrentFloat);
				output += String.format("%-10.2f \n", t.getHoldingAmt());
			}

		}
		System.out.println(output);
	}

	public static void deleteHoldings(ArrayList<MoneyHolding> moneyList) {
		double CurrentFloat = 100000;
		String Currency = Helper.readString("Currency (ISO): ");
		double minus1 = Helper.readDouble("Value: ");

		String output = String.format("%-10s \n", "Holding Amount: ");
		// double MinusValue = CurrentFloat - hold2.getholdingAmt();
		double minus2 = CurrentFloat - minus1;
		if (minus2 < CurrentFloat) {
			CurrentFloat = minus2;
		}
		for (int i = 0; i < moneyList.size(); i++) {
			MoneyHolding t = moneyList.get(i);
			if (Currency.equalsIgnoreCase(t.getIso())) {
				t.setHoldingAmt(CurrentFloat);
				output += String.format("%-10.2f \n", t.getHoldingAmt());
			}
		}
		System.out.println(output);
	}

	public static void updateHoldings(ArrayList<MoneyHolding> moneyList) {
		double CurrentFloat = 100000;
		String Currency = Helper.readString("Currency (ISO): ");
		double update = Helper.readDouble("Value: ");
		String output = String.format("%-10s \n", "Holding Amount: ");
		// String output = String.format("%-10s", "Holding Amount: ");

		for (int i = 0; i < moneyList.size(); i++) {
			MoneyHolding t = moneyList.get(i);
			if (Currency.equalsIgnoreCase(t.getIso()) && update != CurrentFloat) {
				t.setHoldingAmt(CurrentFloat);
				output += String.format("%-10.2f \n", t.getHoldingAmt());
			}
			// hold3.toString();
			// output += String.format("%-10.2f", t.getholdingAmt());

		}
		System.out.println(output);
	}

	public static void addThreshold(ArrayList<MoneyHolding> holdingList) {

		boolean isAdded = false;
		String Currency = Helper.readString("Enter Currency (ISO): ");
		double NewVal = Helper.readDouble("Value: ");
		String output = String.format("%-10s %-5s \n", "ISO", "THRESHOLD");

		// double minus2 = CurrentFloat - minus1;

		for (int i = 0; i < holdingList.size(); i++) {
			MoneyHolding t = holdingList.get(i);
			if (Currency.equalsIgnoreCase(t.getIso())) {
				t.setThreshold(t.getHoldingAmt() + NewVal);
				isAdded = true;
			}
			output += String.format("%-10s %-5.2f \n", t.getIso(), t.getThreshold());

		}
		if (isAdded == true) {
			System.out.println(output);
		} else {
			System.out.println("Threshold Not Added!");
		}
	}

	public static void addTransaction(ArrayList<history> transHistory) {
		Helper.line(40, "=");
		System.out.println("ADD TRANSACTION");
		Helper.line(40, "=");
		System.out.println("List of Currencies:");
		System.out.println("USD , 1.37");
		System.out.println("AUD , 0.98");
		System.out.println("MYR , 0.33");
		System.out.println("KRW , 0.0012");
		System.out.println("EUR , 1.62");

		String mtype = Helper.readString("Enter type (BUY/SELL) > ");
		String mccy_in = Helper.readString("Enter currency in > ");
		double mamt_in = Helper.readDouble("Enter amount in > ");
		String mccy_out = Helper.readString("Enter currency out > ");
		double mrate = Helper.readDouble("Enter rate > ");
		double mamt_out = mamt_in * mrate;

		transHistory.add(new history(LocalDate.now(), mtype.toUpperCase(), mccy_in.toUpperCase(), mamt_in,
				mccy_out.toUpperCase(), mamt_out, mrate));

		String output = String.format("%-5s %-5s %-20s %-10s %-10s %-10s %-10s %-10s\n", "NO.", "DATE", "TYPE",
				"CCY_IN", "AMT_IN", "CCY_OUT", "AMT_OUT", "RATE");

		for (int i = 0; i < transHistory.size(); i++) {
			history t = transHistory.get(i);
			output += String.format("%-5s %-5s %-20s %-10s %-10.2f %-10s %-10.2f %-10.4f\n", i + 1, t.getDate(),
					t.getType(), t.getCcy_in(), t.getAmt_in(), t.getCcy_out(), t.getAmt_out(), t.getRate());

		}
		System.out.println("Transaction has been added!");
		System.out.println(output);
	}

} // class
