public class DrawConstants{	
	static public final String[] MENU = {"DOT", "LINE", "RECT", "OVAL", "", ""};
	
	//final 붙이면 상수 취급, 값을 못 바꿈.그래서 public으로 써도 가능
	
	//static 붙이면 객체 없이 class name으로 바로 접근 가능하다.
	static public final int DOT = 0;
	static public final int LINE = 1;
	static public final int RECT = 2;
	static public final int OVAL = 3;
	
	static public final int NONE = 6;
}	//DrawConstants class