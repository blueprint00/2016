import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrimaryPanel extends JPanel{
	
	//data
	private JPanel menuPanel, buttonMenuPanel, optionMenuPanel;
	private JButton[] btnMenuArray;	//�迭 ǥ��/��ü �迭�� �����ϰ� �迭�� ������ �� ��ü�� �����ϰ� ����Ѵ�
	private JPanel subOptionMenuPanel;
	private JLabel lblSubOption;
	private JTextField txtSubOption;
	private JCheckBox chkFill;
	private JButton btnColor;
	
	private DrawingPanel drawPanel;		//�׸� �׸� �г�
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
		buttonMenuPanel.setLayout(new GridLayout(2, 3));	//2�� 3��¥�� gridLayout
		buttonMenuPanel.setBackground(Color.white);
		buttonMenuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		menuPanel.add(buttonMenuPanel);		//menuPanel�� �߰�
		
		//Menu Button
		btnMenuArray = new JButton[6];	//��ü �迭 ����
		for(int i = 0; i < 6; i ++){
			btnMenuArray[i] = new JButton(DrawConstants.MENU[i]);	//��ü���� ����! �򰥸��� ����!
			btnMenuArray[i].setBackground(Color.white);
			btnMenuArray[i].setForeground(Color.blue);
			btnMenuArray[i].addMouseListener(menuMouseL);
			btnMenuArray[i].addActionListener(menuActionL);
			buttonMenuPanel.add(btnMenuArray[i]);	//buttonMenuPanel�� �߰�
		}	//for
		
		//OptionMenuPanel
		optionMenuPanel = new JPanel();
		optionMenuPanel.setBounds(320, 10, 270, 70);
		optionMenuPanel.setLayout(null);
		optionMenuPanel.setBackground(Color.white);
		optionMenuPanel.setBorder(BorderFactory.createTitledBorder("OPTION"));
		menuPanel.add(optionMenuPanel);		//menuPanel�� �߰�
		
		//subOptionMenuPanel
		subOptionMenuPanel = new JPanel();
		subOptionMenuPanel.setBackground(Color.white);
		subOptionMenuPanel.setBounds(5, 15, 260, 30);
		subOptionMenuPanel.setVisible(false);		//�Ⱥ��� > ���⿡ �߰��Ǵ� �͵鵵 ���� �Ⱥ��̹Ƿ� setVisible �� �ʿ� ����
		optionMenuPanel.add(subOptionMenuPanel);	//optionMenuPanel�� �߰�
		
		//subOption
		lblSubOption = new JLabel("Point Size : ");
		subOptionMenuPanel.add(lblSubOption);	//subOptionMenuPanel�� �߰�
		
		txtSubOption = new JTextField(4);
		txtSubOption.setText("2");
		subOptionMenuPanel.add(txtSubOption);	//subOptionMenuPanel�� �߰�
		
		btnColor = new JButton("COLOR");
		btnColor.setFont(new Font("Arial", Font.BOLD, 10));
		btnColor.addActionListener(optionActionL);
		subOptionMenuPanel.add(btnColor);		//subOptionMenuPanel�� �߰�
		
		//checkBox
		chkFill = new JCheckBox("FILL");
		chkFill.setBounds(5, 45, 260, 25);
		chkFill.setBackground(Color.white);
		chkFill.setHorizontalAlignment(SwingConstants.CENTER);	//optionMenuPanel.setLayout(null);
		chkFill.setVisible(false);
		optionMenuPanel.add(chkFill);		//optionMenuPanel�� �߰�
		
		//drawPanel
		drawPanel = new DrawingPanel(this);		//this = PrimaryPanel >> �Ѱ��༭ ���� �����ϵ���
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
		lblCount.setVisible(false);	//ó���� �Ⱥ���
		messagePanel.add(lblCount);
		//lblPoint
		lblPoint = new JLabel();
		lblPoint.setBounds(15, 35, 500, 20);
		lblPoint.setVisible(false);
		messagePanel.add(lblPoint);
		
	}	//PrimaryPanel()
	
	//primaryPanel���� TextField�� ���� �ִ� ���� �����ٰ� ���ڷ� �������ִ� �޼ҵ�
	public int getOption(){
		int option;
		option = Integer.parseInt(txtSubOption.getText());
		return option;
	}	//getOption()
	//üũ�ڽ� üũ ���� Ȯ���ϴ� �޼ҵ�
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
		lblCount.setText("���� ���� >> " + drawPanel.getCnt());		
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
			JButton obj = (JButton)event.getSource();	//�θ� Ŭ����(object)�� JButton���� �ٲ��� �� ����
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
			
			//� ��ư�� �����Ͽ��°�!
			for(i = 0; i < 6; i ++){
				if(obj == btnMenuArray[i]){
					//to do
					break;
				}	//if
			}	//for
			
			//�������ΰ� ������ ���� �ߺ� ���� -> ���������� �ٲ���
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
				//break ���ö����� ���� -> �ߺ����ΰ��� �ִ��� �ٿ���
							
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
										//parameter = draw �ϴ� ��ü, ���ڿ�, ó���� ���õǴ� ��.
										//draw �ϴ� ��ü? == �� ��ȭ���ڰ� � ������Ʈ�� ���ӵǾ��ִ���!
										//getColorSelcted >> drawingPanel���� �� ������. ���� ������ ���� �ٽ� ����ǵ� ��Ÿ������
				if(chkFill.isSelected()){
					Color cFill = 
					JColorChooser.showDialog(drawPanel, "Pick a Color for Fill!!", drawPanel.getFillColor());
											//parameter = draw �ϴ� ��ü, ���ڿ�, ó���� ���õǴ� ��.
											//draw �ϴ� ��ü? == �� ��ȭ���ڰ� � ������Ʈ�� ���ӵǾ��ִ���!
											//getColorSelcted >> drawingPanel���� �� ������. ���� ������ ���� �ٽ� ����ǵ� ��Ÿ������
					drawPanel.setFillColor(cFill);
				}
				drawPanel.setColorSelected(c);	//������ ������ ����		
				
			}	//if
		}	//actionPerformed()
	}	//OptionActionListener
}	//PrimaryPanel class