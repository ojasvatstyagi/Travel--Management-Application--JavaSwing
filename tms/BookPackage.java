package tms;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BookPackage extends JFrame {
	
	
	private JPanel contentPane;
        JTextField t1,t2;
        Choice c1,c2,c3;
        Color color = new Color(40,96,143);
        Color colorf = new Color(250, 243, 155);
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPackage frame = new BookPackage("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookPackage(String username) {
		setSize(1100, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		getContentPane().setBackground(color);
		contentPane.setLayout(null);
		
		
		JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(550, 30, 500, 350);
        p1.setBackground(colorf);
        add(p1);
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(480, 330,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(10,10,480,330);
        p1.add(la1);
		
		JLabel lblName = new JLabel("BOOK PACKAGE");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 30));
		lblName.setForeground(colorf);
		lblName.setBounds(130, 10, 300, 50);
		contentPane.add(lblName);
                
        JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		la2.setForeground(colorf);
		la2.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(la2);
                
        JLabel l1 = new JLabel(username);
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);
                
        JLabel lblId = new JLabel("Select Package :");
		lblId.setBounds(35, 110, 200, 14);
		lblId.setForeground(colorf);
		lblId.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(lblId);
                
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.add("Normal Package");
        c1.setBounds(271, 110, 150, 30);
        add(c1);
                
        JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		la3.setForeground(colorf);
		la3.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(la3);
                
        t1 = new JTextField();
        t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 190, 200, 14);
		lbl1.setForeground(colorf);
		lbl1.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(lbl1);
                
        JLabel l2 = new JLabel();
		l2.setBounds(271, 190, 200, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 230, 200, 14);
		lbl2.setForeground(colorf);
		lbl2.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(lbl2);
                
        JLabel l3 = new JLabel();
		l3.setBounds(271, 230, 200, 14);
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 270, 200, 14);
		lbl3.setForeground(colorf);
		lbl3.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(lbl3);
                
        JLabel l4 = new JLabel();
		l4.setBounds(271, 270, 200, 14);
		contentPane.add(l4);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 310, 200, 14);
		lblDeposite.setForeground(colorf);
		lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 310, 200, 14);
        l5.setForeground(Color.RED);
		contentPane.add(l5);
                
		
		JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String p = c1.getSelectedItem();
		        int cost = 0;
		        
		        if (p.equals("Gold Package")) {
		            cost += 17000;
		        } else if (p.equals("Silver Package")) {
		            cost += 25000;
		        } else if (p.equals("Bronze Package")) {
		            cost += 32000;
		        } else if (p.equals("Normal Package")) {
		            cost += 12000;
		        }
		        
		        cost *= Integer.parseInt(t1.getText());
		        l5.setText("Rs " + cost);
		    }
		});
		
		b1.setBounds(50, 350, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        try {
		        	Conn c = new Conn();
		            String query = "INSERT INTO bookPackage VALUES (?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement pst = c.c.prepareStatement(query);
		            
		            pst.setString(1, username);
		            pst.setString(2, c1.getSelectedItem());
		            pst.setString(3, t1.getText());
		            pst.setString(4, l2.getText());
		            pst.setString(5, l3.getText());
		            pst.setString(6, l4.getText());
		            pst.setString(7, l5.getText());
		            
		            pst.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Package Booked Successfully");
		            setVisible(false);

		            pst.close();

		        } catch (Exception ee) {
		            System.out.println(ee.getMessage());
		        }
		    }
		});
		
		
		btnNewButton.setBounds(200, 350, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
                    setVisible(false);
	    	}
        }); 

        btnExit.setBounds(350, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        
	}
}