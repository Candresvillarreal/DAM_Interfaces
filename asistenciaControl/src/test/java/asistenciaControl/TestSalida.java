package asistenciaControl;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.openjfx.asistenciaControl.ConexionBBDD;

class TestSalida {
	
	ConexionBBDD conexionMysql = new ConexionBBDD();
  	
  	Connection conexion = null;
  	
  	boolean entradaRegistrada=false;
  	
  	boolean salidaRegistrada=false;
  	
  	String nombre = "Maria";

	@Test
	void test() {
		
		conexion = conexionMysql.conectarMySQL();
		
		try {
  			
  			//Se ha registrado la entrada pero no la salida
  			
  			if(entradaRegistrada==true && salidaRegistrada==false) {
  				
  				Statement stmS = conexion.createStatement();
  				
  				Date fecha = new Date();
  				
  				Timestamp salida = new Timestamp(fecha.getTime());
  				
  				String nombreIntroducido = nombre;
  				
  				stmS.executeUpdate("UPDATE ControlAsistencia SET Salida = '" + salida + "' WHERE Nombre = '" + nombreIntroducido + "'");
  				
  				System.out.println("Salida Registrada");
  				
  				entradaRegistrada = true;
				
				salidaRegistrada = true;
				
				assertTrue(entradaRegistrada=true && entradaRegistrada==false);
				
				//Se ha registrado ya la entrada y la salida
  			
  			}else if(entradaRegistrada==true && salidaRegistrada==true) {
  	  			
  				System.out.println("Salida ya registrada");
  				
  				assertFalse(entradaRegistrada==true && salidaRegistrada==true);
  				
				
  			}else if(entradaRegistrada==false) {
  	  			
  				System.out.println("Es necesario registrar la entrada para registrar la salida");
  				
  				assertFalse(entradaRegistrada==false);
  				
  			}else {
  				
  				System.out.println("No se ha podido realizar la operación solicitada");
  			}
  					
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
	}
}
