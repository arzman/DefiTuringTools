package main;

public class PrintTool {

	public static void printArray(long[] array) {

		System.out.print("(");
		for (long l : array) {
			System.out.print(l + ",");
		}
		System.out.println(")");

	}

	public static void printArray(int[] array) {

		System.out.print("(");
		for (int l : array) {
			System.out.print(l + ",");
		}
		System.out.println(")");

	}

}
