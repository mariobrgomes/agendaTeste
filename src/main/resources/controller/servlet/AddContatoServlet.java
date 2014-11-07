package main.resources.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.resources.model.dao.ContatoDAO;
import main.resources.model.business.*;
/**
 * Servlet implementation class AddContatoServlet
 */
@WebServlet("/addContato")
public class AddContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter = 0;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		counter++;
		PrintWriter out = response.getWriter();

		// request parameters

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String data = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

        // fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
            System.out.println(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		ContatoDAO dao = new ContatoDAO();
		dao.add(contato);

		// imprime o nome do contato que foi adicionado

		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
	}
}
