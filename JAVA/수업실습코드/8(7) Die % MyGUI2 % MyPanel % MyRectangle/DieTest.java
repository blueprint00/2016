public class DieTest{
	
	public static void main(String[] args){
		
		Die d1, d2;
		
		d1 = new Die(-10);
		d2 = new Die(400);
		//생성자가 없으면 자바에서 기본생성자를 하나 넣어줌 -> 객체를 생성했을때 인스턴스 데이터에 대한 것을 초기화
		//driver class = 테스트 하기 위함
		
		System.out.println("Die 1 >> " + d1.getFaceValue());
		System.out.println("Die 2 >> " + d2.getFaceValue());
		System.out.println();
		
		d1.roll();
		d2.roll();
		
		d1.setFaceValue(100);
		
		System.out.println(d1);
		System.out.println(d2);		
		
		//System.out.println("Die Value = " + d1.getFaceValue());
		//System.out.println("Die Value = " + d2.getFaceValue());
						
	}	// main()
}	// DieTest class

//Die class가 제대로 만들어졌는지 확인