import javax.swing.JFrame;

public class SimplePainter{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("SIMPLE PAINTER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	//������ ũ�� ���� �ȵ�. ����.
		
		PrimaryPanel primary = new PrimaryPanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}	//main()
}	//HihgLowGame class