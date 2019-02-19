import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;		//for ArrayList

public class DrawingPanel extends JPanel{
	
	private PrimaryPanel primary;	//instance data�� ���� �����ϰ� -> �����͸� ������ �� ���� 
	private DrawData nowData;
	private ArrayList<DrawData> dataList;	//ArrayList
	private int cnt = 0;
	
	//Listener
	private DrawListener drawL;
	
	//constructor
	public DrawingPanel(PrimaryPanel p){
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 400));
	
		primary = p;	//primaryPanel Ŭ���� ���� ���� �ϵ��� �Ѱ� ����
		
		//Listener �߰�
		drawL = new DrawListener();
		addMouseListener(drawL);
		addMouseMotionListener(drawL);
	
		nowData = new DrawData();		//���� �Է� ��
		dataList = new ArrayList<DrawData>();	//array
	}	//DrawingPanel()

	public void setDrawMode(int mode){
		nowData.setDrawMode(mode);
	}	//setDrawMode
	public void setColorSelected(Color c){
		nowData.setColorSelected(c);
	}	//setColorSelected
	public void setFillColor(Color c){
		nowData.setFillColor(c);
	}	//setColorSelectedFill	
	public Color getColorSelected(){
		return nowData.getColorSelected();
	}	//getColorSelected
		//���� ������ ���� �ٽ� ��ȭ���� �������� ���� ��Ÿ������
	public Color getFillColor(){
		return nowData.getFillColor();
	}
	public int getCnt(){ return cnt; }
	public Point getPoint1() { return nowData.getPointOne();}
	public Point getPoint2() { return nowData.getPointTwo();}
	
	//���������θ� ȣ���� method
	//�簢�� ���� �������� �׸� �� �ֵ��� 
	private void drawRectangle(Graphics page, Point pt1, Point pt2, boolean fill){
		int x, y, width, height;
		x = y = width = height = 0;
		
		//���� ��ǥ�� ���� ����, ���̴� ��ǥ�� ū�ſ��� ������ �� ��
		if(pt1.x < pt2.x && pt1.y < pt2.y){
			x = pt1.x;
			y = pt1.y;
			width = pt2.x - pt1.x;
			height = pt2.y - pt1.y;
		} else if (pt1.x < pt2.x && pt1.y > pt2.y){
			x = pt1.x;
			y = pt2.y;
			width = pt2.x - pt1.x;
			height = pt1.y - pt2.y;
		} else if (pt1.x > pt2.x && pt1.y < pt2.y){
			x = pt2.x;
			y = pt1.y;
			width = pt1.x - pt2.x;
			height = pt2.y - pt1.y;
		} else if (pt1.x > pt2.x && pt1.y > pt2.y){
			x = pt2.x;
			y = pt2.y;
			width = pt1.x - pt2.x;
			height = pt1.y - pt2.y;
		}
		
		if(fill){
			page.drawRect(x, y, width, height);
			page.setColor(getFillColor());
			page.fillRect(x, y, width, height);	//chkFill�� üũ ���� ��
		}
		else page.drawRect(x, y, width, height);
	}	//drawRectangle()
	
	private void drawOVAL(Graphics page, Point pt1, Point pt2, boolean fill){
		int x, y, width, height;
		x = y = width = height = 0;
		
		//���� ��ǥ�� ���� ����, ���̴� ��ǥ�� ū�ſ��� ������ �� ��
		if(pt1.x < pt2.x && pt1.y < pt2.y){
			x = pt1.x;
			y = pt1.y;
			width = pt2.x - pt1.x;
			height = pt2.y - pt1.y;
		} else if (pt1.x < pt2.x && pt1.y > pt2.y){
			x = pt1.x;
			y = pt2.y;
			width = pt2.x - pt1.x;
			height = pt1.y - pt2.y;
		} else if (pt1.x > pt2.x && pt1.y < pt2.y){
			x = pt2.x;
			y = pt1.y;
			width = pt1.x - pt2.x;
			height = pt2.y - pt1.y;
		} else if (pt1.x > pt2.x && pt1.y > pt2.y){
			x = pt2.x;
			y = pt2.y;
			width = pt1.x - pt2.x;
			height = pt1.y - pt2.y;
		}
		
		if(fill) page.fillOval(x, y, width, height);	//chkFill�� üũ ���� ��
		else page.drawOval(x, y, width, height);
	}	//drawRectangle()
	
	private void drawTriangle(Graphics page, Point pt1, Point pt2, boolean fill){
		int width = 0;
		Point a, b, c;
		a = new Point();
		b = new Point();
		c = new Point();
		
		//���� ��ǥ�� ���� ����, ���̴� ��ǥ�� ū�ſ��� ������ �� ��
		if(pt1.x < pt2.x && pt1.y < pt2.y){
			width = pt2.x - pt1.x;
			a.x = pt2.x - width/2; a.y = pt1.y;
			b.x = pt1.x; b.y = pt2.y;
			c = pt2;
		} else if (pt1.x < pt2.x && pt1.y > pt2.y){
			width = pt2.x - pt1.x;
			a.x = pt2.x - width/2; a.y = pt2.y;
			b = pt1;
			c.x = pt2.x; c.y = pt1.y;
		} else if (pt1.x > pt2.x && pt1.y < pt2.y){
			width = pt1.x - pt2.x;
			a.x = pt1.x - width/2; a.y = pt1.y;
			b = pt2;
			c.x = pt1.x; c.y = pt2.y;
		} else if (pt1.x > pt2.x && pt1.y > pt2.y){
			width = pt1.x - pt2.x;
			a.x = pt1.x - width/2; a.y = pt2.y;
			b.x = pt2.x; b.y = pt1.y;
			c = pt1;
		}
		
		//if(fill) page.fillOval(x, y, width, height);	//chkFill�� üũ ���� ��
		//else page.drawOval(x, y, width, height);
		page.drawLine(a.x, a.y, b.x, b.y);
		page.drawLine(a.x, a.y, c.x, c.y);
		page.drawLine(c.x, c.y, b.x, b.y);
	}	//drawTriangle()
	
	private void drawARC(Graphics page, Point pt1, Point pt2){
		int x, y, width, height, angle1, angle2;
		x = y = width = height = angle1 = 0;
		angle2 = 90;
		
		//���� ��ǥ�� ���� ����, ���̴� ��ǥ�� ū�ſ��� ������ �� ��
		if(pt1.x < pt2.x && pt1.y < pt2.y){
			width = pt2.x - pt1.x;
			height = pt2.y - pt1.y;
			x = pt1.x - width;
			y = pt1.y - height;
			angle1 = 270;
		} else if (pt1.x < pt2.x && pt1.y > pt2.y){
			width = pt2.x - pt1.x;
			height = pt1.y - pt2.y;
			x = pt1.x - width;
			y = pt2.y;
			angle1 = 0;
		} else if (pt1.x > pt2.x && pt1.y < pt2.y){
			width = pt1.x - pt2.x;
			height = pt2.y - pt1.y;
			x = pt2.x;
			y = pt1.y - height;
			angle1 = 180;
		} else if (pt1.x > pt2.x && pt1.y > pt2.y){
			width = pt1.x - pt2.x;
			height = pt1.y - pt2.y;
			x = pt2.x;
			y = pt2.y;
			angle1 = 90;
		}
		
		page.drawArc(x, y, width * 2, height * 2, angle1, angle2);
		
	}	//drawARC()	
	
	public void Init(){
		dataList.clear();
		repaint();
		setColorSelected(Color.black);
		primary.initOption();	
		cnt = 0;	
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		//boundary
		page.setColor(Color.darkGray);
		page.drawRect(0, 0, getWidth() - 1, getHeight() - 1);	//(this.)getWidth(height) = my width(height)�� drawRect
																//primaryPanel Ŭ�������� ���ǵ� drawingPanel�� ũ�⸦ get�Ѵ�
		//�������� �͵� ���ֱ�
		Graphics2D page2 = (Graphics2D)page;	//reference -> page���� �ش� �޼ҵ�� ������ page2���� ����
		page.setColor(nowData.getColorSelected());	//����� ���� �� �޾ƿ���

		//now data
		switch(nowData.getDrawMode()){
			case DrawConstants.DOT :	//Dot
				page.fillOval(nowData.getPointOne().x - nowData.getOption()/2,
							  nowData.getPointOne().y - nowData.getOption()/2,	//���콺 Ŀ�� ����� ���� �ϱ�
							  nowData.getOption(),
							  nowData.getOption());			
				break;
			case DrawConstants.LINE :	//Line
				//page2 = (Graphics2D)page;	//reference -> page���� �ش� �޼ҵ�� ������ page2���� ����
				page2.setStroke(new BasicStroke(nowData.getOption()));	//���� �β� ����, ���� �̹� switch�� ������ ��...
				page.drawLine(nowData.getPointOne().x,
							  nowData.getPointOne().y,
							  nowData.getPointTwo().x,
							  nowData.getPointTwo().y);				
				break;
			case DrawConstants.RECT :	//Rect
				//page2 = (Graphics2D)page;
				page2.setStroke(new BasicStroke(nowData.getOption()));
				drawRectangle(page, nowData.getPointOne(), nowData.getPointTwo(), nowData.getFill());			
				break;
			case DrawConstants.OVAL :	//Oval
				page2.setStroke(new BasicStroke(nowData.getOption()));
				drawOVAL(page, nowData.getPointOne(), nowData.getPointTwo(), nowData.getFill());
				break;
			/*case DrawConstants.TRI :	//Triangle
				page2.setStroke(new BasicStroke(nowData.getOption()));
				drawTriangle(page, nowData.getPointOne(), nowData.getPointTwo(), nowData.getFill());
				break;*/
			case DrawConstants.ARC :	//arc
				page2.setStroke(new BasicStroke(nowData.getOption()));
				drawARC(page, nowData.getPointOne(), nowData.getPointTwo());
				break;
			case DrawConstants.INIT :	//init
				//Init();
				break;
		}	//switch
		
		//saved data
		//for(int i = 0; i < dataList.size(); i ++){
		//	DrawData data = dataList.get(i);	// i = index
		for(DrawData savedData : dataList){		//������ �� ���ٷ�... -> ����
			page.setColor(savedData.getColorSelected());
			switch(savedData.getDrawMode()){
				case DrawConstants.DOT :
					page.fillOval(savedData.getPointOne().x - savedData.getOption()/2,
								  savedData.getPointOne().y - savedData.getOption()/2,	//���콺 Ŀ�� ����� ���� �ϱ�
								  savedData.getOption(),
								  savedData.getOption());
					break;
				case DrawConstants.LINE :
					//page2 = (Graphics2D)page;	//reference -> page���� �ش� �޼ҵ�� ������ page2���� ����
					page2.setStroke(new BasicStroke(savedData.getOption()));	//���� �β� ����, ���� �̹� switch�� ������ ��...
					page.drawLine(savedData.getPointOne().x,
								  savedData.getPointOne().y,
								  savedData.getPointTwo().x,
								  savedData.getPointTwo().y);
					break;
				case DrawConstants.RECT :
					page2.setStroke(new BasicStroke(savedData.getOption()));
					drawRectangle(page,
								  savedData.getPointOne(),
								  savedData.getPointTwo(),
								  savedData.getFill());
					break;
				case DrawConstants.OVAL :
					page2.setStroke(new BasicStroke(savedData.getOption()));
					drawOVAL(page,
							  savedData.getPointOne(),
							  savedData.getPointTwo(),
							  savedData.getFill());
					break;
				/*case DrawConstants.TRI :	//Triangle
					page2.setStroke(new BasicStroke(savedData.getOption()));
					drawTriangle(page, savedData.getPointOne(), savedData.getPointTwo(), savedData.getFill());
					break;*/
				case DrawConstants.ARC :	//arc
					page2.setStroke(new BasicStroke(savedData.getOption()));
					drawARC(page, savedData.getPointOne(), savedData.getPointTwo());
					break;
				case DrawConstants.INIT :	//init
					Init();	
					break;
			}	//switch
		}	//for
	}	//paintComponent()
	
	//�޴� ���� ���� �׸� �׸� �� �ְ� �ɼ� ���� �� �Ѱ��ִ� ������
	private class DrawListener implements MouseListener, MouseMotionListener{
		//MouseListener's method
		public void mouseClicked(MouseEvent event){
			if(nowData.getDrawMode() == DrawConstants.DOT){	//DOT
				nowData.setPointOne(event.getPoint());		//event �Ǵ� ��ǥ�� ����
				nowData.setOption(primary.getOption());		//PrimaryPanel Ŭ�������� ��� �ɼ����� �ɼ� ����
				dataList.add(new DrawData(nowData));	//WELL-DEFINED >> ��ü�� ArrayList�� �׻� ���� �����ؼ� add 
				/*dataList.add(new DrawData(nowData.getDrawMode(),
										  nowData.getPointOne(),
										  nowData.getPointTwo(),
										  nowData.getOption(),
										  nowData.getColorSelected(),
										  nowData.getFill()));*/
				repaint();	//paintComponent method call -> �ٽ� �׸�
							//�� ��ǥ �����ϰ� �ٽ� �׷���
			}	//if
		}
		public void mousePressed(MouseEvent event){
			if(nowData.getDrawMode() == DrawConstants.LINE ||
				nowData.getDrawMode() == DrawConstants.RECT ||
				nowData.getDrawMode() == DrawConstants.OVAL ||
				//nowData.getDrawMode() == DrawConstants.TRI || 
				nowData.getDrawMode() == DrawConstants.ARC){
					nowData.setPointOne(event.getPoint());	//event �Ǵ� ��ǥ�� ����
					nowData.setOption(primary.getOption());
					nowData.setFill(primary.getFill());		//PrimaryPanel Ŭ�������� ��� �ɼ����� �ɼ� ����
			}	//if
		}	//mousePressed()
		public void mouseReleased(MouseEvent event){
			if(nowData.getDrawMode() == DrawConstants.LINE ||
				nowData.getDrawMode() == DrawConstants.RECT ||
				nowData.getDrawMode() == DrawConstants.OVAL ||
				//nowData.getDrawMode() == DrawConstants.TRI || 		
				nowData.getDrawMode() == DrawConstants.ARC){
					nowData.setPointTwo(event.getPoint());	//event �Ǵ� ��ǥ�� ����
					dataList.add(new DrawData(nowData));	//saved
					cnt++;
					primary.setMessage();
					repaint();		//�ٽ� �׸�
			}	//if
		}	//mouseReleased()
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		
		//MouseMotionListener's method
		public void mouseDragged(MouseEvent event){
			if(nowData.getDrawMode() == DrawConstants.LINE ||
				nowData.getDrawMode() == DrawConstants.RECT ||
				nowData.getDrawMode() == DrawConstants.OVAL ||
				//nowData.getDrawMode() == DrawConstants.TRI || 				
				nowData.getDrawMode() == DrawConstants.ARC){
				nowData.setPointTwo(event.getPoint());	//event �Ǵ� ��ǥ�� ����
				primary.setPointTwoMessage();
				repaint();		// = �巡�� �߿��� ��� �׸�
			}	//if
		}	//MouseDragged
		public void mouseMoved(MouseEvent event){
			nowData.setPointOne(event.getPoint());
			primary.setPointMessage();
		}		
	}
		
}	//DrawingPanel class