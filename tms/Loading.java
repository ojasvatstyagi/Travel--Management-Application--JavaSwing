package tms;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
    String username;
	int s;
	Thread th;

	public static void main(String[] args) {
            new Loading("").setVisible(true);
	}

	public void setUploading() {
            setVisible(false);
            th.start();
	}

	public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        i = 201;
                        setVisible(false);
                        new Home(username).setVisible(true);
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading(String username) {
            this.username = username;
            th = new Thread((Runnable) this);

            setSize(600, 400);
            setLocationRelativeTo(null);
            contentPane = new JPanel();
            contentPane.setBackground(new Color(29, 69, 103));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel l1 = new JLabel("Travel and Toursim Application");
            l1.setForeground(new Color(29, 69, 103));
            l1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
            l1.setBounds(50, 45, 700, 35);
            contentPane.add(l1);
            
            JLabel l2 = new JLabel("Loading to Home page");
            l2.setForeground(new Color(29, 69, 103));
            l2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
            l2.setBounds(160, 90, 700, 35);
            contentPane.add(l2);
	
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true);
            progressBar.setBounds(150, 170, 300, 25);
            contentPane.add(progressBar);

            JLabel l3 = new JLabel("Please Wait....");
            l3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            l3.setForeground(new Color(160, 82, 45));
            l3.setBounds(220, 200, 150, 20);
            contentPane.add(l3);
            
        	//adding image  to frame	
            ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/load.png"));
            Image i1 = c1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i1);
            JLabel l4 = new JLabel(i2);
            l4.setBounds(250, 250, 80, 80);
            contentPane.add(l4);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(250, 243, 155));
            panel.setBounds(10, 10, 580, 380);
            contentPane.add(panel);
              
            setUndecorated(true);
            setUploading();
	}
}