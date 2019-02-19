import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 	//for ArrayList

public class LineDrawPanel extends JPanel{
	
	//private Point ptLine1, ptLine2;
	private LineListener lineL;
	private JTextField txtLineWidth;
	//private int nLineWidth;
	private ArrayList<LineDrawData> dataList;
	private LineDrawData dataNow;
	
	public LineDrawPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		
		lineL = new LineListener();
		addMouseListener(lineL);
		addMouseMotionListener(lineL);	//Ŭ������ �߰�
		
		//ptLine1 = new Point();
		//ptLine2 = new Point();
		
		//nLineWidth = 1;
		dataNow = new LineDrawData();	//���� ������
		
		txtLineWidth = new JTextField(6);	//()��ȣ �� ���ڴ� ĭ ��
		txtLineWidth.setText(Integer.toString(dataNow.getWidth()));		//�̷��Ե� ���ڿ��� ���ڿ��� �ٲ� like ( "" + nLineWidth)
		add(txtLineWidth);
		
		dataList = new ArrayList<LineDrawData>();	//array
	}	//LineDrawPanel()
	
	public void paintComponent(Graphics page){	//�β� ���� ����.... 2D ��ü ���� ����!
		super.paintComponent(page);
		
		Graphics2D page2 = (Graphics2D)page;	//�������ΰ� ������ ���ֱ�
		
		//page2.setStroke(new BasicStroke(nLineWidth));
		//page.drawLine(ptLine1.x, ptLine1.y, ptLine2.x, ptLine2.y);
		page2.setStroke(new BasicStroke(dataNow.getWidth()));		//������width ����
		page.drawLine(dataNow.getPointOneX(),
					  dataNow.getPointOneY(),
					  dataNow.getPointTwoX(),
					  dataNow.getPointTwoY());
		for(LineDrawData data : dataList){		//�迭�� ����... �ε��� �ϳ��� �Ѿ��.... >> ����ϱ�
			page2.setStroke(new BasicStroke(data.getWidth()));
			page.drawLine(data.getPointOneX(),
						  data.getPointOneY(),
						  data.getPointTwoX(),
						  data.getPointTwoY());
		}
	}//paintComponent
	
	private class LineListener implements MouseListener, MouseMotionListener{	//interface�� ������ ����
		//MouseListener's method
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){
			dataNow = new LineDrawData();	//press �� �� ���� ���ο� ��ü ���� -> ����
				
			//ptLine1 = event.getPoint();
			dataNow.setPointOne(event.getPoint());		//press�� ���� event getPoint�� dataNow�� setPoint
			//ptLine1.setWidth(Integer.parseInt(txtLineWidth.getText()));
			dataNow.setWidth(Integer.parseInt(txtLineWidth.getText()));		//���ڿ� ���ڿ��� �ٲ���
			
		}	//mousePressed()
		public void mouseReleased(MouseEvent event){
			//ptLine2 = event.getPoint();
			//dataList.add(new LineDrawData(PtLine1, ptLine2, nLineWidth));
			dataNow.setPointTwo(event.getPoint());	//released �� �� event getPoint�� dataNow�� setPoint
			dataList.add(dataNow);		//dataNow�� LineDrawData�� ��ü dataList�� add. => dataNow�� LineDrawData�� ��ü!
			
			repaint();	
		}	//mouseRelieased()
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		
		//MouseMotionListener's method
		public void mouseMoved(MouseEvent event){}
		public void mouseDragged(MouseEvent event){
			//ptLine2 = event.getPoint();	//drag�� ���� ��ǥ ���� -> �ٲ�鼭 �� �׸�
			dataNow.setPointTwo(event.getPoint());
			repaint();
		}	//mouseDragged()
	}//LineListener class
		
}	//LineDrawPanel class