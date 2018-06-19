package activiti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL {

    private static Connection Conexion;

    // Conexion con la base de datos (localhost)
    public void MySQLConnection(String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Limpito", user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Cerrar conexion base de datos (localhost)
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Verifica que el usuario exista en base de datos (localhost)
		public boolean existUser(String email) {
			 try {
					 String Query = "SELECT * FROM Clientes where email='"+email+"';";
					 Statement st = Conexion.createStatement();
					 java.sql.ResultSet resultSet;
					 resultSet = st.executeQuery(Query);
					 return resultSet.next();
			 } catch (SQLException ex) {
					 return false;
			 }
	 }


	}
