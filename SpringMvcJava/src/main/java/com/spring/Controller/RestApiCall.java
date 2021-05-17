package com.spring.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.spring.Model.UserFriend3;

@RestController
public class RestApiCall  {
	
	public RestApiCall()
	{
		
	}
	@RequestMapping("/RestApiCall1")
	public void RestApiCall(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException
	{
		ArrayList<UserFriend3> userfriend=new  ArrayList<UserFriend3>();
		userfriend=FetchData1.getSuggestion(request);
		Gson gson=new Gson();
		JsonElement element=gson.toJsonTree(userfriend,new TypeToken<List<UserFriend3>>() {}.getType());
		
		JsonArray jsonArray =element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	
	
	

}
