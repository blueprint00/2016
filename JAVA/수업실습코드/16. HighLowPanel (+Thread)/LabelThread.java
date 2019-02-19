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
		//setText(str);	//나에게 있는 문자열 데이터에 설정
		super(str);		//부모(JLabel)를 통해 데이터에 설정/ 결과는 둘이 같
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
		//labelThread에  ?
		//생성된 객체를 받아서 사용할 수도 있음
		//HighLowPanel의 this를 보냄 -> 직접 사용 할 수 있음!
	}
	
	public void start(){
		if(numberThread == null) {
			numberThread = new Thread(this);
		}	// if
		numberThread.start();		
	}	//start()/thread 하나를 생성하고 연결
	
	public void stop(){
		if(numberThread != null) numberThread.stop();	
	}
	
	public void run(){
		try{
			for(int i = startNumber; i <= finishNumber; i++){
				setText("" + i);
				numberThread.sleep(delayTime);	//잠. delayTime동안.(ms) if delayTime = 1000 = 1s.
			}	//for
			setForeground(Color.red);
			for(int i = 0 ; i < 20; i++){
				setVisible(false);
				numberThread.sleep(50);	//delay (0.5s)
				setVisible(true);
				numberThread.sleep(50);	//delay
			}
			
			primary.continueGame();		//모든 thread가 종료되고 난 후 대화상자 뜸
			
		}catch(Exception e) {}
		//안의 코드를 시도해 봄. 만약 문제가 발생하면 밑의 중괄호에서 처리해줌.
		
	}	//run()
	
}	//LabelThread class