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

<title>My JSP 'displaySubject.jsp' starting page</title>

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

.button {
	font-family: "ËÎÌå";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
</style>

<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>/js/admin.js"></script>
<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
</head>

<body onload="initTerm()">
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
										<td width="550" class="font051">
										学期： <select id="term" name="term" onchange="reloadVerTutorSubByterm(this.options
      											[this.options.selectedIndex].value)">
          									</select>
										<input type="button" name="allocation" value="返回"
											class="font201"
											onclick="javascript:window.location.href='<%=path%>/tutor/queryTutor?opeType=verifySub&currentPage=1'" />
												<s:if test="#request.message != '加载成功'">
																(<span style="color:red">
																	<s:property value="%{#request.message}" />
																</span>
																)
												</s:if>
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
										<td height="40" class="font42">
										<table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">
										
												<tr>
													<td width="40%" height="20" align="center"
														bgcolor="#EEEEEE">题目名称</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">题目来源</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">题目类型</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">导师类型</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">审核状态</td>
													<td width="15%" align="center" bgcolor="#EEEEEE">选题操作</td>
												</tr>
										<s:iterator value="%{#request.subjectInfos}" id="id" status="status"> 
												<tr>
													<td width="30%" height="20" align="center"
														bgcolor="#FFFFFF">
														<a href="<%=path%>/subject/displaySubject!displaySpecificSub?subjectNo=<s:property value="%{#request.subjectInfos[#status.index].subjectNo}" />"
														target="mainFrame">
															<s:property value="%{#request.subjectInfos[#status.index].subName}" />
														</a></td>
													<td width="10%" align="center" bgcolor="#FFFFFF">
														<s:property value="%{#request.subjectInfos[#status.index].subSource}" />
													</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">
														<s:property value="%{#request.subjectInfos[#status.index].subType}" />
													</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">
														<s:property value="%{#request.subjectInfos[#status.index].subPosition}" />
													</td>
													<td width="10%" align="center" bgcolor="#FFFFFF">
														<s:if test="#request.subjectInfos[#status.index].exameState==1">
										                    	通过
										                </s:if>
										                <s:else>
										                    	未通过
										                </s:else>
													</td>
													
													<td width='15%' align='center' bgcolor='#FFFFFF'>
														<input type="button" name="pass" value="通过" onclick="verifyTutorSub(1,<s:property value="%{#request.subjectInfos[#status.index].subjectNo}" />)"/> 
			    										<input type="button" name="revoke" value="不通过" onclick="verifyTutorSub(3,<s:property value="%{#request.subjectInfos[#status.index].subjectNo}" />)"/>
		    										</td>
												</tr>
											</s:iterator>
											<input id="tutorNo" type="hidden" name="tutorNo" value="<s:property value="%{#request.subjectInfos[0].tutorNo}" />"/>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="6"><img src="<%=basePath%>images/spacer.gif"
								width="1" height="1" />
							</td>
						</tr>
						<tr>
							<td height="33"><table width="100%" border="0"
									align="center" cellpadding="0" cellspacing="0"
									class="right-font08">
									 <tr>
                <td width="50%">共 <span id="pageNum" class="right-text09">
                	<s:property value="%{#request.pageVo.pageNum}" />
                </span> 第<span id="currentPage" class="right-text09">
                	<s:property value="%{#request.pageVo.currentPage}" />
                </span> 页</td>
                <td width="49%" align="right">[<a class="right-font08" onclick="changePageNum('first',2)">
                                                首页</a> 
                | <a class="right-font08" onclick="changePageNum('fore',2)">上一页</a>
                | <a class="right-font08" onclick="changePageNum('next',2)">下一页</a> 
                | <a class="right-font08" onclick="changePageNum('last',2)">末页</a>] 
                                                转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
                      <input id="changePageNumNum" name="changePageNumNum" type="text" class="right-textfield03" size="1" />
                      </td>
                      <td width="87%">
                      <input name="sure" type="button" class="right-button06" onclick="changePageNum('input')" />
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
	</form>
</body>
</html>
