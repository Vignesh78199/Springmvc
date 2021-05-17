<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@page import="com.spring.Model.UserFriend"%>
    <%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}
.imgcontainer {
        text-align: center;
        margin: 24px 0 24px 0;
    }
    
    
      
    img.avatar {
        width: 20%;
        border-radius: 25%;
    }
    #AUlogo{ 
  height: 20px;
width: auto;
} 
    
/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}


.header {
  padding: 1px;
  font-family:Luminari;
  font-weight: 600;
  text-align: center;
  background: #004d99;
  color:white;
}


.header h1 {
  font-size: 10px;
}


.navbar {
  overflow: hidden;
  background-color: #333;
  position: sticky;
  position: -webkit-sticky;
  top: 0;
}


.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}


/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.navbar a.active {
  background-color: #666;
  color: white;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
  
  
}

/* Main column */
.main {   
  -ms-flex: 70%; /* IE10 */
  flex: 70%;
  background-color: white;
  padding: 20px;
}

/* Fake image, just for this example */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
  height: 55px;
width: auto;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
}


@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
  }
}


@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
</style>
</head>

<body>

<div class="header">
	<div class="imgcontainer">
  <img src="https://lh3.googleusercontent.com/proxy/ufddJfAYom1bshZ5Jw477sgz4q9hiCJBpNl1RrMw49kQEh7fdwYjqfpfwo5Re58EaCz0zng9WgcSjfdG5RJSs1yHC1P4u2dEOf9C9lP0WwF4TwG_l5kWpgudZcrV"
                 alt="Avatar" class="avatar">
      </div>  
  
  <p>
  <h2>Welcome  <%= request.getAttribute("usernames") %> Let's Bring The World Together</h2>
 </p>
</div>

<div class="navbar">
  <a href="#" class="active">Profile</a>
  <a href="suggest">Friend Suggestion</a>
  <a href="myfriend">My Friends</a>
  <a href="friendrequest">Friend Request</a>
  <a href="Restcall">Three-In-One</a>
  <a href="logout" class="right">Logout</a>
</div>

<div class="row">
  	<div class="side">
   <center><h2>About <%= request.getAttribute("usernames") %></h2></center>
    
  
    	<center>
		<img src="data:image/jpeg;base64,${imgBase}" width="250" height="250" />
		<form name="form1" method="post" action="image-process.jsp" enctype="multipart/form-data">
		<input type="submit" name="submit" value="ADD PHOTO">
		</form>
		</center>
   
   </div>
  <div class="main">
    <table border ="10" width="900" align="center">
         <tr bgcolor="#004d99" >
         
          <th><b></b></th>
         
         
         </tr>
   	<%ArrayList<UserFriend> std = 
            (ArrayList<UserFriend>)request.getAttribute("data");
        for(UserFriend s:std){
        	
        
        	
        %><%-- Arranging data in tabular form
        --%>
        
            <tr>
            	
                <td><%=s.getName()%><br><br>   <img src="data:image/jpeg;base64,<%=s.getEncode()%>"   width="750" height="500" /></td>
             
               
               </form></center></td>
                
            </tr>
          
       
            <%}%>
  
    
  
    
  </div>
</div>

<div class="footer">
  <h2></h2>
</div>

</body>
</html>
