package tms;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;

        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddCustomer(String username) throws SQLException {
		
		setTitle(" Personal Details");
		this.setLayout(null);
		this.setVisible(true);
		setSize(800,600);
		getContentPane().setBackground(new Color(29, 69, 103));
		setLocationRelativeTo(null);
        setResizable(false);
		
        
        JPanel Panel = new JPanel();
        Panel.setBounds(20, 20, 745, 525);
        Panel.setBackground(new Color(250, 243, 155));
		Panel.setLayout(null);
		add(Panel);
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450,50,300,400);
        Panel.add(l1);
		
        
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 25));
		lblName.setForeground(new Color(29, 69, 103));
		lblName.setBounds(230, 10, 350, 50);
		Panel.add(lblName);
                
        JLabel l2 = new JLabel("Username :");
        l2.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l2.setBounds(35, 70, 200, 20);
		Panel.add(l2);
                
        JTextField t7 = new JTextField();
		t7.setBounds(250, 70, 150, 20);
		Panel.add(t7);
		t7.setColumns(10);
                
        JLabel lblId = new JLabel("ID :");
        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		lblId.setBounds(35, 110, 200, 20);
		Panel.add(lblId);
                
        JComboBox comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(250, 110, 150, 20);
		Panel.add(comboBox);
                
        JLabel l3 = new JLabel("ID Number :");
        l3.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l3.setBounds(35, 150, 200, 20);
		Panel.add(l3);
                
        JTextField t1 = new JTextField();
		t1.setBounds(250, 150, 150, 20);
		Panel.add(t1);
		t1.setColumns(10);
		
		JLabel l4 = new JLabel("Name :");
		l4.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l4.setBounds(35, 190, 200, 20);
		Panel.add(l4);
		
		JTextField t2 = new JTextField();
		t2.setBounds(250, 190, 150, 20);
		Panel.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		lblGender.setBounds(35, 230, 200, 20);
		Panel.add(lblGender);
                
        JTextField t9 = new JTextField();
		t9.setBounds(250, 230, 150, 20);
		Panel.add(t9);
		t9.setColumns(10);
                
		JLabel l5 = new JLabel("Country :");
		l5.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l5.setBounds(35, 270, 200, 20);
		Panel.add(l5);
                
        JTextField t3 = new JTextField();
		t3.setBounds(250, 270, 150, 20);
		Panel.add(t3);
		t3.setColumns(10);
		
		JLabel l6 = new JLabel("Permanent Address :");
		l6.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l6.setBounds(35, 310, 200, 20);
		Panel.add(l6);
                
        JTextField t5 = new JTextField();
		t5.setBounds(250, 310, 150, 20);
		Panel.add(t5);
		t5.setColumns(10);
           	
		JLabel l7 = new JLabel("Phone :");
		l7.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l7.setBounds(35, 350, 200, 20);
		Panel.add(l7);
                
        JTextField t6 = new JTextField();
		t6.setBounds(250, 350, 150, 20);
		Panel.add(t6);
		t6.setColumns(10);
		
		JLabel l8 = new JLabel("Email :");
		l8.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l8.setBounds(35, 390, 200, 20);
		Panel.add(l8);
		
		JTextField t8 = new JTextField();
		t8.setBounds(250, 390, 150, 20);
		Panel.add(t8);
		t8.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");		
		btnNewButton.setBounds(200, 450, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
		Panel.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(400, 450, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		Panel.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        setVisible(false);
		    }
		}); 

		try {
		    Conn c = new Conn();
		    String query = "SELECT * FROM account WHERE username = ?";
		    PreparedStatement pst = c.c.prepareStatement(query);
		    pst.setString(1, username);

		    ResultSet rs = pst.executeQuery();

		    while (rs.next()) {
		        t7.setText(rs.getString("username"));  
		        t2.setText(rs.getString("name"));
		    }

		    rs.close();
		    pst.close();
		    c.c.close();

		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "INSERT INTO customer (username, id_type, id_number, name, gender, country, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pst = c.c.prepareStatement(query);
                    pst.setString(1, t7.getText());  // username
                    pst.setString(2, (String) comboBox.getSelectedItem());  // id_type
                    pst.setString(3, t1.getText());  // id_number
                    pst.setString(4, t2.getText());  // name
                    pst.setString(5, t9.getText());  // gender
                    pst.setString(6, t3.getText());  // country
                    pst.setString(7, t5.getText());  // address
                    pst.setString(8, t6.getText());  // phone
                    pst.setString(9, t8.getText());  // email

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                    setVisible(false);
                    pst.close();
                    c.c.close();
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                } catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}