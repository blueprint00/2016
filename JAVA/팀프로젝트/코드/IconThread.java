import java.awt.*;
import javax.swing.*;

//Icon 나타나는 Thread class
public class IconThread extends JPanel implements Runnable{
	
	private Thread 			numberThread;		//Thread 초기화 위한 변수
	private PupsGamePanel 	primary;			//PupsGamePanel 받아옴
	private int				startNum, finishNum;//Range
	
	private JButton[]		btnIcon;			//아이콘으로 생성될 버튼
	private int				nIndex;				//생성될 아이콘의 인덱스
	
	//난이도 따라서 나타나는 아이콘 개수, 간격
	private int				index, delayTime;
	
	//constructor
	public IconThread() {
		index = 6;
		btnIcon = new JButton[6];
		for(int i = 0; i < 6; i ++) {
			btnIcon[i] = new JButton(new ImageIcon(PupsConstants.ICON[i]));
			btnIcon[i].setBorder(BorderFactory.createLineBorder(Color.white, 1));
		}		//아이콘 버튼 생성
		nIndex = 0;
		delayTime = 1000;	//1초
		numberThread = null;
		startNum = 30; finishNum = 0;
	}	
	public IconThread(PupsGamePanel p){
		index = 6;
		btnIcon = new JButton[6];		
		for(int i = 0; i < 6; i ++) {
			btnIcon[i] = new JButton(new ImageIcon(PupsConstants.ICON[i]));
			btnIcon[i].setBorder(BorderFactory.createLineBorder(Color.white, 1));
		}		//아이콘 버튼 생성
		nIndex = 0;
		delayTime = 1000;	//1초
		numberThread = null;
		primary = p;
		startNum = 30; finishNum = 0;
	}
	
	public void setLevel(int n, int time, int start){
		index = n;			//배열 제한
		delayTime = time;
		startNum = start;	//나타나는 시간 간격 제한
	}		//Level 따라 나타나고 사라지는 속도 다르게 설정
	
	public void setThis(PupsGamePanel p){
		primary = p;
	}		//상위클래스 받아오기
	public void setNumberThread(){
		numberThread = null;
	}			//Thread 초기화
	
	public void start(){
		if(numberThread == null) {
			numberThread = new Thread(this);
		}	// if
		numberThread.start();		
	}	//start()/thread 하나를 생성
	public void stop(){
		if(numberThread != null) numberThread.stop();	
	}		
	public void run(){
		try{
			for(int i = startNum; i >= finishNum; i--) {
				nIndex = (int)(Math.random() * index);		//index 랜덤하게 생성
				btnIcon[nIndex].setVisible(true);			//랜덤한 아이콘 버튼 보이게 하기
				primary.addIcon(btnIcon[nIndex], nIndex);	//PupsGamePanel로 넘겨줌
				numberThread.sleep(delayTime);
				btnIcon[nIndex].setVisible(false);			//delayTime 지나고 사라짐
			}		
		}catch(Exception e) {}
	}
}