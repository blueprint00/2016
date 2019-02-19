import java.awt.*;
import javax.swing.*;

//Icon ��Ÿ���� Thread class
public class IconThread extends JPanel implements Runnable{
	
	private Thread 			numberThread;		//Thread �ʱ�ȭ ���� ����
	private PupsGamePanel 	primary;			//PupsGamePanel �޾ƿ�
	private int				startNum, finishNum;//Range
	
	private JButton[]		btnIcon;			//���������� ������ ��ư
	private int				nIndex;				//������ �������� �ε���
	
	//���̵� ���� ��Ÿ���� ������ ����, ����
	private int				index, delayTime;
	
	//constructor
	public IconThread() {
		index = 6;
		btnIcon = new JButton[6];
		for(int i = 0; i < 6; i ++) {
			btnIcon[i] = new JButton(new ImageIcon(PupsConstants.ICON[i]));
			btnIcon[i].setBorder(BorderFactory.createLineBorder(Color.white, 1));
		}		//������ ��ư ����
		nIndex = 0;
		delayTime = 1000;	//1��
		numberThread = null;
		startNum = 30; finishNum = 0;
	}	
	public IconThread(PupsGamePanel p){
		index = 6;
		btnIcon = new JButton[6];		
		for(int i = 0; i < 6; i ++) {
			btnIcon[i] = new JButton(new ImageIcon(PupsConstants.ICON[i]));
			btnIcon[i].setBorder(BorderFactory.createLineBorder(Color.white, 1));
		}		//������ ��ư ����
		nIndex = 0;
		delayTime = 1000;	//1��
		numberThread = null;
		primary = p;
		startNum = 30; finishNum = 0;
	}
	
	public void setLevel(int n, int time, int start){
		index = n;			//�迭 ����
		delayTime = time;
		startNum = start;	//��Ÿ���� �ð� ���� ����
	}		//Level ���� ��Ÿ���� ������� �ӵ� �ٸ��� ����
	
	public void setThis(PupsGamePanel p){
		primary = p;
	}		//����Ŭ���� �޾ƿ���
	public void setNumberThread(){
		numberThread = null;
	}			//Thread �ʱ�ȭ
	
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
			for(int i = startNum; i >= finishNum; i--) {
				nIndex = (int)(Math.random() * index);		//index �����ϰ� ����
				btnIcon[nIndex].setVisible(true);			//������ ������ ��ư ���̰� �ϱ�
				primary.addIcon(btnIcon[nIndex], nIndex);	//PupsGamePanel�� �Ѱ���
				numberThread.sleep(delayTime);
				btnIcon[nIndex].setVisible(false);			//delayTime ������ �����
			}		
		}catch(Exception e) {}
	}
}