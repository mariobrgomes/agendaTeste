package br.com.mario.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	String executa (HttpServletRequest req, HttpServletResponse res) throws Exception;

}
