package tms;


import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewBookedHotel extends JFrame {
	

    private JPanel contentPane;
    Choice c1;
    private Color colorb = new Color(29, 69, 103);
    private Color colorf = new Color(250, 243, 155);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ViewBookedHotel frame = new ViewBookedHotel("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	public ViewBookedHotel(String username)  {
		setBounds(580, 220, 850, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(colorf);
              
		
		JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(400, 100, 400, 370);
        p1.setBackground(colorb);
        add(p1);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.png"));
        Image i3 = i1.getImage().getScaledInstance(500, 370,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(0,10,400,370);
        p1.add(la1);
        
        c1 = new Choice();
        c1.setBounds(271, 70, 150, 30);
        contentPane.add(c1);
		
		JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 25));
		lblName.setBounds(200, 11, 400, 50);
		contentPane.add(lblName);
                
                JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);
                
                JLabel l1 = new JLabel();
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);
                
                JLabel lblId = new JLabel("Name :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);
                
                JLabel lb2 = new JLabel("Number of Persons :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);
		
		JLabel lblName_1 = new JLabel("Number of Days :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

                
		JLabel lblGender = new JLabel("AC / Non-AC :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);
                
		JLabel lblCountry = new JLabel("Food Included (Yes/No) :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);
		
		JLabel lblReserveRoomNumber = new JLabel("ID :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);
           	
		JLabel lblCheckInStatus = new JLabel("Number :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                JLabel l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);

		
		JLabel lblDeposite = new JLabel("Phone :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);
                
                JLabel la2 = new JLabel("Cost :");
		la2.setBounds(35, 430, 200, 14);
		contentPane.add(la2);
		
		JLabel l10 = new JLabel();
		l10.setBounds(271, 430, 200, 14);
		contentPane.add(l10);
                
                Conn c = new Conn();
                try{
                	String query = "SELECT * FROM bookHotel WHERE username = ?";
                    PreparedStatement preparedStatement = c.c.prepareStatement(query);
                    preparedStatement.setString(1, username);

                    ResultSet rs = preparedStatement.executeQuery();
                	while (rs.next()) {
                        l1.setText(rs.getString(1));
                        l2.setText(rs.getString(2));
                        l3.setText(rs.getString(3));
                        l4.setText(rs.getString(4));
                        l5.setText(rs.getString(5));
                        l6.setText(rs.getString(6));
                        l7.setText(rs.getString(7));
                        l8.setText(rs.getString(8));
                        l9.setText(rs.getString(9));
                        l10.setText(rs.getString(10));
                        
                        
                    }

                    rs.close();
                }catch(SQLException e){
                	e.printStackTrace();                }

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(160, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusable(false);
		contentPane.add(btnExit);
                
                
	}
}