package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
//	private String singleTranslation;
	private List<String> translation; // = new LinkedList<String>();
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
//		this.singleTranslation = translation;
		this.translation = new LinkedList<String>();
		addWord(translation);
	}
	
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public void addWord(String translation) {
		this.translation.add(translation);
	}

	public List<String> getTranslation() {
		return translation;
	}

	public void setTranslation(List<String> translation) {
		this.translation = translation;
	}

	@Override
	public boolean equals(Object obj) {
		String parola = (String) obj;
		if(parola.compareTo(alienWord)==0)
			return true;
		else
			return false;
	}
	
	

}

