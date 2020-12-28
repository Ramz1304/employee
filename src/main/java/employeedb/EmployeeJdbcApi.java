package employeedb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;


public class EmployeeJdbcApi {

	private static Logger Log = Logger.getLogger(EmployeeJdbcApi.class);
	private Connection con;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {




	}

	public EmployeeJdbcApi() throws IOException, ClassNotFoundException, SQLException {
		Properties props = new Properties();
		InputStream inStream = new FileInputStream("employee.properties");
		props.load(inStream);

		Class.forName(props.getProperty("jdbc.Driver"));

		con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
				props.getProperty("jdbc.password"));

	}

	public void Insert() throws SQLException {
		Log.warn("inserting employee");
		Statement stat = con.createStatement();
		for (int i = 0; i < 3; i++) {
			int id = i;
			int age = 30 + i;
			String name = "name" + i;
			String query = "insert into employee values(" + id + ",'" + name + "'," + age + ")";
			Log.info(query);
			stat.executeUpdate(query);

		}
		stat.close();
	}

	public ResultSet Select() throws SQLException {
		Log.info("selecting employee");
		Statement stat = con.createStatement();

		ResultSet rs = stat.executeQuery("select * from employee");
		return rs;

		/*
		 * while (rs.next()) { Log.info(rs.getInt(1) + " " + rs.getString(2) + " " +
		 * rs.getInt(3)); s } stat.close();
		 */

	}

	public void Delete() throws SQLException {
		Log.info("deleting employee");
		Statement stat = con.createStatement();

		ResultSet rs = stat.executeQuery("select * from employee");

		List<Integer> idList = new ArrayList<Integer>();
		while (rs.next()) {
			idList.add(rs.getInt(1));

		}
		for (Integer element : idList) {
			stat.executeUpdate("delete from employee where id = " + element);

		}
		stat.close();
	}

}
