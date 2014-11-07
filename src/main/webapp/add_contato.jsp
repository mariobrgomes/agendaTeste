<!DOCTYPE html>
<html>
<head>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>  
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>  
<meta charset="UTF-8">
<title>Insira novo contato</title>
</head>

<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="d"%>
	<c:import url="header.jsp" />
	<form action="addContato">
		Nome: <input type="text" name="nome" /><br /> 
		E-mail: <input type="text" name="email" /><br /> 
		Endereço: <input type="text" name="endereco" /><br /> 
		Data Nascimento: <d:dataField id="dataNascimento" />
		<br /> <input type="submit" value="Gravar" />
	</form>
	<c:import url="footer.jsp" />
</body>
</html>
