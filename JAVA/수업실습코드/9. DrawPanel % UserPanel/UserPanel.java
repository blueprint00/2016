import java.awt.*;
import javax.swing.*;

public class UserPanel extends JPanel{
	
	//data
	private JLabel lblUniv, lblName;
	
	//method
	public UserPanel(){
		setPreferredSize(new Dimension(400, 300));
		setBackground(Color.pink);
		setLayout(null);
		// this == ��. UserPanel class(��ӹ޾����Ƿ�)
		// ���� ����. �տ� �ƹ��͵� �� �������� this
		
		
		Font fnt = new Font("Verdana", Font.BOLD + Font. ITALIC, 20);
		
		lblUniv = new JLabel("SEJONG UNIV.");
		lblUniv.setForeground(Color.magenta);
		lblUniv.setFont(fnt);
		lblUniv.setBounds(60, 60, 200, 30);
		add(lblUniv);
			
		lblName = new JLabel("KKK");
		lblName.setForeground(Color.red);
		lblName.setFont(fnt);
		lblName.setBounds(90, 90, 200, 30);
		add(lblName);
		
			
	}	// UserPanel()
	
}	//UserPanel class