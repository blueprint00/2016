import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 	//for ArrayList

public class DotDrawPanel extends JPanel{
	
	private Point ptDot;
	private int nDotSize;
	private JTextField txtDot;
	private ArrayList<DotDrawData> dataList;	//ArrayList에 DotDrawData class의 객체를 저장
	//2.선언하고
	private DotListener dotL;
	
	public DotDrawPanel(){
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.white);
		
		//2.생성
		dotL = new DotListener();
		
		//3.
		addMouseListener(dotL);	//앞에 this 생략. 나(panel)에게 add
		
		ptDot = new Point();
		nDotSize = 40;
		
		txtDot = new JTextField(8);
		txtDot.setText("" + nDotSize);
		add(txtDot);
		
		dataList = new ArrayList<DotDrawData>();	//templet? class라 이름일 저렇게 김...	
	}	//DotDrawPanel()
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		page.setColor(Color.blue);
		
		//for(int i = 0; i < dataList.size(); i ++){
		//	DotDrawData data = dataList.get(i);	// i = index
		for(DotDrawData data : dataList) {	//위의 두 줄을 이 한줄로...	
			page.fillOval(data.getX() - data.getSize()/2,
						  data.getY() - data.getSize()/2,
						  data.getSize(),
						  data.getSize());	//클릭한 곳을 중심으로 원 그려줌
		}
	}	//paintComponent()
	
	//1. Listener Class
	private class DotListener implements MouseListener {
		//4.
		public void mousePressed(MouseEvent event){	}
		public void mouseReleased(MouseEvent event){ }
		public void mouseClicked(MouseEvent event){	
			if(event.getButton() == MouseEvent.BUTTON1) {//왼쪽 버튼으로만 누르고 싶을때/1 = Left Button, 2 = ?, 3 = ?
				ptDot = event.getPoint();	//매번 입력 받을 댸마다 새로운 객체가 됨...
				//ptDot.x = event.getX();
				//ptDot.y = event.getY();
				//이렇게 할거면 ptDot객체를 매번 생성해줘야 함. 아니면 입력 받을 때마다 x, y값 같아짐.
				nDotSize = Integer.parseInt(txtDot.getText());
				
				dataList.add(new DotDrawData(ptDot, nDotSize));	//dataList에 저장 -> DotDrawData의 객체가 저장!
				
				repaint();	//paintComponent method call -> 다시 그림
				// 즉 좌표 설정하고 다시 그려줌
			}
		}	//mouseClicked()
		public void mouseEntered(MouseEvent event){	}
		public void mouseExited(MouseEvent event){ }
		
	}	//DotListener
	
}	//DotDrawPanel class