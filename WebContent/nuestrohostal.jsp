<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

  pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

 <meta charset="utf-8">

 <meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Proyecto La Casona</title>

</head>

<body>



<div class="container">

 <h2>Nuestro Hostal</h2>  

 <div id="myCarousel" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->

  <ol class="carousel-indicators">

   <li data-target="#myCarousel" data-slide-to="0" class="active"></li>

   <li data-target="#myCarousel" data-slide-to="1"></li>

   <li data-target="#myCarousel" data-slide-to="2"></li>

   <li data-target="#myCarousel" data-slide-to="3"></li>

  </ol>



  <!-- Wrapper for slides -->

  <div class="carousel-inner">

   <div class="item active">

    <img src="imagenes/hostal.jpg" alt="Habitación Individual" style="width:80%">

   </div>

    

	 <div class="item">

    <img src="imagenes/individual.jpg" alt="Habitación Individual" style="width:80%">

   </div>

    

   <div class="item">

    <img src="imagenes/doble.jpg" alt="Habitación doble" style="width:80%">

   </div>

   

   <div class="item">

    <img src="imagenes/habmatri.jpg" alt="Habitación matrimonio" style="width:80%">

   </div>

  </div>



  <!-- Left and right controls -->

  <a class="left carousel-control" href="#myCarousel" data-slide="prev">

   <span class="glyphicon glyphicon-chevron-left"></span>

   <span class="sr-only">Previous</span>

  </a>

  <a class="right carousel-control" href="#myCarousel" data-slide="next">

   <span class="glyphicon glyphicon-chevron-right"></span>

   <span class="sr-only">Next</span>

  </a>

 </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>