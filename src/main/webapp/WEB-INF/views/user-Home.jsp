<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy And Sell</title>
</head>
<style>
<style>
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

input[type=text]:focus {
    width: 25%;
}

input[type=text] {
    width: 300px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('searchicon.png');
    background-position: 5px 5px; 
    background-repeat: no-repeat;
    padding: 2px 10px 2px 20px;
    -webkit-transition: width 0.2s ease-in-out;
    transition: width 0.2s ease-in-out;
}

* {
  box-sizing: border-box;
}

/*#myInput {
   width: 100px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('searchicon.png');
    background-position: 5px 5px;*/ 
   /* background-repeat: no-repeat;
    padding: 2px 10px 2px 20px;
    -webkit-transition: width 0.2s ease-in-out;
    transition: width 0.2s ease-in-out;
}*/

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}

.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
    background-color: #3e8e41;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {background-color: #f1f1f1}

.show {display:block;}

.button {
  display: inline-block;
  border-radius: 4px;
  background-color: red;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 14px;
  padding: 15px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
<body>
<h3> Welcome to Let go..!</h3>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="topnav" id="myTopnav">
  <a href="${contextPath}/veiwMyAdds">VIEW MY ADDS</a>
  <a href="${contextPath}/myMessages">VIEW MY MESSAGES</a>
  <a href="${contextPath}/addItem">SELL AN ITEM</a>
  <%if (session.getAttribute("ROLE").equals("admin")) { %>
  <a href="${contextPath}/admin/AdminSearch">VIEW ALL ADDS</a>
  <a href="${contextPath}/admin/addCategory">ADD A CATEGORY</a>
  <% } %>
  <a href="${contextPath}/logout">LOGOUT</a>
</div>
<br>
<form action="${contextPath}/search" method="post">
KEYWORD <input type="text" name="keyword" placeholder="What are you looking for?"/> 
<br>
<br>
CITY &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="city" id="myInput" onkeyup="myFunction()" placeholder="which locatio..?" />
<br>
<br> 
<table id="myTable">
  <tr class="header">
    <th style="width:60%;">City</th>
    </tr>
    <c:forEach items="${cityList}" var="city"> 
    <tr>
    <td>${city.city}</td>
    
  </tr>
  </c:forEach>
  </table>
  <br>
  <br>
  <br>
  <br>
    <button class="button" type="submit"><span>SEARCH</span></button>
</form>

<br>

<br>

<script>
function myFunction() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}

</script>
</body>
</html>