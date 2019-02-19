import java.awt.*;
import javax.swing.*;

public class MyRectPanel extends JPanel{

	//data
	private MyRect rect1, rect2;
	
	//method
	// default constructor
	public MyRectPanel(){
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.white);
		
		rect1 = new MyRect();
		rect2 = new MyRect();
		
	} //MyRectPanel()	
	
	//method
	public void setRectsRandom(){
		int x, y, w, h;
		
		x = (int) (Math.random() * 300); // 0 ~ 299
		y = (int) (Math.random() * 300);
		w = (int) (Math.random() * 350); // 0 ~ 349
		h = (int) (Math.random() * 350);
		rect1.setBounds(x, y, w, h);
		
		x = (int) (Math.random() * 300); // 0 ~ 299
		y = (int) (Math.random() * 300);
		w = (int) (Math.random() * 350); // 0 ~ 349
		h = (int) (Math.random() * 350);
		rect2.setBounds(x, y, w, h);
	}	//setRectsRandom()
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		setRectsRandom();
		
		int r, g, b;
		r = (int) (Math.random() * 256);
		g = (int) (Math.random() * 256);
		b = (int) (Math.random() * 256);
		
		page.setColor(new Color(r, g, b));
		page.fillRect(rect1.getX(), rect1.getY(), rect1.getWidth(), rect1.getHeight());
		
		r = (int) (Math.random() * 256);
		g = (int) (Math.random() * 256);
		b = (int) (Math.random() * 256);
		page.setColor(new Color(r, g, b));
		page.fillRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
		
	}	//paintComponent()
	
	
}