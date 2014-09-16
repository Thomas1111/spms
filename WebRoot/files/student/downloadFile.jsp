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

<title>My JSP 'downloadFile.jsp' starting page</title>

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
	<form action="" method="post" enctype="multipart/form-data" name="form"
		target="sypost">
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
									<fieldset style="height:100%;">
										<legend>资料下载---点击标题下载</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<s:iterator value="%{#request.docInfo}" id="id" status="status">
											  <tr>
											    <td nowrap align="left" width="50%">
											    <li>
											    	<a href="<%=path%>/document/<s:property value="%{#request.docInfo[#status.index].tutorNo}" />/<s:property value="%{#request.docInfo[#status.index].identifier}" />.doc"> 
													<s:property value="%{#request.docInfo[#status.index].docName}" />
											    	</a>
											    </li>
											    </td>
											    <td width="20%" align="left">
											    	<s:property value="%{#request.docInfo[#status.index].docType}" />
											    </td>
											    <td width="30%" align="right">
											    	<s:property value="%{#request.docInfo[#status.index].uploadTime}" />
											    </td>
											  </tr>
				</s:iterator>
										</table>
										<br />
									</fieldset></TD>
							</TR>
						</TABLE></td>
				</tr>
			</TABLE>
			</td>
			</tr>
			</table>
		</div>
	</form>
</body>
</html>
