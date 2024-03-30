package tms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Splash extends JFrame implements Runnable {
	
	Splash(){
		
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l1 = new JLabel(i2);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }
	
	Thread t1;
    public void run(){
    try{
        Thread.sleep(5000);
        this.setVisible(false);
        
        SwingUtilities.invokeLater(() -> {
	        new Login().setVisible(true);
	    });
        
    }catch(Exception e){
        e.printStackTrace();
    }
}

    public static void main(String[] args){
    	
        Splash f1 = new Splash();
        f1.setVisible(true);
        int i;
        int x=1;
        for (i = 2; i <= 600; i += 10, x += 7){
            f1.setLocation(750 - ((i+x)/2), 450 - (i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
        
    }
}
