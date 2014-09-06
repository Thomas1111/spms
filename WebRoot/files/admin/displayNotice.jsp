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

<title>My JSP 'displayNotice.jsp' starting page</title>

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
	function tishi() {
		var a = confirm('132');
		if (a != true)
			return false;
		window
				.open(
						"123.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}
</script>
<style type="text/css">
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
</style>
</head>

<body class="ContentBody">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">公告信息</th>
				</tr>
				<tr>
					<td class="CPanel">
						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>公告列表</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<s:iterator value="%{#request.noticeInfos}" id="id"
												status="status">
												<tr>
													<td nowrap align="left" width="50%">
														<li>
														<a href="<%=path%>/notice/<s:property value="%{#request.noticeInfos[#status.index].adminNo}" />/<s:property value="%{#request.noticeInfos[#status.index].identifier}" />.doc"> 
														<s:property value="%{#request.noticeInfos[#status.index].noticeName}" />
														</a>
														</li>
														</td>
													<td width="50%" align="left"><s:property
															value="%{#request.noticeInfos[#status.index].uploadTime}" />
													</td>
												</tr>
											</s:iterator>
										</table>
										<br />
									</fieldset>
								</TD>
							</TR>
						</TABLE>
					</td>
				</tr>
			</TABLE>
		</div>
</body>
</html>
