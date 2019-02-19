import javax.swing.JFrame;

public class CountEx{
	public static void main(String[] args){
		JFrame frame = new JFrame("COUNT EXAMPLE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Count2Panel primary = new Count2Panel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
			
	}
}