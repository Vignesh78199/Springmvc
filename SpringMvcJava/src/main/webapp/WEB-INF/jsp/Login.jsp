
<%@page import="com.spring.Constants.Constants"%>
<html>
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
        margin: 24px 0 12px 0;
    }
    /*set image properties*/
      
    img.avatar {
        width: 40%;
        border-radius: 50%;
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
<body>
<form action="login" method="post"  modelAttribute="loginBean">
<div class="imgcontainer">
            <img src="https://lh3.googleusercontent.com/proxy/ufddJfAYom1bshZ5Jw477sgz4q9hiCJBpNl1RrMw49kQEh7fdwYjqfpfwo5Re58EaCz0zng9WgcSjfdG5RJSs1yHC1P4u2dEOf9C9lP0WwF4TwG_l5kWpgudZcrV""
                 alt="Avatar" class="avatar">
        </div>
        <div class="container">
Email Id:<input type="text" name="<%=Constants.LOGINEMAIL %>" ><br>
Password:<input type="password" name="<%=Constants.LOGINPASSWORD %>"><br>
<input type="submit">
</div>
<div class="container" style="background-color:#f1f1f1">
            <button type="button" class="cancelbtn">Cancel</button>
            <span class="psw">Sign up <a href="SignUp.jsp">New User?</a></span>
        </div>

</form>
</body>
</html>
