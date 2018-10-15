package tk.patrickweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import tk.patrickweb.model.Acess;

public class AcessDao {

	public List<Acess> getAcess() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM acess");
		ResultSet result = preparedStatement.executeQuery();
		List<Acess> accesses = new ArrayList<>();
		while (result.next()) {
			accesses.add(new Acess(result.getInt(1), result.getString(2), result.getInt(3)));
			// System.out.println("ID: " + result.getInt(1) + "NAME: " + result.getString(2)
			// + "LEVEL: " + result.getInt(3));
		}
		return accesses;
	}
	
	public Acess getAcess(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM acess WHERE id = ?");
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		if(result.next()) {
			Acess acess = new Acess(result.getInt(1), result.getString(2), result.getInt(3));
			return acess;
		}else {
			return null;
		}
	}

	public void save(Acess acess) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection
				.prepareStatement("INSERT INTO acess(name, level) VALUES (?,?)");
		preparedStatement.setString(1, acess.getName());
		preparedStatement.setInt(2, acess.getLevel());
		preparedStatement.execute();
	}
	
	public void excluir(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection
				.prepareStatement("DELETE FROM acess WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	}

	public Acess getAcessId(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM acess WHERE id = ?");
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			return new Acess(result.getInt(1), result.getString(2), result.getInt(3));
		}
		return null;
	}
}
