package tms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;



public class ViewCustomers extends JFrame implements ActionListener {

	ViewCustomers(String username) {

		  	setLayout(null);
			setVisible(true);
			setSize(900,550);
			getContentPane().setBackground(new Color(29, 69, 103));
			setLocationRelativeTo(null);
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        
	        JPanel Panel = new JPanel();
	        Panel.setBounds(20, 20, 845, 475);
	        Panel.setBackground(new Color(250, 243, 155));
			Panel.setLayout(null);
			add(Panel);
	        
			
			JLabel lblName = new JLabel("View Your Details");
			lblName.setFont(new Font("Yu Mincho", Font.BOLD, 25));
			lblName.setForeground(new Color(29, 69, 103));
			lblName.setBounds(320, 10, 350, 50);
			Panel.add(lblName);
			
			
	        JLabel l1 = new JLabel("Username :");
	        l1.setFont(new Font("Yu Mincho", Font.BOLD, 17));
	        l1.setBounds(35, 70, 200, 20);
	  	    Panel.add(l1);
	  	    
	  	    JLabel l1s = new JLabel();
	        l1s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
	        l1s.setBounds(235, 70, 200, 20);
	  	    Panel.add(l1s);
	  	    
	  	    JLabel lblId = new JLabel("ID :");
	        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			lblId.setBounds(35, 110, 200, 20);
			Panel.add(lblId);
			
			JLabel lblIds = new JLabel();
	        lblIds.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			lblIds.setBounds(235, 110, 200, 20);
			Panel.add(lblIds);
			
	        JLabel l3 = new JLabel("ID Number :");
	        l3.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l3.setBounds(35, 150, 200, 20);
			Panel.add(l3);
			
			JLabel l3s = new JLabel();
	        l3s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l3s.setBounds(235, 150, 200, 20);
			Panel.add(l3s);
			
			JLabel l4 = new JLabel("Name :");
			l4.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l4.setBounds(35, 190, 200, 20);
			Panel.add(l4);
			
			JLabel l4s = new JLabel();
			l4s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l4s.setBounds(235, 190, 200, 20);
			Panel.add(l4s);
			
			JLabel lblGender = new JLabel("Gender :");
			lblGender.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			lblGender.setBounds(35, 230, 200, 20);
			Panel.add(lblGender);
			
			JLabel lblGenders = new JLabel();
			lblGenders.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			lblGenders.setBounds(235, 230, 200, 20);
			Panel.add(lblGenders);
			
			JLabel l5 = new JLabel("Country :");
			l5.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l5.setBounds(400, 70, 200, 20);
			Panel.add(l5);
			
			JLabel l5s = new JLabel();
			l5s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l5s.setBounds(600, 70, 200, 20);
			Panel.add(l5s);
			
			JLabel l6 = new JLabel("Permanent Address :");
			l6.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l6.setBounds(400, 110, 200, 20);
			Panel.add(l6);
			
			JLabel l6s = new JLabel();
			l6s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l6s.setBounds(600, 110, 200, 20);
			Panel.add(l6s);
			
			JLabel l7 = new JLabel("Phone :");
			l7.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l7.setBounds(400, 190, 200, 20);
			Panel.add(l7);
			
			JLabel l7s = new JLabel();
			l7s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l7s.setBounds(600, 190, 200, 20);
			Panel.add(l7s);
			
			JLabel l8 = new JLabel("Email :");
			l8.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l8.setBounds(400, 230, 200, 20);
			Panel.add(l8);
			
			JLabel l8s = new JLabel();
			l8s.setFont(new Font("Yu Mincho", Font.BOLD, 17));
			l8s.setBounds(600, 230, 200, 20);
			Panel.add(l8s);
			
			ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.png"));
	        Image i3 = i1.getImage().getScaledInstance(700, 200,Image.SCALE_DEFAULT);
	        ImageIcon i2 = new ImageIcon(i3);
	        JLabel image = new JLabel(i2);
	        image.setBounds(80,300,700,200);
	        Panel.add(image);
	        
	        
			JButton btnExit = new JButton("Back");
			btnExit.setBounds(350, 280, 100, 30);
			btnExit.setFocusable(false);
	        btnExit.setBackground(Color.BLACK);
	        btnExit.setForeground(Color.WHITE);
	        btnExit.addActionListener(this);
			Panel.add(btnExit);
			
			try {
			    Conn conn = new Conn();
			    String query = "select * from customer where username = '"+username+"'";

			    ResultSet rs = conn.s.executeQuery(query);
			    while (rs.next()) {
			        l1s.setText(rs.getString("username"));
			        lblIds.setText(rs.getString("id_type"));
			        l3s.setText(rs.getString("number"));
			        l4s.setText(rs.getString("name"));
			        lblGenders.setText(rs.getString("gender"));
			        l5s.setText(rs.getString("country"));
			        l6s.setText(rs.getString("address"));
			        l7s.setText(rs.getString("phone"));  // Corrected column name
			        l8s.setText(rs.getString("email"));  // Corrected column name
			    }

			    rs.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}

	  }
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}
	  public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ViewCustomers frame = new ViewCustomers("");
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

  }