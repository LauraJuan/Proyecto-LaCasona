<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>La Casona</title>

<link rel="stylesheet" href="css/header.css">
<meta charset="utf-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Trirong">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: right;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create three unequal columns that floats next to each other */
.column {
  float: left;
  padding: 10px;
}


/* Middle column */
.column.middle {
  width: 80%;
   
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column.middle {
    width: 100%;
  }
}

/* Style the footer */
.footer {
	margin-top: 250px;
  background-color: #f1f1f1;
  padding: 5px;
  text-align: up;
}
</style>
</head>
<body>

<div class="header">
  <h1>LA CASONA &#8902 &#8902 &#8902</h1>
  <h2>Bienvenido / Benvingut / Welcome </h2> <br>
</div>

<div class="topnav">
  <a href="SobreNosotros.jsp">Sobre-Nosotros</a>
  <a href="nuestrohostal.jsp">Nuestro Hostal</a>
  <a href="login.jsp">Login</a>
</div>


  


  
</body>
</html>