import javax.swing.JFrame;

public class RectDrawEx{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("RECT DRAW");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);	//프레임 크기 조정 안됨. 고정.
		
		RectDrawPanel primary = new RectDrawPanel();
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
	}	//main()
}	//HihgLowGame class