import java.awt.*;
import javax.swing.*; // .* : 모든. 만능.
 
	/* GUI package
	 자바에서는 모든게 클래스 단위
	 같은 기능들을 수행하는 클래스들의 package
	 
	 AWT : (Abstract Window Toolkit)
	 Swing : 예쁘고 기능 더 탑재...
	 javax = java extend
	 */
 
public class MyApplet extends JApplet{
	
	public void paint(Graphics page) {
		
		page.setColor(Color.blue);
		page.fillRect(10, 10, 300, 200);
		
	}	//paint()
	
	
} // MyApplet class
 
 
