import java.awt.*;
import javax.swing.*;


public class UserPanelApplet extends JApplet{
	/*JApplet �� OS�� �����ϴ� �߷� �����̳� => ������ ���� ����*/
	
	private UserPanel user;
	
	public void init() {
		
		user = new UserPanel();
		getContentPane().add(user);		//�߷� �����̳ʿ� add 
		
	}	// init() - constructor
	//JApplet���� ��ӹ��� ��� ~~�� init�� ��
		
}	//UserPanelApplet class