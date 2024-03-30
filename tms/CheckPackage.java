package tms;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame{
    public static void main(String[] args) {
      new CheckPackage().setVisible(true);
    }
    Color color = new Color(40,96,143);

    CheckPackage() {    
      setBounds(550, 220, 900, 600);  
      setVisible(true);
      String[] package1 = new String[]{"package1.jpg","BRONZE PACKAGE","3 days and 2 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "Book Now", "Summer Special", "Rs 17000 only"};
      String[] package2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "Book Now", "Winter Special", "Rs 25000 only"};
      String[] package3 = new String[]{"package3.jpg","GOLD PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "Book Now", "Winter Special", "Rs 32000 only"};
      String[] package4 = new String[]{"package3.jpg","NORMAL PACKAGE","5 days and 4 Nights", "Airport vehiclle booking only", "10% off on Clubbing, other Games", "Welcome drinks on Arrival", " 10% 0n Daily Buffet", "Stay in 3 Star Hotel", "Dinner", "Book Now", "Summer Special", "Rs 12000 only"};
      
      
      JTabbedPane tabbedPane = new JTabbedPane();
      JPanel p1 = createPackage(package1);
      tabbedPane.addTab("Package 1", null, p1);
      
      JPanel p2 = createPackage(package2);
      tabbedPane.addTab("Package 2", null, p2);
      
      JPanel p3 = createPackage(package3);
      tabbedPane.addTab("Package 3", null, p3);
      
      JPanel p4 = createPackage(package4);
      tabbedPane.addTab("Package 4", null, p4);
      
      add(tabbedPane, BorderLayout.CENTER);    
   }
    
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(250, 243, 155));
      
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i3 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450,30,400,400);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 30));
        lblName.setBounds(300, 10, 300, 50);
        p1.add(lblName);

        JLabel l3 = new JLabel(pack[2]);
        l3.setForeground(color);
        l3.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        l3.setBounds(35, 100, 400, 20);
        p1.add(l3);

        JLabel lblId = new JLabel(pack[3]);
        lblId.setForeground(color);
        lblId.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblId.setBounds(35, 140, 400, 20);
        p1.add(lblId);

        JLabel l2 = new JLabel(pack[4]);
        l2.setForeground(color);
        l2.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        l2.setBounds(35, 180, 400, 20);
        p1.add(l2);

        JLabel lblName_1 = new JLabel(pack[5]);
        lblName_1.setForeground(color);
        lblName_1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName_1.setBounds(35, 220, 400, 20);
        p1.add(lblName_1);

        JLabel lblGender = new JLabel(pack[6]);
        lblGender.setForeground(color);
        lblGender.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblGender.setBounds(35, 260, 400, 20);
        p1.add(lblGender);

        JLabel lblCountry = new JLabel(pack[7]);
        lblCountry.setForeground(color);
        lblCountry.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblCountry.setBounds(35, 300, 400, 20);
        p1.add(lblCountry);

        JLabel RoomNumber = new JLabel(pack[8]);
        RoomNumber.setForeground(color);
        RoomNumber.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        RoomNumber.setBounds(35, 340, 400, 20);
        p1.add(RoomNumber);

        
        JPanel Panel = new JPanel();
        Panel.setBounds(20, 420, 840, 100);
        Panel.setBackground(new Color(29, 69, 103));
		Panel.setLayout(null);
		p1.add(Panel);
		
        JLabel lblCheckInStatus = new JLabel(pack[9]);
        lblCheckInStatus.setForeground(new Color(250, 243, 155));
        lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblCheckInStatus.setBounds(50, 30, 350, 40);
        Panel.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel(pack[10]);
		lblDeposite.setForeground(new Color(250, 243, 155));
        lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblDeposite.setBounds(300, 30, 350, 40);
        Panel.add(lblDeposite);
        
        JLabel la1 = new JLabel(pack[11]);
        la1.setForeground(new Color(250, 243, 155));
        la1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        la1.setBounds(600, 30, 350, 40);
        Panel.add(la1);
        
        return p1;
    }
}
