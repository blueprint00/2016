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
	
	private DrawingPanel drawPanel;		//그림 그릴 패널
	private JPanel messagePanel;
	private someThread lblCount;
	private JLabel lblPoint;
	
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
		
		//lblCount
		lblCount = new someThread(this);//JLabel();
		lblCount.setBounds(15, 15, 500, 20);
		lblCount.setVisible(false);	//처음엔 안보임
		messagePanel.add(lblCount);
		//lblPoint
		lblPoint = new JLabel();
		lblPoint.setBounds(15, 35, 500, 20);
		lblPoint.setVisible(false);
		messagePanel.add(lblPoint);
		
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
	public void initOption(){
		txtSubOption.setText("2");
		chkFill.setSelected(false);
		lblCount.setVisible(false);
		lblPoint.setVisible(false);
	}
	public void setMessage(){
		lblCount.setText("도형 갯수 >> " + drawPanel.getCnt());		
		lblCount.setVisible(true);
		lblCount.start();
	}
	public void setPointMessage(){
		lblPoint.setText("x = " + drawPanel.getPoint1().x + "    y = " + drawPanel.getPoint1().y);
		lblPoint.setVisible(true);
	} 
	public void setPointTwoMessage(){
		lblPoint.setText("x = " + drawPanel.getPoint2().x + "    y = " + drawPanel.getPoint2().y);
		lblPoint.setVisible(true);
	} 
		
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
			
			//공통적인것 밖으로 빼서 중복 줄임 -> 선택적으로 바꿔줌
			subOptionMenuPanel.setVisible(true);
			chkFill.setVisible(false);
			drawPanel.setDrawMode(i);
			
			switch(i){
				case DrawConstants.DOT :
					lblSubOption.setText("Point Size : ");
					break;
				//case DrawConstants.TRI :
				case DrawConstants.RECT :
				case DrawConstants.OVAL :
					chkFill.setVisible(true);
					//lblSubOption.setText("Line Width : ");					
					//break;
				case DrawConstants.ARC :
				case DrawConstants.LINE :
					lblSubOption.setText("Line Width : ");
					break;
				//break 나올때까지 실행 -> 중복적인것은 최대한 줄여줌
							
				default :
					subOptionMenuPanel.setVisible(false);
					drawPanel.Init();
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
				if(chkFill.isSelected()){
					Color cFill = 
					JColorChooser.showDialog(drawPanel, "Pick a Color for Fill!!", drawPanel.getFillColor());
											//parameter = draw 하는 객체, 문자열, 처음에 선택되는 색.
											//draw 하는 객체? == 이 대화상자가 어떤 컴포넌트에 종속되어있는지!
											//getColorSelcted >> drawingPanel에서 색 얻어오기. 전에 선택한 색이 다시 실행되도 나타나도록
					drawPanel.setFillColor(cFill);
				}
				drawPanel.setColorSelected(c);	//선택한 색으로 설정		
				
			}	//if
		}	//actionPerformed()
	}	//OptionActionListener
}	//PrimaryPanel class