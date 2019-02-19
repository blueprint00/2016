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
	private RectDrawData dataNow;	//현재 값을 저장하기 위한
	
	public RectDrawPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		
		lineL = new LineListener();
		addMouseListener(lineL);
		addMouseMotionListener(lineL);
		
		//ptLine1 = new Point();
		//ptLine2 = new Point();
		
		//nLineWidth = 1;
		dataNow = new RectDrawData();	//현재 데이터
		
		txtLineWidth = new JTextField(6);	//괄호 안 숫자는 칸 수
		txtLineWidth.setText(Integer.toString(dataNow.getWidth()));		//이렇게도 숫자열이 문자열로 바뀜 like( "" + nLineWidth)
		add(txtLineWidth);
		
		dataList = new ArrayList<RectDrawData>();	//array
	}	//LineDrawPanel()
	
	//내부적으로만 호출할 method
	//사각형 여러 방향으로 그리기 가능하게 하는 method
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
		//page.drawOval(x, y, width, height); <- 원그리기
	}	//drawRectangle()
	
	public void paintComponent(Graphics page){	//두께 2D 객체 쓰면 가능!
		super.paintComponent(page);
		
		Graphics2D page2 = (Graphics2D)page;
		
		//page2.setStroke(new BasicStroke(nLineWidth));
		//page.drawLine(ptLine1.x, ptLine1.y, ptLine2.x, ptLine2.y);
		page2.setStroke(new BasicStroke(dataNow.getWidth()));		//설정된width 얻어옴
		drawRectangle(page, dataNow.getPointOne(), dataNow.getPointTwo());		//사각형 그려주는 method 호출
		/*page.drawRect(dataNow.getPointOneX(),
					  dataNow.getPointOneY(),
					  dataNow.getPointTwoX() - dataNow.getPointOneX(),
					  dataNow.getPointTwoY() - dataNow.getPointOneY());
					  */
		for(RectDrawData data : dataList){		//배열로 저장... 인덱스 하나씩 넘어가며.... >> 기억하기
			page2.setStroke(new BasicStroke(data.getWidth()));
			drawRectangle(page, data.getPointOne(), data.getPointTwo());
			/*page.drawRect(data.getPointOneX(),
						  data.getPointOneY(),
						  data.getPointTwoX() - data.getPointOneX(),
						  data.getPointTwoY() - data.getPointOneY());
						  */
		}
	}//paintComponent
	
	private class LineListener implements MouseListener, MouseMotionListener{	//interface는 여러개 가능
		//MouseListener's method
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){
			dataNow = new RectDrawData();	//press 할 떄 마다 새로운 객체 생성 -> 저장
				
			//ptLine1 = event.getPoint();
			dataNow.setPointOne(event.getPoint());		//press될 때의 event getPoint를 dataNow에 setPoint
			//ptLine1.setWidth(Integer.parseInt(txtLineWidth.getText()));
			dataNow.setWidth(Integer.parseInt(txtLineWidth.getText()));		//문자열 숫자열로 바꿔줌
			
		}	//mousePressed()
		public void mouseReleased(MouseEvent event){
			//ptLine2 = event.getPoint();
			//dataList.add(new LineDrawData(PtLine1, ptLine2, nLineWidth));
			dataNow.setPointTwo(event.getPoint());	//released 될 때 event getPoint를 dataNow의 setPoint
			dataList.add(dataNow);	//dataNow를 LineDrawData의 객체 dataList에 add. => dataNow는 LineDrawData의 객체!
			
			repaint();	
		}	//mouseRelieased()
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		
		//MouseMotionListener's method
		public void mouseMoved(MouseEvent event){}
		public void mouseDragged(MouseEvent event){
			//ptLine2 = event.getPoint();	//drag할 떄의 좌표 얻음 -> 바뀌면서 선 그림
			dataNow.setPointTwo(event.getPoint());
			repaint();
		}	//mouseDragged()
	}//LineListener class
		
}	//LineDrawPanel class