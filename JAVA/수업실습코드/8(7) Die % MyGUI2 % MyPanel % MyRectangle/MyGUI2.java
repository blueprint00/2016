import java.awt.*;
import javax.swing.*;

/*
public class MyGUI2{
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("My GUI");	//frame 객체 선언&생성/이 문자열을 갖는 객체 생성
		frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //-> 정상 종료 안 될때
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(300, 200));
		primary.setBackground(Color.yellow);
		primary.setLayout(null);	// layout manager disable
		//container.setLayout(null) -> container.setBounds(x,y,w,z)로 위치 지정
		
		Font fnt = new Font("Verdana", Font.BOLD, 30);
		
		JLabel lblSchoolNumber, lblName;
		
		lblSchoolNumber = new JLabel("123456");
		lblSchoolNumber.setFont(fnt);
		lblSchoolNumber.setForeground(Color.red);
		lblSchoolNumber.setBounds(40, 40, 200, 30);	// 얘가 add 되는 container를 기준으로(x,y), w = 글자 길이, h = 글자 높이
		primary.add(lblSchoolNumber);
		
		lblName = new JLabel("Hong,gildong");
		lblName.setFont(fnt);
		lblName.setBounds(40, 70, 400, 40);
		primary.add(lblName);
		
		frame.getContentPane().add(primary);
		// frame은 운영체제가 관리하므로 허락받고(get~~) add..
		//primary로 한다면 내가 관리하므로 허락 x
		
		frame.pack();	//메모리 정리. 안해도 잘 나오긴 함
		frame.setVisible(true);
		
		
	}	// main()
}	// MyGUI2 class
*/ 


public class MyGUI2{
	
	public static void main(String[] args){	
		
		JFrame frame = new JFrame("My GUI");
		frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(430, 320));
		primary.setBackground(Color.blue);
		primary.setLayout(null);	// layout manager disable
		
		JPanel leftPanel, rightPanel;
		
		leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 200, 300);
		leftPanel.setBackground(Color.white);
		leftPanel.setLayout(null);
		primary.add(leftPanel);
		
		rightPanel = new JPanel();
		rightPanel.setBounds(220, 10, 200, 300);
		rightPanel.setBackground(Color.green);
		rightPanel.setLayout(null);
		primary.add(rightPanel);
		
		Font fnt = new Font("Verdana", Font.BOLD + Font.ITALIC, 30);
		
		ImageIcon icon = new ImageIcon("smile.jpg");
		
		JLabel lblOne, lblTwo;
		
		lblOne = new JLabel("ONE", icon, SwingConstants.CENTER);
		lblOne.setBounds(10, 10, 180, 280);
		
		lblOne.setFont(fnt);
		lblOne.setForeground(Color.green);
		//lblOne.setHorizontalAlignment(SwingConstants.CENTER);	// CENTER/RIGHT/LEFT
		//lblOne.setVerticalAlignment(SwingConstants.CENTER);		// CENTER/BOTTOM/TOP
		lblOne.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOne.setVerticalTextPosition(SwingConstants.CENTER);	// 이미지에 따라 텍스트 위치 정해주기(CENTER/BOTTOM/TOP)
		leftPanel.add(lblOne);
		
		
		lblTwo = new JLabel("TWO");
		lblTwo.setBounds(10, 10, 180, 280);
		
		lblTwo.setFont(fnt);
		lblTwo.setForeground(Color.red);
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);	// CENTER/RIGHT/LEFT
		lblTwo.setVerticalAlignment(SwingConstants.CENTER);		// CENTER/BOTTOM/TOP
		rightPanel.add(lblTwo);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}	// main()
}	// MyGUI2 class
 
 