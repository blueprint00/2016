import javax.swing.JFrame;

public class HighLowGame{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("HIGH-LOW GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	//프레임 크기 조정 안됨. 고정.
		
		HighLowPanel primary = new HighLowPanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}	//main()
}	//HihgLowGame class