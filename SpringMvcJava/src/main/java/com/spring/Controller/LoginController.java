package com.spring.Controller;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.Constants.Constants;
import com.spring.Model.LoginBean;
import com.spring.Model.UserFriend;




@Controller
@ResponseBody
public class LoginController {
	
	   @RequestMapping(value="/login",method=RequestMethod.GET,produces="application/json")
	    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	    {
	        ModelAndView model = new ModelAndView("login");
	        LoginBean loginBean = new LoginBean();
	        model.addObject("loginBean", loginBean);
	        response.setIntHeader("Refresh",3); 
	        
	       
	        return model;
	    }
	
	
	
	@RequestMapping(value="/login",method =RequestMethod.POST)
	public  ModelAndView login(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("loginBean")LoginBean loginBean) throws ClassNotFoundException
	{
		 
		
		String email=loginBean.getEmail();
		String password=loginBean.getPassword(); 
		
		ModelAndView mv=new ModelAndView();
		Cookie theCookie=new Cookie("email",email);
		theCookie.setMaxAge(60*60);
		response.addCookie(theCookie);
		String dburl=Constants.DBHOST;
		String dbuser=Constants.DBUSER;
		String dbpass=Constants.DBPASSWORD;
		
		
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection(dburl,dbuser,dbpass);
		        String queryString = "SELECT * FROM registratiion1 WHERE email=? and password=?";
		        PreparedStatement ps=conn.prepareStatement(queryString);
		        ps.setString(1,email);
				ps.setString(2,password);
		        ResultSet result = ps.executeQuery();
		        byte[] imgData = null ;	
		        if(result.next()) {
		        	  int userid=result.getInt("userid");
		        	 
		        	  String place=result.getString("place");
		        	  Cookie theCookie1=new Cookie("place",place);
		      		theCookie1.setMaxAge(60*60);
		      		response.addCookie(theCookie1);
		      		  Cookie theCookie2=new Cookie("userid",String.valueOf(userid));
		      		  response.addCookie(theCookie2);
		      		theCookie2.setMaxAge(60*60);
		              String username=result.getString("username");
		              Cookie theCookie3=new Cookie("username",username);
		      		  response.addCookie(theCookie3);
		      		theCookie3.setMaxAge(60*60);
		      		int age=result.getInt("age");
		      		String age1=String.valueOf(age);
		      		Cookie theCookie4=new Cookie("age",age1);
		      		response.addCookie(theCookie4);
		      		theCookie4.setMaxAge(60*60);
		      		
		             
		             
		              mv.addObject("usernames",username);
		              imgData = result.getBytes("photo");
		             
		              String encode = Base64.getEncoder().encodeToString(imgData);
		            
		              request.setAttribute("imgBase", encode);
		              
		              String queryString1 = "Select DISTINCT r.username,r.userid,r.email,r.place,r.photo from registratiion1 r inner join friends f on r.userid=f.userid where f.friendid=(select r.userid from registratiion1 r where r.email=? and status='2') union all Select DISTINCT username,r.userid,r.email,r.place,r.photo from registratiion1 r inner join friends f on r.userid=f.friendid where f.userid=(select r.userid from registratiion1 r where r.email=? and status='2')";
		              PreparedStatement ps1=conn.prepareStatement(queryString1);
		              ps1.setString(1,email);
		              ps1.setString(2,email);
		              ResultSet result1 = ps1.executeQuery();
		              byte[] imgData1 = null ;
		              ArrayList<String> suggestList = new ArrayList<String>();
		  	        ArrayList<UserFriend> std = new ArrayList<UserFriend>();
		  	      while(result1.next()) {
		        		
		        		String name=result1.getString("username");
		        		String mail=result1.getString("email");
		        		String place1=result1.getString("place");
		        		imgData1 = result1.getBytes("photo");
		        	
		        		String encode1 = Base64.getEncoder().encodeToString(imgData1);
		        	
		        	
						List<String> namesList1 = Arrays.asList(name,mail,place1,encode1);
		        			suggestList.addAll(namesList1);   
		        		std.add(new UserFriend(name,mail,place1,encode1));
		        }
		              
		  	    request.setAttribute("data", std);
		    	mv.addObject("friend_name",suggestList);
		              
		              
			            mv.setViewName("MainPage.jsp");
		             
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(null, "Wrong emailId and Password.");  
		              mv.setViewName("Login.jsp");
		        }
		        result.close();
		        ps.close();
		        conn.close();

		    } catch (SQLException sql) {

		    	
		    }
		    return mv;
		
		
	}

	


	
	

}
