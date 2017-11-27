<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MedicineAPI - Place Order</title>
</head>
<body>
<form action="rest/medicine/products/order" method="post">
        <table>
                <tr>
                        <td>Order Number: </td>
                        <td><input type="text" name="orderNo" id="orderNo" /></td>
                </tr>
                
                <tr>
                        <td>User Id: </td>
                        <td><input type="text" name="userId" id="userId" /></td>
                </tr>
                
                <tr>
                        <td>Product Id: </td>
                        <td><input type="text" name="productId" id="productId" /></td>
                </tr>
                
                <tr>
                        <td>Order Date: </td>
                        <td><input type="date" name="orderDate" id="orderDate" /></td>
                </tr>
                
                <tr>
                        <td>Order Quantity:</td>
                        <td><input type="number" name="orderQty" id="orderQty" /></td>
                </tr>
                
                <tr>
                        <td>Order Price:</td>
                        <td><input type="text" name="orderPrice" id="orderPrice" /></td>
                </tr>
                
                <tr>
                        <td><input type="submit" value="Place Order" /></td>
                </tr>
        </table>
</form>
</body>
</html>