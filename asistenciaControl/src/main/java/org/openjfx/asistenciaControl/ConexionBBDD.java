package org.openjfx.asistenciaControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {	
	private final static String controlador ="com.mysql.cj.jdbc.Driver";	
	private String url;	
	private String usuario = "root";
	private String password = "";	
	Connection conexionMysql = null;	
	//Cargo el controlador
		static {	
			try {			
				Class.forName(controlador);			
			}catch(ClassNotFoundException e) {		
				System.out.println("Error al cargar el controlador");		
				e.printStackTrace();
			}		
		}		
		//Método que realiza la conexión		
		public Connection conectarMySQL() {			
			url = "jdbc:mysql://localhost:3306/asistenciaControl";			
			try {				
				conexionMysql = DriverManager.getConnection(url, usuario, password);				
				System.out.println("Conexión establecida.");
			}catch(SQLException e) {				
				System.out.println("No se ha podido establecer la conexión solicitada");				
				e.printStackTrace();				
			}			
			return conexionMysql;			
		}		
		//Método que cierra la conexión
		
		public void cerrarConexionMysql() {			
			try {			
				conexionMysql.close();
				System.out.println("Conexión cerrada");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}		
		}
}
