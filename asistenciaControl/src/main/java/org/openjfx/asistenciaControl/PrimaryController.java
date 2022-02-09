package org.openjfx.asistenciaControl;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
  //Obtengo la conexión a la BBDD	
  	ConexionBBDD conexionMysql = new ConexionBBDD();	
  	//Obtengo los campos del formulario	
  	@FXML
  	TextField nombre;	
  	@FXML	
  	Button entrada, salida;	
  	//Método que recoge los datos del formulario y los inserta en la base de datos	
  	public void entrando(ActionEvent event) {		
  		//Establezco la conexion con la BBDD		
  		Connection conexionEntrada = conexionMysql.conectarMySQL();		
  		System.out.println("Conexión establecida");	
  		/*
  		try {			
  			Statement stEntrada = conexionEntrada.createStatement();			
  			String Nombre = nombre.getText();			
  			LocalDateTime Entrada = LocalDateTime.now();			
  			String queryEntrada = "INSERT INTO ControlAsistencia (Nombre, Entrada) VALUES (Nombre, Entrada)";			
  			stEntrada.executeUpdate(queryEntrada);			
  			System.out.println();			
  		}catch(SQLException e) {			
  			System.out.println("Error al insertar los datos");				
  		}		
  		try {			
  			conexionEntrada.close();			
  			System.out.println("Conexión cerrada");			
  		} catch (SQLException e) {			
  			System.out.println("No se ha podido cerrar la conexión con la BBDD");
  		}	
  		*/	
  	}	
  	public void saliendo(ActionEvent event) {		
  		//Establezco la conexion		
  		Connection conexionSalida = conexionMysql.conectarMySQL();		
  		System.out.println("Conexión establecida");
  		/*
  		try {			
  			Statement stEntrada = conexionSalida.createStatement();			
  			String Nombre = nombre.getText();			
  			LocalDateTime Salida = LocalDateTime.now();			
  			String queryEntrada = "INSERT INTO ControlAsistencia (Nombre, Salida) VALUES (Nombre, Salida)";			
  			stEntrada.executeUpdate(queryEntrada);			
  			System.out.println();			
  		}catch(SQLException e) {			
  			System.out.println("Error al insertar los datos");				
  		}		
  		try {			
  			conexionSalida.close();			
  			System.out.println("Conexión cerrada");			
  		} catch (SQLException e) {		
  			System.out.println("No se ha podido cerrar la conexión con la BBDD");
  		}	
  		*/
  	}
  	@Override
  	public void initialize(URL location, ResourceBundle resources) {
  		// TODO Auto-generated method stub		
  		//Le asigno al botón entrada la acción del método entrando		
  		entrada.setOnAction(this::entrando);		
  		//Le asigno al botón salida la acción del método saliendo		
  		salida.setOnAction(this::saliendo);
  		
  	}
}
