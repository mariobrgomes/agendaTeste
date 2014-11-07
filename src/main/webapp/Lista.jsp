<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="main.resources.model.dao.ContatoDAO, main.resources.model.business.Contato, java.util.*, java.text.SimpleDateFormat" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%
ContatoDAO dao = new ContatoDAO();
List<Contato> contatos = dao.getLista();
SimpleDateFormat fmr = new SimpleDateFormat("dd/MM/yyyy");

for (Contato contato : contatos) {
%>
<tr>
<td><%= contato.getNome() %> </td>
<td><%= contato.getEmail() %> </td>
<td><%= contato.getEndereco() %> </td>
<td><%= fmr.format(contato.getDataNascimento().getTime())  %> </td>
</tr>
<%
}
%>
</table>
</body>
</html>