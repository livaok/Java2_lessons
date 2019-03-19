package lesson3;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liva
 */
public class Phonebook {

	private Map<Integer, String> data = new HashMap<>();

	void get(String name) {
		Set<Map.Entry<Integer, String>> entrySet = data.entrySet();
		for (Map.Entry<Integer, String> pair : entrySet) {
			if (name.equals(pair.getValue())) {
				System.out.println(String.format("Номер телефона абонента %s: %s",name, pair.getKey()));
			}
		}
	}

	void add(String name, Integer telephone) {
		data.put(telephone, name);
	}
}
