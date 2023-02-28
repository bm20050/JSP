package edu.mission;

import java.sql.DriverManager;

class JDBCDatabaseMySQL extends JDBCDatabase {

	public JDBCDatabaseMySQL(String url, String usr, String pwd) throws Exception {
		super("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
	}

	public void StudyStatement(int type) throws Exception {

		System.out.println("StudyStatement:" + type);
		if (type == 1)	StudyStatement1();	// board
		else			StudyStatement2();	// memeber
	}
}
