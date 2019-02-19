import javax.swing.JFrame;

public class UserPanelExam{
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("User Defined Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UserPanel user = new UserPanel();
		//DrawPanel user = new DrawPanel();
		
		
		frame.getContentPane().add(user);
		frame.pack();
		frame.setVisible(true);
		
				
	}	//main()
	//UserPanel을 드라이브할 ...?
	
}	//UserPanelExame class
