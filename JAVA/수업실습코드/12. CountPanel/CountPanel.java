import java.awt.*;
import javax.swing.*;
import java.awt.event.*;	//eventHandling�� �� �ʿ��� package => �־�� import ����

public class CountPanel extends JPanel{
	
	private JButton	btnCount;
	private JLabel	lblCount;
	private int		nCount;
	// 2. delaration of the listener object
	private CountListener countL;	//listenerclass�� ��ü�� �����ϰ�
	
	public CountPanel(){
		setPreferredSize(new Dimension(400, 100));
		setBackground(Color.white);
		
		// 2. creating of the listener object
		countL = new CountListener();	//����
		
		Font fnt = new Font("Verdana", Font. BOLD, 20);
		
		btnCount = new JButton("COUNT");	//���ڿ� �ǹ̴� ��ư�� �������� �ؽ�Ʈ
		btnCount.setFont(fnt);
		// 3. add the listener object to the component
		btnCount.addActionListener(countL);	// new CountListener() -> annonymous object : �ѹ��� ���� �� ����
		add(btnCount);
		
		nCount = 0;
		
		lblCount = new JLabel("COUNT : " + nCount);
		lblCount.setFont(fnt);
		add(lblCount);
		
	}	//CountPanel()
		
	//inner class
	//1.Listener Class
	private class CountListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//4. event handling....
			nCount++;
			lblCount.setText("Count : " + nCount);				
		}	// actionPerformed()
	}	//CountListener class		
	
} //CountPanel class