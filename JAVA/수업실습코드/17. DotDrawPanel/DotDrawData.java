import java.awt.Point;	//Point class needs awt

public class DotDrawData{	//data 저장하기 위한 클래스
	
	//data
	private Point ptDot;
	private int nDotSize;
	
	//method
	//1.constructor
	public DotDrawData(){
		ptDot= new Point();
		nDotSize = 40;	
	}	//DotDrawData()
	public DotDrawData(Point pt, int size){
		ptDot = pt;
		nDotSize = size;
	}	//DotDrawData()
	
	//2.get/set
	public Point getPoint() {return ptDot;}
	public int getX() 		{return ptDot.x;}
	public int getY() 		{return ptDot.y;}
	public int getSize() 	{return nDotSize;}
	public void setPoint(Point pt)  {ptDot = pt;}
	public void setX(int x)			{ptDot.x = x;}
	public void setY(int y) 		{ptDot.y = y;}
	public void setSize(int size) 	{nDotSize = size;}
	public void setData(Point pt, int size){
		ptDot = pt;
		nDotSize = size;
	}
	public void setData(int x, int y, int size){
		ptDot.x = x;
		ptDot.y = y;
		nDotSize = size;
	}
	
	
	
}//DotDrawData Class