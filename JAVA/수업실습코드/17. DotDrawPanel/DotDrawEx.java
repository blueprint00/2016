import javax.swing.JFrame;

public class DotDrawEx{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("DOT DRAW");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	//������ ũ�� ���� �ȵ�. ����.
		
		DotDrawPanel primary = new DotDrawPanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}	//main()
}	//HihgLowGame class