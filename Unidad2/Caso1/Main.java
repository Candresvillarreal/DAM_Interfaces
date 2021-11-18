package Caso1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		//Creo el elemento principal que cargar� el archivo fxml (recepcion.fxml) que contiene el dise�o
		
		Parent principal = FXMLLoader.load(getClass().getResource("recepcion.fxml"));
		
		//Establezco el t�tulo y el tama�o de la ventana y la hago visible
		
		primaryStage.setTitle("Recepci�n de Instrumentos");
		
		primaryStage.setScene(new Scene(principal, 600,600));
		
		primaryStage.show();
		
	}
	
	//Lanzo la aplicaci�n
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
