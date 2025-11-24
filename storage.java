import java.util.*;


public class TradeStorage {
private List<Trade> trades = new ArrayList<>();


public void addTrade(Trade t) {
trades.add(t);
}


public List<Trade> getTrades() {
return trades;
}
}
