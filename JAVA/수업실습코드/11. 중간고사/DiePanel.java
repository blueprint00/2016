import java.awt.*;
import javax.swing.*;

public class DiePanel extends JPanel{
	
	private DieLabel die1, die2;
	
	public DiePanel(){
		setPreferredSize(new Dimension(600, 200));
		setBackground(Color.white);
		setLayout(null);
		
		die1 = new DieLabel();
		die1.roll();
		die1.setSizeWidth(10, 10, 280, 280);
		add(die1);
		
		die2 = new DieLabel();
		die2.roll();
		die2.setX(310);
		die2.setY(10);
		die2.setSize(280, 280);
		die2.setBounds(die2.getX(), die2.getY(), die2.getWidth(), die2.getHeight());	
		add(die2);
	
	}
	
}