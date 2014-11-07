package main.resources.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.resources.model.business.Contato;

public class ContatoDAO {

	private Connection connection;

	//constuctor
	public ContatoDAO () {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//add a statement to table
	public void add(Contato contato) {
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";

		try {
			//prepared statement
			PreparedStatement stmt = connection.prepareStatement(sql);

			//values
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			//execute
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// object Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				//data
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// add object to list
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void modify(Contato contato) {
		String sql = "update contatos set nome = ?, email = ?, endereco = ?, " +
				"dataNascimento = ? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());;
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id = ?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public Contato search(int id){
		Contato contato = new Contato();
		String sql = "select id, nome, email, endereco, dataNascimento " +
				"from contatos where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();	
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return contato;
	}
}
