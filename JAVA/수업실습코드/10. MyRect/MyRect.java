import java.awt.*;

public class MyRect{
	
	// data
	private Point pt; //instance data(global)
	private int width, height;
	
	// method
	//1. constructor
	public MyRect() {
		pt = new Point(); // pt.x, pt.y are initialized 0
		width = height = 1;
	}	// MyRect()
	public MyRect(Point pt){	//pt = local data
		this.pt = pt; //both local data(in method, local data first) => this == class data
			//class.pt = method.pt
			//이미 pt가 메인에서 생성이 되어서 넘어오므로 따로 생성 안해줘도 됨
		width = height = 1;
	}	//MyRect()
	public MyRect(int w, int h) {
		pt = new Point();	// 그러나 얘는 생성 안 되있으므로 생성 해줌!
		width = (w < 1)? 1 : w;
		height = (h < 1) ? 1 : h;
	}	//MyRect()
	public MyRect (Point pt, int w, int h){
		this.pt = pt;
		width = (w < 1)? 1 : w;
		height = (h < 1) ? 1 : h;		
	}	//MyRect()
	public MyRect(int x, int y, int w, int h){
		pt.x = x;
		pt.y = y;
		width = (w < 1)? 1 : w;
		height = (h < 1) ? 1 : h;		
	}	//MyRect()
	
	// 2. get/set method =>generally, same as private data 
	public Point getPoint()	{return pt;}
	public int getWidth()	{return width;}
	public int getHeight()	{return height;}
	public int getX()		{return pt.x;}
	public int getY()		{return pt.y;}
	public void setPoint(Point pt)	{this.pt = pt;}
	public void setWidth (int w)	{width = (w < 1) ? 1 : w;}
	public void setHeight(int h)	{height = (h < 1) ? 1 : h;}
	public void setX(int x)			{pt.x = x;}
	public void setY(int y)			{pt.y = y;}
	public void setSize(int w, int h){
		width = (w < 1)? 1 : w;
		height = (h < 1) ? 1 : h;		
	}	
	public void setPosition(int x, int y){
		pt.x = x;
		pt.y = y;
	}
	public void setBounds(Point pt, int w, int h){
		this.pt = pt;
		width = (w < 1)? 1 : w;
		height = (h < 1) ? 1 : h;		
	}
	public void setBounds(int x, int y, int w, int h){
		pt.x = x;
		pt.y = y;
		width = (w < 1)? 1 : w;
		height = (h < 1) ? 1 : h;		
	}
	
	//3. other
	public int calcArea() { return (width * height);}
	public int calcPerimter() {return (width * 2 + height* 2); }
	public boolean isPTInRect(Point pt){
		if(this.pt.x <= pt.x && (this.pt.x + width) >= pt.x && this.pt.y <= pt.y && (this.pt.y + height) >= pt.y){
			return true;
		} else {
			return false;
		}
	}	// isPTInRect()	
	
	// 4. toString
	public String toString(){
		String str = "(" + pt.x + ", " + pt.y + ", " + width + "," + height + ")";
		return str;
	}	//toString()
	
	
	
}	// MyRect class