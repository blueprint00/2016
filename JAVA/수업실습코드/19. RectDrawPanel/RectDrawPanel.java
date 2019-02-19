import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 	//for ArrayList

public class RectDrawPanel extends JPanel{
	
	//private Point ptLine1, ptLine2;
	private LineListener lineL;
	private JTextField txtLineWidth;
	//private int nLineWidth;
	private ArrayList<RectDrawData> dataList;
	private RectDrawData dataNow;	//���� ���� �����ϱ� ����
	
	public RectDrawPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		
		lineL = new LineListener();
		addMouseListener(lineL);
		addMouseMotionListener(lineL);
		
		//ptLine1 = new Point();
		//ptLine2 = new Point();
		
		//nLineWidth = 1;
		dataNow = new RectDrawData();	//���� ������
		
		txtLineWidth = new JTextField(6);	//��ȣ �� ���ڴ� ĭ ��
		txtLineWidth.setText(Integer.toString(dataNow.getWidth()));		//�̷��Ե� ���ڿ��� ���ڿ��� �ٲ� like( "" + nLineWidth)
		add(txtLineWidth);
		
		dataList = new ArrayList<RectDrawData>();	//array
	}	//LineDrawPanel()
	
	//���������θ� ȣ���� method
	//�簢�� ���� �������� �׸��� �����ϰ� �ϴ� method
	private void drawRectangle(Graphics page, Point pt1, Point pt2){
		int x, y, width, height;
		x = y = width = height = 0;
		
		if(pt1.x < pt2.x && pt1.y < pt2.y){
			x = pt1.x;
			y = pt1.y;
			width = pt2.x - pt1.x;
			height = pt2.y - pt1.y;
		}else if (pt1.x < pt2.x && pt1.y > pt2.y){
			x = pt1.x;
			y = pt2.y;
			width = pt2.x - pt1.x;
			height = pt1.y - pt2.y;
		}else if (pt1.x > pt2.x && pt1.y < pt2.y){
			x = pt2.x;
			y = pt1.y;
			width = pt1.x - pt2.x;
			height = pt2.y - pt1.y;
		}else if (pt1.x > pt2.x && pt1.y > pt2.y){
			x = pt2.x;
			y = pt2.y;
			width = pt1.x - pt2.x;
			height = pt1.y - pt2.y;
		}//if... else
		
		page.drawRect(x, y, width, height);	
		//page.drawOval(x, y, width, height); <- ���׸���
	}	//drawRectangle()
	
	public void paintComponent(Graphics page){	//�β� 2D ��ü ���� ����!
		super.paintComponent(page);
		
		Graphics2D page2 = (Graphics2D)page;
		
		//page2.setStroke(new BasicStroke(nLineWidth));
		//page.drawLine(ptLine1.x, ptLine1.y, ptLine2.x, ptLine2.y);
		page2.setStroke(new BasicStroke(dataNow.getWidth()));		//������width ����
		drawRectangle(page, dataNow.getPointOne(), dataNow.getPointTwo());		//�簢�� �׷��ִ� method ȣ��
		/*page.drawRect(dataNow.getPointOneX(),
					  dataNow.getPointOneY(),
					  dataNow.getPointTwoX() - dataNow.getPointOneX(),
					  dataNow.getPointTwoY() - dataNow.getPointOneY());
					  */
		for(RectDrawData data : dataList){		//�迭�� ����... �ε��� �ϳ��� �Ѿ��.... >> ����ϱ�
			page2.setStroke(new BasicStroke(data.getWidth()));
			drawRectangle(page, data.getPointOne(), data.getPointTwo());
			/*page.drawRect(data.getPointOneX(),
						  data.getPointOneY(),
						  data.getPointTwoX() - data.getPointOneX(),
						  data.getPointTwoY() - data.getPointOneY());
						  */
		}
	}//paintComponent
	
	private class LineListener implements MouseListener, MouseMotionListener{	//interface�� ������ ����
		//MouseListener's method
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){
			dataNow = new RectDrawData();	//press �� �� ���� ���ο� ��ü ���� -> ����
				
			//ptLine1 = event.getPoint();
			dataNow.setPointOne(event.getPoint());		//press�� ���� event getPoint�� dataNow�� setPoint
			//ptLine1.setWidth(Integer.parseInt(txtLineWidth.getText()));
			dataNow.setWidth(Integer.parseInt(txtLineWidth.getText()));		//���ڿ� ���ڿ��� �ٲ���
			
		}	//mousePressed()
		public void mouseReleased(MouseEvent event){
			//ptLine2 = event.getPoint();
			//dataList.add(new LineDrawData(PtLine1, ptLine2, nLineWidth));
			dataNow.setPointTwo(event.getPoint());	//released �� �� event getPoint�� dataNow�� setPoint
			dataList.add(dataNow);	//dataNow�� LineDrawData�� ��ü dataList�� add. => dataNow�� LineDrawData�� ��ü!
			
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