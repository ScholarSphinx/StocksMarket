package stocks;
public class Stock {
	/** the stock symbol*/
	protected String symbol;
	
	/** total number of shares of the stock*/
	protected int totalShares;
	
	/** the total cost of this stock */
	protected double totalCost;

	
	/**
	 * @param symbol
	 */
	public Stock (String symbol) {
		this.symbol = symbol;
		totalShares = 0;
		totalCost = 0.0;
	}
	
	/**
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}


	/**
	 * @return totalShares
	 */
	public int getTotalShares() {
		return totalShares;
	}


	/**
	 * @return total cost
	 */
	public double getTotalCost() {
		return totalCost;
	}
	
	public void BuyShares(int Shares , double Cost) {
		totalShares += Shares;
		totalCost += Cost*Shares;;

	}
	public void sellShares (int Shares , double Cost) {
		totalShares -= Shares;
		totalCost -= Shares * Cost;
		
	}
	public double Profit(double marketPrice) {
		return (marketPrice * totalShares) - totalCost;

	}
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", totalShares=" + totalShares + ", totalCost=" + totalCost + "]";
	}
	
}
