package lesson5;

/**
 * @author liva
 */
class CalculationRunnable implements Runnable {

	float[] array;
	int     begin;
	int     length;

	CalculationRunnable(float[] array, int begin, int length) {
		this.array = array;
		this.begin = begin;
		this.length = length;
	}

	@Override
	public void run() {
		float[] arrayHelp = new float[array.length / 2];
		System.arraycopy(array, begin, arrayHelp, 0, length);
		TimeCalculator.calculateFunction(arrayHelp);
		System.arraycopy(arrayHelp, 0, array, begin, length);
	}
}