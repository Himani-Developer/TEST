<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<table class="table" border="1">

		<tr>
			<td rowspan="9"><img
				src="<c:url value="/resources/images/product/${product.code}.jpg"/>" width="300"
				height="300" /></td>
		</tr>

		<tr>
			<td>product id</td>
			<td>${product.productid}</td>
		</tr>

		<tr>
			<td>product Name</td>
			<td>${product.productname}</td>
		</tr>

		<tr>
			<td>Price</td>
			<td>${product.price}</td>
		</tr>

		<tr>
			<td>Supplier id</td>
			<td>${product.supid}</td>
		</tr>

		<tr>
			<td>Stock</td>
			<td>${product.stock}</td>
		</tr>

		<tr>
			<td>Category</td>
			<td>${categoryname}</td>
		</tr>
<form action="${pageContext.request.contextPath }/AddToCart/${product.productid}" method="get">
		<tr>
			<td>Quantity</td>
			<td><select name="quantity" class="form-control btn-block">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select></td>
		</tr>
		
		<tr>
		<td colspan="2">
		<input type="submit" value="AddToCart" class="btn btn-info btn-block"> 
		</td>
		</tr>
</form>
	</table>

</div>

