import java.awt.*;
import javax.swing.*;

public class someThread extends JLabel implements Runnable{
	
	private int startNum, finishNum;
	private int delayTime;
	private Thread numberThread;
	private PrimaryPanel primary;
	private DrawingPanel drawPanel;
	
	public someThread(){
		startNum = finishNum = 1;
		delayTime = 1000;
		numberThread = null;
	}	
	public someThread(PrimaryPanel p){
		startNum = finishNum = 1;
		delayTime = 1000;
		numberThread = null;
		primary = p;
	}
	
	public int getStartNum() { return startNum; }
	public int getFinishNum() {return finishNum;}
	public int getDelayTim() {return delayTime;}
	public void setStartFinishNum(int s, int f) {
		startNum = s;
		finishNum = f;
	}
	public void setDelayTime(int d){
		delayTime = d;
	}
	public void setThis(PrimaryPanel p){
		primary = p;
	}
	public void setNumberThread(){
		numberThread = null;
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
			//for(int i = startNum; i < finishNum; i++){
			for(int i = 10; i > 0; i--){	
				setVisible(false);
				numberThread.sleep(50);
				setVisible(true);
				numberThread.sleep(50);
			}
			numberThread = null;
		}catch(Exception e){}
	}
	
}