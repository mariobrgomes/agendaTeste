package br.com.mario.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.resources.model.business.Contato;
import main.resources.model.dao.ContatoDAO;

public class RemoveContatoLogica implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");
		
		return "lista-contatos.jsp";
	}

}
