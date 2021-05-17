<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style type="text/css">
table,td,th
{
border:1px solid green;
font-family:'Oxygen' ,sans-serif;
}
th
{
background-cor:green;
color:black;
}
body
{
text-align:center;
}
.container
{
margin-left:auto;
margin-right:auto;
width:40em;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	$("#tablediv").hide();
		$("#showTable").click(function(event){
			$.get('RestApiCall1',function(responseJson){
				if(responseJson!=null){
					var jData = '{"Status":"200", "message":"Success"}';
					var tmpData = JSON.parse(jData);
					var formattedJson = JSON.stringify(tmpData, null, '\t');
				
					$("#countrytable").find("tr:gt(0)").remove();
					var table1=$("#countrytable");
					
					$.each(responseJson,function(key,value){
						var rowNew=$("<tr><td></td><td></td><td></td></tr>");
							rowNew.children().eq(0).text(value['userid']);
							rowNew.children().eq(1).text(value['username']);
							rowNew.children().eq(2).text(value['email']);
							rowNew.appendTo(table1);		
					});	
				}
			});
			$("#tablediv").show();
			
		});
});
$(document).ready(function() {
	$("#tablediv1").hide();
		$("#showTable1").click(function(event){
			$.get('RestApiCall2',function(responseJson){
				if(responseJson!=null){
					$("#countrytable1").find("tr:gt(0)").remove();
					var table1=$("#countrytable1");
					$.each(responseJson,function(key,value){
						var rowNew=$("<tr><td></td><td></td><td></td></tr>");
							rowNew.children().eq(0).text(value['userid']);
							rowNew.children().eq(1).text(value['username']);
							rowNew.children().eq(2).text(value['email']);
							rowNew.appendTo(table1);		
					});	
				}
			});
			$("#tablediv1").show();
		});
});
$(document).ready(function() {
	$("#tablediv2").hide();
		$("#showTable2").click(function(event){
			$.get('RestApiCall3',function(responseJson){
				if(responseJson!=null){
					$("#countrytable2").find("tr:gt(0)").remove();
					var table1=$("#countrytable2");
					$.each(responseJson,function(key,value){
						var rowNew=$("<tr><td></td><td></td></tr>");
							
							rowNew.children().eq(0).text(value['username']);
							rowNew.children().eq(1).text(value['email']);
							rowNew.appendTo(table1);		
					});	
				}
			});
			$("#tablediv2").show();
		});
});
</script>
</head>
<body class="container">
<h1>Suggestion list</h1>
<input type="button" value="Show Table" id="showTable"/>
<div id="tablediv">
<table cellspacing="0" id="countrytable">
	<tr>
		<th scope="col">userid</th>
		<th scope="col">username</th>
		<th scope="col">email</th>
	</tr>


</table>
<pre id="pJson"></pre>

</div>

</body>
<body class="container">
<h1>Request list</h1>
<input type="button" value="Show Table2" id="showTable1"/>
<div id="tablediv1">
<table cellspacing="0" id="countrytable1">
	<tr>
		<th scope="col">userid</th>
		<th scope="col">username</th>
		<th scope="col">email</th>
	</tr>


</table>

</div>

</body>
<body class="container">
<h1>Friend list</h1>
<input type="button" value="Show Table3" id="showTable2"/>
<div id="tablediv2">
<table cellspacing="0" id="countrytable2">
	<tr>
	
		<th scope="col">username</th>
		<th scope="col">email</th>
	</tr>


</table>

</div>

</body>
</html>