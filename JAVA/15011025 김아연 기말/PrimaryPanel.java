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
	private JButton btnFill;
	
	private DrawingPanel drawPanel;		//�׸� �׸� �г�
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
		
		//Color Button
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
		
		//Fill Color button
		btnFill = new JButton("FILL COLOR");
		btnFill.setBounds(120, 35, 100, 25); 
		btnFill.setFont(new Font("Arial", Font.BOLD, 10));
		btnFill.addActionListener(optionActionL);
		btnFill.setVisible(false);	//ó���� ������ ����
		optionMenuPanel.add(btnFill);
		
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
		
		lblPrintMenu = new MenuThread(this);
		lblPrintMenu.setBounds(10, 10, 200, 30);
		lblPrintMenu.setVisible(false); //ó���� �� ����
		messagePanel.add(lblPrintMenu);
		
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
	//init/set/set
	
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
			
			if(chkFill.isSelected()){	//chkFill�� ���õǸ�
				btnFill.setVisible(true); //��
				chkFill.setBounds(5, 45, 100, 25);
				btnFill.setBounds(135, 45, 100, 25);
			} else{
				btnFill.setVisible(false); //�Ⱥ���
				chkFill.setBounds(5, 45, 260, 25);
			}
			//üũ ���ڸ��� ��ư�� �ٷ� ���� ������ RECT�� OVAL �޴� ��ư�� �� �� �� ������ ���� �� �־��....
			
			//�������ΰ� ������ ���� �ߺ� ���� -> ���������� �ٲ���
			subOptionMenuPanel.setVisible(true);
			chkFill.setVisible(false);
			drawPanel.setDrawMode(i);
			btnColor.setText("COLOR");		
			btnColor.setForeground(Color.black);	//btnColor foreground color	
			lblPrintMenu.setVisible(true);		//������ ����
			lblPrintMenu.start();		//������ ��ŸƮ
		
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
				//break ���ö����� ���� -> �ߺ����ΰ��� �ִ��� �ٿ���
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
										//parameter = draw �ϴ� ��ü, ���ڿ�, ó���� ���õǴ� ��.
										//draw �ϴ� ��ü? == �� ��ȭ���ڰ� � ������Ʈ�� ���ӵǾ��ִ���!
										//getColorSelcted >> drawingPanel���� �� ������. ���� ������ ���� �ٽ� ����ǵ� ��Ÿ������
				drawPanel.setColorSelected(c);	//������ ������ ����	
				btnColor.setForeground(c);	//btnColor foreground color
			} else if(obj == btnFill){
				Color cFill =
				JColorChooser.showDialog(drawPanel, "Pick a Color!!", drawPanel.getFillColorSelected());
										//parameter = draw �ϴ� ��ü, ���ڿ�, ó���� ���õǴ� ��.
										//draw �ϴ� ��ü? == �� ��ȭ���ڰ� � ������Ʈ�� ���ӵǾ��ִ���!
										//getColorSelcted >> drawingPanel���� �� ������. ���� ������ ���� �ٽ� ����ǵ� ��Ÿ������
				drawPanel.setFillColorSelected(cFill);	//������ ������ ����	
				btnFill.setForeground(cFill);	//btnColor foreground color
			}	//if
				
		}	//actionPerformed()
	}	//OptionActionListener
}	//PrimaryPanel class