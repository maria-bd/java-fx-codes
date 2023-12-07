package packagename;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class insert extends Application {
	@Override
        public void start(Stage primaryStage) {
    	primaryStage.setTitle("Carré");
        Label label = new Label("Entrez un nombre :");
        TextField textField = new TextField();
        Button calculerButton = new Button("CALCUL");
        Button rest = new Button("rest");
        Label resultLabel = new Label("Resultat :");
        
        HBox btns = new HBox(15); 
        
        btns.getChildren().addAll(calculerButton,rest);
        rest.setOnAction(e -> {
        	textField.clear();
        resultLabel.setText("Resultat :");
        });
        calculerButton.setOnAction(e -> {
        if (!textField.getText().isBlank()) {
        		
    try {
    	
    	  resultLabel.setText("Resultat : " +calculerCarre(textField.getText()));
    }catch(Exception exc){ resultLabel.setText("Resultat : in valide input ");}

        }
        else resultLabel.setText("Resultat : in valide input ");});
     
        // Gestion de l'événement de clic sur le bouton
        // Mise en page des éléments graphiques dans un conteneur VBox
        VBox vbox = new VBox(10); // 10 pixels d'espace entre les éléments
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, textField, btns,resultLabel);
        // Création de la scène
        Scene scene = new Scene(vbox, 300, 150);
        // Configuration de la fenêtre principale
        primaryStage.setTitle("Calculateur de Carré");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
    private double calculerCarre(String text) throws Exception {
    	  double nombre = Double.parseDouble(text);
    	 return Math.pow(nombre,2); 
  
    	
    }
	    // Méthode pour calculer le carré du nombre saisi
	    private void calculerCarre(TextField textField) {
	        try {
	            // Récupérer le texte saisi et le convertir en double
	            double nombre = Double.parseDouble(textField.getText());

	            // Calculer le carré
	            double carre = nombre * nombre;

	            // Afficher le résultat
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Résultat");
	            alert.setHeaderText(null);
	            alert.setContentText("Le carré de " + nombre + " est : " + carre);
	            alert.show();
	        } catch (NumberFormatException ex) {
	            // Gérer le cas où l'utilisateur n'a pas saisi un nombre
	            textField.setText(""); // Remettre le champ à blanc
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Erreur");
	            alert.setHeaderText(null);
	            alert.setContentText("Veuillez saisir un nombre valide.");
	            alert.show();
	        }
	    }
    public static void main(String[] args) {
        launch(args);
    }
}
