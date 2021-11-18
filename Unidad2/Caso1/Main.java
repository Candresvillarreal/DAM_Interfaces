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
		
		//Creo el elemento principal que cargará el archivo fxml (recepcion.fxml) que contiene el diseño
		
		Parent principal = FXMLLoader.load(getClass().getResource("recepcion.fxml"));
		
		//Establezco el título y el tamaño de la ventana y la hago visible
		
		primaryStage.setTitle("Recepción de Instrumentos");
		
		primaryStage.setScene(new Scene(principal, 600,600));
		
		primaryStage.show();
		
	}
	
	//Lanzo la aplicación
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
