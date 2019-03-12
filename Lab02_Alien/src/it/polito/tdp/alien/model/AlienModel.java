package it.polito.tdp.alien.model;

import java.security.InvalidParameterException;

import it.polito.tdp.alien.AlienDictionary;

public class AlienModel {

	private AlienDictionary alienDictionary;
	
	
	
	public AlienModel() {
		this.alienDictionary = new AlienDictionary();
	}

	public void newDictionary() {
		alienDictionary.clear();		
	}

	public String traduci(String testoInserito) {
		testoInserito = testoInserito.toLowerCase();
		if(!inserimentoValido(testoInserito)) {
			throw new IllegalArgumentException(String.format("Devi inserire un testo esclusivamente"
					+ "alfabetico!"));
		}
		
		String words[] = testoInserito.split(" ");
//		System.out.println(testoInserito+"-"+words.length+"-"+words[0]+"-"+words[1]);
		
		
		if(words.length==1) {
			String traduzione = alienDictionary.translateWord(words[0]);
				if(traduzione==null)
					return "Non risulta nota la traduzione della parola \" "+words[0]+" \""+"\n";			
				else
					return "Traduzione di \" "+words[0]+"\": "+traduzione+"\n";
		} else {
			alienDictionary.addWord(words[0], words[1]);
			return "Inserita:\n"+"Traduzione di \" "+words[0]+" \": "+words[1]+"\n";
		}
	}

	public boolean inserimentoValido(String testoInserito) {
		for (char c : testoInserito.toCharArray()) {
		    if(!((Character.isAlphabetic(c))|| Character.compare(c, ' ')==0)) {
		    	return false;
		    }
		}
		return true;
	}

}
