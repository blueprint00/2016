import java.awt.*;
import javax.swing.*;

public class MyPanelTest{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("User Defined");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel my = new MyPanel();
		my.setBackground(Color.yellow);
		my.setPreferredSize(new Dimension(300, 300));
		
		frame.getContentPane().add(my);
		frame.pack();
		frame.setVisible(true);	
	}

}

//사용자 정의 패널만 잘 만들어놓으면 frame이나 applet에서 다 실행 가능