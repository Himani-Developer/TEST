<%@ page language="java" contentType="text/html"%>
<%@include file="templates/navbar.jsp"%>

<div class="container">

	<table class="table">
		<tr>
			<td colspan="6"><center>
					<h2>RECEIPT</h2>
				</center></td>
		</tr>
		<tr>

			<td>Order ID</td>
			<td>${orderDetail.orderId}</td>
			<td>Order Date</td>
			<td>${orderDetail.orderDate}</td>
		</tr>
		<TR>
		<td>Address for delivery</td>
		<td>${user.address}</td>
		</TR>

		
		<tr bgcolor="yellow">
			<td>SL#</td>
			<td>Product name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Price</td>
		</tr>


		<c:forEach items="${cartItems }" var="cartItem">
			<tr>
				<td></td>
				<td>${cartItem.productname}</td>
				<td>${cartItem.quantity}</td>
				<td>${cartItem.price}</td>
				<td>${cartItem.quantity * cartItem.price}</td>
			</tr>
		</c:forEach>




		<tr bgcolor="aqua">
			<td colspan="4">Total Purchased Amount</td>
			<td>${totalPurchasedAmount}</td>
		</tr>
		
		<tr>
		<td colspan="5"><center>Thanks for shopping here.. Hope to see you again</center></td>
		</tr>

	</table>

</div>