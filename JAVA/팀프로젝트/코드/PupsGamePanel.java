import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PupsGamePanel extends JPanel
{
	//data
	//Bagic UI
	private JPanel		menuPanel;
	private IconThread	gamePanel;
	private JLabel		lblTitle;			//Title
	private JLabel		lblLevel, lblScore; //menu Label
	private TimeThread	limitTime;			//Time
	int					nScore;				//menu Value
	private JButton		btnStart, btnExit;	//menu Button
	
	private JButton		btnIcon;			//Icon
	private Point		nLocation;			//Icon's location
	private int			index;				//Icon index
	
	//Listener
	private GameListener gameL;
	
	//constructor
	public PupsGamePanel() {
		setPreferredSize(new Dimension(600, 500));
		setBackground(Color.white);
		setLayout(null);
		
		gameL = new GameListener();
		
		//Title
		lblTitle = new JLabel("Pop Up Points!");
		lblTitle.setBounds(10,10,580,70);
		lblTitle.setForeground(Color.cyan);
		lblTitle.setBorder(BorderFactory.createLineBorder(Color.pink, 3));
		lblTitle.setFont(new Font("Hobo BT", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		//Game Screen
		gamePanel = new IconThread(this);
		gamePanel.setBounds(170,90,420,400);
		gamePanel.setBackground(Color.white);
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.cyan, 3));
		gamePanel.setLayout(null);
		add(gamePanel);
		
		//Menu
		menuPanel = new JPanel();
		menuPanel.setBounds(10,90,150,400);
		menuPanel.setBackground(Color.white);
		menuPanel.setLayout(null);
		add(menuPanel);
		
		Font menuFont = new Font("Gadugi", Font.PLAIN, 20);	//�޴� ��Ʈ ����
		
		//Level
		lblLevel = new JLabel("LEVEL");
		lblLevel.setBounds(0,0,150,50);
		lblLevel.setBackground(Color.white);
		lblLevel.setFont(menuFont);
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setVerticalAlignment(SwingConstants.CENTER);
		lblLevel.setBorder(BorderFactory.createLineBorder(Color.pink, 3));
		menuPanel.add(lblLevel);
		
		//Score
		nScore = 0;
		lblScore = new JLabel(nScore + " /50");
		lblScore.setBounds(0,60,150,50);
		lblScore.setBackground(Color.white);
		lblScore.setFont(menuFont);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setVerticalAlignment(SwingConstants.CENTER);
		lblScore.setBorder(BorderFactory.createLineBorder(Color.pink, 3));
		menuPanel.add(lblScore);
		
		//Time
		limitTime = new TimeThread(this);
		limitTime.setText("00 : 00");
		limitTime.setBounds(0,120,150,50);
		limitTime.setFont(menuFont);
		limitTime.setHorizontalAlignment(SwingConstants.CENTER);
		limitTime.setVerticalAlignment(SwingConstants.CENTER);
		limitTime.setBorder(BorderFactory.createLineBorder(Color.pink, 3));
		menuPanel.add(limitTime);
		
		//Start button
		btnStart = new JButton("START");
		btnStart.setBounds(0,290,150,50);
		btnStart.setFont(menuFont);
		btnStart.setHorizontalAlignment(SwingConstants.CENTER);
		btnStart.setVerticalAlignment(SwingConstants.CENTER);
		btnStart.addActionListener(gameL);
		menuPanel.add(btnStart);
		
		//Exit button
		btnExit = new JButton("EXIT");
		btnExit.setBounds(0,350,150,50);
		btnExit.setFont(menuFont);
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setVerticalAlignment(SwingConstants.CENTER);
		btnExit.addActionListener(gameL);
		menuPanel.add(btnExit);
	} //PupsGamePanel()
	
	//add Icon from IconThread to gamePanel
	public void addIcon(JButton button, int n) {
		btnIcon = button;	//IconThread���� ������ ��ư �Ѱܹޱ�
		index = n;			//IconThread���� ������ ��ư �ε��� �Ѱܹޱ�
		nLocation = new Point();
		
		nLocation.x = (int)(Math.random()*(420-40));
		nLocation.y = (int)(Math.random()*(400-40));
		
		btnIcon.setBounds(nLocation.x, nLocation.y, 40,40);
		btnIcon.addActionListener(gameL);
		gamePanel.add(btnIcon);
	} //addIcon()
	
	//exit button������ �� �޼ҵ�
	public void exitGame(){	
		int result = JOptionPane.showConfirmDialog(null, "EXIT?");
			
			switch(result){
				case JOptionPane.YES_OPTION:
					System.exit(0);  	//���μ��� ����		
					break;
				case JOptionPane.NO_OPTION:	//���� ���� ���� ����
					break;
			}
	}	
	//���� ������ �� �޼ҵ�
	public void continueGame(){
		int result = JOptionPane.showConfirmDialog(null, "CONTINUE?");	
		
		switch(result){
			case JOptionPane.YES_OPTION:	//���� ���� �ϱ� ������ ���ư�

				nScore = 0;							// ���� �ʱ�ȭ
				btnStart.setEnabled(true);			//start��ư Ȱ��ȭ
				lblLevel.setText("LEVEL");			//LEVEL
				lblScore.setText(nScore + " /50");	//���� �ٽ� ��Ÿ��
				limitTime.setForeground(Color.black);
				limitTime.setText("00 : 00");		//�ð� �ٽ� ��Ÿ��
				
				limitTime.setNumberThread();
				gamePanel.setNumberThread();		//thread �ʱ�ȭ
				break;
			case JOptionPane.NO_OPTION:	
				exitGame();							//exit â ��
				break;
		}
	}
	
	public class GameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object obj = event.getSource();		//�̺�Ʈ ����
			Boolean bFlag = false;		//���� �������� ����, true�� ���� ��
			
			if(obj == btnStart){		//press start button before game start
				
				//���̵� üũ�ϴ� �ɼ� ��ȭ����
				Object[] options = {"HIGH", "MIDDLE", "LOW"};
				int selectedNum = JOptionPane.showOptionDialog(new JFrame(), "���̵��� �����ϼ���.", "���̵� üũ",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				//press button HIGH				
				if(selectedNum == 0){
					System.out.println("HIGH");		//test
					gamePanel.setLevel(6, 600, 50);	//������ 6��, delayTime = 600, startNum = 50
				}
				//press button MIDDLE
				else if(selectedNum == 1){
					System.out.println("MIDDLE");	//test
					gamePanel.setLevel(5, 750, 40);	//������ 5��, delayTime = 750, startNum = 40
				}
				//press button LOW
				else if(selectedNum == 2){
					System.out.println("LOW");		//test
					gamePanel.setLevel(3, 1000, 30);//������ 3��, delayTime = 1000, startNum = 30
				}
				
				lblLevel.setText("" + options[selectedNum]);	//���õ� level ǥ��
				limitTime.start();
				gamePanel.start();		//�� Thread ����
				limitTime.setVisible(true);
				btnStart.setEnabled(false);	//���۹�ư �ٽ� �� �������� ��Ȱ��ȭ
			}
			
			if(obj == btnExit){	//press exit button
				exitGame();
			}
			
			if(obj == btnIcon){	//������ ������ ��
				nScore += PupsConstants.ICONSCORE[index];	//�ش� �������� ���� ���
				lblScore.setText(nScore + " /50");			//���� ������
				btnIcon.setVisible(false);	//�������� �������� �����
				btnIcon = null;				//��ư �ʱ�ȭ
			
				if(nScore >= 50) bFlag = true;	//��ǥ ���� ������ ���� ��	
			}
			
			if(bFlag){	//���� ������ ��
				limitTime.stop();
				gamePanel.stop();	//�� Thread ����
				JOptionPane.showMessageDialog (null, "YOU WIN!");	//Ȯ�� â
				continueGame();
			}
		}
	}
} //PupsGamePanel class