package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class JDBC {
	public JDBC() {

	}

	public int printColumnName(ResultSet rs) throws Exception {
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();

		StringBuilder sb = new StringBuilder("#");
		for (int i = 1; i <= count; i++) {
			sb.append("," + meta.getColumnName(i));
		}
		System.out.println(sb);
		System.out.println("-".repeat(sb.length()));

		return count;
	}

	public void StudyStatement(Connection con) throws Exception {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from board");

		int colCount = printColumnName(rs);
		int rowCount = 1;
		while (rs.next()) {
			for (int i = 1; i <= colCount; i++) {
				if (i == 1)
					System.out.print((rowCount++) + ",");
				else
					System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}

	public void StudyPrepareStatement(Connection con) throws Exception {

		PreparedStatement st = con.prepareStatement("select * from member"); // code

		// st.setString(1, "KOR"); //setString -> 따옴표 추가해서 문자열로 만듦
		ResultSet rs = st.executeQuery();

		int colCount = printColumnName(rs);
		int rowCount = 1;
		while (rs.next()) {
			for (int i = 1; i <= colCount; i++) {
				if (i == 1)
					System.out.print((rowCount++) + ",");
				else
					System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
}

class JDBCH2 extends JDBC {
	public JDBCH2() throws Exception {
		Class.forName("org.h2.Driver");

		try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/musthave", "sa", "");) {

			System.out.println("<=== StudyStatement ===>");
			super.StudyStatement(con);
			System.out.println();

			System.out.println("<=== StudyPrepareStatement ===>");
			super.StudyPrepareStatement(con);
			System.out.println();
		}
	}

}

class JDBCMySQL extends JDBC {
	public JDBCMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "musthave", "tiger");) {

			System.out.println("<=== StudyStatement ===>");
			super.StudyStatement(con);
			System.out.println();

			System.out.println("<=== StudyPrepareStatement ===>");
			super.StudyPrepareStatement(con);
			System.out.println();
		}
	}

}

public class JDBCMain {

	public static void main(String[] args) throws Exception {
		JDBC h2 = new JDBCH2();
		JDBC mysql = new JDBCMySQL();
	}

}
