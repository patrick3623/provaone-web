package tk.patrickweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import tk.patrickweb.model.Record;
import tk.patrickweb.model.User;

public class RecordDao {
	public List<Record> getRecord() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM record");
		ResultSet result = preparedStatement.executeQuery();
		List<Record> records = new ArrayList<>();
		while (result.next()) {
			records.add(new Record(result.getInt(1), result.getString(2), result.getString(3), new User(result.getInt(4), null, null)));
		}
		return records;
	}

	public void save(Record record) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection
				.prepareStatement("INSERT INTO record(date, note, id_user) VALUES (?,?,?)");
		preparedStatement.setString(1, record.getDate());
		preparedStatement.setString(2, record.getNote());
		preparedStatement.setObject(3, record.getUser().getId());
		preparedStatement.execute();
	}

	public void excluir(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection
				.prepareStatement("DELETE FROM record WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	}

	public Record getRecordId(Integer id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM record WHERE id = ?");
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			return new Record(result.getInt(1), result.getString(2), result.getString(3), new User(result.getInt(5), null, null));
		}
		return null;
	}
}
