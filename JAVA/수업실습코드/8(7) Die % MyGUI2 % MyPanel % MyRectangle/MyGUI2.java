import java.awt.*;
import javax.swing.*;

/*
public class MyGUI2{
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("My GUI");	//frame ��ü ����&����/�� ���ڿ��� ���� ��ü ����
		frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //-> ���� ���� �� �ɶ�
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(300, 200));
		primary.setBackground(Color.yellow);
		primary.setLayout(null);	// layout manager disable
		//container.setLayout(null) -> container.setBounds(x,y,w,z)�� ��ġ ����
		
		Font fnt = new Font("Verdana", Font.BOLD, 30);
		
		JLabel lblSchoolNumber, lblName;
		
		lblSchoolNumber = new JLabel("123456");
		lblSchoolNumber.setFont(fnt);
		lblSchoolNumber.setForeground(Color.red);
		lblSchoolNumber.setBounds(40, 40, 200, 30);	// �갡 add �Ǵ� container�� ��������(x,y), w = ���� ����, h = ���� ����
		primary.add(lblSchoolNumber);
		
		lblName = new JLabel("Hong,gildong");
		lblName.setFont(fnt);
		lblName.setBounds(40, 70, 400, 40);
		primary.add(lblName);
		
		frame.getContentPane().add(primary);
		// frame�� �ü���� �����ϹǷ� ����ް�(get~~) add..
		//primary�� �Ѵٸ� ���� �����ϹǷ� ��� x
		
		frame.pack();	//�޸� ����. ���ص� �� ������ ��
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
		lblOne.setVerticalTextPosition(SwingConstants.CENTER);	// �̹����� ���� �ؽ�Ʈ ��ġ �����ֱ�(CENTER/BOTTOM/TOP)
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
 
 