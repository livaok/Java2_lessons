package lesson5;



/**
 * @author liva
 */
public class TimeCalculator {

	static final int     size = 100000;
	static final int     half = size / 2;
	static       float[] arr  = new float[size];

	private void fillArray(float[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
	}

	public static void calculateFunction(float[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
	}

	void calculateTime1() {
		fillArray(arr);
		long a = System.currentTimeMillis();
		calculateFunction(arr);
		System.currentTimeMillis();
		System.out.println("Calculate time 1 = " + (System.currentTimeMillis() - a));
	}

	void calculateTime2() {
		fillArray(arr);
		long a = System.currentTimeMillis();

		Thread thread1 = new Thread(new CalculationRunnable(arr, 0, half));
		Thread thread2 = new Thread(new CalculationRunnable(arr, half, half));
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Calculate time 2 = " + (System.currentTimeMillis() - a));
	}
}
