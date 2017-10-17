<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: red;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

a:link, a:visited {
    background-color: #f44336;
    color: white;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: red;
}

</style>
<body>
<h3><a href="register.htm">Click here to register..</a><br/></h3>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<br>
<br>
	<h2><font color="red"></font>Already registered? Login here..</h2>
	<form action="${contextPath}/HomePage" method="post">
	
		<table>
		<tr>
		    <td>User Name:</td>
		    <td><input type="text" name="username" size="50" required="required" placeholder="Enter Username"/></td>
		</tr>
		
		<tr>
		    <td>Password:</td>
		    <td><input type="password" name="password" size="50" required="required" placeholder="Enter Password"/></td>
		</tr>
		
		<tr>
		  <td><button type="submit">Login</button></td>  
		</tr>
				
		</table>
         
	</form>

</body>
</html>
