<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.database.entity.Provincia" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Province JSP</title>
</head>
<body>
	<h1>Elenco delle Province</h1>
	<%
	List<Provincia> province = (List<Provincia>)request.getAttribute("lista.province");
	%>
</body>
</html>