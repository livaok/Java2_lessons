package lesson5;


/**
 * @author liva
 */
public class TimeCalculator {

	static final int size = 1000000;
	static final int half = size / 2;
	float[] arr      = new float[size];
	float[] arrHalf1 = new float[half];
	float[] arrHalf2 = new float[half];

	private void calculateFunction(float[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
	}

	void calculateTime1() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}

		long a = System.currentTimeMillis();
		calculateFunction(arr);
		System.currentTimeMillis();
		System.out.println("Calculate time 1 = " + (System.currentTimeMillis() - a));
	}

	void calculateTime2() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}

		long a = System.currentTimeMillis();
		System.arraycopy(arr, 0, arrHalf1, 0, half);
		System.arraycopy(arr, half, arrHalf2, 0, half);

		new Thread(() -> {
			calculateFunction(arrHalf1);
		}).start();

		new Thread(() -> {
			calculateFunction(arrHalf2);
		}).start();

		System.arraycopy(arrHalf1, 0, arr, 0, half);
		System.arraycopy(arrHalf2, 0, arr, half, half);
		System.currentTimeMillis();
		System.out.println("Calculate time 2 = " + (System.currentTimeMillis() - a));
	}
}
