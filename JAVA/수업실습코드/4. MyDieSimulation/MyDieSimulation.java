import java.util.Random; //.* 하면 모든 클래스 import, 메모리 아끼려면 클래스 이름으로...
 
public class MyDieSimulation{
	
	public static void main(String[] args){
			
			int faceValue, sum = 0, count = 0;
			Random gen = new Random();
			
			for(int i = 0; i < 100000; i++){
				
				sum = 0;	// sum(제어변수) initialize checking important!
					
				while(sum < 100){	
					faceValue = gen.nextInt(6) + 1;	// one of 1~6
					sum += faceValue;
					count++;
				}	// while
			
			}	// for
		
		System.out.println("COUNT >>" + (count/100000.0));
		
	}	// main	
	
}	// MyDieSimulation class