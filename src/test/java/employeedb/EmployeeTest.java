package employeedb;


import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void sayHello() throws Exception {
		EmployeeJdbcApi api = new EmployeeJdbcApi();
		api.Delete();
		api.Insert();
		ResultSet rs = api.Select();
		int i = 0;
		while (rs.next()) {
			i++;
	}
		assertEquals(3, i);
	}
}
