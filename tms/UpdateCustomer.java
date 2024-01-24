package tms;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UpdateCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateCustomer(String username) throws SQLException {
		
		setTitle(" Update Details");
		this.setLayout(null);
		this.setVisible(true);
		setSize(800,600);
		getContentPane().setBackground(new Color(29, 69, 103));
		setLocationRelativeTo(null);
        setResizable(false);
		
        
        JPanel Panel = new JPanel();
        Panel.setBounds(20, 20, 525, 525);
        Panel.setBackground(new Color(250, 243, 155));
		Panel.setLayout(null);
		add(Panel);
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i3 = i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,70,400,400);
        add(l1);
		
        
		JLabel lblName = new JLabel("UPDATE CUSTOMER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		lblName.setForeground(new Color(29, 69, 103));
		lblName.setBounds(120, 10, 350, 50);
		Panel.add(lblName);
                
        JLabel l2 = new JLabel("Username :");
        l2.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l2.setBounds(35, 70, 200, 20);
		Panel.add(l2);
                
        JTextField t1 = new JTextField();
		t1.setBounds(250, 70, 150, 20);
		Panel.add(t1);
		t1.setColumns(10);
                
        JLabel lblId = new JLabel("ID :");
        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		lblId.setBounds(35, 110, 200, 20);
		Panel.add(lblId);
                
		JTextField t2 = new JTextField();
		t2.setBounds(250, 110, 150, 20);
		Panel.add(t2);
		t2.setColumns(10);
                
        JLabel l3 = new JLabel("ID Number :");
        l3.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l3.setBounds(35, 150, 200, 20);
		Panel.add(l3);
                
        JTextField t3 = new JTextField();
		t3.setBounds(250, 150, 150, 20);
		Panel.add(t3);
		t3.setColumns(10);
		
		JLabel l4 = new JLabel("Name :");
		l4.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l4.setBounds(35, 190, 200, 20);
		Panel.add(l4);
		
		JTextField t4 = new JTextField();
		t4.setBounds(250, 190, 150, 20);
		Panel.add(t4);
		t4.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		lblGender.setBounds(35, 230, 200, 20);
		Panel.add(lblGender);
                
        JTextField t5 = new JTextField();
		t5.setBounds(250, 230, 150, 20);
		Panel.add(t5);
		t5.setColumns(10);
                
		JLabel l5 = new JLabel("Country :");
		l5.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l5.setBounds(35, 270, 200, 20);
		Panel.add(l5);
                
        JTextField t6 = new JTextField();
		t6.setBounds(250, 270, 150, 20);
		Panel.add(t6);
		t6.setColumns(10);
		
		JLabel l6 = new JLabel("Permanent Address :");
		l6.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l6.setBounds(35, 310, 200, 20);
		Panel.add(l6);
                
        JTextField t7 = new JTextField();
		t7.setBounds(250, 310, 150, 20);
		Panel.add(t7);
		t7.setColumns(10);
           	
		JLabel l7 = new JLabel("Phone :");
		l7.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l7.setBounds(35, 350, 200, 20);
		Panel.add(l7);
                
        JTextField t8 = new JTextField();
		t8.setBounds(250, 350, 150, 20);
		Panel.add(t8);
		t8.setColumns(10);
		
		JLabel l8 = new JLabel("Email :");
		l8.setFont(new Font("Yu Mincho", Font.BOLD, 17));
		l8.setBounds(35, 390, 200, 20);
		Panel.add(l8);
		
		JTextField t9 = new JTextField();
		t9.setBounds(250, 390, 150, 20);
		Panel.add(t9);
		t9.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");		
		btnNewButton.setBounds(140, 450, 100, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
		Panel.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(270, 450, 100, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		Panel.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            setVisible(false);
			}
		}); 
		
		
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                    if(rs.next()){
                        t1.setText(rs.getString(1));  
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));  
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));  
                        t6.setText(rs.getString(6));
                        t7.setText(rs.getString(7));  
                        t8.setText(rs.getString(8));
                        t9.setText(rs.getString(9));
                    }
                }catch(Exception e){ }
		
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = t1.getText();
                                String s2 = t2.getText(); 
	    			String s3 =  t3.getText();
	    			String s4 =  t4.getText();
                                String s5 =  t5.getText();
	    			String s6 =  t6.getText();
	    			String s7 =  t7.getText(); 
                                String s8 =  t8.getText();
                                String s9 = t9.getText(); 
                                
                                String q1 = "update customer set id_type = '"+s2+"', number = '"+s3+"', name = '"+s4+"', gender = '"+s5+"', country = '"+s6+"', address = '"+s7+"', phone = '"+s8+"', email = '"+s9+"' where username = '"+s1+"'";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		
	}
}