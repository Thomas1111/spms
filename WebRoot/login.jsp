<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
	
	
<script type="text/javascript">
	function login(){
		var username = $("#username").attr("value");
		var password = $("#password").attr("value");
		var roleName = $("#roleName").attr("value");
		var role = 1;
		if(username==''){	
			alert("用户名不能为空");
		}else if(password==''){	
			alert("密码不能为空");
		}else {
			if(roleName == '学生') {
				role = 1;
			} else if(roleName == '导师') {
				role = 2;
			} else if(roleName == '管理员'){
				role = 3;
			}					
			 $.get("userlogin?account="+username+"&password="+password+"&role="+role,function(data){
	    		alert(data);
	    		if(data=="登录成功!"){
	    			if(role == 1){
	    				window.location.href = "index_student.jsp";
		    		}else if(role == 2){
		    			window.location.href = "index_tutor.jsp";
		    		}else{
		    			window.location.href = "index_admin.jsp";
		    		}
	    		}
	     	});
	     } 
	}
</script>
</head>

<body style="margin-top: 0px">
	<img src="images/login_logo.jpg" width="100%" height="140" align="top"
		style="margin-top: 0px" />

	<table width="562" border="0" align="center" cellpadding="0"
		cellspacing="0" class="right-table03">
		<tr>
			<td width="221">
				<table width="95%" border="0" cellpadding="0" cellspacing="0"
					class="login-text01">

					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="login-text01">
								<tr>
									<td align="center"><img src="images/ico13.gif" width="107"
										height="97" />
									</td>
								</tr>
								<tr>
									<td height="40" align="center">&nbsp;</td>
								</tr>
							</table>
						</td>
						<td><img src="images/line01.gif" width="5" height="292" /></td>
					</tr>
				</table></td>
			<td>

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="top"><br />
						</td>
						<td width="31%" height="35" class="login-text02">登陆角色：<br />
						</td>
						<td width="69%"><select id="roleName">
								<option>学生</option>
								<option>导师</option>
								<option>管理员</option>
						</select></td>
					</tr>
					<tr>
						<td valign="top"><br />
						</td>
						<td width="31%" height="35" class="login-text02">用户名：<br />
						</td>
						<td width="69%"><input name="username" type="text" size="30"
							id="username" />
						</td>
					</tr>
					<tr>
						<td valign="top"><br />
						</td>
						<td height="35" class="login-text02">密 码：<br />
						</td>
						<td><input name="password" type="password" size="30"
							id="password" />
						</td>
					</tr>
					<tr>
						<td valign="top"><br />
						</td>
						<td height="35">&nbsp;</td>
						<td><input name="" type="button" class="right-button01"
							value="确认登陆"
							onclick="login()" />
							<input name="Submit232" type="reset" class="right-button02"
							value="重 置" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
