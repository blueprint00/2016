import java.awt.*;
import javax.swing.*;
 
/*	resolution : 400*200
 	color depth(24 true color)	*/
 
public class MyBusinessCard extends JApplet{
	
	public void paint(Graphics page){
		
		page.setColor(Color.red);	// new Color(0,0,0) <-새로운 칼라 만들어 쓸때
		page.drawRect(0, 0, 399, 199);	// resolution : 400 * 200
		
		page.setColor(Color.green);
		page.fillArc(10, 10, 40, 40, 90, 60);
		page.setColor(Color.magenta);
		page.fillArc(10, 10, 40, 40, 20, 60);
		page.setColor(Color.yellow);
		page.fillOval(18, 20, 20, 20);
		
		page.setColor(new Color(175, 90, 90));
		page.setFont(new Font("Verdana", Font.BOLD, 26)); //("폰트 이름", 폰트 타입(BOLD, ITALIC,PLAIN +로 세개 같이 써도 됨), 사이즈) 
		page.drawString("SEJONG UNIVERSITY", 60, 30);	//(String, x, y)
		
		page.setColor(Color.orange);
		page.drawLine(60, 50, 250, 50);
		
		page.setColor(Color.darkGray);
		page.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		page.drawString("Department of Computer Engineering", 60, 80);
		
		page.setColor(Color.gray);
		page.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		page.drawString("15011025", 80, 100);
		page.drawString("A-yeon Kim", 80, 120);
				
	}	// paint()
 
}	// MyBusinessCard class
 
 