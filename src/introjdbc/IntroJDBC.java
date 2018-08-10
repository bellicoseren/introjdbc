package introjdbc;

import java.sql.*;

public class IntroJDBC {

	
	public static void main(String[] arg){
		String url = "jdbc:mysql://127.0.0.1:3306/prueba?useSSL=false";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "root");
			
			Statement instruction = connection.createStatement();
			
			String sql = "select id, nombre from mitabla";
			
			ResultSet result = instruction.executeQuery(sql);
			
			
			while(result.next()) {
				System.out.println("id: " + result.getInt(1));
				System.out.println("nombre: " + result.getString(2));
			}
			result.close();
			instruction.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
