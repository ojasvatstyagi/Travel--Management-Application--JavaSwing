package tms;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BookHotel extends JFrame {
	
	    JTextField t1,t2;
        Choice c1,c2,c3;
        Color color = new Color(40,96,143);
        Color colorf = new Color(250, 243, 155);
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookHotel frame = new BookHotel("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookHotel(String username) {
        
    
		setSize(1100,600);
		getContentPane().setBackground(colorf);
		setLocationRelativeTo(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(650,100,410,300);
        add(la1);
		
                
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20, 20, 600, 520);
        p1.setBackground(color);
        add(p1);
        
        
		JLabel lblName = new JLabel("BOOK HOTEL");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 30));
		lblName.setBounds(200, 10, 300, 50);
		lblName.setForeground(colorf);
		p1.add(lblName);
                
        JLabel la2 = new JLabel("Username :");
        la2.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        la2.setForeground(colorf);
		la2.setBounds(35, 70, 200, 14);
		p1.add(la2);
                
        JLabel l1 = new JLabel(username);
		l1.setBounds(271, 70, 200, 14);
		p1.add(l1);
                
        JLabel lblId = new JLabel("Select Hotel :");
		lblId.setBounds(35, 110, 200, 14);
		lblId.setForeground(colorf);
		lblId.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(lblId);
                
        c1 = new Choice();
        c1.setBounds(271, 110, 150, 30);
        p1.add(c1);
        
                
                try{
                	Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotels");
                    while(rs.next()){
                        c1.add(rs.getString("name"));
                    }

                    rs.close();
                }catch(SQLException e){} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}

                
        JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		la3.setForeground(colorf);
		la3.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(la3);
                
        t1 = new JTextField();
        t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		p1.add(t1);
		t1.setColumns(10);
                
        JLabel la4 = new JLabel("Number of Days");
        la4.setBounds(35, 190, 200, 14);
        la4.setForeground(colorf);
        la4.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(la4);
		
		t2 = new JTextField();
		t2.setText("0");
		t2.setBounds(271, 190, 150, 20);
		p1.add(t2);
		t2.setColumns(10);
		
		JLabel la5 = new JLabel("AC / Non-AC");
		la5.setBounds(35, 230, 200, 14);
		la5.setForeground(colorf);
		la5.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(la5);
                
        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(271, 230, 150, 30);
        p1.add(c2);

                
		JLabel la6 = new JLabel("Food Included :");
		la6.setBounds(35, 270, 200, 14);
		la6.setForeground(colorf);
		la6.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(la6);
                
        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(271, 270, 150, 30);
        p1.add(c3);
                
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 310, 200, 14);
		lbl1.setForeground(colorf);
		lbl1.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(lbl1);
                
        JLabel l2 = new JLabel();
		l2.setBounds(271, 310, 200, 14);
		p1.add(l2);
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 350, 200, 14);
		lbl2.setForeground(colorf);
		lbl2.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(lbl2);
                
        JLabel l3 = new JLabel();
		l3.setBounds(271, 350, 200, 14);
		p1.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 390, 200, 14);
		lbl3.setForeground(colorf);
		lbl3.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(lbl3);
                
        JLabel l4 = new JLabel();
		l4.setBounds(271, 390, 200, 14);
		p1.add(l4);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 430, 200, 14);
		lblDeposite.setForeground(colorf);
		lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		p1.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 430, 200, 14);
        l5.setForeground(Color.RED);
		p1.add(l5);
                
		try {
            // Fetch customer details using PreparedStatement
            Conn c = new Conn();
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                l2.setText(rs.getString("id_type"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            System.out.println("Error fetching customer details: " + e.getMessage());
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

	   JButton b1 = new JButton("Check Price");
       b1.setBounds(50, 470, 120, 30);
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
	   p1.add(b1);

		b1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        try {
		        	Conn c = new Conn();
		            String query = "SELECT * FROM hotels WHERE name = ?";
		            PreparedStatement pst = c.c.prepareStatement(query);
		            pst.setString(1, c1.getSelectedItem());
		            
		            ResultSet rs = pst.executeQuery();
		            
		            if (rs.next()) {
		                int cost = Integer.parseInt(rs.getString("cost_per_day"));
		                int food = Integer.parseInt(rs.getString("food_charges"));
		                int ac = Integer.parseInt(rs.getString("ac_charges"));
		                
		                int persons = Integer.parseInt(t1.getText());
		                int days = Integer.parseInt(t2.getText());
		                
		                String acprice = c2.getSelectedItem();
		                String foodprice = c3.getSelectedItem();
		                
		                if (persons * days > 0) {
		                    int total = 0;
		                    total += acprice.equals("AC") ? ac : 1;
		                    total += foodprice.equals("Yes") ? food : 1;
		                    total += cost;
		                    total = total * persons * days;
		                    l5.setText("Rs " + total);
		                }
		            }
		            
		            rs.close();
		            pst.close();

		        } catch (Exception ee) {
		            System.out.println(ee.getMessage());
		        }
		    }
		});

		

		JButton btnNewButton = new JButton("Book");		
		btnNewButton.setBounds(200, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
		p1.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        try {
		        	Conn c = new Conn();
		            String query = "INSERT INTO bookHotel VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement pst = c.c.prepareStatement(query);
		            
		            pst.setString(1, l1.getText());
		            pst.setString(2, c1.getSelectedItem());
		            pst.setString(3, t1.getText());
		            pst.setString(4, t2.getText());
		            pst.setString(5, c2.getSelectedItem());
		            pst.setString(6, c3.getSelectedItem());
		            pst.setString(7, l2.getText());
		            pst.setString(8, l3.getText());
		            pst.setString(9, l4.getText());
		            pst.setString(10, l5.getText());
		            
		            pst.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
		            setVisible(false);

		            pst.close();

		        } catch (Exception ee) {
		            System.out.println(ee.getMessage());
		        }
		    }
		});

		
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(350, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		p1.add(btnExit);
		
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
                
         
	}
}