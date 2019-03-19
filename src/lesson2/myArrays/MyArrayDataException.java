package lesson2.myArrays;

/**
 * @author liva
 */
public class MyArrayDataException extends NumberFormatException {

	public MyArrayDataException(String[][] ss, int i, int j) {

		System.err.println(String.format("Ошибка в ячейке [%d][%d]", i, j));
	}
}
