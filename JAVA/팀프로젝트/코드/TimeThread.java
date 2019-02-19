import java.awt.*;
import javax.swing.*;

//Time Thread class
public class TimeThread extends JLabel implements Runnable{
	
	private int 			startNumber, finishNumber;	//Time Range
	private int 			delayTime;					//����
	private Thread 			numberThread;				//Thread �ʱ�ȭ ���� ����
	private PupsGamePanel 	primary;					//up-call�� PupsGamePanel �޾ƿ�
	
	//constructor
	public TimeThread() {
		startNumber = 30;
		finishNumber = 0;
		delayTime = 1000;
		numberThread = null;
	}
	public TimeThread(PupsGamePanel p){
		startNumber = 30;
		finishNumber = 0;
		delayTime = 1000;
		numberThread = null;
		primary = p;
	}
	
	//get/set method
	public int getStartNumber()		{return startNumber;}
	public int getFinishNumber()    {return finishNumber;}
	public int getDelayTime()		{return delayTime;}
	public void setStartNumber(int start)	{startNumber = start;}
	public void setFinishNumber(int finish) {finishNumber = finish;}
	public void setDelayTime(int delay)		{delayTime = delay;}
	public void setStartFinish(int start, int finish){
		startNumber = start;
		finishNumber = finish;
	}
	
	public void setThis(PupsGamePanel p){
		primary = p;
	}		//����Ŭ���� �޾ƿ���
	public void setNumberThread(){
		numberThread = null;
	}		//Thread �ʱ�ȭ

	public void start(){
		if(numberThread == null) {
			numberThread = new Thread(this);
		}	// if
		numberThread.start();		
	}	//start()/thread �ϳ��� ����
	public void stop(){
		if(numberThread != null) numberThread.stop();	
	}
	public void run(){
		try{
			for(int i = startNumber; i >= finishNumber; i--) {
				setText("00 : " + i);
				numberThread.sleep(delayTime);	
			}
			setForeground(Color.red);
			for(int i = 0; i<10; i++) {
				setVisible(false);
				numberThread.sleep(100);
				setVisible(true);
				numberThread.sleep(100);
			} //������ ���������� �ٲ��ְ� �����Ÿ��ٰ� ����
			
			//�ð����� == ���ӿ��� ��.
			JOptionPane.showMessageDialog (null, "LOSE T_T");	//Ȯ�� â	
			primary.continueGame();	
			
		}catch(Exception e) {}
	}
}