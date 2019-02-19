/**
 *java applet�� �Ƿ��� ��� �޾ƾ� ��
 *application�� �Ƿ��� main�� ����
 * => �� �� ������ �ܼ� Ŭ���� ����
 */
 
 public class Die{

	/* data */
	private int faceValue;	//public = ����������
	//ĸ��ȭ�� �ǰ��ؼ� instance data �� private�� ��ȣ
	//method�� ...		
	
	/* method */
	
	//1. constructor
	//1-1. default constructor	
	public Die(){ // class name�� ���� �޼ҵ� = ������
			//instance data initialize
		faceValue = 1;
			
	}	// Die ������
	
	//1-2. parameter constructor
	public Die(int value){
		faceValue = (value > 6)? 6 : value;
		faceValue = (faceValue < 1) ? 1 : faceValue;
	}	// Die();
	// C++, java�� �Լ� ���̺��� ���鶧 �Լ� �̸� �� �ƴ϶� �Ķ���� ���� �� => �Լ� �̸� ���Ƶ� �Ķ���� �ٸ��� �ٸ� �Լ�
	// ������ �ߺ� ����(method overloadng, overriding(���?), ~~~)
	
	//2. get/set methods (=> data�� private���� ��ȣ�ϹǷ� ���� �����ϱ� ����......)
	public int getFaceValue(){ return faceValue; }
	public void setFaceValue(int value){
		faceValue = (value < 1) ? 1 : value;
		faceValue  = (faceValue > 6) ? 6 : faceValue;
	}
	
	
	public int roll(){
		
		faceValue = (int) (Math.random() * 6 + 1);	//��ü ���� ���� �ٷ� �޼ҵ� ȣ���ؼ� �� �� �ִ�
										// = next. ...? 0 ~ 9.99999
										// 0.0 ~ 5.99999 => (int�� ĳ����) 0 ~ 5 => 1 ~ 6 ��ȣ����!
																
					
		return faceValue;
		
	}	// roll method
}	// Die class

