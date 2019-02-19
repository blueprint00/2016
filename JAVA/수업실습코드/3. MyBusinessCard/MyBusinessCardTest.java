import java.awt.*;
import javax.swing.*;

public class MyBusinessCardTest{
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("MyBusinessCard Example");
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyBusinessCard primary = new MyBusinessCard();	
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}		
	
}