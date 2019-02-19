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
		addMouseMotionListener(lineL);	//클래스에 추가
		
		//ptLine1 = new Point();
		//ptLine2 = new Point();
		
		//nLineWidth = 1;
		dataNow = new LineDrawData();	//현재 데이터
		
		txtLineWidth = new JTextField(6);	//()괄호 안 숫자는 칸 수
		txtLineWidth.setText(Integer.toString(dataNow.getWidth()));		//이렇게도 숫자열이 문자열로 바뀜 like ( "" + nLineWidth)
		add(txtLineWidth);
		
		dataList = new ArrayList<LineDrawData>();	//array
	}	//LineDrawPanel()
	
	public void paintComponent(Graphics page){	//두께 설정 못함.... 2D 객체 쓰면 가능!
		super.paintComponent(page);
		
		Graphics2D page2 = (Graphics2D)page;	//공통적인거 밖으로 빼주기
		
		//page2.setStroke(new BasicStroke(nLineWidth));
		//page.drawLine(ptLine1.x, ptLine1.y, ptLine2.x, ptLine2.y);
		page2.setStroke(new BasicStroke(dataNow.getWidth()));		//설정된width 얻어옴
		page.drawLine(dataNow.getPointOneX(),
					  dataNow.getPointOneY(),
					  dataNow.getPointTwoX(),
					  dataNow.getPointTwoY());
		for(LineDrawData data : dataList){		//배열로 저장... 인덱스 하나씩 넘어가며.... >> 기억하기
			page2.setStroke(new BasicStroke(data.getWidth()));
			page.drawLine(data.getPointOneX(),
						  data.getPointOneY(),
						  data.getPointTwoX(),
						  data.getPointTwoY());
		}
	}//paintComponent
	
	private class LineListener implements MouseListener, MouseMotionListener{	//interface는 여러개 가능
		//MouseListener's method
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event){
			dataNow = new LineDrawData();	//press 될 때 마다 새로운 객체 생성 -> 저장
				
			//ptLine1 = event.getPoint();
			dataNow.setPointOne(event.getPoint());		//press될 때의 event getPoint를 dataNow에 setPoint
			//ptLine1.setWidth(Integer.parseInt(txtLineWidth.getText()));
			dataNow.setWidth(Integer.parseInt(txtLineWidth.getText()));		//문자열 숫자열로 바꿔줌
			
		}	//mousePressed()
		public void mouseReleased(MouseEvent event){
			//ptLine2 = event.getPoint();
			//dataList.add(new LineDrawData(PtLine1, ptLine2, nLineWidth));
			dataNow.setPointTwo(event.getPoint());	//released 될 때 event getPoint를 dataNow의 setPoint
			dataList.add(dataNow);		//dataNow를 LineDrawData의 객체 dataList에 add. => dataNow는 LineDrawData의 객체!
			
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