<%@ page language="java" contentType="text/html"%>
<%@ include file="templates/navbar.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<table class="table">
		<tr bgcolor="lightblue">
			<td colspan="2"><center>
					<h2>Your Order</h2>
				</center></td>
		</tr>
		
		<tr bgcolor="orange">
		<td>Total Amount</td>
		<td>${totalPurchasedAmount}</td>
		</tr>
	</table>
</div>

<div class="container">
<form:form modelAttribute="orderDetail" action="${pageContext.request.contextPath}/paymentProcess/${orderDetail.orderId}" method="post">
	<table class="table">
		<tr bgcolor="lightblue">
			<td colspan="2"><center>
					<h2>Payment Option</h2>
				</center></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="radio" name="paymenttype"
				value="CC" />Credit Card <input type="radio" name="paymenttype"
				value="COD" />Cash ON Delivery</td>
		</tr>

		<tr>
			<td>Card no.</td>
			<td><input type="text" name="cardno" required /></td>
		</tr>

		<tr>
			<td>CVV</td>
			<td><input type="text" name="cvv" /></td>
		</tr>

		<tr>
			<td>Valid Upto</td>
			<td><input type="text" name="valid" /></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Payment" /></td>
		</tr>
		
		

	</table>
</form:form>
</div>