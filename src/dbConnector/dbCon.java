package dbConnector;

import java.sql.Connection;

public class dbCon {
	
	private Connection con;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public dbCon(){
		try{
			
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

