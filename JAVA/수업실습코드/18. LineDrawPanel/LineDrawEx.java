import javax.swing.JFrame;

public class LineDrawEx{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("LINE DRAW");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);	//������ ũ�� ���� �ȵ�. ����.
		
		LineDrawPanel primary = new LineDrawPanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}	//main()
}	//HihgLowGame class