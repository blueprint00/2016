import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 	//for ArrayList

public class DotDrawPanel extends JPanel{
	
	private Point ptDot;
	private int nDotSize;
	private JTextField txtDot;
	private ArrayList<DotDrawData> dataList;	//ArrayList�� DotDrawData class�� ��ü�� ����
	//2.�����ϰ�
	private DotListener dotL;
	
	public DotDrawPanel(){
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.white);
		
		//2.����
		dotL = new DotListener();
		
		//3.
		addMouseListener(dotL);	//�տ� this ����. ��(panel)���� add
		
		ptDot = new Point();
		nDotSize = 40;
		
		txtDot = new JTextField(8);
		txtDot.setText("" + nDotSize);
		add(txtDot);
		
		dataList = new ArrayList<DotDrawData>();	//templet? class�� �̸��� ������ ��...	
	}	//DotDrawPanel()
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		page.setColor(Color.blue);
		
		//for(int i = 0; i < dataList.size(); i ++){
		//	DotDrawData data = dataList.get(i);	// i = index
		for(DotDrawData data : dataList) {	//���� �� ���� �� ���ٷ�...	
			page.fillOval(data.getX() - data.getSize()/2,
						  data.getY() - data.getSize()/2,
						  data.getSize(),
						  data.getSize());	//Ŭ���� ���� �߽����� �� �׷���
		}
	}	//paintComponent()
	
	//1. Listener Class
	private class DotListener implements MouseListener {
		//4.
		public void mousePressed(MouseEvent event){	}
		public void mouseReleased(MouseEvent event){ }
		public void mouseClicked(MouseEvent event){	
			if(event.getButton() == MouseEvent.BUTTON1) {//���� ��ư���θ� ������ ������/1 = Left Button, 2 = ?, 3 = ?
				ptDot = event.getPoint();	//�Ź� �Է� ���� �۸��� ���ο� ��ü�� ��...
				//ptDot.x = event.getX();
				//ptDot.y = event.getY();
				//�̷��� �ҰŸ� ptDot��ü�� �Ź� ��������� ��. �ƴϸ� �Է� ���� ������ x, y�� ������.
				nDotSize = Integer.parseInt(txtDot.getText());
				
				dataList.add(new DotDrawData(ptDot, nDotSize));	//dataList�� ���� -> DotDrawData�� ��ü�� ����!
				
				repaint();	//paintComponent method call -> �ٽ� �׸�
				// �� ��ǥ �����ϰ� �ٽ� �׷���
			}
		}	//mouseClicked()
		public void mouseEntered(MouseEvent event){	}
		public void mouseExited(MouseEvent event){ }
		
	}	//DotListener
	
}	//DotDrawPanel class