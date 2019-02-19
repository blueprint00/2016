import java.awt.*;
import javax.swing.*;

public class MenuThread extends JLabel implements Runnable{
	private Thread numberThread;
	private PrimaryPanel primary;
	private int delayTime;
	
	public MenuThread(){
		numberThread = null;
		delayTime = 50;
	}
	public MenuThread(PrimaryPanel p){
		numberThread = null;
		delayTime = 50;
		primary = p;
	}	
	
	public void start(){
		if(numberThread == null){
			numberThread = new Thread(this);
		}
		numberThread.start();
	}
	public void stop(){
		if(numberThread != null)
			numberThread.stop();
	}
	public void run(){
		try{
			setForeground(Color.red);
			for(int i = 0; i < 10 ; i++){
				setVisible(false);
				numberThread.sleep(delayTime);
				setVisible(true);
				numberThread.sleep(delayTime);
			}
			numberThread = null;
		}catch(Exception e){}
	}
	
}