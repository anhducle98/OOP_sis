package hust.edu;

import java.util.Scanner;

public class IO {
	public static Scanner reader = new Scanner(System.in);

	public static void println(Object s) {
		System.out.println(s);
	}

	public static String readString(String message) {
		System.out.print(message);
		return reader.nextLine();
	}

	public static int readInt(String message) {
		System.out.print(message);
		int res = reader.nextInt();
		reader.nextLine();
		return res;
	}
}
