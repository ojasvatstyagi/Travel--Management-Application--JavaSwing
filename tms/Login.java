package tms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener {
	private JTextField t1;
	private Component passwordField;
	private JButton login,signup,forgotpass;
	
	Login(){
		
	setTitle("Login Page");
	this.setLayout(null);
	this.setVisible(true);
	setSize(750,450);
	getContentPane().setBackground(new Color(255, 255, 204));
	setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				
	JPanel p1 = new JPanel();
	p1.setBackground(new Color(255, 229, 180));
	p1.setBounds(50, 50, 640, 330);
	p1.setLayout(null);
	add(p1);
	
	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(50, 50, 150, 25);
	l1.setFont(new Font("Arial", Font.BOLD, 18));
	p1.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(50, 100, 150, 25);
	l2.setFont(new Font("Arial", Font.BOLD, 18));
	p1.add(l2);

	t1 = new JTextField();
	t1.setBounds(170, 50, 200, 25);
	p1.add(t1);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(170, 100, 200, 25);
	p1.add(passwordField);
	

    // Create a border for the panel
	p1.setForeground(new Color(34, 139, 34));
	p1.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "   Get In Fast !  ",
	TitledBorder.CENTER, TitledBorder.TOP, null, new Color(34, 139, 34)));
	p1.setLayout(null);
	
	login = new JButton("Login");
	login.addActionListener(this);                
	login.setForeground(Color.WHITE);
	login.setBackground(new Color(92, 219, 92));
	login.setBounds(70, 170, 100, 30);
	p1.add(login);
	
	
    signup = new JButton("SignUp");
	signup.addActionListener(this);	
	signup.setForeground(Color.WHITE);
	signup.setBackground(new Color(92, 219, 92));
	signup.setBounds(260, 170, 100, 30);
	p1.add(signup);

	
	forgotpass = new JButton("Forgot Password");
	forgotpass.addActionListener(this);	
    forgotpass.setForeground(Color.WHITE);
	forgotpass.setBackground(new Color(92, 219, 92));
	forgotpass.setBounds(140, 230, 150, 30);
	p1.add(forgotpass);
	
    JLabel l3 = new JLabel(" *Your information is safe with us,we will not share it with any body !");
	l3.setBounds(20, 290, 400, 25);
	p1.add(l3);
	
	
	//adding image  to frame	
    ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    Image i1 = c1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
    ImageIcon i2 = new ImageIcon(i1);
    JLabel l4 = new JLabel(i2);
    l4.setBounds(450, 85, 150, 150);
    p1.add(l4);
    
	}
	
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == login) {
	        try {
	            Conn con = new Conn();
	            String sql = "SELECT * FROM account WHERE username=? AND password=?";
	            PreparedStatement st = con.c.prepareStatement(sql);

	            st.setString(1, t1.getText());
	            st.setString(2, new String(((JPasswordField) passwordField).getPassword()));

	            ResultSet rs = st.executeQuery();
	            if (rs.next()) {
	                this.setVisible(false);
	                new Loading(t1.getText()).setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
	            }

	            st.close();
	            con.c.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    } else if (ae.getSource() == signup) {
	        setVisible(false);
	        Signup su = new Signup();
	        su.setVisible(true);
	    } else if (ae.getSource() == forgotpass) {
	        setVisible(false);
	        ForgotPassword forgot = new ForgotPassword();
	        forgot.setVisible(true);
	    }
	}

	public static void main(String[] args){
	    SwingUtilities.invokeLater(() -> {
	        new Login().setVisible(true);
	    });
	    
	}
}