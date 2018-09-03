<%@ page language="java" contentType="text/html"%>
<%@ include file="templates/navbar.jsp"%>

<div class="container">
	<table class="table">
		<tr>
			<td><center>
					<h2>Shopping Cart</h2>
				</center></td>
		</tr>
		<tr>
			<td>SL #</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total price</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${cartItems}" var="cartItem">
			<form
				action="${pageContext.request.contextPath}/updateCartItem/${cartItem.cartItemId}"
				method="get">
			<tr>
				<td></td>
				<td>${cartItem.productname}</td>
				<td><input type="text" name="quantity" value="${cartItem.quantity}" /></td>
				<td>${cartItem.price}</td>
				<td>${cartItem.quantity * cartItem.price}</td>
				<td><input type="submit" value="Update" class="btn btn-info" />
					<a
					href="${pageContext.request.contextPath}/deleteCartItem/${cartItem.cartItemId}"
					class="btn btn-danger">Delete</a></td>
			</tr>

			</form>
		</c:forEach>
		<tr bgcolor="orange">
			<td colspan="4">Total Purchased Amount</td>
			<td colspan="2">${totalPurchasedAmount}</td>
		</tr>

		<tr>
			<td colspan="3"><a
				href="${pageContext.request.contextPath}/continueShopping"
				class="btn btn-info">Continue Shopping</a></td>
			<td colspan="3"><a
				href="${pageContext.request.contextPath}/checkout"
				class="btn btn-info">Check Out</a></td>
		</tr>
	</table>

</div>