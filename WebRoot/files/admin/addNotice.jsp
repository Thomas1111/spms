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

<title>My JSP 'addNotice.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" rev="stylesheet"
	href="<%=basePath%>css/style.css" type="text/css" media="all" />
<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
<script language="JavaScript" type="text/javascript">
	function fill(){
		var notice = $("#notice").val();	//获取文件目录
		var suffix = String(notice).split(".").pop();		//获取文件后缀
		alert(suffix);
		if(!(suffix == "doc")){
			alert("文件必须是.doc文档");
		}else{
			$("#title").attr("value",String(notice).split("\\").pop());	//截取文件名
		}
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}
</script>
<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
</head>

<body class="ContentBody">
	<div class="MainDiv">
		<form action="notice/uploadNotice" method="post" name="upload"
			enctype="multipart/form-data">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">公告管理</th>
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
										<legend>发布新公告</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">

											<tr>
												<td width="11%" nowrap align="right">公告文件</td>
												<td colspan="3"><input id="notice" name='upload' type="file"
													class="text" style="width:250px" onchange="fill()" />
												</td>
											</tr>

											<tr>
												<td nowrap align="right" width="11%">公告标题</td>
												<td width="27%"><input id="title" name='noticeTitle'
													type="text" class="text" style="width:250px" value="" />
												</td>
											</tr>
										</table>
										<br />
									</fieldset>
									</TD>
							</TR>
						</TABLE></td>
				</tr>
				<TR>
					<TD colspan="2" align="center" height="50px">
					<input type="submit" name="add" value="发布" class="button"/> 
					<input type="button" name="cancel" value="取消" class="button" onclick="" /></TD>
				</TR>
			</TABLE>
			</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>
