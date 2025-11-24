public class Trade {
private String symbol;
private int quantity;
private double buyPrice;
private double sellPrice;


public Trade(String symbol, int quantity, double buyPrice, double sellPrice) {
this.symbol = symbol;
this.quantity = quantity;
this.buyPrice = buyPrice;
this.sellPrice = sellPrice;
}


public String getSymbol() { return symbol; }
public int getQuantity() { return quantity; }
public double getBuyPrice() { return buyPrice; }
public double getSellPrice() { return sellPrice; }


public double getProfitLoss() {
return (sellPrice - buyPrice) * quantity;
}
}
