import jdk.internal.icu.text.UnicodeSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindow extends JFrame {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("localization.translation");
    private final JTextField fieldAmount;
    private final ArrayList<Currency> currencies = Currency.init();

    // Create the mainWindow frame
    public MainWindow(JTextField fieldAmount) {
        this.fieldAmount = fieldAmount;
        // ... (unchanged code)

        // Button "Convert"
        JButton btnConvert = new JButton(BUNDLE.getString("MainWindow.btnConvert.text"));
        btnConvert.setBounds(147, 142, 129, 38);
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                performConversion();
            }
        });
        UnicodeSet contentPane;
        contentPane.add(btnConvert);
    }

    private void performConversion() {
        String nameCurrency1 = comboBoxCountry1.getSelectedItem().toString();
        String nameCurrency2 = comboBoxCountry2.getSelectedItem().toString();
        String result;
        String formattedPrice;
        String formattedAmount;
        Double price;
        Double amount = 0.0;
        DecimalFormat format = new DecimalFormat("#0.00");

        try {
            amount = Double.parseDouble(fieldAmount.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            showErrorDialog("Invalid Input");
            amount = 0.0;
        }

        price = CurrencyConverter.convert(amount, currencies, nameCurrency1, nameCurrency2);

        formattedPrice = format.format(price);
        formattedAmount = format.format(amount);

        result = formattedAmount + " " + nameCurrency1 + " = " + formattedPrice + " " + nameCurrency2;
        lblResult.setText(result);
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(MainWindow.this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ... (unchanged code)
}
