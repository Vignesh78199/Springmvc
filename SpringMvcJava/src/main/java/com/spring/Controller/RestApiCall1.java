package com.spring.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.spring.Model.UserFriend3;


@RestController
public class RestApiCall1  {
	
	public RestApiCall1()
	{
		
	}
	@RequestMapping("/RestApiCall2")
	public void RestApiCall1(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException
	{
		ArrayList<UserFriend3> userfriend=new  ArrayList<UserFriend3>();
		String status=null;
		userfriend=FetchData2.getRequest(request);
		Gson gson=new Gson();
		JsonElement element=gson.toJsonTree(userfriend,new TypeToken<List<UserFriend3>>() {}.getType());
		
		JsonArray jsonArray =element.getAsJsonArray();
		/*if(jsonArray!=null)
		{
			status="{\"Status\":\"200\",\"Message\":\"Success\"}";  
			
		}
		else
		{
			status="{\"Status\":\"400\",\"Message\":\"failed\"}";  
		}
		JSONObject jsonObject= new JSONObject(status); 
*/		
		response.setContentType("application/json");
		//response.getWriter().print(jsonObject);
		response.getWriter().print(jsonArray);
		
	}
}
	
	
	

