<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.database.entity.Cliente" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/table-style.css">
	<title>Clienti JSP</title>
</head>
<body>
	<h1>Elenco dei Clienti</h1>
	<%
	List<Cliente> clienti = (List<Cliente>)request.getAttribute("lista.clienti");
	%>

	<table>
		<tr>
			<th>#</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th>Indirizzo</th>
			<th>Citta</th>
			<th>Provincia</th>
			<th>CAP</th>
		</tr>
		<!-- repeating group di TR una per ciascuna provincia -->
		<%for(Cliente c: clienti) { %>
		<tr>
			<td><%=c.getIdCliente()%></td>
			<td><%=c.getNome()%></td>
			<td><%=c.getCognome()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getIndirizzo() %></td>
			<td><%=c.getCitta() %></td>
			<td><%=c.getProvincia() %></td>
			<td><%=c.getCap() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>