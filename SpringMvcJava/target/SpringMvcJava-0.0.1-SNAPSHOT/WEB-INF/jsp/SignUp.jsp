<%@page import="com.spring.Constants.Constants"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h3>Welcome to Socialize</h3>
<style>
    /*set border to the form*/
      
    form {
        border: 3px solid #f1f1f1;
    }
    /*assign full width inputs*/
      
    input[type=text],
    input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    /*set a style for the buttons*/
      
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }
    /* set a hover effect for the button*/
      
    button:hover {
        opacity: 0.8;
    }
    /*set extra style for the cancel button*/
      
    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }
    /*centre the display image inside the container*/
      
    .imgcontainer {
        text-align: center;
        margin: 12px 0 12px 0;
    }
    /*set image properties*/
      
    img.avatar {
        width: 20%;
        border-radius: 30%;
    }
    /*set padding to the container*/
      
    .container {
        padding: 16px;
    }
    /*set the forgot password text*/
      
    span.psw {
        float: right;
        padding-top: 16px;
    }
    /*set styles for span and cancel button on small screens*/
      
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }
        .cancelbtn {
            width: 100%;
        }
    }
</style>

  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
</head>
<script>  
function validateform(){ 
var email=document.signupform.email.value;  
var username=document.signupform.username.value;  
var password=document.signupform.password.value;
var cpassword=document.signupform.confirmpassword.value;
var age=document.signupform.age.value;
var place=document.signupform.place.value; 
var re = /\S+@\S+\.\S+/;
 if(!(re.test(email)))
	 {
	 alert("enter valid emailid");
	 return false;
	 }
else if (username==null || username==""){  
  alert("Username can't be blank");  
  return false;  
}
else if(password.length<6){  
  alert("Password must be at least 6 characters long.");  
  return false;  
  } 
else if(password!=cpassword)
	{
	alert("Enter the correct confirm password ");
	return false;
	}
else if(age==null || age=="")
	{
	alert("Enter Age");
	return false;
	}
else if(place==null || place=="")
	{
	alert("Enter Place");
	return false;
	}
 

}  
</script>  
<body>
<form action="signup" name="signupform" onsubmit="return validateform()" method="post" modelAttribute="signupBean"  >
<div class="imgcontainer">
         <img src="https://lh3.googleusercontent.com/proxy/ufddJfAYom1bshZ5Jw477sgz4q9hiCJBpNl1RrMw49kQEh7fdwYjqfpfwo5Re58EaCz0zng9WgcSjfdG5RJSs1yHC1P4u2dEOf9C9lP0WwF4TwG_l5kWpgudZcrV"
                 alt="Avatar" class="avatar">
        </div>
        <div class="container">
EmailId:<input type="text" placeholder="Email id required" name="<%=Constants.LOGINEMAIL %>" >
Username:<input type="text" placeholder="Type Username" name="<%=Constants.LOGINUSERNAME %>" ><br>
Password:<input type="password" placeholder="Type Password" name="<%=Constants.LOGINPASSWORD %>" ><br>
Confirm Password:<input type="password" placeholder="Type Confirm Password" name="<%=Constants.LOGINCONFIRMPASSWORD %>" ><br>
Gender:<input type="radio" placeholer="select gender" name="<%=Constants.LOGINGENDER %>" value="m" id="male">male
<input type="radio" placeholer="select gender" name="<%=Constants.LOGINGENDER %>" value="f" id="female">female<br>
Age:<input type="text" placeholder="Enter age" name="<%=Constants.LOGINAGE %>" ><br>
Place:<input type="text" placeholder="Enter Place" name="<%=Constants.LOGINPLACE%>"><br>


<input type="submit">
</div>
</form>

</body>
</html>