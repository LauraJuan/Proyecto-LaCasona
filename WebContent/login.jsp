<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/header.css">
<script type="text/javascript" src="js/script.js" defer></script>
<title>La Casona</title>
</head>
<body>



	<form action="Login" method="post">
		<label>Email:</label> <input type="email" name="email"> <label>Pass:</label>
		<input type="password" name="pass"> <input type="submit"
			value="Login"> <span style="color: red"><%=request.getAttribute("msgerr")==null ? "" : request.getAttribute("msgerr") %></span>
		<a style="color: blue" href='altaCliente.jsp'><%=request.getAttribute("msgerr")==null ? "" : "Registrar" %></a>
		<a href="altaCliente.jsp">AltaCliente</a>
	</form>
</body>
</html>