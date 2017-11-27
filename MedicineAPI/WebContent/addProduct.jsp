<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MedicineAPI  - Add Product</title>
</head>
<body>
<form action="rest/medicine/products" method="post">
        <table>
                <tr>
                                <td>Code: </td>
                                <td><input type="text" name="code" id="code" /></td>
                </tr>
                
                 <tr>
                                <td>Name: </td>
                                <td><input type="text" name="name" id="name" /></td>
                </tr>
                
                 <tr>
                                <td>Category Id:</td>
                                <td><input type="text" name="catId" id="catId" /></td>
                </tr>
                
                <tr>
                                <td>Price: </td>
                                <td><input type="text" name="price" id="price" /></td>
                </tr>
                
                <tr>
                                <td>Image Path: </td>
                                <td><input type="text" name="image" id="image" /></td>
                </tr>
                
                <tr>
                                <td>Description: </td>
                                <td><input type="text" name="desc" id="desc" /></td>
                </tr>
                
                 <tr>
                                <td>Status: </td>
                                <td>
                                                <input type="radio" name="status"  value="Available"/>Available
                                                <input type="radio" name="status" value="Not Available"/>Not Available
                                </td>
                </tr>
                <tr>
                                <td>Prescription required: </td>
                                <td>
                                                <input type="radio" name="presReq"  value="Yes"/>Required
                                                <input type="radio" name="presReq" value="No"/>Not Required
                                </td>
                </tr>
                <tr>
                                <td>Tab strips: </td>
                                <td><input type="number" name="tabStrips"/></td>
                </tr>
                <tr>
                                <td><input type="submit" value="add"/></td>
                </tr>
        </table>
</form>
</body>
</html>