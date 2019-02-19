import java.awt.*;
import javax.swing.*;
 
public class MyGui {
 
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("My Gui");	// frame 객체 선언하고 생성/이 문자열을 갖는 객체 생성
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //-> 정상 종료 안 될때
		
		JPanel primary = new JPanel();
		primary.setPreferredSize(new Dimension(400, 200));
		primary.setBackground(Color.cyan);
		
		frame.getContentPane().add(primary);	// frame은 운영체제가 관리하므로 허락받고(get~~) add..
		//primary로 한다면 내가 관리하므로 허락 x
		
		frame.pack();	// 메모리 정리 안 해도 잘 나오긴 함
		frame.setVisible(true);
		
		
    }	// main()
}	//MyGUI class
 