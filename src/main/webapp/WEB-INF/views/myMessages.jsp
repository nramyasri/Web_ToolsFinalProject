<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<title>My Messages</title>
</head>
<style>
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: red;
}

input[type=submit] {
    width: 20%;
    background-color: red;
    color: white;
    padding: 7px 10px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
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

 select
 {
    width: 20%;
    background-color: white;
    color: Black;
    padding: 7px 10px; 
 
 }

h1 {
    color: white;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
}


table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}

.button {
    background-color: white
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 12px;
    margin: 4px 2px;
    cursor: pointer;
}

.button3 {
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
}

.dropbtn {
    background-color: red;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
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
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}



</style>
<body>
<div class="topnav" id="myTopnav">
  <a href="${contextPath}/veiwMyAdds">VIEW MY ADDS</a>
  <a href="${contextPath}/myMessages">VIEW MY MESSAGES</a>
  <a href="${contextPath}/addItem">SELL AN ITEM</a>
  <a href="${contextPath}/HomePage">SEARCH PAGE</a>
  <a href="${contextPath}/logout">LOGOUT</a>
</div>


<H3>Your conversations..</H3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <form  method="post" action="${contextPath}/myMessages">
       
       
       <select name="title">
    
       <c:forEach items="${sessionScope.adList}" var="ad">
     
           <option>${ad.title}</option>
           </c:forEach>
       </select>
       
     <input type="submit" name="submit" value="Select Add"/>
      <input type="hidden" name="action" value="view" />
    </form>
    
 <c:choose>
<c:when test="${!empty msgList}">
           <table>            
            <thead>
                <tr>
                    <th>Message</th>
                    <th>Message Date</th>
                    <th>from </th>
                    <th>to</th>
                    <th></th>
                     </tr>                
            </thead>
            <tbody>
           <c:forEach items="${msgList}" var="msg"> 
            <tr>
                    <td>${msg.message}</td>
                    <td>${msg.messageDate}</td>
                    <td>${msg.fromUser}</td>
                    <td>${msg.toUser}</td>
                    <c:choose>
                    <c:when test="${msg.fromUser!=sessionScope.user.username}">
                   <td><form action="${contextPath}/chat" method="get">
    <button class="button button3" type="submit"><font color="red">CHAT..</font></button>
    <input type="hidden" value="${msg.fromUser}" name="toUser">
    <input type="hidden" value="${msg.advert.id}" name="advertID">  
   
</form></td>
</c:when>
<c:otherwise>
<td></td>
</c:otherwise>

</c:choose>
                   
     <!--  <td><form action="${contextPath}/chat" method="get">
    <input type="submit" value="CHAT.."/>
    <input type="hidden" value="${msg.fromUser}" name="toUser">
    <input type="hidden" value="${msg.advert.id}" name="advertID">  
   
</form></td>-->
                     </tr>                
            </c:forEach> 
             </tbody>
            
                </table><br>
                </c:when>
           <c:otherwise>
<form  method="post" action="${contextPath}/myMessages">
       <select name="title">
       <c:forEach items="${sessionScope.adList}" var="ad">
           <option>${ad.title}</option>
           </c:forEach>
       </select>
     <input type="submit" name="submit" value="Select Add"/>
      <input type="hidden" name="action" value="view" />
    </form>
</c:otherwise>
</c:choose>

</body>
</html>