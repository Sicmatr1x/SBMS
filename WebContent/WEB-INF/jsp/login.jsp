<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>login</h1>
	<form id="login-form">
		username:<input type="text" name="username"/><br>
		password:<input type="text" name="password"/><br>
		<input type="button" name="submit" value="login" id="login-btn"/><br><br><span name="info-span"></span>
	</form>
	<!-- <form method="POST" active="/SBMS/user/login">
		username:<input type="text" name="username"/><br>
		password:<input type="text" name="password"/><br>
		<input type="submit" name="submit" value="login"/><br>
	</form> -->
	
</body>
<script>
$(document).ready(function(){
	$("#login-btn").click(function() {
       
		$.ajax({
            url : "/SBMS/user/login/"+$("#login-form input[name=username]").val(),
            type : "post",
            data : {
            	username:$("#login-form input[name=username]").val(),
            	password:$("#login-form input[name=password]").val()
            },  
            dataType : "json",
            success : function(data) {
            	console.log(data);
            	$("#login-form span[name=info-span]").text(data);
				console.log("data=" + data);
            },
            error : function() {
            	$("#login-form span[name=info-span]").text("logined");
            	console.log("ajax request error");
            }
        });//end ajax

    });
});
</script>
</html>