package org.openjfx.asistenciaControl;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
  //Obtengo la conexión a la BBDD	
    
  	ConexionBBDD conexionMysql = new ConexionBBDD();
  	
  	Connection conexion = null;
  	
  	//Obtengo los campos del formulario	
  	@FXML
  	TextField nombre;	
  	@FXML	
  	Button entrada, salida;	
  	
  	//Variables que controlan si ha registrado la entrada y la salida
  	
  	boolean entradaRegistrada=false;
  	boolean salidaRegistrada=false;
  	  
  	//Método que recoge los datos del formulario y los inserta en la base de datos
  	
  	public void entrando(ActionEvent event) {
		
		conexion = conexionMysql.conectarMySQL();
		
		try {
			
			if(entradaRegistrada==false) {
			
			Statement stmE = conexion.createStatement();
			
			//Capturo la fecha de la entrada
			
			Date fecha = new Date();
			
			Timestamp entrada = new Timestamp(fecha.getTime());
			
			stmE.executeUpdate("INSERT INTO ControlAsistencia (Nombre, Entrada) "
					+ "VALUES('" + nombre.getText() + "' , '" + entrada  + "')");
			
			System.out.println("Entrada Registrada");
			
			entradaRegistrada = true;
			
			salidaRegistrada = false;
			
			}else if(entradaRegistrada==true){
				
				System.out.println("Entrada ya registrada");
				
				Alert alerta = new Alert(AlertType.ERROR);
				
				alerta.setContentText("Entrada ya registrada");
				
				alerta.showAndWait();
				
			}else {
				
				System.out.print("Se ha producido un error");
				
			}
			
			}catch (SQLException e){
				
				e.printStackTrace();
				
			}
		
		
		try {
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
  	
  	public void saliendo(ActionEvent event) {
  		
  		conexion = conexionMysql.conectarMySQL();
  		
  		try {
  			
  			//Se ha registrado la entrada pero no la salida
  			
  			if(entradaRegistrada==true && salidaRegistrada==false) {
  				
  				Statement stmS = conexion.createStatement();
  				
  				Date fecha = new Date();
  				
  				Timestamp salida = new Timestamp(fecha.getTime());
  				
  				String nombreIntroducido = nombre.getText();
  				
  				//String query = "UPDATE ControlAsistencia SET Salida= + salida WHERE Nombre= + nombreIntroducido";
  				
  				stmS.executeUpdate("UPDATE ControlAsistencia SET Salida = '" + salida + "' WHERE Nombre = '" + nombreIntroducido + "'");
  				
  				System.out.println("Salida Registrada");
  				
  				entradaRegistrada = true;
				
				salidaRegistrada = true;
				
				//Se ha registrado ya la entrada y la salida
  			
  			}else if(entradaRegistrada==true && salidaRegistrada==true) {
  	  			
  				System.out.println("Salida ya registrada");
  				
  				Alert alerta = new Alert(AlertType.ERROR);
  				
  				alerta.setContentText("Salida ya registrada");
  				
  				alerta.showAndWait();
  				
  				entradaRegistrada = true;
				
				salidaRegistrada = true;
  				
  				//No se ha registrado ni la entrada ni la salida
				
  			}else if(entradaRegistrada==false) {
  	  			
  				System.out.println("Es necesario registrar la entrada para registrar la salida");
  				
  				Alert alerta = new Alert(AlertType.ERROR);
  				
  				alerta.setContentText("Imposible registrar salida sin antes registrar entrada");
  				
  				alerta.showAndWait();
  				
  				//entradaRegistrada = false;
				
				//salidaRegistrada = false;
  				
  			}else {
  				
  				System.out.println("No se ha podido realizar la operación solicitada");
  			}
  					
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}	
  		
  		try {
  			
  			conexion.close();
  			
  		}catch(SQLException e) {
  			
  			e.printStackTrace();
  		}
  		
  		
  	}
  	
  	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		entrada.setOnAction(this::entrando);
		
		salida.setOnAction(this::saliendo);

	}
	
}
