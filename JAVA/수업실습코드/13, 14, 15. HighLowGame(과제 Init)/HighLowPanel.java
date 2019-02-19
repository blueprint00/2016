import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HighLowPanel extends JPanel{
	
	private JPanel	 	leftPanel, rightPanel;		//������ �͵��� ��Ÿ���� ���� JPanel ����
	private JLabel	 	lblTitle, lblMark, lblHint;	//Title, Mark, Hint�� ��Ÿ�� JLabel ����
	private JButton		btnRandom, btnInput;		//���ڸ� �������� ������ ��ư�� ���ڸ� �Է��� ��ư�� JButton���� ����
	private JTextField	txtInput;					//�ؽ�Ʈ�� �Է��� �� �ִ� �ؽ�Ʈ�ʵ� ����
	private int 		nRandom, nInput;			//���� ���� ����� �Է� �� ������ ����
	private JLabel		lblRange;					//������ ��Ÿ�� JLabel ����
	private int			nMin, nMax;					//������ ��Ÿ�� �ּڰ��� �ִ�
	private JLabel		lblCount;					//������ Ƚ���� ��Ÿ�� JLabel ����
	private int 		nCount;						//������ Ƚ�� ������ ����
	//2.declaration of the listener object
	private GameListener gameL;
		
	//default constroctor
	public HighLowPanel(){
		setPreferredSize(new Dimension(430, 320));
		setBackground(Color.white);
		setLayout(null);	
		
		//2. creating of the listener object
		gameL = new GameListener();
		
		//leftPanel ����
		leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 200, 300);
		leftPanel.setBackground(Color.cyan);
		leftPanel.setLayout(null);
		add(leftPanel);	
		
		//rightPanel ����
		rightPanel = new JPanel();
		rightPanel.setBounds(220, 10, 200, 300);
		rightPanel.setBackground(Color.yellow);
		rightPanel.setLayout(null);
		add(rightPanel);	
		
		//HIGH-LOW GAME ���ڿ� ��Ÿ����
		lblTitle = new JLabel("HIGH-LOW GAME");
		lblTitle.setBounds(10, 20, 180, 50);
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTitle);	//leftPanel�� �߰�
		
		//? ��Ÿ����
		lblMark = new JLabel("?");
		lblMark.setBounds(10, 50, 180, 180);
		lblMark.setFont(new Font("Verdana", Font.BOLD, 85));
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblMark.setVerticalAlignment(SwingConstants.CENTER);
		lblMark.setForeground(Color.darkGray);
		lblMark.setVisible(false);	//?�� ������ �ʰ� �ʱ�ȭ
		leftPanel.add(lblMark);
		
		//RIGHT ���ڿ� ��Ÿ����
		lblHint = new JLabel("RIGHT");
		lblHint.setBounds(10, 230, 180, 40);
		lblHint.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		lblHint.setVerticalAlignment(SwingConstants.CENTER);
		lblHint.setVisible(false);	// ������ �ʰ� �ʱ�ȭ
		leftPanel.add(lblHint);
		
		Font fntButton = new Font("Verdana", Font.PLAIN, 12);
		
		//�������� ���� ������ ��ư ����
		btnRandom = new JButton("Random Number");
		btnRandom.setBounds(20, 50, 160, 30);
		btnRandom.setFont(fntButton);
		//3. add the listener object to the component
		btnRandom.addActionListener(gameL);
		rightPanel.add(btnRandom);	//rightPanel�� �߰�
		
		//������ �� �Է��� �� �ִ� �ؽ�Ʈ�ʵ� ����
		txtInput = new JTextField();
		txtInput.setBounds(20, 85, 75, 30);
		//3.add the listener object to the component
		txtInput.addActionListener(gameL);
		txtInput.setEnabled(false);	//Ȱ��ȭ���� �ʵ��� �ʱ�ȭ
		rightPanel.add(txtInput);
		
		//���� input�� ��ư ����
		btnInput = new JButton("INPUT");
		btnInput.setBounds(100, 85, 80, 30);
		//3.add the listener object to the component
		btnInput.addActionListener(gameL);
		btnInput.setFont(fntButton);
		btnInput.setEnabled(false);	//Ȱ��ȭ���� �ʵ��� �ʱ�ȭ
		rightPanel.add(btnInput);
		
		nRandom = nInput = 0;	//������ ���� ��ǲ�� ��� 0���� �ʱ�ȭ
		
		//������ 1 ~ 100���� �ʱ�ȭ
		nMin = 1;
		nMax = 100;
		
		Font fntLabel = new Font("Cambia", Font.PLAIN, 16);

		//�Է� ���� ���� ��Ÿ����	
		lblRange = new JLabel("RANGE >> " + nMin + " - " + nMax);
		lblRange.setFont(fntLabel);
		lblRange.setBounds(30, 120, 160, 35);
		lblRange.setForeground(new Color(200, 100, 0));
		rightPanel.add(lblRange);
		
		//���� Ƚ�� 0���� �ʱ�ȭ
		nCount = 0;
		
		//���� Ƚ�� ��Ÿ����
		lblCount = new JLabel("COUNT >> " + nCount);
		lblCount.setFont(fntLabel);
		lblCount.setBounds(30, 155, 160, 35);
		lblCount.setForeground(new Color(0, 100, 140));
		rightPanel.add(lblCount);
	}	// constructor
	
	// �̺�Ʈ �ڵ鷯���� ��ȭ���� ó�� �� �� �޼ҵ�
	public void continueGame(){
		int result = JOptionPane.showConfirmDialog(null, "CONTINUE?");	//if Yes, result = 0, no, result = 1, cancle = 2;
	
		// ��� ���� ���������� swtich�� ���
		switch(result){ 	// result���� ���� ����
			case JOptionPane.YES_OPTION:		//game init

				//�ʱ���¿� ����
				lblMark.setVisible(false);		//? ��Ÿ���� ����
				txtInput.setEnabled(false);		//�ؽ�Ʈ �Է� �Ұ���
				btnInput.setEnabled(false);		//input��ư ��Ȱ��ȭ
				btnRandom.setEnabled(true);		//Random��ư Ȱ��ȭ
				lblHint.setVisible(false);		//Hint �Ⱥ���
				
				//����, ���� Ƚ�� �ʱ�ȭ
				nMin = 1;
				nMax = 100;
				nCount = 0;
				break;
				
			case JOptionPane.NO_OPTION:
				System.out.println("NO");	//test
				break;
			
		}	//swtich
	}	//continueGame()
	
	//1.Listener class
	private class GameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//4. event handling...
			boolean bFlag = false;	//������ �������� �˱� ���� ����, true�� ���� ����
			
			Object obj = event.getSource();	//?
			
			if(obj == btnRandom){	//btnRandom��ư�� ��������
				nRandom = (int)(Math.random() * 100) + 1; 	//1 ~ 100
				System.out.println(nRandom);	//test
				lblMark.setText("?");
				lblMark.setVisible(true);		//?�� ��Ÿ��
				
				txtInput.setEnabled(true);		//�ؽ�Ʈ �Է� ����
				btnInput.setEnabled(true);		//input��ư Ȱ��ȭ
				btnRandom.setEnabled(false);	//Random��ư ��Ȱ��ȭ
			} else if (obj == txtInput || obj == btnInput){
				nInput = Integer.parseInt(txtInput.getText());
				//txtInput.getText�� ���ڿ�, nInput�� ���ڿ� >> ���ڿ��� ���ڿ��� �ٲ��ֱ� ���� integer
				
				txtInput.setText("");	// ���� �������� ����(�Է� �� ���� �Ⱥ���)
				
				//���͸� ġ�ų� input���� ������ ���ؾ� �� > nRandom�� nInput ��
				if(nRandom < nInput){
					lblHint.setText("HIGH");	//�Է� ���� �� ŭ
					nMax = nInput - 1;			//���� �缳��(nMin ~ nInput - 1)
				} else if (nRandom > nInput) {
					lblHint.setText("LOW");		//�Է� ���� �� ����
					nMin = nInput + 1;			//���� �缳��(nInput + 1 ~ nMax)
				} else { // nRandom == nInput (= correct)
					lblHint.setText("RIGHT");
					lblMark.setText("" + nRandom); // (nInput)/ ���ڿ��� �ٲ��ֱ� ���� "" +
					bFlag = true;		//���� ����
				} //if..else
				
				lblHint.setVisible(true);							 //Hint ����
			
				if(bFlag){	//if(bFlag == true) > ���� ������ ��
					continueGame();					
				}	// if
				
				lblRange.setText("RANGE >> " + nMin + " - " + nMax); //���� ����
				lblCount.setText("COUNT >> " + (nCount++));			 //���� Ƚ�� ��Ÿ��
			}// if...else
						
		}	// actionPerformed()
	}	// GameListener
	
}	//HighLowPanel class