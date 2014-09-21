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

<title>My JSP 'uploadFile.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" rev="stylesheet" href="<%=basePath%>css/style.css"
	type="text/css" media="all" />
<script src="<%=basePath%>js/admin.js"></script>
<script src="<%=basePath%>js/report.js"></script>
<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
<style type="text/css">
.atten {
	font-size: 18px;
	font-weight: normal;
	color: #F00;
}
</style>
</head>

<body class="ContentBody" onload="initUplaodInfo()">
	<form id="addDocuemnt" action="" method="post" enctype="multipart/form-data" onsubmit="return checkReportInfo(this)">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">文档管理</th>
				</tr>
				<tr>
					<td class="CPanel">
						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<TR>
								<TD width="100%">
									<fieldset style="height:100%;" >
										<legend>上传资料</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td width="30%" align="center" class="atten">上传文件类型： <select
													id="fileType" name="fileType">
												</select></td>
												<td width="30%" align="center" class="atten">选择学期：
														 <select id="term" name="term">
         												 </select>
												</td>
												<td nowrap align="center" width="30%"><input id="upload"
													type="file" name="upload" /></td>
												<td width="10%" align="left"><input type="submit"
													name="add" value="上传" /></td>
											</tr>
										</table>
										<br />
									</fieldset></TD>
							</TR>
						</TABLE></td>
				</tr>
			</TABLE>
		</div>
	</form>
</body>
</html>
