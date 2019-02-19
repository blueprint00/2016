import java.awt.*;
import javax.swing.*;
import java.awt.event.*;	//eventHandling할 때 필요한 package => 있어야 import 가능

public class CountPanel extends JPanel{
	
	private JButton	btnCount;
	private JLabel	lblCount;
	private int		nCount;
	// 2. delaration of the listener object
	private CountListener countL;	//listenerclass의 객체를 선언하고
	
	public CountPanel(){
		setPreferredSize(new Dimension(400, 100));
		setBackground(Color.white);
		
		// 2. creating of the listener object
		countL = new CountListener();	//생성
		
		Font fnt = new Font("Verdana", Font. BOLD, 20);
		
		btnCount = new JButton("COUNT");	//문자열 의미는 버튼에 보여지는 텍스트
		btnCount.setFont(fnt);
		// 3. add the listener object to the component
		btnCount.addActionListener(countL);	// new CountListener() -> annonymous object : 한번만 쓰고 안 쓸때
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