package asistenciaControl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.openjfx.asistenciaControl.ConexionBBDD;

class TestEntrada {
	
	ConexionBBDD conexionMysql = new ConexionBBDD();
  	
  	Connection conexion = null;
  	
  	boolean entradaRegistrada=false;
  	
  	boolean salidaRegistrada=false;
  	
  	String nombre = "Maria";

	@Test
	void test() {

		conexion = conexionMysql.conectarMySQL();
		
		try {
			
			if(entradaRegistrada==false) {
			
			Statement stmE = conexion.createStatement();
			
			//Capturo la fecha de la entrada
			
			Date fecha = new Date();
			
			Timestamp entrada = new Timestamp(fecha.getTime());
			
			stmE.executeUpdate("INSERT INTO ControlAsistencia (Nombre, Entrada) "
					+ "VALUES('" + nombre + "' , '" + entrada  + "')");
			
			System.out.println("Entrada Registrada");
			
			entradaRegistrada = true;
			
			salidaRegistrada = false;
			
			assertTrue(entradaRegistrada==true);
			
			}else if(entradaRegistrada==true) {
				
				System.out.println("Entrada ya registrada");
								
				assertFalse(entradaRegistrada=true);
				
			}else {
				
				System.out.println("Se ha producido un error");
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

}
