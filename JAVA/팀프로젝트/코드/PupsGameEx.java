import javax.swing.JFrame;

//driver class
public class PupsGameEx {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pups Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		//â ũ�� ����
		
		PupsGamePanel primary = new PupsGamePanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	} // main()
} // PupsGameEx class