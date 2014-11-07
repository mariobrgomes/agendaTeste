<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
	<%@taglib tagdir="/WEB-INF/tags" prefix="d"%>
	<c:import url="header.jsp" />

	<!--  criar DAO -->
	<jsp:useBean id="dao" class="main.resources.model.dao.ContatoDAO" />
	<table id="table1">
		
		<%request.setAttribute("lista", dao.getLista()); %>
		<display:table name ="lista">
		<display:column property="nome" sortable="true" title="Nome" />
		<display:column property="email" sortable="true" title="Email" />
		<display:column property="endereco" sortable="true" title="Endereço" />
		<display:column property="dataNascimento.time" format="{0,date,dd/MM/yyyy}" sortable="true" title="Data de Nascimento" />
		</display:table>
	<c:import url="footer.jsp" />
</body>