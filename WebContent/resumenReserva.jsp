<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>

<%@ page import="es.eoi.modelo.*"%>



<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="fontawesome.com/v4.7/icons">



<title>Proyecto: La Casona</title>

</head>

<body>



	<jsp:include page="header.jsp"></jsp:include>



	<%
		List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");

	Cliente clie = (Cliente) session.getAttribute("cliente");
	%>

	<h2>Información de su reserva</h2>





	<table>

		<tr>

			<th>Fecha reserva</th>

			<th>Fecha entrada</th>

			<th>Fecha salida</th>

			<th>Número de personas</th>

			<th>ID Cliente</th>

			<th>Tipo Habitación</th>

			<th>Extra</th>



		</tr>

		<%
			if (reservas != null) {

			for (Reserva r : reservas) {
		%>



		<tr>

			<td><%=r.getFecha_reserva()%></td>

			<td><%=r.getFecha_entrada()%></td>

			<td><%=r.getFecha_salida()%></td>

			<td><%=r.getNum_personas()%></td>

			<td><%=r.getCliente_id()%></td>

			<td><%=r.getTipo()%></td>

			<td><%=r.getExtra()%></td>





			<td>
				<%
					if (clie.getRol().equals("admin")) {
				%><a href="anularReserva?habitacion_n=<%=r.getHabitacion_n()%>">Anular
					Reserva</a>

			</td>



		</tr>

		<%
			}

		}

		}
		%>

	</table>





</body>

</html>