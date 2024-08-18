package stocks;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
    	ArrayList <Stock> stocks = new ArrayList<>(3);
    		
    	File myFile = new File("transactions.txt");
	    try (Scanner scan = new Scanner(myFile)) {
				
				Stock object = new Stock("");
				String symbol = null;
				String next = scan.next();
				
				while(!next.equals("****")) {
					if(next.equals("N")) {
						symbol = scan.next();
						object = new Stock(symbol);
						stocks.add(object);
						next=scan.next();
					}else if(next.equals("D")) {
						symbol = scan.next();
						object = new DividendStock(symbol);
						stocks.add(object);
						next = scan.next();
					}
			    	System.out.println("Created new stock object for " + object.getSymbol()  );	
				}
				System.out.println("############################################################");
				
				while(scan.hasNext()) {	
					String line = scan.next();
			    	if(line.equals("buy")) {
			    		String sym = scan.next();
				    	int amt = Integer.parseInt(scan.next());
				    	double price = Double.parseDouble(scan.next());
			    		
				    	for(Stock stock : stocks) {
			    			if(stock.getSymbol().equals(sym)) {
			    				stock.BuyShares(amt, price);
			    			}
			    		}
			    		System.out.println("Bought " + amt + " " + sym + " Stocks at " + price );
					}
			    	if(line.equals("sell")) {
			    		String sym = scan.next();
				    	int amt = Integer.parseInt(scan.next());
				    	double price = Double.parseDouble(scan.next());
				    	int index = 0;
			    		int RemainingStock = 0;
				    	
			    		for(int i = 0 ; i< stocks.size(); i++ ) {
			    			if(stocks.get(i).getSymbol().equals(sym)) {
			    				stocks.get(i).sellShares(amt, price);
			    				index = i;
			    				RemainingStock = stocks.get(i).getTotalShares();
			    			}
			    		}
			    		System.out.println("Sold " + amt + " " + sym + " Stocks at R" + price + " per share");
			    		System.out.println("Profit if remaining " + RemainingStock + " " + sym +" stocks are sold at price R"+ price + " per share: " + "R"+ stocks.get(index).Profit(price)  );
					}
			    	if(line.equals("div")) {
			    		String sym = scan.next();
				    	double price = Double.parseDouble(scan.next());
			    		for(int i = 0 ; i< stocks.size(); i++ ) {
			    			if((stocks.get(i).getSymbol()).equals(sym)) {
			    				DividendStock divStock = (DividendStock)stocks.get(i);
			    				divStock.payDividend(price);
			    				
			    			}
			    		}
			    		System.out.println("Paid " + sym + " dividends at R" + price + " per share");
			    		
			    	}
			    	
				}
		} catch (NumberFormatException e) {
			//Try and catch block
			e.printStackTrace();
		}
	    System.out.println("############################################################");
	    	
	    	System.out.println("FINAL DETAILS OF STOCK:");
	    	double totaldividends = calcTotalDividends(stocks);
	    	for(Stock s : stocks) {
	    		System.out.println(s.toString());
	    	}  	
	    	System.out.println("Total Dividends Recieved : " + "R" +totaldividends);
    }
    
	public static int findStockIndex(String symbol, ArrayList<Stock> stocks) {
	    for (int i = 0; i < stocks.size(); i++) {
	        if (stocks.get(i).getSymbol().equals(symbol)) {
	            return i; // Return the index if the symbol matches
	        }
	    }
	    return -1;
	}
	public static double calcTotalDividends(ArrayList<Stock> stocks) {
		double sum = 0.0;	
		for (Stock s : stocks) {
				if(s instanceof DividendStock) {
					DividendStock divStock = (DividendStock) s ;
					sum += divStock.getTotalDividends();
				}
		}return sum; //returns the totalDividends
	} 	
}
