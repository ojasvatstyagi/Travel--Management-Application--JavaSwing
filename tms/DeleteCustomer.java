package tms;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DeleteCustomer extends JFrame {
	private JPanel contentPane;
        Choice c1;
        Color colorb = new Color(29, 69, 103);
        Color colorf = new Color(250, 243, 155);
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCustomer frame = new DeleteCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteCustomer() throws SQLException {
		setSize(850, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(colorf);
		
        JPanel Panel = new JPanel();
        Panel.setBounds(510, 70, 320, 400);
        Panel.setBackground(colorb);
		Panel.setLayout(null);
		add(Panel);
		
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(10,10,300,300);
        Panel.add(l1);
		
		JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 25));
		lblName.setBounds(250, 10, 400, 50);
		contentPane.add(lblName);
                
        JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 15);
		lb3.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lb3);
                
                c1 = new Choice();
                Conn c = new Conn();
                try{

                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("username"));
                    }

                    rs.close();
                }catch(SQLException e){}

                c1.setBounds(271, 70, 150, 30);
                add(c1);
                
        JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 15);
		lblId.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblId);
                
        JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);
                
        JLabel lb2 = new JLabel("Number :");
		lb2.setBounds(35, 150, 200, 14);
		lb2.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lb2);
                
        JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		lblGender.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblGender);
                
        JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		lblCountry.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblCountry);
                
        JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		lblReserveRoomNumber.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblReserveRoomNumber);
                
        JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		lblCheckInStatus.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblCheckInStatus);
                
        JLabel l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);

		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		lblDeposite.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		contentPane.add(lblDeposite);
		
		JLabel l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);

		
		JButton b1 = new JButton("Check");
		b1.setBounds(425, 70, 80, 22);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
		
		b1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Conn c = new Conn();
		        try {
		            String s1 = c1.getSelectedItem();
		            String query = "SELECT * FROM customer WHERE username = '" + s1 + "'";
		            ResultSet rs = c.s.executeQuery(query);

		            if (rs.next()) {
		                l2.setText(rs.getString(2));
		                l3.setText(rs.getString(3));
		                l4.setText(rs.getString(4));
		                l5.setText(rs.getString(5));
		                l6.setText(rs.getString(6));
		                l7.setText(rs.getString(7));
		                l8.setText(rs.getString(8));
		                l9.setText(rs.getString(9));
		            } else {
		                JOptionPane.showMessageDialog(null, "Customer not found!");
		            }

		            rs.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});



		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    String s1 = c1.getSelectedItem();
                    String query = "DELETE FROM customer WHERE username = '" + s1 + "'";
                    int rowsAffected = c.s.executeUpdate(query);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found or deletion failed!");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });


		
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 

                
	}
}