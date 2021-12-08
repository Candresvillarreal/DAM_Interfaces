package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class AsistenciaController implements Initializable {
	
	//Método que muestra un tooltip al pasar sobre el campo nombre
	
	@FXML
	
	TextField campoNombre;
	
	public void avisoNombre(MouseEvent event) {
		
		campoNombre.setTooltip(new Tooltip("Debes introducir tu nombre"));
		
	}
	
	//Método que muestra un tooltip al pasar sobre el campo apellido
	
	@FXML 
	
	TextField apellidos;
	
	public void avisoApellidos(MouseEvent event) {
		
		Tooltip aA = new Tooltip("Debes introducir tu apellido");
		
		apellidos.setTooltip(aA);
		
	}
	
	//Método que muestra un tooltip al pasar sobre el campo fecha
	
	@FXML
	
	DatePicker fecha;
	
	public void avisoFecha(MouseEvent event) {
		
		fecha.setTooltip(new Tooltip("Debes introducir la fecha"));
	}
	
	//Método que crea la ventana emergente sobre el botón fichar
	
	@FXML
	
	Button ficharButton;
	
	public void handleButtonAction(ActionEvent event) {
		
		System.out.println("Fichaje Registrado");
		
		Alert alerta = new Alert(AlertType.CONFIRMATION);
		
		alerta.setTitle("Confirmación");
		
		alerta.setContentText("Fichaje Guardado");
		
		alerta.showAndWait();
		
	}
	
	//Este métodos es el resultante de Initilizable y utilizo el id creado en sceneBuilder para el botón fichar


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("Inicializo AsistenciaController");
		
		ficharButton.setOnAction(this::handleButtonAction);
		
	}

}
