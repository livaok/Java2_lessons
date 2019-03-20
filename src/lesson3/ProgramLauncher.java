package lesson3;

import java.util.*;

/**
 * @author liva
 */
public class ProgramLauncher {

	public static void main(String[] args) {

		String[] words = {
				"kitty",
				"cat",
				"kitty",
				"cat",
				"cat",
				"cat",
				"parrot",
				"dog",
				"cat",
				"cat"
		};

		System.out.println("Исходный массив:");
		for (String word1 : words) {
			System.out.println(word1);
		}

		Arrays.sort(words, String::compareToIgnoreCase);

		Map<String, Integer> repeatWords = new HashMap<>();

		String repeatWord = words[0];
		int count = 0;

		for (String word : words) {
			if (word.equals(repeatWord)) {
				count++;
			}
			else {
				repeatWords.put(repeatWord, count);
				count = 1;
				repeatWord = word;
			}
		}
		repeatWords.put(words[words.length-1], count);

		System.out.println("Список уникальных слов массива:");

		for (String key : repeatWords.keySet()) {
			if (repeatWords.get(key) == 1) {
				System.out.println(key);
			}
		}

		System.out.println("Число повторений слов массива:\n" + repeatWords);

		Phonebook phonebook = new Phonebook();
		phonebook.add("Куликов", 143533);
		phonebook.add("Петров", 111111);
		phonebook.add("Петров", 234434);
		phonebook.add("Иванов", 234344);
		System.out.println("Номера телефонов абонента Петров: " + phonebook.get("Петров"));
		phonebook.get("Куликов");
	}
}
