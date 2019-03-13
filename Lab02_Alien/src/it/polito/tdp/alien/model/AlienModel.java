package it.polito.tdp.alien.model;

import java.util.List;

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
			List<String> traduzione = alienDictionary.translateWord(words[0]);
			if(traduzione==null)
				return "Non risulta nota la traduzione della parola \" "+words[0]+" \""+"\n";			
			else {
				String traduzioni = "Traduzione di \" "+words[0]+"\": \n";
				for(String w : traduzione){
					traduzioni = traduzioni + w +"\n";
					}
				return traduzioni;
				
			}
		} else {
			alienDictionary.addWord(words[0], words[1]);
			return "Nuovo inserimento:\n"+"Traduzione di \" "+words[0]+" \": "+words[1]+"\n";
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
