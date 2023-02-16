package test03;

public class Test2_거스름돈2 {
	public static void main(String[] args) {
	
		int money = 800;
		
		int c500 = money / 500;
		money -= c500 * 500;
		
		int c400 = money / 400;
		money -= c400 * 400;
		
		int c100 = money / 100;
		money -= c100 * 100;
		
		int c50 = money / 50;
		money -= c50 * 50;
		
		int c10 = money / 10;
		money -= c10 * 10;
		
		System.out.printf("500원: %d\n", c500);
		System.out.printf("400원: %d\n", c400);
		System.out.printf("100원: %d\n", c100);
		System.out.printf(" 50원: %d\n", c50);
		System.out.printf(" 10원: %d\n", c10);
		
		
	}
}
