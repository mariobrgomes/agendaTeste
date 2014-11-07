package main.resources.model.daotests;

import java.util.Calendar;

import main.resources.model.business.Contato;
import main.resources.model.dao.ContatoDAO;

public class TestInsert {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Mario");
		contato.setEmail("mariobrgomes91@gmail.com");
		contato.setEndereco("Rua Caraibas 1288 AP 6");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		
		dao.add(contato);
	
		System.out.println("Ok!");

	}

}
