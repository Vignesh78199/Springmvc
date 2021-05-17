<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import ="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
String email=request.getParameter("email");
String username=request.getParameter("username");
String password=request.getParameter("password");
String confirmpassword=request.getParameter("confirmpassword");
String gender=request.getParameter("gender");
String age=request.getParameter("age");
String place=request.getParameter("place");

try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
	PreparedStatement ps=conn.prepareStatement("insert into registratiion(email,username,password,confirmpassword,gender,age,place)values(?,?,?,?,?,?,?)");
	ps.setString(1,email);
	ps.setString(2,username);
	ps.setString(3,password);
	ps.setString(4,confirmpassword);
	ps.setString(5,gender);
	ps.setString(6,age);
	ps.setString(7,place);
	int x=ps.executeUpdate();
	
	if(x>0)
	{
		System.out.println("Registration successfull");
	     
	}
	else
	{
		System.out.println("registration failed");
	}
	ps.close();
	conn.close();
	
}
catch(SQLException e)
{
	e.printStackTrace(); 
}

%>
<body>
	<form action="Login.jsp">
	</form>
</body>
</html>

