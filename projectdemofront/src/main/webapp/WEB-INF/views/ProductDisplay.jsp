<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-3.3.1.js"></script>
<script src="resources/js/popper.js"></script>
<script src="resources/js/bootstrap.js"></script>  -->

<!-- -----navbar----------- -->
<%@include file="templates/navbar.jsp"%>






 <div class="container">
	<c:set var="count" value="0"/>
		<div class="row">
		<c:forEach items="${productlist }" var="product">
			<div class="col-sm-6 col-md-3">
            <div class="thumbnail">

				<h2>
					<span data-toggle="tooltip" title="Bootstrap version">${product.productname}
						&nbsp; Rs.${product.price} </span>
				</h2>


				<img
					src="<c:url value="/resources/images/product/${product.code}.jpg" />"
					 alt="Image not supported" width="150"
					height="150"/> <a
					href="${pageContext.request.contextPath }/totalProductInfo/${product.productid}"
					class="btn btn-primary col-xs-12" role="button"> Click for
					Large</a>
					
					<div class="clearfix"></div>
					
					</div>
			</div>
			<c:set var="count" value="${count+1 }"/>
			<c:if test="${count==4 }">
			<c:set var="count" value="0"/>
			</div>
			<div class="row">
			</c:if>
			</c:forEach>
			</div>
			
		
</div>
 
 
 