package asistenciaControl;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import org.openjfx.asistenciaControl.ConexionBBDD;

class TestConexionBBDD {

	@Test
	void test() {
		
		ConexionBBDD conexionPrueba = new ConexionBBDD();
		
		Connection nuevaConexion = conexionPrueba.conectarMySQL();
		
		assertNotNull(nuevaConexion);
		
		
	}

}
