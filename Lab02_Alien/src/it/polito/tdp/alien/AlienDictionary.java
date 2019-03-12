package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> dictionary;	
	
	public AlienDictionary() {
		this.dictionary = new LinkedList<Word>();
	}

	public void addWord(String alienWord, String translation) {
		
		alienWord = alienWord.toLowerCase();
		translation = translation.toLowerCase();
		Word word = new Word(alienWord, translation);
		
		boolean presente = false;
		int i=0;
		for(Word w : dictionary) {
			if(w.equals(alienWord)) {
				dictionary.set(i, word);
				presente=true;
				break;
			}
		}
		
		if(presente == false)
			dictionary.add(word);
		
	}

	public String translateWord (String alienWord) {
		for(Word w : dictionary) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				return w.getTranslation();
		}
		return null;
	}

	public void clear() {
		dictionary.clear();		
	}
}
