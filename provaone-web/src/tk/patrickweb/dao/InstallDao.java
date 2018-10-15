package tk.patrickweb.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InstallDao {
	
	public Boolean getInstall() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionJDBCFactory.getConnection();
		String db_exixsts = "show tables like 'user';";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(db_exixsts);
		ResultSet result = preparedStatement.executeQuery();
		System.out.println(result.getString(1));
		if(result.getString(1) == "user") {
			System.out.println(result.getString(1));
			return true;
		}else {
			System.out.println("Passo 4");
			String sql = "CREATE DATABASE IF NOT EXISTS 'prova_db'; USE 'prova_db'; DROP TABLE IF EXISTS 'acess'; CREATE TABLE 'acess' ( 'id' int(11) NOT NULL, 'name' varchar(45) NOT NULL, 'level' int(11) NOT NULL, PRIMARY KEY ('id') ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; LOCK TABLES 'acess' WRITE; UNLOCK TABLES; DROP TABLE IF EXISTS 'user'; CREATE TABLE 'user' ( 'id' int(11) NOT NULL, 'name' varchar(45) NOT NULL, 'email' varchar(100) NOT NULL, 'password' varchar(45) NOT NULL, 'id_acess' int(11) NOT NULL, PRIMARY KEY ('id'), KEY 'fk_user_1_idx' ('id_acess'), CONSTRAINT 'fk_user_1' FOREIGN KEY ('id_acess') REFERENCES 'acess' ('id') ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; LOCK TABLES 'user' WRITE; UNLOCK TABLES; INSERT INTO 'acess' ('id','name','level') VALUES (1,'Administrativo',3); INSERT INTO 'acess' ('id','name','level') VALUES (2,'Servidor',2); INSERT INTO 'acess' ('id','name','level') VALUES (3,'Contratado',1); INSERT INTO 'acess' ('id','name','level') VALUES (4,'Estagiário',1); INSERT INTO 'acess' ('id','name','level') VALUES (5,'Externo',0);";
			PreparedStatement preparedStatement2 = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet result2 = preparedStatement.executeQuery();preparedStatement2.executeQuery();
			System.out.println(result2.getString(1));
			return false;
		}
	}
}
