package lesson2;

import lesson2.myArrays.MyArrayDataException;
import lesson2.myArrays.MyArraySIzeException;

/**
 * @author liva
 */
public class ProgramLauncher {

	public static String[][] returnMassiv(int i, int j) {

		return new String[i][j];
	}

	public static void sizeMassiv(String[][] ss, int x, int y) throws MyArraySIzeException {

		if (x != 4) {
			throw new MyArraySIzeException();
		}
		if (y != 4) {
			throw new MyArraySIzeException();
		}
	}

	public static int sumElemMassiv(String[][] ss) throws MyArrayDataException {

		int sum = 0;

		for (int i = 0; i < ss.length; i++) {
			for (int j = 0; j < ss[i].length; j++) {
				if (ss[i][j] != null) {
					sum += Integer.parseInt(ss[i][j]);
				}
				else {
					throw new MyArrayDataException(ss, i, j);
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {

		String[][] m = returnMassiv(3, 4);

		try {
			sizeMassiv(m, 3, 4);
		}
		catch (MyArraySIzeException e) {
		}

		String[][] s = new String[2][2];
		s[0][0] = "1";
		s[1][0] = "2";
		s[1][1] = "3";

		try {
			System.out.println(String.format("Сумма элементов массива равна ", sumElemMassiv(s)));
		}
		catch (MyArrayDataException e) {
		}
	}
}
