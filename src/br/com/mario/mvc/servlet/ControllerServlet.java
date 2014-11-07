package br.com.mario.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mario.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.mario.mvc.logica." + parametro;

		try {
			Class classe = Class.forName(nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();
			String page = logica.executa(request, response);

			request.getRequestDispatcher(page).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("A lógica causou exceção", e);
		}
	}

}
