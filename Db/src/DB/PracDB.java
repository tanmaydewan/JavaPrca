package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracDB {

	public static void main(String[] args) 
		// TODO Auto-generated method stub
		{
			Connection conn;
			Statement stat;
			ResultSet rs;
			
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			}
			catch(ClassNotFoundException ex)
			{
				System.out.println("Problem in loading the driver");
				ex.printStackTrace();
			}
			
			try {
				String dbName= "Database1.accdb";
				String dbUrl = "jdbc:ucanaccess://" + dbName;
				conn = DriverManager.getConnection(dbUrl);
				stat = conn.createStatement();
				String query = "Insert into emp (empName,Salary)";
				rs = stat.executeQuery("SELECT * FROM EMP");
				int id;
				String name;
				double sal;
				while (rs.next()) {
					id=rs.getInt(1);
					name = rs.getString(2);
					sal= rs.getDouble(3);
					System.out.println("id " +id + "name "+ name + "salary" + sal);
				}
				
			}
			catch( SQLException ex) {
				System.out.println("Problem with DB");
			}

	}

}
