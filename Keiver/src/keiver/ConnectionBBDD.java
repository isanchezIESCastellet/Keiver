package keiver;

import java.sql.*;
import java.io.*;

public class ConnectionBBDD {

	private static String data[] = new String[3];
		
	public Connection connection;
	public Connection getConnection() {
		
		String end = "";
		int i = 0;
		try {
			
			File dataFile = new File("src/keiver/bbdd_data.txt");
			
			BufferedReader file = new BufferedReader(new FileReader(dataFile));

			while ((end = file.readLine()) != null) {		
				data[i] = end;
				i++;
			}		
									
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo -> " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error imprevisto");
		}
		
		try {
			
			Connection myConnection = DriverManager.getConnection(data[0],data[1],data[2]);
		
						
			//Statement myStatement = myConnection.createStatement();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return connection;
	}
}