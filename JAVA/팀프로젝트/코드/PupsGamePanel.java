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
		
		Font menuFont = new Font("Gadugi", Font.PLAIN, 20);	//메뉴 폰트 설정
		
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
		btnIcon = button;	//IconThread에서 생성된 버튼 넘겨받기
		index = n;			//IconThread에서 생성된 버튼 인덱스 넘겨받기
		nLocation = new Point();
		
		nLocation.x = (int)(Math.random()*(420-40));
		nLocation.y = (int)(Math.random()*(400-40));
		
		btnIcon.setBounds(nLocation.x, nLocation.y, 40,40);
		btnIcon.addActionListener(gameL);
		gamePanel.add(btnIcon);
	} //addIcon()
	
	//exit button눌렀을 때 메소드
	public void exitGame(){	
		int result = JOptionPane.showConfirmDialog(null, "EXIT?");
			
			switch(result){
				case JOptionPane.YES_OPTION:
					System.exit(0);  	//프로세서 종료		
					break;
				case JOptionPane.NO_OPTION:	//게임 종료 상태 유지
					break;
			}
	}	
	//게임 끝났을 떄 메소드
	public void continueGame(){
		int result = JOptionPane.showConfirmDialog(null, "CONTINUE?");	
		
		switch(result){
			case JOptionPane.YES_OPTION:	//게임 시작 하기 전으로 돌아감

				nScore = 0;							// 점수 초기화
				btnStart.setEnabled(true);			//start버튼 활성화
				lblLevel.setText("LEVEL");			//LEVEL
				lblScore.setText(nScore + " /50");	//점수 다시 나타냄
				limitTime.setForeground(Color.black);
				limitTime.setText("00 : 00");		//시간 다시 나타냄
				
				limitTime.setNumberThread();
				gamePanel.setNumberThread();		//thread 초기화
				break;
			case JOptionPane.NO_OPTION:	
				exitGame();							//exit 창 뜸
				break;
		}
	}
	
	public class GameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object obj = event.getSource();		//이벤트 받음
			Boolean bFlag = false;		//게임 끝나는지 여부, true면 게임 끝
			
			if(obj == btnStart){		//press start button before game start
				
				//난이도 체크하는 옵션 대화상자
				Object[] options = {"HIGH", "MIDDLE", "LOW"};
				int selectedNum = JOptionPane.showOptionDialog(new JFrame(), "난이도를 선택하세요.", "난이도 체크",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				//press button HIGH				
				if(selectedNum == 0){
					System.out.println("HIGH");		//test
					gamePanel.setLevel(6, 600, 50);	//아이콘 6개, delayTime = 600, startNum = 50
				}
				//press button MIDDLE
				else if(selectedNum == 1){
					System.out.println("MIDDLE");	//test
					gamePanel.setLevel(5, 750, 40);	//아이콘 5개, delayTime = 750, startNum = 40
				}
				//press button LOW
				else if(selectedNum == 2){
					System.out.println("LOW");		//test
					gamePanel.setLevel(3, 1000, 30);//아이콘 3개, delayTime = 1000, startNum = 30
				}
				
				lblLevel.setText("" + options[selectedNum]);	//선택된 level 표시
				limitTime.start();
				gamePanel.start();		//각 Thread 시작
				limitTime.setVisible(true);
				btnStart.setEnabled(false);	//시작버튼 다시 못 누르도록 비활성화
			}
			
			if(obj == btnExit){	//press exit button
				exitGame();
			}
			
			if(obj == btnIcon){	//아이콘 눌렸을 때
				nScore += PupsConstants.ICONSCORE[index];	//해당 아이콘의 점수 계산
				lblScore.setText(nScore + " /50");			//점수 보여줌
				btnIcon.setVisible(false);	//아이콘이 눌렸으면 사라짐
				btnIcon = null;				//버튼 초기화
			
				if(nScore >= 50) bFlag = true;	//목표 점수 넘으면 게임 끝	
			}
			
			if(bFlag){	//게임 끝났을 때
				limitTime.stop();
				gamePanel.stop();	//각 Thread 정지
				JOptionPane.showMessageDialog (null, "YOU WIN!");	//확인 창
				continueGame();
			}
		}
	}
} //PupsGamePanel class