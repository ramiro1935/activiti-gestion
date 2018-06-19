<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<html lang="en">
<head>
	<title>Lista de procesos activos</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="list-group">
  <a href="#" class="list-group-item list-group-item-action active">
    Procesos en ejecución
  </a>

  <%
  	List<String> pl = (List<String>) request.getAttribute("procesos");
  	for(String s : pl) {
  		out.print( "<a href='#' class='list-group-item list-group-item-action'>"+ s +"</a>" );
  } 
  %>
  <div class="row">
  	<a class="col-md-3 col-md-offset-8 btn btn-primary" href="home.jsp">Volver</a>
  </div>
</body>
</html>