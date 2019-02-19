import java.awt.*;	//for Point, Color class 

public class DrawData{
	
	private int nDrawMode;
	private Point ptOne, ptTwo;
	private int nOption;
	private Color colorSelected, colorFill;
	private boolean bFill;
	
	public DrawData(){
		nDrawMode = DrawConstants.NONE;
		ptOne = new Point();
		ptTwo = new Point();
		nOption = 1;
		colorSelected = Color.black;//= new Color(0, 0, 0);	
		bFill = false;
	}//default constructor
	
	public DrawData(int mode, Point pt1, Point pt2, int option, Color c, boolean fill){
		nDrawMode = mode;
		ptOne = pt1; ptTwo = pt2;
		nOption = option;
		colorSelected = c;
		bFill = fill;
	}	//parameter constructor
	public DrawData(DrawData data){	//copy
		nDrawMode = data.getDrawMode();
		ptOne = data.getPointOne();
		ptTwo = data.getPointTwo();
		nOption = data.getOption();
		colorSelected = data.getColorSelected();
		bFill = data.getFill();
	}	//DrawData
	
	//get/set
	public int getDrawMode()		{return nDrawMode;}
	public Point getPointOne()		{return ptOne;}
	public Point getPointTwo()		{return ptTwo;}
	public int getOption()			{return nOption;}
	public Color getColorSelected()	{return colorSelected;}
	public Color getFillColorSelected()	{return colorFill;}
	public boolean getFill()		{return bFill;}
	public void setDrawMode(int mode) {nDrawMode = mode;}
	public void setPointOne(Point pt) {ptOne = pt;}
	public void setPointTwo(Point pt) {ptTwo = pt;}
	public void setOption(int option) {nOption = option;}
	public void setColorSelected(Color c) {colorSelected = c;}
	public void setFillColorSelected(Color c)	{colorFill = c;}
	public void setFill(boolean fill) {bFill = fill;}
	
}	//DrawData class