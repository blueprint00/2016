import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel{
	
	public DrawPanel(){
		setPreferredSize(new Dimension(400, 300));
		setBackground(Color.white);
	}
	
	public void paintComponent(Graphics page){
		
		super.paintComponent(page);	//super class. parent class == JPanel
		//reference type(= pointer) => 부모에게 붓(=page)을 줌, 권한설정
		
		//drawing...
		page.setColor(Color.red);
		page.setFont(new Font("Verdana", Font.BOLD, 20));
		page.drawString("SEJONG UNIV.", 60, 60);
		
		page.setColor(Color.blue);
		page.drawString("Hong,gildong", 60, 100);
		
		page.setColor(Color.green);
		page.fillRect(200, 120, 120, 140);
		
		
	}	//paintComponent()	
	
}	// DrawPanel class