import java.awt.*;
import javax.swing.*; // .* : ���. ����.
 
	/* GUI package
	 �ڹٿ����� ���� Ŭ���� ����
	 ���� ��ɵ��� �����ϴ� Ŭ�������� package
	 
	 AWT : (Abstract Window Toolkit)
	 Swing : ���ڰ� ��� �� ž��...
	 javax = java extend
	 */
 
public class MyApplet extends JApplet{
	
	public void paint(Graphics page) {
		
		page.setColor(Color.blue);
		page.fillRect(10, 10, 300, 200);
		
	}	//paint()
	
	
} // MyApplet class
 
 
