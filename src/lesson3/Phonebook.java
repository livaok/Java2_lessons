package lesson3;


import java.util.*;

/**
 * @author liva
 */
public class Phonebook {

	private Map<Integer, String> data = new HashMap<>();

	public List<Integer> get(String name) {
		if (data.isEmpty()) {
			return Collections.emptyList();
		}

		List<Integer> numbers = new ArrayList<>();

		for (Map.Entry<Integer, String> pair : data.entrySet()) {
			if (name.equals(pair.getValue())) {
				numbers.add(pair.getKey());
			}
		}

		return numbers;
	}

	public void add(String name, Integer telephone) {

		if (name == null || name.trim().length() == 0) {
			{
				throw new IllegalArgumentException("Проверьте правильность введенного имени пользователя");
			}
		}

		if (telephone == null || telephone <= 0) {
			throw new IllegalArgumentException("Проверьте правильность введенного телефона пользователя");
		}

		data.put(telephone, name);
	}
}
