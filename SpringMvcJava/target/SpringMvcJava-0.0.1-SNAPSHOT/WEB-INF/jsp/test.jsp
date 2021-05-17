<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
	$(document).ready(function()
	{
		//alert('JQUERY is ready and integrated');
		$("#id_get_time").click(function()
				{
				//alert('button clicked');
				$.ajax({
					url:'get_time',
					success:function(data)
					{
						$("#id_time").html(data);
					}
				})
				})
	});
	
	
</script>
</head>
<body>
Testing Ajax
<button id="id_get_time">get server time</button>
<p id="id_time"></p>
</body>
</html>