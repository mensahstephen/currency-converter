// // import javax.swing.*;

// // import org.json.JSONObject;
// // import org.junit.runner.Request;

// // import java.awt.event.*;
// // import java.io.BufferedReader;
// // import java.io.IOException;
// // import java.io.InputStreamReader;
// // import java.net.HttpURLConnection;
// // import java.net.URL;

// // import java.io.*;
// // import okhttp3.*;

// // public class cctest implements ActionListener {

// //     static int amount = 0;
// //     static String inputCurr = " ";
// //     static String outputCurr = " ";
// //     int result = 0;

// //     // textfields made global variables;
// //     JTextField t1, t2, t3;
// //     static JTextField t4;
// //     static JLabel l4;

// //     public cctest() {

// //     }

// //     public void GUI(int amount, String inputCurr, String outputCurr) {
// //         JFrame frame = new JFrame("Currency Converter");

// //         // labels
// //         JLabel l1, l2, l3;

// //         l1 = new JLabel("Enter Amount:");
// //         l1.setBounds(200, 20, 150, 30);
// //         t1 = new JTextField(amount);
// //         t1.setBounds(175, 60, 150, 30);

// //         l2 = new JLabel("Currency From:");
// //         l2.setBounds(200, 100, 150, 30);
// //         t2 = new JTextField(inputCurr);
// //         t2.setBounds(175, 140, 150, 30);

// //         l3 = new JLabel("Currency To:");
// //         l3.setBounds(205, 180, 150, 30);
// //         t3 = new JTextField(outputCurr);
// //         t3.setBounds(175, 220, 150, 30);

// //         JButton b1 = new JButton("enter");
// //         b1.setBounds(225, 260, 50, 50);

// //         l4 = new JLabel("Converted Amount");
// //         l4.setBounds(195, 320, 150, 30);
// //         t4 = new JTextField(0);
// //         t4.setBounds(175, 360, 150, 30);

// //         JButton b2 = new JButton("exit");
// //         b2.setBounds(225, 400, 50, 50);

// //         frame.add(l1);
// //         frame.add(t1);
// //         frame.add(l2);
// //         frame.add(t2);
// //         frame.add(l3);
// //         frame.add(t3);
// //         frame.add(l4);
// //         frame.add(t4);
// //         frame.add(b1);
// //         frame.add(b2);

// //         frame.setSize(500, 500);
// //         frame.setLayout(null);
// //         frame.setVisible(true);

// //         b1.addActionListener(this);
// //         b2.addActionListener(new ActionListener() {
// //             @Override
// //             public void actionPerformed(ActionEvent e) {
// //                 System.exit(0);

// //             }
// //         });

// //     }

// //     public static void convert(int amount, String inputCurr, String outputCurr) throws IOException{
        
// //         // api key: IEDl5p6OIMOFo6RXpA4giBZlHlcLIjBp


// //     OkHttpClient client = new OkHttpClient().newBuilder().build();

// //     Request request = new Request.Builder()
// //       .url("https://api.apilayer.com/exchangerates_data/convert?to=" + outputCurr + "&from=" + inputCurr + "&amount=" + amount +")"
// //       .addHeader("apikey", "IEDl5p6OIMOFo6RXpA4giBZlHlcLIjBp")
// //       .method("GET", }).build();

// //     Response response = client.newCall(request).execute();

// //     try (Response response = client.newCall(request).execute()) {
// //         int responseCode = response.code();
// //       }

// //     if(responseCode==200)
// //     { // success
// //       // l4.setText("pass 1");

// //         // read input stream as buffered reader object
// //         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
// //         String inputLine = " ";
// //         StringBuffer response = new StringBuffer();
// //         // l4.setText("pass2");

// //         try {
// //             while ((inputLine = reader.readLine()) != null) {
// //                 response.append(inputLine);
// //             }
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             reader.close();
// //         }
// //         // l4.setText("pass3");

// //         // create JSON Object
// //         JSONObject obj = new JSONObject(response.toString());
// //         Double output = obj.getJSONObject("result").getDouble(inputCurr);
// //         t4.setText(Double.toString(output));
// //         // l4.setText("pass4");
// //     }else
// //     {
// //         System.out.println("Response Code: " + responseCode);
// //         t4.setText("GET REQUEST FAILED");
// //     }

// //     }

// //     public static void main(String[] args) {

// //         CurrencyConverter CC = new CurrencyConverter();
// //         CC.GUI(amount, inputCurr, outputCurr);
        

// //     }

// //     @Override
// //     public void actionPerformed(ActionEvent e) {
// //         amount = Integer.parseInt(t1.getText());
// //         inputCurr = t2.getText();
// //         outputCurr = t3.getText();
        
        
// //             try {
// //                 convert(amount, inputCurr, outputCurr);
// //             } catch (IOException e1) {
// //                 // TODO Auto-generated catch block
// //                 e1.printStackTrace();
// //             }
        
        
// //     }

// // }

// public static void convert(int amount, String inputCurr, String outputCurr) throws IOException{
        
//     // api key: IEDl5p6OIMOFo6RXpA4giBZlHlcLIjBp


//     URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?to=" + outputCurr+ "&from="+ inputCurr + "&amount=" + amount + "&apikey=IEDl5p6OIMOFo6RXpA4giBZlHlcLIjBp");
//     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//     connection.setRequestMethod("GET");
//     int responseCode = connection.getResponseCode();

//     if(responseCode == 200){ //success
//         //l4.setText("pass 1");

//         //read input stream as buffered reader object
//         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//         String inputLine = " ";
//         StringBuffer response = new StringBuffer();
//         //l4.setText("pass2");

//         try {
//             while ((inputLine = reader.readLine()) != null) {
//                 response.append(inputLine);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             reader.close();
//         }
//         //l4.setText("pass3");

//         //create JSON Object
//         JSONObject  obj = new JSONObject(response.toString());
//         Double output = obj.getJSONObject("result").getDouble(inputCurr);
//         t4.setText(Double.toString(output));
//        // l4.setText("pass4");
//     }else{
//         System.out.println("Response Code: " + responseCode);
//         t4.setText("GET REQUEST FAILED");
//     }
