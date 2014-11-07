package main.resources.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.resources.model.business.Funcionario;

public class FuncionarioDAO {

	private Connection connection;

	//constuctor
	public FuncionarioDAO () {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//add a statement to table
	public void add (Funcionario funcionario) {
		String sql = "insert into funcionarios " +
				"(nome, senha)" +
				" values (?,?)";

		try {
			//prepared statement
			PreparedStatement stmt = connection.prepareStatement(sql);

			//values
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());


			//execute
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Funcionario> getLista() {
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// object Funcionario
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSenha(rs.getString("senha"));

				// add object to list
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
			return funcionarios;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void modify(Funcionario funcionario) {
		String sql = "update funcionarios set nome = ?, senha = ? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			stmt.setLong(3, funcionario.getId());

			stmt.execute();
			stmt.close();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id = ?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public Funcionario search(int id){
		Funcionario funcionario = new Funcionario();
		String sql = "select id, nome, senha from funcionarios where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, funcionario.getId());

			stmt.execute();
			stmt.close();	
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return funcionario;
	}
}
