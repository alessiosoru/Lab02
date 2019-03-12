package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class

 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import it.polito.tdp.alien.model.AlienModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienModel model;
	


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane boxControlloInserimento;

    @FXML
    private TextField txtWord;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
//    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
//    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
//    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
//    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

        assert boxControlloInserimento != null : "fx:id=\"boxControlloInserimento\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String testoInserito = txtWord.getText();
    	if(!model.inserimentoValido(testoInserito))
    		txtResult.appendText("Testo inserito non valido, devi inserire "
    				+ "un testo esclusivamente alfabetico\n");
    	txtResult.appendText(model.traduci(testoInserito));
    	
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    	model.newDictionary();
    }


	public void setModel(AlienModel model) {
		this.model = model;
		
	}
    
}
