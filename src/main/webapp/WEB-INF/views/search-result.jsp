<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.container {
  padding: 0 8px;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
  font-size: 18px;
}

input[type=submit] {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}

body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: red;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: white;
  color: red;
}

.topnav a.active {
    background-color: white;
    color: white;  
    
}


</style>
<title>Search</title>
</head>
<body>
<div class="topnav" id="myTopnav">
  <a href="${contextPath}/veiwMyAdds">VIEW MY ADDS</a>
  <a href="${contextPath}/myMessages">VIEW MY MESSAGES</a>
  <a href="${contextPath}/addItem">SELL AN ITEM</a>
  <a href="${contextPath}/HomePage">SEARCH PAGE</a>
  <a href="${contextPath}/logout">LOGOUT</a>
</div>

<h3><font color="red">Items for Sale..</font></h3>

 <c:forEach items="${adList}" var="ad">
<div class="card">
  <img src="${ad.filename}"  style="width:100%">
  <div class="container">
    
    <p class="title">${ad.title}</p>
    <p>${ad.message}</p>
    
    <p>${ad.price}</p>
    <div style="margin: 24px 0;">
      <form action="${contextPath}/sendMessage" method="get">
    <input type="submit" value="MESSAGE THE SELLER"/>
    <input type="hidden" value="${ad.user.username}" name="postedBy"> 
    <input type="hidden" value="${ad.user.userAccountId}" name="userAccountId">
    <input type="hidden" value="${ad.id}" name="advertID"></form>
    
   </div>
   
</div>
</div>
<br><br>
</c:forEach>
 

</body>
</html>