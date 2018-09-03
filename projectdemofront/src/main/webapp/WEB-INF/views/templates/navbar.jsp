<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineShop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
    
     <c:if test="${!sessionScope.loggedIn }">
       <li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
       <li><a href="${pageContext.request.contextPath}/register">REGISTER</a></li>
       <li><a href="${pageContext.request.contextPath}/productDisplay">Display Product</a></li>
       <li><a href="${pageContext.request.contextPath}/contactus">CONTACT US</a></li>
       <li><a href="${pageContext.request.contextPath}/aboutus">ABOUT US</a></li>
      </c:if>
     
     <c:if test="${sessionScope.loggedIn}">
          <c:if test="${sessionScope.role=='admin'}">
      <li><a href="${pageContext.request.contextPath}/category">CATEGORY</a></li>
      <li><a href="${pageContext.request.contextPath}/ShowAllProduct">Manage Product</a></li>
      <li><a href="${pageContext.request.contextPath}/supplier">SUPPLIER</a></li>
      </c:if>
      
     <c:if test="${sessionScope.role=='user'}">
       <li><a href="${pageContext.request.contextPath }/productDisplay">Display Product</a></li>
      	 <li><a href="${pageContext.request.contextPath }/cart">Cart</a></li>
      </c:if>
      
      </c:if>
      
           
    </ul>
  </div>
  <div class="nav navbar-nav navbar-right">
  <c:if test="${sessionScope.loggedIn }">
  <font color="white" face="calibri" size="3">Welcome :${username}</font>
  <a href="${pageContext.request.contextPath}/perform_logout"><font color="white" face="calibri" size="2">LOGOUT</font></a>
 </c:if>
  </div>
  
</nav>
</body>
</html>








