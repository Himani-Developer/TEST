<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

</head>

<%@include file="templates/navbar.jsp"%>
<h1>Supplier</h1>
<hr />

<c:if test="${UserClickedEdit==true} ">
	<c:set var="url" value="UpdateSupplier" />
</c:if>

<c:if test="${UserClickedEdit!=true} ">
	<c:set var="url" value="SaveSupplier" />
</c:if>

<!-- --------- form  ------------- -->
<center>

	<form:form modelAttribute="supplier"    
		action="${pageContext.request.contextPath}/${url}" method="post">    

		<c:if test="${UserClickedEdit==true }">
			<form:hidden path="supid" />
		</c:if>

		<form:input path="supname" placeholder="supplier Name" />     
		<form:input path="supphone" placeholder=" phone" />
		<form:input path="supdetails" placeholder=" details" />

		<c:if test="${UserClickedEdit==true }">
			<input type="submit" value="Update Supplier" />
		</c:if>

		<c:if test="${UserClickedEdit!=true }">
		<input type="submit" value="Save Supplier" />
		</c:if>
		
	</form:form>



	<!-- ---------------- table------- -->

	<table align="center" width="300">
		<thead>
			<tr bgcolor="pink">
				<th>ID</th>
				<th>NAME</th>
				<th>PHONE</th>
				<TH>DETAILS</TH>
				<TH>ACTION</TH>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${supplist}" var="supp">
				<tr>
					<td>${supp.supid }</td>
					<td>${supp.supname }</td>
					<td>${supp.supphone }</td>
					<td>${supp.supdetails }</td>

					<td><a
						href="${pageContext.request.contextPath }/editsupp/${supp.supid } ">Edit</a>
						
						<a
						href="${pageContext.request.contextPath }/deletesupp/${supp.supid } ">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>





</center>