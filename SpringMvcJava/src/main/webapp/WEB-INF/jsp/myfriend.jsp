<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.spring.Model.UserFriend2"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
  box-sizing: border-box;
}
.imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }
    
      
    img.avatar {
        width: 20%;
        border-radius: 25%;
    }
/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}


.header {
  padding: 20px;
  font-family:Luminari;
  font-weight: 600;
  text-align: center;
  background: #004d99;
  color:white;
}


.header h1 {
  font-size: 25px;
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
     $('#YourButton').click(function(e) {
     e.preventDefault();
     var ajaxdata = $("#userid").val();
     var value ='userid='+ajaxdata;

     $.ajax({
     url: "RemoveFriend",
     //type: "post",
     data: value,
     cache: false,
     success: function(data) {
    	 
     $("#userid").val('');
     alert('Blocked friend');
     }
     });
});
});
</script>

</head>

<body>
	<h2> </h2>
	<div class="header">
	<h1>Displaying Friend List</h1>
	</div>
	
      <table border ="10" width="1300" align="center">
         <tr bgcolor="#004d99" >
        
          <th><b> Name</b></th>
          <th><b>Block</b></th>
        
     	
          
         </tr>
         <%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "MyFriendController.java"
        --%> 
        <%ArrayList<UserFriend2> std = 
            (ArrayList<UserFriend2>)request.getAttribute("data");
        for(UserFriend2 s:std){
    
        %>
       
        
            <tr>
              
              <center>  <td><%=s.getName()%></td></center>
  				
                <td><center><form name="Removeform" action="RemoveFriend" id="Removeform" >
                <input id="userid" name="userid" type="hidden" value="<%=s.getUserid()%>"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>      
               	<center><input type="button" id="YourButton" value="Block"/></center>
               
                
               </form></center></td>
            </tr>
            <%}%>
  
         </table>
         
</body>
</html>