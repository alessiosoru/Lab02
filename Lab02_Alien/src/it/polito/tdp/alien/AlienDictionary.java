package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> dictionary;	
	
	public AlienDictionary() {
		this.dictionary = new LinkedList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		
		alienWord = alienWord.toLowerCase();
		translation = translation.toLowerCase();
		WordEnhanced word = new WordEnhanced(alienWord, translation);
		
		boolean presente = false;
//		int i=0;
		for(WordEnhanced w : dictionary) {
			if(w.equals(alienWord)) {
//				dictionary.set(i, word); // modificava la traduzione di quella precisa parola
				w.addWord(translation); // aggiunge una traduzione multipla alla parola già presente
				presente=true;
				break;
			}
		}
		
		if(presente == false)
			dictionary.add(word);
		
	}

	public List<String> translateWord (String alienWord) {
		for(WordEnhanced w : dictionary) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				return w.getTranslation();
		}
		return null;
	}

	public void clear() {
		dictionary.clear();		
	}
}
