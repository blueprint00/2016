import java.awt.*;
import javax.swing.*;


public class UserPanelApplet extends JApplet{
	/*JApplet 은 OS가 관리하는 중량 컨테이너 => 생성자 쓰지 않음*/
	
	private UserPanel user;
	
	public void init() {
		
		user = new UserPanel();
		getContentPane().add(user);		//중량 컨테이너에 add 
		
	}	// init() - constructor
	//JApplet에서 상속받은 모든 ~~는 init을 씀
		
}	//UserPanelApplet class