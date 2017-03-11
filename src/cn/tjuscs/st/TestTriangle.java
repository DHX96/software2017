package cn.tjuscs.st;

public class TestTriangle {
	
	public int getkind(int a, int b, int c)
	{
		int kind = 0;
		if (a+b<=c || a+c<=b || b+c<=a || a<=0 || b<=0 || c<=0)
			kind = -1;	//-1代表三角形不成立
		else if (a==b && b==c)
			kind = 1;  //1代表等边三角形
		else if ((a==b && a!=c) || (a==c && a!=b) || (b==c && b!=a))
			kind = 2; //2代表等腰三角形
		else if (a!=b && b!=c)
			kind = 3; //3代表普通三角形
		
		return kind;
	}
	
	
	
}
