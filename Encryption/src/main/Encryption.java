package main;

import java.util.*;

public class Encryption {

	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private char[] letters;
	private String encrypted;
	private String decrypted;

	public Encryption() {
		list = new ArrayList<>();
		shuffledList = new ArrayList<>();
		character = ' ';

		newKey();

		getKey();

		encrypt("Hello World!");
		
		decrypt();
	}
	
	public static Encryption start() {
		return new Encryption();
	}

	private void newKey() {

		character = ' ';
		list.clear();
		shuffledList.clear();

		for (int i = 32; i < 127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}

		shuffledList = new ArrayList<>(list);
		Collections.shuffle(shuffledList);

	};

	private void getKey() {
		System.out.println();
		for (Character x : list) {
			System.out.print(x);
		}
		System.out.println();
		for (Character x : shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	};

	private void encrypt(String message) {

		letters = message.toCharArray();

		for (int i = 0; i < letters.length; i++) {

			for (int j = 0; j < list.size(); j++) {
				if (letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}

		}
		this.encrypted = String.valueOf(letters);

		System.out.print(encrypted);
		System.out.println();
	};

	private void decrypt() {
		letters = encrypted.toCharArray();

		for (int i = 0; i < letters.length; i++) {

			for (int j = 0; j < shuffledList.size(); j++) {
				if (letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}

		}

		this.decrypted = String.valueOf(letters);
		System.out.println(decrypted);
		System.out.println();
	};

}
