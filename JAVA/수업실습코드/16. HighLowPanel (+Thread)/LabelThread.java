import java.awt.*;
import javax.swing.*;

public class LabelThread extends JLabel implements Runnable{
	
	//data
	private int startNumber, finishNumber;
	private int delayTime;
	private Thread numberThread;
	private HighLowPanel primary;
	
	//method
	//constructor
	public LabelThread(){
		startNumber = finishNumber = 1;
		delayTime = 1000;
		numberThread = null;
	}	//LabelThread()
	public LabelThread(int start, int finish){
		startNumber = start;
		finishNumber = finish;
		delayTime = 1000;
		numberThread = null;
	}
	public LabelThread(int start, int finish, int delay){
		startNumber = start;
		finishNumber = finish;
		delayTime = delay;
		numberThread = null;
	}
	public LabelThread(String str){
		//setText(str);	//������ �ִ� ���ڿ� �����Ϳ� ����
		super(str);		//�θ�(JLabel)�� ���� �����Ϳ� ����/ ����� ���� ��
		startNumber = finishNumber = 1;
		delayTime = 1000;
		numberThread = null;
	}
	public LabelThread(HighLowPanel p){
		startNumber = finishNumber = 1;
		delayTime = 1000;
		numberThread = null;
		primary = p;
	}
		
	
	//get/set
	public int getStartNumber()		{return startNumber;}
	public int getFinishNumber()	{return finishNumber;}
	public int getDelayTime()		{return delayTime;}
	public void setStartNumber(int start)	{ startNumber = start;}
	public void setFinishNumber(int finish) {finishNumber = finish;}
	public void setDelayTime(int delay)		{delayTime = delay;}
	public void setStartFinish(int start, int finish){
		startNumber = start;
		finishNumber = finish;
	}
	
	public void setThis(HighLowPanel p){
		primary = p;
		//labelThread��  ?
		//������ ��ü�� �޾Ƽ� ����� ���� ����
		//HighLowPanel�� this�� ���� -> ���� ��� �� �� ����!
	}
	
	public void start(){
		if(numberThread == null) {
			numberThread = new Thread(this);
		}	// if
		numberThread.start();		
	}	//start()/thread �ϳ��� �����ϰ� ����
	
	public void stop(){
		if(numberThread != null) numberThread.stop();	
	}
	
	public void run(){
		try{
			for(int i = startNumber; i <= finishNumber; i++){
				setText("" + i);
				numberThread.sleep(delayTime);	//��. delayTime����.(ms) if delayTime = 1000 = 1s.
			}	//for
			setForeground(Color.red);
			for(int i = 0 ; i < 20; i++){
				setVisible(false);
				numberThread.sleep(50);	//delay (0.5s)
				setVisible(true);
				numberThread.sleep(50);	//delay
			}
			
			primary.continueGame();		//��� thread�� ����ǰ� �� �� ��ȭ���� ��
			
		}catch(Exception e) {}
		//���� �ڵ带 �õ��� ��. ���� ������ �߻��ϸ� ���� �߰�ȣ���� ó������.
		
	}	//run()
	
}	//LabelThread class