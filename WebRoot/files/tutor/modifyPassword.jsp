<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>My JSP 'modifyPassword.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" rev="stylesheet" href="<%=basePath%>css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
<script src="<%=basePath%>js/spms.js"></script>
</head>

<body class="ContentBody">
	<form action="tutor/modifyPass" method="get" name="form" onSubmit="return checkModPass()">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">
							个人信息管理
					</th>
				</tr>
				<tr>
					<td class="CPanel">
						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<tr>
								<td align="left"></td>
							</tr>
							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>修改密码</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">

											<tr>
												<td width="11%" nowrap align="right">原密码</td>
												<td width="27%"><input id="originPass" name='originPass'
													type="password" class="text" style="width:250px" value="" />
												</td>
											</tr>

											<tr>
												<td nowrap align="right" width="11%">新密码</td>
												<td width="27%"><input id="modifyPass" name='modifyPass' type="password"
													class="text" style="width:250px" value="" />
												</td>
											</tr>
											<tr>
												<td nowrap align="right" width="11%">确认输入</td>
												<td width="27%"><input id="confirmPass" name='confirmPass'
													type="password" class="text" style="width:250px" value="" />
													<span><s:property value="#request.message" /></span>
												</td>
											</tr>
										</table>
										<br />
									</fieldset></TD>

							</TR>
						</TABLE></td>
				</tr>
				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="submit" name="modify" value="修改" class="button"/>
						 <input type="button" name="cancel" 
						value="取消" class="button" onclick="cancelModPass()" /></TD>
				</TR>
			</TABLE>
		</div>
	</form>
</body>
</html>
