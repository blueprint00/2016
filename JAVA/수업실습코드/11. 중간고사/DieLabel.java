import java.awt.*;
import javax.swing.*;

public class DieLabel extends JLabel{
		
	private int faceValue;
	private Point pt;
	private int width, height;
	
	public DieLabel(){
		faceValue = 1;
		pt = new Point();
		width = height = 10;
	}		
	public DieLabel(int value){
		faceValue = (value < 1) ? 1 : value;
		faceValue = (faceValue > 6) ? 6 : faceValue;
				
		pt = new Point();
		width = height = 10;
	}	
	public DieLabel(Point pt){
		faceValue = 1;
		this.pt = pt;
		width = height = 10;
	}	
	public DieLabel(int w, int h){
		faceValue = 1;
		pt = new Point();
		width = (w < 10) ? 10 : w;
		height = (h < 10) ? 10 : h;
	}	
	public DieLabel(int value, Point pt){
		faceValue = (value < 1) ? 1 : value;
		faceValue = (faceValue > 6) ? 6 : faceValue;
		this.pt = pt;
		width = height = 10;
	}	
	public DieLabel(int value, Point pt, int w, int h){
		faceValue = (value < 1) ? 1 : value;
		faceValue = (faceValue > 6) ? 6 : faceValue;
		this.pt = pt;
		width = (w < 10) ? 10 : w;
		height = (h < 10) ? 10 : h;
	}
	
	public int getFaceValue()	{return faceValue;}
	public Point getPoint()		{return pt;}
	public int getWidth()	{return width;}
	public int getHeight()	{return height;}
	public int getX()	{return pt.x;}
	public int getY()	{return pt.y;}
	public void setFaceValue (int value){
		faceValue = (value < 1) ? 1 : value;
		faceValue = (faceValue > 6) ? 6 : faceValue;
	}
	public void setPoint(Point pt)	{this.pt = pt;}
	public void setWidht(int w)		{ width = (w < 10) ? 10 : w;}
	public void setHeight(int h)	{ height = (h < 10) ? 10 : h;}
	
	public void setSize(int w, int h){
		width = (w < 10) ? 10 : w;
		height = (h < 10) ? 10 : h;
	}
	public void setAll(int value, int x, int y, int w, int h){
		faceValue = (value < 1) ? 1 : value;
		faceValue = (faceValue > 6) ? 6 : faceValue;
		pt.x = x;
		pt.y = y;
		width = (w < 10) ? 10 : w;
		height = (h < 10) ? 10 : h;
	}
	public void setX(int x)	{pt.x = x;}
	public void setY(int y)	{pt.y = y;}

	public void roll() {
		faceValue = (int) (Math.random() * 6 + 1);
	}
	public void setSizeWidth(int x, int y, int w, int h) {
		pt.x = x;
		pt.y = y;
		width = (w < 10) ? 10 : w;
		height = (h < 10) ? 10 : h;
		
		setBounds(pt.x, pt.y, width, height);
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		int r, g, b;
		
		r = (int)(Math.random() * 256);
		g = (int)(Math.random() * 256);
		b = (int)(Math.random() * 256);
		page.setColor(new Color(r, g, b));
		page.fillRect(0, 0, width, height);
		
		r = (int)(Math.random() * 256);
		g = (int)(Math.random() * 256);
		b = (int)(Math.random() * 256);		
		page.setColor(new Color(r, g, b));
		page.drawRect(10, 10, width - 21, height - 21);
	
	
		r = (int)(Math.random() * 256);
		g = (int)(Math.random() * 256);
		b = (int)(Math.random() * 256);
		page.setColor(new Color(r, g, b));
		page.setFont(new Font("Verdana", Font.BOLD, width/2));
		page.drawString("" + faceValue, 40, height/2);
		
	}

}