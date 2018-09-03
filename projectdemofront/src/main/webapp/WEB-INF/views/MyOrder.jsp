<%@ page language="java" contentType="text/html"%>
<%@ include file="templates/navbar.jsp"%>
<div class="container">
	<table class="table">
		<tr>
			<td colspan="6"><center>
					<h2>Your Order</h2>
				</center></td>
		</tr>

		<tr>
			<td>SL#</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total price</td>
		</tr>

		<c:if test="${empty cartItems}">
			<tr>
				<td colspan="6"><center>Your Cart Is Empty!!!</center></td>
			</tr>
		</c:if>

		<c:if test="${not empty cartItems}">
		<c:forEach items="${cartItems}" var="cartItem">
			<tr>
				<td></td>
				<td>${cartItem.productname}</td>
				<td>${cartItem.quantity}</td>
				<td>${cartItem.price}</td>
				<td>${cartItem.quantity * cartItem.price}</td>

			</tr>
		</c:forEach>
		</c:if>

		<tr bgcolor="orange">

			<td colspan="4">Total Purchased Amount</td>
			<td>${totalPurchasedAmount}</td>
		</tr>

		<tr>
			<td colspan="3"><a
				href="${pageContext.request.contextPath}/continueShopping"
				class="btn btn-info">Continue Shopping</a></td>
			<td colspan="2"><a
				href="${pageContext.request.contextPath}/payment"
				class="btn btn-info">Payment</a></td>
		</tr>

	</table>


</div>