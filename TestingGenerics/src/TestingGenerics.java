

public class TestingGenerics<T> {

	public static void main(String[] args) {
		TestingGenerics<Integer> runnerGenerics = new TestingGenerics<Integer>();
		//TestingGenerics runnerGenerics = new TestingGenerics();
		runnerGenerics.test();
	}
	
	public void test() {
		Object[] array = new Object[5];
		
		Custom[] val3 = (Custom[])array;
		
		//throws class cast exception
		//Integer [] val = (Integer[]) array;
		//works well
		Custom val2 = (Custom)array[0];
	}
	
	class Custom{
		int[] array;
	}
}
