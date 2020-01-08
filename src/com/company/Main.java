package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        JButton button = new JButton();
        button.setText("Take Image");
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        label.setText("Image Taken.");
        label.setBounds(100,20,350,110);
        frame.add(label);
        label.setVisible(false);
        button.setBounds(100,100,100,20);
        frame.setLayout(null);
        frame.add(button);
        frame.setResizable(false);
        frame.setSize(300,250);
        frame.setLocationRelativeTo(null);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // send api call here
                    String uri = "http://localhost:8080/data";
                    URL urlObj = new URL(uri);
                    HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

                    int responseCode = httpCon.getResponseCode();
                        label.setText(String.valueOf(responseCode));
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        System.out.println("Server returned response code " + responseCode);
                        System.exit(0);
                    }
                }catch (Exception ex){
                    label.setText(ex.getMessage());
                    System.out.println(ex.getMessage());
                }
                label.setVisible(true);
            }
        });
        frame.setVisible(true);
    }
}
