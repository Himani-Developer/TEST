<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineShop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-3.3.1.js"></script>
<script src="resources/js/popper.js"></script>
<script src="resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="resources/css/fontawsome.css"> -->


<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}

body{

background:url(resources/images/wallpaper2.jpg) no-repeat;
background-size: cover;
}
</style>

</head>
<body>
	<div class="container-fluid" >
	
		
		
		
			<c:if test="${UserClickedHome==true}">
			<%@include file="home.jsp" %>
			</c:if>
			<c:if test="${UserClickedCategory==true}">
			<%@include file="showcategory.jsp" %>
			</c:if>
			
		
		
		<!-- -------- FOOTER  -------- -->
		<%@include file="templates/footer.jsp" %>
	</div>
</body>
</html>