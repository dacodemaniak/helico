import java.sql.SQLException;

import com.helico.entities.Variante;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Variante variante = new Variante();
			variante.setSerial("03102018");
			variante.add();
			variante.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
