package poo.loja.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLojaFactory {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/lojadb", "sa", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
