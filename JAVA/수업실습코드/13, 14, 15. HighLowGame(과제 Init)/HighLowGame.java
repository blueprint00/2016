import javax.swing.JFrame;

public class HighLowGame{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("HIGH-LOW GAME");		//JFrame 객체 선언/생성
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setResizable(false);	//프레임 크기 조정 안됨. 고정.
		
		HighLowPanel primary = new HighLowPanel();	//HighLowPanel 객체 primary 선언/생성
		
		frame.getContentPane().add(primary);	//primary를 JFrame에 추가
		frame.pack();
		frame.setVisible(true);
		
	}	//main()
}	//HihgLowGame class