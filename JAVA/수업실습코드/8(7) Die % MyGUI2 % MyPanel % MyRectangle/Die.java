/**
 *java applet이 되려면 상속 받아야 함
 *application이 되려면 main이 존재
 * => 둘 다 없으면 단순 클래스 파일
 */
 
 public class Die{

	/* data */
	private int faceValue;	//public = 접근제어자
	//캡슐화에 의거해서 instance data 는 private로 보호
	//method는 ...		
	
	/* method */
	
	//1. constructor
	//1-1. default constructor	
	public Die(){ // class name과 같은 메소드 = 생성자
			//instance data initialize
		faceValue = 1;
			
	}	// Die 생성자
	
	//1-2. parameter constructor
	public Die(int value){
		faceValue = (value > 6)? 6 : value;
		faceValue = (faceValue < 1) ? 1 : faceValue;
	}	// Die();
	// C++, java는 함수 테이블을 만들때 함수 이름 뿐 아니라 파라미터 같이 들어감 => 함수 이름 같아도 파라미터 다르면 다른 함수
	// 생성자 중복 정의(method overloadng, overriding(상속?), ~~~)
	
	//2. get/set methods (=> data를 private으로 보호하므로 값을 변경하기 위해......)
	public int getFaceValue(){ return faceValue; }
	public void setFaceValue(int value){
		faceValue = (value < 1) ? 1 : value;
		faceValue  = (faceValue > 6) ? 6 : faceValue;
	}
	
	
	public int roll(){
		
		faceValue = (int) (Math.random() * 6 + 1);	//객체 생성 없이 바로 메소드 호출해서 쓸 수 있다
										// = next. ...? 0 ~ 9.99999
										// 0.0 ~ 5.99999 => (int로 캐스팅) 0 ~ 5 => 1 ~ 6 괄호조심!
																
					
		return faceValue;
		
	}	// roll method
}	// Die class

