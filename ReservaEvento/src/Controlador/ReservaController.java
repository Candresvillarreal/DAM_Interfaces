package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ReservaController implements Initializable {
	
	
	
	@FXML
	
	ChoiceBox<String> choiceAcompanantes;
	
	@FXML
	
	TextField campoNombre, campoApellido1, campoApellido2, campoEmpresa, campoEmail;
	
	@FXML
	
	Button botonReservar;
	
	//Método que rellena el ChoiceBox con el número de acompañantes que es posible reservar
	
	public void opcionesAcompanantes() {
		
		//Creo la lista de elementos a seleccionar del 0 al 10 y marco el 1 como opción seleccionada por defecto
		
		choiceAcompanantes.getItems().addAll("0", "1", "2", "3", "4", "5", "6","7", "8", "9", "10");
		
		choiceAcompanantes.getSelectionModel().select("1");
		
	}
	
	//Método que comprueba si una dirección de correo es válida o no
	
	public static boolean validarCorreo(String correo) {
		
		String patronValido="^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[esES]{2})$";
		
		Pattern patron = Pattern.compile(patronValido);
		
		Matcher comparador = patron.matcher(correo);
		
		return comparador.find();
	
	}
	
	public void comprobaciones(ActionEvent event) {
		
		//Valido si uno o más campos está vacío
		
		if(campoNombre.getText().isEmpty() || campoApellido1.getText().isEmpty() || campoApellido2.getText().isEmpty() ||
				campoEmpresa.getText().isEmpty() || campoEmail.getText().isEmpty()) {
			
			//Si algún campo está vacío, le cambio el color de fondo
			
			if(campoNombre.getText().isEmpty()) {
				
				campoNombre.setStyle("-fx-control-inner-background: #ef9a9a");
				
			}
			
			if(campoApellido1.getText().isEmpty()) { 
				
				campoApellido1.setStyle("-fx-control-inner-background: #ef9a9a");
				
			}
			
			if(campoApellido2.getText().isEmpty()) { 
				
				campoApellido2.setStyle("-fx-control-inner-background: #ef9a9a");
				
			}
			
			if(campoEmpresa.getText().isEmpty()) { 
				
				campoEmpresa.setStyle("-fx-control-inner-background: #ef9a9a");
				
			}
			if(campoEmail.getText().isEmpty()) { 
				
				campoEmail.setStyle("-fx-control-inner-background: #ef9a9a");
			
			}
			
		
			
			//Además creo una alerta de tipo error que indica que deben rellenarse los campos subrayados para completar la reserva
			
			Alert alertaCamposVacios = new Alert(AlertType.ERROR);
			
			alertaCamposVacios.setTitle("No se puede realizar la reserva");
			
			alertaCamposVacios.setContentText("Tiene que completar los campos subrayados");
			
			alertaCamposVacios.showAndWait();
			
		//Ahora compruebo que la dirección de email sea válida
			
		}else if(!campoEmail.getText().isEmpty()) {
			
			String correoIntroducido = campoEmail.getText();
			
			if(validarCorreo(correoIntroducido) == false) {
			
			campoEmail.setStyle("-fx-control-inner-background: #f6fc38");
			
			Alert alertaEmail = new Alert(AlertType.ERROR);
			
			alertaEmail.setTitle("Dirección de correo incorrecta");
			
			alertaEmail.setContentText("Debe introducir una dirección de correo válida");
			
			alertaEmail.showAndWait();
			
		//En caso que todos los campos obligatorios estén completados, se confirma la reserva
			
		}else {

			
				Alert alertaConfirmacion = new Alert(AlertType.CONFIRMATION);
				
				alertaConfirmacion.setTitle("Reserva Confirmada");
				
				alertaConfirmacion.setContentText("Reserva realizada. Muchas gracias!");
				
				alertaConfirmacion.showAndWait();
			
		}
		
	}
					
}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//Ejecuto el método que ofrece la selección del número de acompañantes
		
		opcionesAcompanantes();
		
		botonReservar.setOnAction(this::comprobaciones);	
		
	}

}
