import java.awt.*;
import javax.swing.*;

public class HighLowGameApplet extends JApplet{
	
	private HighLowPanel primary;
	
	public void init(){
		primary = new HighLowPanel();
		getContentPane().add(primary);	//앞에 this 생략, this = HIghLowGameapplet
	}	//init() => constuctor
	
}	//HighLowGameApplet class

//heavy container -> no constructor