package tms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JPanel {

    String username;

    public Dashboard(String username) {
        this.username = username;

        setLayout(null);
        setBounds(0, 70, 230, 800);
        setBackground(new Color(29, 69, 103));

        JLabel menuLabel = new JLabel("Dashboard");
        menuLabel.setForeground(new Color(250, 243, 155));
        menuLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        menuLabel.setBounds(35, 10, 200, 50);
        add(menuLabel);

        JButton addDetails = createButton("Add Personal Details", 70);
        JButton upDetails = createButton("Update Details", 120);
        JButton viewDetails = createButton("View Personal Details", 170);
        JButton deDetails = createButton("Delete Details", 220);
        JButton checkpack = createButton("Check Packages", 270);
        JButton bookpack = createButton("Book Package", 320);
        JButton viewpack = createButton("View Package", 370);
        JButton checkhotel = createButton("Check Hotels", 420);
        JButton bookhotel = createButton("Book Hotel", 470);
        JButton viewhotel = createButton("View Hotel", 520);
        JButton des = createButton("Destination Vlog", 570);
        JButton pay = createButton("Do Payment", 620);
        JButton cal = createButton("Do Calculation", 670);
        JButton about = createButton("Know About Us", 720);

        add(addDetails);
        add(upDetails);
        add(viewDetails);
        add(deDetails);
        add(checkpack);
        add(bookpack);
        add(viewpack);
        add(checkhotel);
        add(bookhotel);
        add(viewhotel);
        add(des);
        add(pay);
        add(cal);
        add(about);

        addDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddCustomer(username).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Add ActionListener for other buttons...
        upDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new UpdateCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
        });
        
        viewDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewCustomers(username).setVisible(true);
                }catch(Exception e ){}
            }
        });
        
        deDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteCustomer().setVisible(true);
                }catch(Exception e ){}
            }
        });
        
        checkpack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckPackage().setVisible(true);
                }catch(Exception e ){}
            }
        });
        

        bookpack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new BookPackage(username).setVisible(true);
                }catch(Exception e ){}
            }
        });
        

        viewpack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewPackage(username).setVisible(true);
                }catch(Exception e ){}
                
            }
        });        
        
        bookhotel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BookHotel(username).setVisible(true);
            }
        });
                
        checkhotel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckHotels().setVisible(true);
                }catch(Exception e ){}
            }
        });
        
        viewhotel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewBookedHotel(username).setVisible(true);
                }catch(Exception e ){}
            }
        });
        
        des.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Destination().setVisible(true);
            }
        });
        
        pay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Payment().setVisible(true);
            }
        });
        
        
        cal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
        });
       
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new About().setVisible(true);
            }
        });
        
    }

    private JButton createButton(String label, int yPosition) {
        JButton button = new JButton(label);
        button.setBackground(new Color(29, 69, 103));
        button.setForeground(new Color(250, 243, 155));
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setBounds(0, yPosition, 230, 50);
        button.setMargin(new Insets(0, 0, 0, 10));
        button.setFocusable(false);
        return button;
    }

    public static void main(String[] args) {
        Dashboard dash = new Dashboard("");
        dash.setVisible(true);
    }
}
