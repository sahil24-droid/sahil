import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TradeTrackerUI extends JFrame {
private TradeStorage storage;
private JTable table;
private DefaultTableModel model;


private JTextField symbolField, qtyField, buyField, sellField;


public TradeTrackerUI(TradeStorage storage) {
this.storage = storage;
setTitle("Stock Trade Tracker");
setSize(600, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());


// Input panel
JPanel inputPanel = new JPanel(new GridLayout(2, 5));
symbolField = new JTextField();
qtyField = new JTextField();
buyField = new JTextField();
sellField = new JTextField();
JButton addBtn = new JButton("Add Trade");


inputPanel.add(new JLabel("Symbol"));  
inputPanel.add(new JLabel("Qty"));
inputPanel.add(new JLabel("Buy"));
inputPanel.add(new JLabel("Sell"));
inputPanel.add(new JLabel(" "));
inputPanel.add(symbolField);
inputPanel.add(qtyField);
inputPanel.add(buyField);
inputPanel.add(sellField);
inputPanel.add(addbutton);
add(inputPanel, BorderLayout.NORTH);
String[] cols = {"Symbol", "Quantity ", "Buy", "Sell", "PnL"};
model = new DefaultTableModel(cols, 0);
table = new JTable(model);
add(new JScrollPane(table), BorderLayout.CENTER);
addBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
  //try catch implementation 
try {
String sym = symbolField.getText().toUpperCase();
int qty = Integer.parseInt(qtyField.getText());
double buy = Double.parseDouble(buyField.getText());
double sell = Double.parseDouble(sellField.getText());
Trade t = new Trade(sym, qty, buy, sell);
storage.addTrade(t);
model.addRow(new Object[]{sym, qty, buy, sell, t.getProfitLoss()});
clearFields();
} catch (Exception ex) {
JOptionPane.showMessageDialog(null, "Invalid input");
}
}
});


setVisible(true);
}
private void clearFields() {
symbolField.setText("");
qtyField.setText("");
buyField.setText("");
sellField.setText("");
}
}
