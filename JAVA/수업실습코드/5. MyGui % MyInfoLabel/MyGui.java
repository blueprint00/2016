import java.awt.*;
import javax.swing.*;
 
public class MyGui {
 
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("My Gui");	// frame ��ü �����ϰ� ����/�� ���ڿ��� ���� ��ü ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //-> ���� ���� �� �ɶ�
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(400, 200));
		primary.setBackground(Color.cyan);
		
		frame.getContentPane().add(primary);	// frame�� �ü���� �����ϹǷ� ����ް�(get~~) add..
		//primary�� �Ѵٸ� ���� �����ϹǷ� ��� x
		
		frame.pack();	// �޸� ���� �� �ص� �� ������ ��
		frame.setVisible(true);
		
		
    }	// main()
}	//MyGUI class
 