package lesson3;

import java.util.*;

/**
 * @author liva
 */
public class ProgramLauncher {

	public static void main(String[] args) {

		String[] words = new String[10];
		words[0] = "kitty";
		words[1] = "cat";
		words[2] = "kitty";
		words[3] = "cat";
		words[4] = "cat";
		words[5] = "parrot";
		words[6] = "cat";
		words[7] = "dog";
		words[8] = "cat";
		words[9] = "cat";

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
				count = 0;
				count++;
				repeatWord = word;
			}
			repeatWords.put(word, count);
		}

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
		phonebook.get("Петров");
		phonebook.get("Куликов");
	}
}
