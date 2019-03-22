package lesson3;


import java.util.*;

/**
 * @author liva
 */
public class Phonebook {

	private Map<Integer, String> data = new HashMap<>();
	private List<Integer> numbers = new ArrayList<>();

	public List<Integer> get(String name) {
		Set<Map.Entry<Integer, String>> entrySet = data.entrySet();
		for (Map.Entry<Integer, String> pair : entrySet) {
			if (name.equals(pair.getValue())) {
				numbers.add(pair.getKey());
			}
		}
		return numbers;
	}

	public void add(String name, Integer telephone) {
		data.put(telephone, name);
	}
}
