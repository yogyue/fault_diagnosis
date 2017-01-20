package dbConnector;

import java.sql.Connection;

public class dbCon {
	
	private Connection con;
	
	public dbCon(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://115.29.144.123:3306/fault_diagnosis?useUnicode=true&characterEncoding=utf8", "root", "root");
			
			this.setCon(connection);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	

}

