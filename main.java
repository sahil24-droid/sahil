public class Main {
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
TradeStorage storage = new TradeStorage();
new TradeTrackerUI(storage);
});
}
}
