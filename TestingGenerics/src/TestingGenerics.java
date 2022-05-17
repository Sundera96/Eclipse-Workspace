

public class TestingGenerics {

	public static void main(String[] args) {
		long val = 2147483647;
		val+=10;
		System.out.println(val);
		
		int[] arr = new int[Math.abs((int) val)];
	}
}
