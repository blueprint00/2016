public class MyRectangleTest{
	
	public static void main(String[] args){
		
		MyRectangle rect1, rect2;
		
		rect1 = new MyRectangle();
		rect2 = new MyRectangle(-10, 10);
		
		System.out.println(rect1);
		System.out.println(rect2);
		
		rect1.setSize(2, 4);
		rect2.setWidth(6);
		
		System.out.println(rect1 + " >> " + rect1.calcArea());
		System.out.println(rect2 + " >> " + rect2.calcArea());
		
	}	//main()
	
}	//MyRectangleTest class