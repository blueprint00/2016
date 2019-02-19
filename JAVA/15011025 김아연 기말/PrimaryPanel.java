import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrimaryPanel extends JPanel{
	
	//data
	private JPanel menuPanel, buttonMenuPanel, optionMenuPanel;
	private JButton[] btnMenuArray;	//배열 표시/객체 배열은 선언하고 배열을 생성한 뒤 객체를 생성하고 사용한다
	private JPanel subOptionMenuPanel;
	private JLabel lblSubOption;
	private JTextField txtSubOption;
	private JCheckBox chkFill;
	private JButton btnColor;
	private JButton btnFill;
	
	private DrawingPanel drawPanel;		//그림 그릴 패널
	private JPanel messagePanel;		//status message / lbl
	private MenuThread lblPrintMenu;
	
	private MenuMouseListener 		menuMouseL;
	private MenuActionListener 		menuActionL;
	private OptionActionListener 	optionActionL;
	
	//constructor
	public PrimaryPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(620, 590));
		setLayout(null);
		
		//Listener
		menuMouseL = new MenuMouseListener();
		menuActionL = new MenuActionListener();
		optionActionL = new OptionActionListener();
		
		//menuPanel
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.white);
		menuPanel.setBounds(10, 10, 600, 90);
		menuPanel.setLayout(null);
		menuPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(180, 0, 0)));
		add(menuPanel);
		
		//buttonMenuPanel
		buttonMenuPanel = new JPanel();
		buttonMenuPanel.setBounds(10, 10, 300, 70);
		buttonMenuPanel.setLayout(new GridLayout(2, 3));	//2행 3열짜리 gridLayout
		buttonMenuPanel.setBackground(Color.white);
		buttonMenuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		menuPanel.add(buttonMenuPanel);		//menuPanel에 추가
		
		//Menu Button
		btnMenuArray = new JButton[6];	//객체 배열 생성
		for(int i = 0; i < 6; i ++){
			btnMenuArray[i] = new JButton(DrawConstants.MENU[i]);	//객체들을 생성! 헷갈리지 말자!
			btnMenuArray[i].setBackground(Color.white);
			btnMenuArray[i].setForeground(Color.blue);
			btnMenuArray[i].addMouseListener(menuMouseL);
			btnMenuArray[i].addActionListener(menuActionL);
			buttonMenuPanel.add(btnMenuArray[i]);	//buttonMenuPanel에 추가
		}	//for
		
		//OptionMenuPanel
		optionMenuPanel = new JPanel();
		optionMenuPanel.setBounds(320, 10, 270, 70);
		optionMenuPanel.setLayout(null);
		optionMenuPanel.setBackground(Color.white);
		optionMenuPanel.setBorder(BorderFactory.createTitledBorder("OPTION"));
		menuPanel.add(optionMenuPanel);		//menuPanel에 추가
		
		//subOptionMenuPanel
		subOptionMenuPanel = new JPanel();
		subOptionMenuPanel.setBackground(Color.white);
		subOptionMenuPanel.setBounds(5, 15, 260, 30);
		subOptionMenuPanel.setVisible(false);		//안보임 > 여기에 추가되는 것들도 같이 안보이므로 setVisible 할 필요 없음
		optionMenuPanel.add(subOptionMenuPanel);	//optionMenuPanel에 추가
		
		//subOption
		lblSubOption = new JLabel("Point Size : ");
		subOptionMenuPanel.add(lblSubOption);	//subOptionMenuPanel에 추가
		
		txtSubOption = new JTextField(4);
		txtSubOption.setText("2");
		subOptionMenuPanel.add(txtSubOption);	//subOptionMenuPanel에 추가
		
		//Color Button
		btnColor = new JButton("COLOR");
		btnColor.setFont(new Font("Arial", Font.BOLD, 10));
		btnColor.addActionListener(optionActionL);
		subOptionMenuPanel.add(btnColor);		//subOptionMenuPanel에 추가
		
		//checkBox
		chkFill = new JCheckBox("FILL");
		chkFill.setBounds(5, 45, 260, 25);
		chkFill.setBackground(Color.white);
		chkFill.setHorizontalAlignment(SwingConstants.CENTER);	//optionMenuPanel.setLayout(null);
		chkFill.setVisible(false);
		optionMenuPanel.add(chkFill);		//optionMenuPanel에 추가
		
		//Fill Color button
		btnFill = new JButton("FILL COLOR");
		btnFill.setBounds(120, 35, 100, 25); 
		btnFill.setFont(new Font("Arial", Font.BOLD, 10));
		btnFill.addActionListener(optionActionL);
		btnFill.setVisible(false);	//처음엔 보이지 않음
		optionMenuPanel.add(btnFill);
		
		//drawPanel
		drawPanel = new DrawingPanel(this);		//this = PrimaryPanel >> 넘겨줘서 접근 가능하도록
		drawPanel.setBounds(10, 110, 600, 400);
		add(drawPanel);
		
		//messagePanel
		messagePanel = new JPanel();
		messagePanel.setBackground(Color.white);
		messagePanel.setBounds(10, 520, 600, 60);
		messagePanel.setLayout(null);
		messagePanel.setBorder(BorderFactory.createTitledBorder("status"));
		add(messagePanel);	
		
		lblPrintMenu = new MenuThread(this);
		lblPrintMenu.setBounds(10, 10, 200, 30);
		lblPrintMenu.setVisible(false); //처음엔 안 보임
		messagePanel.add(lblPrintMenu);
		
	}	//PrimaryPanel()
	
	//primaryPanel에서 TextField에 써져 있는 값을 가져다가 숫자로 리턴해주는 메소드
	public int getOption(){
		int option;
		option = Integer.parseInt(txtSubOption.getText());
		return option;
	}	//getOption()
	//체크박스 체크 여부 확인하는 메소드
	public boolean getFill(){
		return chkFill.isSelected();
	}	//getFill()
	//init/set/set
	
	private class MenuMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mouseEntered(MouseEvent event){
			JButton obj = (JButton)event.getSource();	//부모 클래스(object)를 JButton으로 바꿔줄 수 있음
			obj.setBackground(Color.yellow);
			obj.setForeground(Color.red);
		}	//mouseEntered()
		public void mouseExited(MouseEvent event){
			JButton obj = (JButton)event.getSource();
			obj.setBackground(Color.white);
			obj.setForeground(Color.blue);
		}	//mouseExited()
	}	//MenuMouseListener class
	
	private class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			int i;
			Object obj = event.getSource();
			
			//어떤 버튼을 선택하였는가!
			for(i = 0; i < 6; i ++){
				if(obj == btnMenuArray[i]){
					//to do
					break;
				}	//if
			}	//for
			
			if(chkFill.isSelected()){	//chkFill이 선택되면
				btnFill.setVisible(true); //보
				chkFill.setBounds(5, 45, 100, 25);
				btnFill.setBounds(135, 45, 100, 25);
			} else{
				btnFill.setVisible(false); //안보임
				chkFill.setBounds(5, 45, 260, 25);
			}
			//체크 하자마자 버튼이 바로 뜨진 않지만 RECT나 OVAL 메뉴 버튼을 한 번 더 누르면 옆에 떠 있어요....
			
			//공통적인것 밖으로 빼서 중복 줄임 -> 선택적으로 바꿔줌
			subOptionMenuPanel.setVisible(true);
			chkFill.setVisible(false);
			drawPanel.setDrawMode(i);
			btnColor.setText("COLOR");		
			btnColor.setForeground(Color.black);	//btnColor foreground color	
			lblPrintMenu.setVisible(true);		//스레드 보임
			lblPrintMenu.start();		//스레드 스타트
		
			switch(i){
				
				case DrawConstants.DOT :
					lblSubOption.setText("Point Size : ");
					lblPrintMenu.setText("DOT");
					break;
				case DrawConstants.RECT :
					lblSubOption.setText("Line Width : ");
					btnColor.setText("LINE COLOR");			//btnColor string change
					lblPrintMenu.setText("RECT");
					chkFill.setVisible(true);
					break;
				case DrawConstants.OVAL :
					lblSubOption.setText("Line Width : ");
					btnColor.setText("LINE COLOR");			//btnColor string change
					chkFill.setVisible(true);
					lblPrintMenu.setText("OVAL");
					break;
				case DrawConstants.LINE :
					lblSubOption.setText("Line Width : ");
					lblPrintMenu.setText("LINE");
					break;
				//break 나올때까지 실행 -> 중복적인것은 최대한 줄여줌
				default :
					subOptionMenuPanel.setVisible(false);
					break;
			}	//switch
		}	//actionPerformed()
	}	//MenuActionListner class
	
	private class OptionActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object obj = event.getSource();
			
			if(obj == btnColor){
				Color c =
				JColorChooser.showDialog(drawPanel, "Pick a Color!!", drawPanel.getColorSelected());
										//parameter = draw 하는 객체, 문자열, 처음에 선택되는 색.
										//draw 하는 객체? == 이 대화상자가 어떤 컴포넌트에 종속되어있는지!
										//getColorSelcted >> drawingPanel에서 색 얻어오기. 전에 선택한 색이 다시 실행되도 나타나도록
				drawPanel.setColorSelected(c);	//선택한 색으로 설정	
				btnColor.setForeground(c);	//btnColor foreground color
			} else if(obj == btnFill){
				Color cFill =
				JColorChooser.showDialog(drawPanel, "Pick a Color!!", drawPanel.getFillColorSelected());
										//parameter = draw 하는 객체, 문자열, 처음에 선택되는 색.
										//draw 하는 객체? == 이 대화상자가 어떤 컴포넌트에 종속되어있는지!
										//getColorSelcted >> drawingPanel에서 색 얻어오기. 전에 선택한 색이 다시 실행되도 나타나도록
				drawPanel.setFillColorSelected(cFill);	//선택한 색으로 설정	
				btnFill.setForeground(cFill);	//btnColor foreground color
			}	//if
				
		}	//actionPerformed()
	}	//OptionActionListener
}	//PrimaryPanel class