package lesson3;

import java.util.*;

/**
 * @author liva
 */
public class ProgramLauncher {

	public static void main(String[] args) {

		String[] words = {
				"cat",
				"dog",
				"cat",
				"dog",
				"dog",
				"kitty",
				"dog",
				"cat",
				"parrot"
		};

		Arrays.sort(words, String::compareToIgnoreCase);

		System.out.print("Исходный массив:");
		for (String word : words) {
			System.out.print(" " + word);
		}
		System.out.println();

		Map<String, Integer> repeatWords = new HashMap<>();

		String repeats = words[0];
		int count = 0;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(repeats)) {
				count++;
			}
			else {
				repeatWords.put(repeats, count);

				count = 1;
				repeats = words[i];
			}

			if (i == words.length - 1) {
				repeatWords.put(words[i], count);
			}
		}

		System.out.print("Список уникальных слов массива: ");

		for (String key : repeatWords.keySet()) {
			if (repeatWords.get(key) == 1) {
				System.out.print(" " + key);
			}
		}
		System.out.println();

		System.out.println("Число повторений слов массива: " + repeatWords);

		Phonebook phonebook = new Phonebook();
		phonebook.add("Куликов", 434434);
		phonebook.add("Петров", 414343);
		phonebook.add("Петров", 234434);
		phonebook.add("Иванов", 234344);
		System.out.println("Номера телефона абонента Петров: " + phonebook.get("Петров"));
		System.out.println("Номера телефона абонента Куликов: " + phonebook.get("Куликов"));
	}
}
