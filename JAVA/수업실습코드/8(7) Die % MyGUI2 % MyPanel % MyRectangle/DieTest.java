public class DieTest{
	
	public static void main(String[] args){
		
		Die d1, d2;
		
		d1 = new Die(-10);
		d2 = new Die(400);
		//�����ڰ� ������ �ڹٿ��� �⺻�����ڸ� �ϳ� �־��� -> ��ü�� ���������� �ν��Ͻ� �����Ϳ� ���� ���� �ʱ�ȭ
		//driver class = �׽�Ʈ �ϱ� ����
		
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

//Die class�� ����� ����������� Ȯ��