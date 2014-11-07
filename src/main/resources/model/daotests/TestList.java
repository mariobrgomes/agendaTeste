package main.resources.model.daotests;

import java.text.SimpleDateFormat;
import java.util.List;

import main.resources.model.business.Contato;
import main.resources.model.dao.ContatoDAO;

public class TestList {

	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + format.format(contato.getDataNascimento().getTime()) + "\n");
		}
	}

}
