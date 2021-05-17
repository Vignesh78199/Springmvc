package com.spring.Controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.spring.Model.SignupBean;

@Controller
@ResponseBody
public class SignUpController 
{
	
	@RequestMapping(value="/signup",method=RequestMethod.GET,produces="application/json")
    public ModelAndView displaySignup(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView("signup");
        SignupBean signupBean = new SignupBean();
        model.addObject("signupBean", signupBean);
        
        return model;
    }
	
	
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView signup( HttpServletResponse response,HttpServletRequest request,@ModelAttribute("signupBean")SignupBean signupBean) throws ClassNotFoundException, IOException, ServletException
	{
		
		String email=signupBean.getEmail();
		String password=signupBean.getPassword();
		String confirmpassword=signupBean.getConfirmpassword();
		String username=signupBean.getUsername();
		String gender=signupBean.getGender();
		String age=signupBean.getAge();
		String place=signupBean.getPlace();
		System.out.println(email+password+place);
		ModelAndView mv=new ModelAndView();
		
		
		
	
		InputStream in =new FileInputStream("/home/local/ZOHOCORP/vignesh-pt4085/Desktop/download.jpeg");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			PreparedStatement ps=conn.prepareStatement("insert into registratiion1(email,username,password,confirmpassword,gender,age,place,photo)values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1,email);
			ps.setString(2,username);
			ps.setString(3,password);
			ps.setString(4,confirmpassword);
			ps.setString(5,gender);
			ps.setString(6,age);
			ps.setString(7,place);
			ps.setBlob(8,in);
			
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
			
		}
		mv.setViewName("Login.jsp");
	
		
		return mv;
		

	}
	
	
	

}
