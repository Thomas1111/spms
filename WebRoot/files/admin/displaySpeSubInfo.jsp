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

<title>My JSP 'displaySpeSubInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "ËÎÌå";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "ËÎÌå";
	font-size: 20px;
	color: #FF0000;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "ËÎÌå";
	font-size: 15px;
	color: #FF0000;
	text-decoration: none;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
</style>

<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/xiangmu.js"></script>
</head>
<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function selectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "xiangmu.htm";
		document.getElementById("fom").submit();
	}

	function on_load() {
		var loadingmsg = document.getElementById("loadingmsg");
		var mainpage = document.getElementById("mainpage");
		loadingmsg.style.display = "";
		mainpage.style.display = "none";

		loadingmsg.style.display = "none";
		mainpage.style.display = "";
	}
</SCRIPT>

<body>
	<form name="fom" id="fom" method="post" action="">
		<table id="mainpage" width="100%" border="0" cellspacing="0"
			cellpadding="0">

			<tr>
				<td height="30"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td height="62" background="<%=basePath%>images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21"><img src="<%=basePath%>images/ico07.gif"
											width="20" height="18" />
										</td>
										<td width="550" class="font051">导师详细选题信息 <input
											type="button" name="allocation" value="返回" class="font201"
											onclick="javascript:window.location.href='<%=basePath%>files/admin/displaySubject.jsp'" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">

						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42"><table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">
												<tr>
													<td height="20" colspan="13" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title"><center>
															选题基本信息表
															</cente>
													</td>
												</tr>
												<tr align="center">
													<td width="10%" height="20" align="center"
														bgcolor="#EEEEEE">*题目名称</td>
													<td width="10%" align="center" bgcolor="#FFFFFF"
														colspan="9">基于B/S架构的飞机航班订票系统的设计与开发</td>
												</tr>
												<tr align="center">
													<td width="10%" height="20" align="center"
														bgcolor="#EEEEEE">*题目来源</td>
													<td width="10%" align="center" bgcolor="#FFFFFF"
														colspan="5">横向且有经费</td>
													<td width="10%" height="20" align="center"
														bgcolor="#EEEEEE" colspan="2">*毕业设计论文地点</td>
													<td width="10%" align="center" bgcolor="#FFFFFF"
														colspan="2">5教102</td>
												</tr>
												<tr align="center">
													<td width="10%" height="20" align="center"
														bgcolor="#EEEEEE">*题目类型</td>
													<td width="10%" align="center" bgcolor="#FFFFFF"
														colspan="9">运用于理论结合研究</td>
												</tr>
												<tr align="center">
													<td width="10%" height="20" bgcolor="#EEEEEE">导师姓名</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">彭莹琼</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">性别</td>
													<td width="5%" align="center" bgcolor="#FFFFFF">女</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">年龄</td>
													<td width="10%" height="20" bgcolor="#FFFFFF">38</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">职称</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">副教授</td>
													<td width="5%" align="center" bgcolor="#EEEEEE">学位</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">学士</td>
												</tr>
												<tr align="center">
													<td width="10%" height="20" bgcolor="#EEEEEE">所在单位</td>
													<td width="10%" align="center" bgcolor="#FFFFFF"
														colspan="2">江西农业大学</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">所学专业</td>
													<td width="5%" align="center" bgcolor="#FFFFFF" colspan="2">软件工程</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">*来自</td>
													<td width="10%" height="20" bgcolor="#FFFFFF">校内</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">电话</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">180705114243</td>
												</tr>
												<tr align="center">
													<td width="10%" height="20" align="center"
														bgcolor="#FFFFFF" rowspan="4" colspan="10">
														<fieldset style="height:100%;">
															<legend>*选题介绍：（主要内容、现有条件、时间安排、预期结果及表现形式）</legend>
															该系统在B/S模式开发，具有良好的界面交互性以及较好的页面响应能力
															该系统在B/S模式开发，具有良好的界面交互性以及较好的页面响应能力
															该系统在B/S模式开发，具有良好的界面交互性以及较好的页面响应能力
															该系统在B/S模式开发，具有良好的界面交互性以及较好的页面响应能力
															该系统在B/S模式开发，具有良好的界面交互性以及较好的页面响应能力该系统在B/S模式开发，具有良好的界面交互性以及较好的页面响应能力
														</fieldset></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>
