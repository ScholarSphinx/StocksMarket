package stocks;

public class DividendStock extends Stock {

	protected double totalDividends;
 	
	// Default Constructor
	public DividendStock(String symbol) {
		super(symbol);
		totalDividends = 0;
	}
	//Parameterized constructor
	public DividendStock (String symbol , int totalShares, double totalCosts , double totalDividends) {
		super(symbol);
		this.totalDividends = totalDividends;
	}
	public double getTotalDividends() {
		return totalDividends;
	}
	public void setTotalDividends(double totalDividends) {
		this.totalDividends = totalDividends;
	}
	
	public void payDividend(double shareAmount) {
		totalDividends += totalShares * shareAmount;
		
	}
	public double Profit(double marketprice) {
		return  super.Profit(marketprice) + totalDividends ; 
	}
	public String toString() {
		return "Stock [symbol=" + symbol + ", totalShares=" + totalShares + ", totalCost=" + totalCost + "];" + " [totalDividends =" + totalDividends +"]"; 
	}
		

}
