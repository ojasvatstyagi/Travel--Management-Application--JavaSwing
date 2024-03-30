package tms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Home extends JFrame {
    String username;
 
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
    
    public Home(String username) {
        super("Travel and Tourism Management System");
        this.username = username;
        setForeground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        JPanel bar = new JPanel();
        bar.setLayout(null);
        bar.setBounds(0, 0, 1600, 70);
        bar.setBackground(new Color(29, 69, 103));
        bar.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "",
        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(34, 139, 34)));
        this.add(bar);
        
        
        JLabel Name = new JLabel("Welcome  " +username);
        Name.setForeground(new Color(250, 243, 155));
        Name.setBounds(120, 2, 300, 60);
        Name.setFont(new Font("Tahoma",Font.PLAIN, 20));
        bar.add(Name);
        
        
        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setForeground( new Color(250, 243, 155));
        l1.setFont(new Font("Tahoma", Font.PLAIN, 55));
        l1.setBounds(360, 2, 1000, 60);
        bar.add(l1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image temp = i1.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(temp); 
        JLabel logoL = new JLabel(i3);
        logoL.setBounds(20, 0, 80, 80); 
        bar.add(logoL);
       
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image temp2 = i2.getImage().getScaledInstance(1310, 770,Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(temp2); 
        JLabel NewLabel = new JLabel(i4);
        NewLabel.setBounds(230, 70, 1310, 770);
        add(NewLabel);
        
         
        Dashboard dash = new Dashboard(username);
        dash.setBounds(0, 70, 230, 800);
        add(dash);
        dash.setVisible(true);
                
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

}