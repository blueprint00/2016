import java.awt.*;
import javax.swing.*;

public class HighLowGameApplet extends JApplet{
	
	private HighLowPanel primary;
	
	public void init(){
		primary = new HighLowPanel();
		getContentPane().add(primary);	//�տ� this ����, this = HIghLowGameapplet
	}	//init() => constuctor
	
}	//HighLowGameApplet class

//heavy container -> no constructor