<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem Vindo</title>
</head>
<body>
	Teste
<%
String mensagem = "Bem vindo de verdade!";
%>
<% out.println(mensagem); %>
<br />
<% String txt = "Desenvolvido por: Isso nao eh um programa!"; %>
<% out.println(txt); %>
</body>
</html>