<%@ page language="java" contentType="text/html"%>
<%@ include file="templates/navbar.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
* {
  box-sizing: border-box;
}

body {
  background-color: #f1f1f1;
  padding: 20px;
  font-family: Arial;
}

/* Center website */
.main {
  max-width: 1000px;
  margin: auto;
}

h1 {
  font-size: 50px;
  word-break: break-all;
}

.row {
  margin: 10px -16px;
}

/* Add padding BETWEEN each column */
.row,
.row > .column {
  padding: 8px;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  display: none; /* Hide all elements by default */
}

/* Clear floats after rows */ 
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Content */
.content {
  background-color: white;
  padding: 10px;
}

/* The "show" class is added to the filtered elements */
.show {
  display: block;
}

/* Style the buttons */
.btn {
  border: none;
  outline: none;
  padding: 12px 16px;
  background-color: white;
  cursor: pointer;
}

.btn:hover {
  background-color: #ddd;
}

.btn.active {
  background-color: #666;
  color: white;
}
</style>
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
	<!-- <table class="table">
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
		
		

	</table> -->
	
	<!-- MAIN (Center website) -->
<div class="main">

<h1>PAYMENT Options</h1>
<hr>



<div id="myBtnContainer">
  <button class="btn active" onclick="filterSelection('all')">  All Payment modes</button>
  <button class="btn" onclick="filterSelection('creditcard')"> Credit Card</button>
  <button class="btn" onclick="filterSelection('cod')"> Cash On Delivery</button>
  
</div>

<!-- Portfolio Gallery Grid -->
<div class="row">
  <div class="column creditcard">
    <div class="content">
    <div class="container">
    <img alt="Credit card 2  image not supported" src="resources/images/creditcard2.jpg" width="35%"/>
    </div>
    <h2>Credit Card Details</h2>
    <hr>
    
    <table bgcolor="#00FF00">
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
     
      
    </div>
  </div>
  
  
  
  <div class="column cod">
    <div class="content">
     <h2>Cash On Delivery</h2>
     <img alt="COD1 image not supported" src="resources/images/cod1.jpg" width="100%"/>
     <hr>
      <table bgcolor="yellow">
      <tr>
      <td>Name</td>
      <td><input type="text" name="name"/></td>
      </tr>
      <tr>
      <td>Phone no.</td>
      <td><input type="text" name="phone"/></td>
      </tr>
      <tr>
      <td>Address</td>
      <td><textarea rows="2" cols="7"></textarea></td>
      </tr>
      <tr>
			<td colspan="2"><input type="submit" value="Payment" /></td>
		</tr>
		
      
      </table>
      
      
      
    </div>
  </div>
    

  
  
  
<!-- END GRID -->
</div>

<!-- END MAIN -->
</div>


	
</form:form>
</div>
<script>
filterSelection("all")
function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("column");
  if (c == "all") c = "";
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "show");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
  }
}

function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);     
    }
  }
  element.className = arr1.join(" ");
}


// Add active class to the current button (highlight it)
var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}
</script>










