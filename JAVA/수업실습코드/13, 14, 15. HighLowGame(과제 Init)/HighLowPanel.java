import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HighLowPanel extends JPanel{
	
	private JPanel	 	leftPanel, rightPanel;		//각각의 것들을 나타내기 위한 JPanel 선언
	private JLabel	 	lblTitle, lblMark, lblHint;	//Title, Mark, Hint를 나타낼 JLabel 선언
	private JButton		btnRandom, btnInput;		//숫자를 랜덤으로 생성할 버튼과 숫자를 입력할 버튼을 JButton으로 선언
	private JTextField	txtInput;					//텍스트를 입력할 수 있는 텍스트필드 선언
	private int 		nRandom, nInput;			//비교할 값과 사용자 입력 값 저장할 변수
	private JLabel		lblRange;					//범위를 나타낼 JLabel 선언
	private int			nMin, nMax;					//범위를 나타낼 최솟값과 최댓값
	private JLabel		lblCount;					//실행한 횟수를 나타낼 JLabel 선언
	private int 		nCount;						//실행한 횟수 저장할 변수
	//2.declaration of the listener object
	private GameListener gameL;
		
	//default constroctor
	public HighLowPanel(){
		setPreferredSize(new Dimension(430, 320));
		setBackground(Color.white);
		setLayout(null);	
		
		//2. creating of the listener object
		gameL = new GameListener();
		
		//leftPanel 생성
		leftPanel = new JPanel();
		leftPanel.setBounds(10, 10, 200, 300);
		leftPanel.setBackground(Color.cyan);
		leftPanel.setLayout(null);
		add(leftPanel);	
		
		//rightPanel 생성
		rightPanel = new JPanel();
		rightPanel.setBounds(220, 10, 200, 300);
		rightPanel.setBackground(Color.yellow);
		rightPanel.setLayout(null);
		add(rightPanel);	
		
		//HIGH-LOW GAME 문자열 나타내기
		lblTitle = new JLabel("HIGH-LOW GAME");
		lblTitle.setBounds(10, 20, 180, 50);
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		leftPanel.add(lblTitle);	//leftPanel에 추가
		
		//? 나타내기
		lblMark = new JLabel("?");
		lblMark.setBounds(10, 50, 180, 180);
		lblMark.setFont(new Font("Verdana", Font.BOLD, 85));
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblMark.setVerticalAlignment(SwingConstants.CENTER);
		lblMark.setForeground(Color.darkGray);
		lblMark.setVisible(false);	//?가 보이지 않게 초기화
		leftPanel.add(lblMark);
		
		//RIGHT 문자열 나타내기
		lblHint = new JLabel("RIGHT");
		lblHint.setBounds(10, 230, 180, 40);
		lblHint.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		lblHint.setVerticalAlignment(SwingConstants.CENTER);
		lblHint.setVisible(false);	// 보이지 않게 초기화
		leftPanel.add(lblHint);
		
		Font fntButton = new Font("Verdana", Font.PLAIN, 12);
		
		//랜덤으로 값을 지정할 버튼 생성
		btnRandom = new JButton("Random Number");
		btnRandom.setBounds(20, 50, 160, 30);
		btnRandom.setFont(fntButton);
		//3. add the listener object to the component
		btnRandom.addActionListener(gameL);
		rightPanel.add(btnRandom);	//rightPanel에 추가
		
		//임의의 값 입력할 수 있는 텍스트필드 생성
		txtInput = new JTextField();
		txtInput.setBounds(20, 85, 75, 30);
		//3.add the listener object to the component
		txtInput.addActionListener(gameL);
		txtInput.setEnabled(false);	//활성화되지 않도록 초기화
		rightPanel.add(txtInput);
		
		//값을 input할 버튼 생성
		btnInput = new JButton("INPUT");
		btnInput.setBounds(100, 85, 80, 30);
		//3.add the listener object to the component
		btnInput.addActionListener(gameL);
		btnInput.setFont(fntButton);
		btnInput.setEnabled(false);	//활성화되지 않도록 초기화
		rightPanel.add(btnInput);
		
		nRandom = nInput = 0;	//임의의 수와 인풋값 모두 0으로 초기화
		
		//범위는 1 ~ 100으로 초기화
		nMin = 1;
		nMax = 100;
		
		Font fntLabel = new Font("Cambia", Font.PLAIN, 16);

		//입력 값의 범위 나타내기	
		lblRange = new JLabel("RANGE >> " + nMin + " - " + nMax);
		lblRange.setFont(fntLabel);
		lblRange.setBounds(30, 120, 160, 35);
		lblRange.setForeground(new Color(200, 100, 0));
		rightPanel.add(lblRange);
		
		//게임 횟수 0으로 초기화
		nCount = 0;
		
		//실행 횟수 나타내기
		lblCount = new JLabel("COUNT >> " + nCount);
		lblCount.setFont(fntLabel);
		lblCount.setBounds(30, 155, 160, 35);
		lblCount.setForeground(new Color(0, 100, 140));
		rightPanel.add(lblCount);
	}	// constructor
	
	// 이벤트 핸들러에서 대화상자 처리 해 줄 메소드
	public void continueGame(){
		int result = JOptionPane.showConfirmDialog(null, "CONTINUE?");	//if Yes, result = 0, no, result = 1, cancle = 2;
	
		// 결과 값이 숫자임으로 swtich문 사용
		switch(result){ 	// result값에 따라 수행
			case JOptionPane.YES_OPTION:		//game init

				//초기상태와 같게
				lblMark.setVisible(false);		//? 나타나지 않음
				txtInput.setEnabled(false);		//텍스트 입력 불가능
				btnInput.setEnabled(false);		//input버튼 비활성화
				btnRandom.setEnabled(true);		//Random버튼 활성화
				lblHint.setVisible(false);		//Hint 안보임
				
				//범위, 게임 횟수 초기화
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
			boolean bFlag = false;	//게임이 끝났는지 알기 위한 변수, true면 게임 끝남
			
			Object obj = event.getSource();	//?
			
			if(obj == btnRandom){	//btnRandom버튼이 눌렸을때
				nRandom = (int)(Math.random() * 100) + 1; 	//1 ~ 100
				System.out.println(nRandom);	//test
				lblMark.setText("?");
				lblMark.setVisible(true);		//?가 나타남
				
				txtInput.setEnabled(true);		//텍스트 입력 가능
				btnInput.setEnabled(true);		//input버튼 활성화
				btnRandom.setEnabled(false);	//Random버튼 비활성화
			} else if (obj == txtInput || obj == btnInput){
				nInput = Integer.parseInt(txtInput.getText());
				//txtInput.getText는 문자열, nInput은 숫자열 >> 문자열을 숫자열로 바꿔주기 위해 integer
				
				txtInput.setText("");	// 값을 가져오고 지움(입력 한 값이 안보임)
				
				//엔터를 치거나 input값을 누르면 변해야 함 > nRandom과 nInput 비교
				if(nRandom < nInput){
					lblHint.setText("HIGH");	//입력 값이 더 큼
					nMax = nInput - 1;			//범위 재설정(nMin ~ nInput - 1)
				} else if (nRandom > nInput) {
					lblHint.setText("LOW");		//입력 값이 더 작음
					nMin = nInput + 1;			//범위 재설정(nInput + 1 ~ nMax)
				} else { // nRandom == nInput (= correct)
					lblHint.setText("RIGHT");
					lblMark.setText("" + nRandom); // (nInput)/ 문자열로 바꿔주기 위해 "" +
					bFlag = true;		//게임 끝남
				} //if..else
				
				lblHint.setVisible(true);							 //Hint 보임
			
				if(bFlag){	//if(bFlag == true) > 게임 끝났을 때
					continueGame();					
				}	// if
				
				lblRange.setText("RANGE >> " + nMin + " - " + nMax); //범위 보임
				lblCount.setText("COUNT >> " + (nCount++));			 //실행 횟수 나타냄
			}// if...else
						
		}	// actionPerformed()
	}	// GameListener
	
}	//HighLowPanel class