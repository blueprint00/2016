import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HighLowPanel extends JPanel{
	
	private JPanel	 	leftPanel, rightPanel;
	private JLabel	 	lblTitle, /*lblMark,*/ lblHint;
	private LabelThread lblMark;
	private JButton		btnRandom, btnInput;
	private JTextField	txtInput;
	private int 		nRandom, nInput;
	private JLabel		lblRange;
	private int			nMin, nMax;
	private JLabel		lblCount;
	private int 		nCount;
		
	//2.declaration of the listener object
	private GameListener gameL;
		
	public HighLowPanel(){
		setPreferredSize(new Dimension(430, 320));
		setBackground(Color.white);
		setLayout(null);	
		
		//2. creating of the listener object
		gameL = new GameListener();
		
		leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 200, 300);
		leftPanel.setBackground(Color.cyan);
		leftPanel.setLayout(null);
		add(leftPanel);	
		
		rightPanel = new JPanel();
		rightPanel.setBounds(220, 10, 200, 300);
		rightPanel.setBackground(Color.yellow);
		rightPanel.setLayout(null);
		add(rightPanel);	
		
		lblTitle = new JLabel("HIGH-LOW GAME");
		lblTitle.setBounds(10, 20, 180, 50);
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTitle);
		
		//lblMark = new JLabel("?");
		lblMark = new LabelThread(this);	//�޼ҵ带 �� ����� �����ڸ� ����� �̷��� �� ����....
		//lblMark.setThis(this);	//����
		//���⼭�� ��(This)�� HighLowPanel
		lblMark.setBounds(10, 50, 180, 180);
		lblMark.setFont(new Font("Verdana", Font.BOLD, 85));
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblMark.setVerticalAlignment(SwingConstants.CENTER);
		lblMark.setForeground(Color.darkGray);
		lblMark.setVisible(false);
		leftPanel.add(lblMark);
		
		lblHint = new JLabel("RIGHT");
		lblHint.setBounds(10, 230, 180, 40);
		lblHint.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		lblHint.setVerticalAlignment(SwingConstants.CENTER);
		lblHint.setVisible(false);
		leftPanel.add(lblHint);
		
		Font fntButton = new Font("Verdana", Font.PLAIN, 12);
		
		btnRandom = new JButton("Random Number");
		btnRandom.setBounds(20, 50, 160, 30);
		btnRandom.setFont(fntButton);
		//3. add the listener object to the component
		btnRandom.addActionListener(gameL);
		rightPanel.add(btnRandom);
		
		txtInput = new JTextField();
		txtInput.setBounds(20, 85, 75, 30);
		//3.add the listener object to the component
		txtInput.addActionListener(gameL);
		txtInput.setEnabled(false);
		rightPanel.add(txtInput);
		
		btnInput = new JButton("INPUT");
		btnInput.setBounds(100, 85, 80, 30);
		//3.add the listener object to the component
		btnInput.addActionListener(gameL);
		btnInput.setFont(fntButton);
		btnInput.setEnabled(false);
		rightPanel.add(btnInput);
		
		nRandom = nInput = 0;
		
		nMin = 1;
		nMax = 100;
		
		Font fntLabel = new Font("Cambia", Font.PLAIN, 16);
	
		lblRange = new JLabel("RANGE >> " + nMin + " - " + nMax);
		lblRange.setFont(fntLabel);
		lblRange.setBounds(30, 120, 160, 35);
		lblRange.setForeground(new Color(200, 100, 0));
		rightPanel.add(lblRange);
		
		nCount = 0;
		
		lblCount = new JLabel("COUNT >> " + nCount);
		lblCount.setFont(fntLabel);
		lblCount.setBounds(30, 155, 160, 35);
		lblCount.setForeground(new Color(0, 100, 140));
		rightPanel.add(lblCount);
	}	// constructor
	
	// �̺�Ʈ �ڵ鷯���� ��ȭ���� ó�� �� �� �޼ҵ�
	public void continueGame(){
		int result = JOptionPane.showConfirmDialog(null, "CONTINUE?");	//if Yes, result = 0, no, result = 1, cancle = 2;
	
		switch(result){ // ��� ���� ���������� swtich
			case JOptionPane.YES_OPTION: 
				//init....?????????? blackboard
				//System.out.println("YES");
				break;
			case JOptionPane.NO_OPTION:
				System.out.println("YES");
				break;
			
		}	//swtich
	}	//continueGame()
	
	//1.Listener class
	private class GameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//4. event handling...
			boolean bFlag = false;
			
			Object obj = event.getSource();
			
			if(obj == btnRandom){
				nRandom = (int)(Math.random() * 100) + 1; 	//1 ~ 100
				System.out.println(nRandom);
				lblMark.setText("?");
				lblMark.setVisible(true);
				
				txtInput.setEnabled(true);
				btnInput.setEnabled(true);
				btnRandom.setEnabled(false);
			} else if (obj == txtInput || obj == btnInput){
				nInput = Integer.parseInt(txtInput.getText());
				//txtInput.getText�� ���ڿ�, nInput�� ���ڿ�
				//���ڿ��� ���ڿ��� �ٲ��ֱ� ���� integer
				txtInput.setText("");	// ���� �������� ����(�Է� �� ���� �Ⱥ���)
				
				//���͸� ġ�ų� input���� ������ ���ؾ� �� > nRandom�� nInput ��
				if(nRandom < nInput){
					lblHint.setText("HIGH");
					nMax = nInput - 1;
				} else if (nRandom > nInput) {
					lblHint.setText("LOW");
					nMin = nInput + 1;
				} else { // nRandom == nInput
					lblHint.setText("RIGHT");
					//lblMark.setText("" + nRandom); // (nInput)/ ���ڸ� ���ڿ��� �ٲ��ֱ� ���� "" +
					lblMark.setStartFinish(1, nRandom);
					lblMark.setDelayTime(90);
					lblMark.start();
					bFlag = true;
				} //if..else
				lblHint.setVisible(true);
				lblRange.setText("RANGE >> " + nMin + " - " + nMax);
				nCount++;
				lblCount.setText("COUNT >> " + nCount);
				
				/*
				if(bFlag){
					continueGame();					
				}	// if
				*/
			}// if...else
			
		}	// actionPerformed()
	}	// GameListener
	
}	//HighLowPanel class