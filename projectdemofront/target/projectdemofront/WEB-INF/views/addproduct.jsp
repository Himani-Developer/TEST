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


<body>
	<%@include file="templates/navbar.jsp"%>
	<h1>product</h1>
	<hr />
	<center>
		<form:form modelAttribute="product"
			action="${pageContext.request.contextPath}/${url}" method="post"
			enctype="multipart/form-data">
			<c:if test="${UserClickedEdit==true}">
				<form:hidden path="productid" />
			</c:if>
			<form:input path="productname" placeholder="productname" /></br>
			<form:input path="productbrandname" placeholder="productbrandname" />
			</br>
			<form:input path="productcolor" placeholder="productcolor" /></br>
			<form:input path="productmaterial" placeholder="productmaterial" />
			<br>
		PRICE<form:input path="price" placeholder="price" />
			<br>
		STOCK<form:input path="stock" placeholder="stock" />
			<br>
			<form:input path="productdetails" placeholder="productdetails" />
			<br>

			<form:input path="file" type="file" />
			<br>
		
		Category ID <form:select path="categoryid" items="${catlist}"
				itemLabel="categoryname" itemValue="categoryid">
			</form:select>
			<br>
		
		SUPID<form:input path="supid" /></br>


			<c:if test="${UserClickedEdit==true}">
				<input type="submit" value="Update product" />
			</c:if>
			<c:if test="${UserClickedEdit!=true}">
				<input type="submit" value="Save product" />
			</c:if>
		</form:form>

		<table align="center" width="300">
			<thead>
				<tr bgcolor="aqua">
					<th>Image</th>
					<th>ID</th>
					<th>NAME</th>
					<th>Brand Name</th>
					<th>Price</th>
					<th>Stock</th>
					<th>Product color</th>
					<th>Material</th>
					<th>DISCRIPTION</th>
					<th>Category</th>
					<th>Supplier</th>

					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productlist}" var="product">
					<tr bgcolor="pink">
						<td><img src="resources/images/product/${product.code}.jpg"
							height="200px" width="200px" /></td>
						<td>${product.productid}</td>
						<td>${product.productname}</td>
						<td>${product.productbrandname}</td>
						<td>${product.price}</td>
						<td>${product.stock}</td>
						<td>${product.productcolor}</td>
						<td>${product.productmaterial}</td>
						<td>${product.productdetails}</td>
						<td>${product.categoryid}</td>
						<td>${product.supid}</td>

						<td><a
							href="${pageContext.request.contextPath}/editproduct/${product.productid}">Edit</a>

							<a
							href="${pageContext.request.contextPath}/deleteproduct/${product.productid}">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</center>
</body>
</html>
