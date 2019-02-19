import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Count2Panel extends JPanel{
	
	private JButton btnInc, btnDec;
	private JLabel lblCount;
	private int nCount;
	//2. declaartion of the listener object
	private Count2Listener count2L;
	
	public Count2Panel(){
		setPreferredSize(new Dimension(400, 200));
		setBackground(Color.white);
		setLayout(null);
		
		//2. declaration of the listener object
		count2L = new Count2Listener();
		
		Font fntButton = new Font("Verdana", Font.PLAIN, 16);
		
		btnInc = new JButton("INCREMENT");
		btnInc.setBounds(40, 50, 150, 40);
		btnInc.setFont(fntButton);
		//3. add the listener object to the componenets
		btnInc.addActionListener(count2L);
		add(btnInc);	
		
		btnDec = new JButton("DECREMENT");
		btnDec.setBounds(210, 50, 150, 40);
		btnDec.setFont(fntButton);
		//3. add the listener object to the componenets
		btnDec.addActionListener(count2L);
		add(btnDec);
		
		nCount = 0;
		
		lblCount = new JLabel("COUNT : " + nCount);
		lblCount.setBounds(40, 100, 320, 40);
		lblCount.setFont(new Font("Arial", Font.BOLD, 20));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCount);		
		
	}	//Count2Panel()
	
	//1. listener class
	private class Count2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//4. event andling...
			Object obj = event.getSource();	// this event is same as ActionEent event
			//Object 클래스는 컴포넌트 클래스의 최상위. 뭘 넘겨주던 다 받을 수 있음
			//다용성을 이용해 부모클래스로 받을 수 있음
			
			if(obj == btnInc) nCount++;
			else if (obj == btnDec) nCount--;
			
			if(nCount > 0) lblCount.setForeground(Color.blue);
			else if(nCount < 0) lblCount.setForeground(Color.red);
			else lblCount.setForeground(Color.black);
			
			lblCount.setText("COUNT : " + nCount);
			
		}	// actionPerformed()
	}	//Count2Listener class
	
	
}	//Count2PAnel class