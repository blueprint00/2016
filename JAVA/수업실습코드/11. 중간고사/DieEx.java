import javax.swing.JFrame;

public class DieEx{
	public static void main(String[] args){
		JFrame frame = new JFrame("DIE EXAMPLE");
		frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DiePanel primary = new DiePanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}