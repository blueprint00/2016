import java.awt.Point;

public class RectDrawData{
	
	private Point ptOne, ptTwo;
	private int nWidth;
	
	public RectDrawData(){
		ptOne = new Point();
		ptTwo = new Point();
		nWidth = 1;
	}
	public RectDrawData(Point pt1, Point pt2, int width){
		ptOne = pt1;
		ptTwo = pt2;
		nWidth = width;
	}
	
	public Point getPointOne() {return ptOne;}
	public Point getPointTwo() {return ptTwo;}
	public int getWidth() {return nWidth;}
	public int getPointOneX() {return ptOne.x;}
	public int getPointOneY() {return ptOne.y;}
	public int getPointTwoX() {return ptTwo.x;}
	public int getPointTwoY() {return ptTwo.y;}
	
	public void setPointOne(Point pt){ptOne = pt;}
	public void setPointTwo(Point pt) {ptTwo = pt;}
	public void setWidth(int width) {nWidth = width;}
	public void setPoints(Point pt1, Point pt2){
		ptOne = pt1;
		ptTwo = pt2;
	}
	
}