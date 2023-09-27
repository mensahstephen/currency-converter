import javax.swing.*;

import org.json.JSONObject;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class CurrencyConverter implements ActionListener {

    static int amount = 0;
    static String outputCurr = " ";
    int result = 0;

    // textfields made global variables;
    JTextField t1, t2;
    static JTextField t3;
    static JLabel l3;

    public CurrencyConverter() {

    }

    public void GUI(int amount, String outputCurr) {
        JFrame frame = new JFrame("USD Converter");

        JLabel l1, l2;

        l1 = new JLabel("Amount:");
        l1.setBounds(225, 20, 150, 30);
        t1 = new JTextField(amount);
        t1.setBounds(175, 60, 150, 30);

        l2 = new JLabel("Currency To:");
        l2.setBounds(215, 100, 150, 30);
        t2 = new JTextField(outputCurr);
        t2.setBounds(175, 140, 150, 30);

        JButton b1 = new JButton("enter");
        b1.setBounds(225, 180, 50, 50);

        l3 = new JLabel("Result:");
        l3.setBounds(230, 250, 150, 30);
        t3 = new JTextField(0);
        t3.setBounds(175, 290, 150, 30);

        JButton b2 = new JButton("exit");
        b2.setBounds(225, 340, 50, 50);

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(b1);
        frame.add(l3);
        frame.add(t3);
        frame.add(b2);

        frame.setSize(500, 450);
        frame.setLayout(null);
        frame.setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public void convert(int amount, String outputCurr) throws IOException {

        URL url = new URL("https://v6.exchangerate-api.com/v6/96d540987f05f36fbdb861ca/latest/USD");
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println(response.toString());

                JSONObject jsonResponse = new JSONObject(response);
                JSONObject conversionRates = jsonResponse.getJSONObject("'conversion_rates'");
                String getCurr = conversionRates.getString(outputCurr.trim());
      
                double outputValue = Double.parseDouble(getCurr);
                double convertedAmount = amount * outputValue;

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedAmount = decimalFormat.format(convertedAmount);
                String outResponse = formattedAmount + " " + outputCurr;
                t3.setText(outResponse);

            } else {
                System.out.println("Response Code: " + responseCode);
                t3.setText("GET REQUEST FAILED");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        amount = Integer.parseInt(t1.getText());
        outputCurr = t2.getText();

        try {
            convert(amount, outputCurr);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {

        CurrencyConverter CC = new CurrencyConverter();
        CC.GUI(amount, outputCurr);

    }
}