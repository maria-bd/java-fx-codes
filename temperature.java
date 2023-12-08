package packagename;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class temperature extends Application {
	public int x=0;
	public void start(Stage idstage) {
		idstage.setTitle("IHM Température");
		Button plus = new Button("+");
		Label num = new Label(""+x);
		Label unit = new Label ("°C");
		Button sub = new Button("-");	
		Button change = new Button ("Change unit");
		HBox hbox = new HBox(15);
		hbox.getChildren().addAll(plus,num,unit,sub,change);
//Event handeling actions plus
		 plus.setOnAction(e -> {
	            num.setText(""+(x++));
	        });
//Event handeling actions sub
		sub.setOnAction(e -> {
        num.setText(""+(x--));		
        });
//Event changing unit actions 
		change.setOnAction(e -> {
			if(unit.getText().equals("°C")){
					unit.setText("F");
                    num.setText(""+(x=(x*9/5)+ 32));
                    }
			else {
				unit.setText("°C");
				num.setText(""+(x=(x-32)*5/9));
			}
	});
// Basic stage settings
        Scene scene = new Scene(hbox, 300, 150);
        idstage.setScene(scene);
        idstage.show();
	}
    public static void main(String[] args) {
        launch(args);
    }
}
