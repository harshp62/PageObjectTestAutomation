package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

	public static List<String> getCredentials() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sel";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT username, password FROM sample limit 1");

		List<String> cred = new ArrayList<>();

		if (resultSet.next()) {

			cred.add(resultSet.getString("username"));
			cred.add(resultSet.getString("password"));
		}

		resultSet.close();
		statement.close();
		connection.close();

		return cred;
	}

}
