package tk.patrickweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import tk.patrickweb.model.Acess;
import tk.patrickweb.model.User;

public class UserDao {

	public List<User> getUser() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM user");
		ResultSet result = preparedStatement.executeQuery();
		List<User> users = new ArrayList<>();
		while (result.next()) {
			users.add(new User(result.getInt(1), result.getString(2), result.getString(3)));
			// System.out.println("ID: " + result.getInt(1) + "NAME: " + result.getString(2)
			// + "Email: " + result.getString(3));
		}
		return users;
	}
	
	public User getLogin(String email, String password) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM user WHERE email ='" + email + "' AND password ='" + password + "';");
		ResultSet result = preparedStatement.executeQuery();
		if(result.next()) {
			AcessDao acessDao = new AcessDao();
			Acess acess = acessDao.getAcess(result.getInt(5));
			User user = new User(null, result.getString(2), result.getString(3), null, acess);
			return user;
		}else {
			return null;
		}
	}

	public void save(User user) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection
				.prepareStatement("INSERT INTO user(name, email, password, id_acess) VALUES (?,?,?,?)");
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setObject(4, user.getAcess().getId());
		preparedStatement.execute();
	}

	public void excluir(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection
				.prepareStatement("DELETE FROM user WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	}

	public User getUserId(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM user WHERE id = ?");
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), new Acess(result.getInt(5)));
		}
		return null;
	}
	
	
}
