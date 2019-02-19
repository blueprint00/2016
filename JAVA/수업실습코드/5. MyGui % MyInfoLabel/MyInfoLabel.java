import java.awt.*;
import javax.swing.*;
 
public class MyInfoLabel{
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("MY INFORMATION");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(300, 200));
		primary.setBackground(Color.yellow);
		primary.setLayout(null);	// layout manager disable
		
		Font fnt = new Font("Verdana", Font.BOLD, 20);	// fnt라는 폰트 객체 생성, 여러번 사용할 땐 이렇게
		//setFont(new~~~) 로 하면 이름 없는 무명 객체 생성, 한번만 쓸 땐 많이
		
		JLabel lblSchoolNumber, lblName;
		
		lblSchoolNumber = new JLabel("123456");
		lblSchoolNumber.setFont(fnt);
		lblSchoolNumber.setForeground(Color.red);
		lblSchoolNumber.setBounds(10, 10, 100, 30);
		primary.add(lblSchoolNumber);
 
		lblName = new JLabel("Hong, gildong");
		lblName.setFont(fnt);
		lblName.setForeground(Color.red);
		primary.add(lblName);
				
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}
}