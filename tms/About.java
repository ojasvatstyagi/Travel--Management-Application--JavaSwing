package tms;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class About extends JFrame implements ActionListener {

	public About() {
    	
		this.setLayout(null);
		this.setVisible(true);
		setSize(750,500);
		getContentPane().setBackground(new Color(250, 243, 155));
		setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JLabel l1 = new JLabel("About Project");
        l1.setBounds(280, 10, 210, 50);
        l1.setForeground(new Color(29, 69, 103));
        l1.setFont(new Font("RALEWAY", Font.BOLD, 30));
        add(l1);
        
        
        JButton b1 = new JButton("Exit");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b1.setForeground(new Color(29, 69, 103));
        b1.setBounds(330, 400, 100, 30);
        b1.addActionListener(this);
        add(b1);

       String  s = " \t\t\t\t\tProjects Details\t\t\t\t\t\n"
                + "\n  The objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "  This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "  Advantages of Project:"
                + "\n  Gives accurate information"
                + "\n  Simplifies the manual work"
                + "\n  It minimizes the documentation related work"
                + "\n  Provides up to date information"
                + "\n  Friendly Environment by providing warning messages."
                + "\n  travelers details can be provided"
                + "\n  booking confirmation notification"
                ;

        TextArea t1 = new TextArea(s,10,10, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(70, 80, 600, 300);
        t1.setFont(new Font("RALEWAY", Font.BOLD, 16));
        t1.setBackground(new Color(255, 255, 204));
        t1.setForeground(Color.black);
        add(t1);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }

}
