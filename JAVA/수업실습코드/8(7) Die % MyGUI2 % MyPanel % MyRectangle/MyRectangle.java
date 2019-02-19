public class MyRectangle{
	
	//data
	private int width;	//m_~~ = member, instance data
	private int height;
	
	//method
	//1. constructor
	//1-1. default constructor
	public MyRectangle(){
		width = 1;
		height = 1;		
	}	//MyRectangle()
	
	//1-2. parameter constructor
	public MyRectangle(int w, int h){
		width = (w < 1) ? 1 : w;
		height = (h < 1) ? 1 : h;		
	}	//MyRectangle
	//width, height == instance data, w, h == local instance(메소드내에서만 사용)
	
	//2. get/set methods
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	public void setWidth(int w) { width = (w < 1) ? 1 : w; }
	public void setHeight(int h) { height = (h < 1) ? 1 : h; }
	public void setSize(int w, int h) {
		width = (w < 1) ? 1 : w;
		height = (h < 1) ? 1 : h;
	}
	
	//3. other methods
	public int calcArea() {
		int area = width * height;
		return area;
	}	// calcArea()
	
	public int calcPerimeter(){
		int perimeter = (width + height) * 2;
		return perimeter;
	}	//calcPerimeter()
	
	public boolean isRect(){
		boolean bReturn;
		
		if( width == height) bReturn = true;
		else bReturn = false;
		
		return bReturn;
	}
	
	// 4. toString()
	public String toString(){
		String str = "(" + width + "," + height + ")";
		return str;		
	}	//toString()
	
}	// MyRectangle class