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
		
		Font fnt = new Font("Verdana", Font.BOLD, 20);	// fnt��� ��Ʈ ��ü ����, ������ ����� �� �̷���
		//setFont(new~~~) �� �ϸ� �̸� ���� ���� ��ü ����, �ѹ��� �� �� ����
		
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