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

<title>My JSP 'fillPhaseMission.jsp' starting page</title>

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
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "ËÎÌå" 0 font-size :   14px;
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
<script src="<%=basePath%>js/admin.js"></script>
<script src="<%=basePath%>js/phaseMission.js"></script>
<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
</head>

<body>
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
										 <select id="term" name="term" 
      		onchange="reloadPhaseByterm(this.options
      			[this.options.selectedIndex].value)">
      			 <s:iterator value="%{#request.terms}" id="id" status="status">
      			 	<s:if test="#request.terms[#status.index].term == #request.term">
      			 		<option selected=true>
      			 			<s:property value="%{#request.term}" />
      			 		</option>
      			 	</s:if>
      			 	<s:else>
      			 		<option>
      			 			<s:property value="%{#request.terms[#status.index].term}" />
      			 		</option>
      			 	</s:else>
      			 </s:iterator>
          </select>
           <span style="color:red">
	          <s:if test="#request.message != '查询成功'">
	          	<s:property value="#request.message" />
	          </s:if>
          </span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td>
					<fieldset style="height:100%;">
						<legend>查填写阶段任务</legend>
						<table id="subtree1" style="DISPLAY: " width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td height="40" class="font42"><table width="100%"
													border="0" cellpadding="4" cellspacing="1"
													bgcolor="#464646" class="newfont03">
													<tr>
														<td width="30%" height="20" align="center"
															bgcolor="#EEEEEE">任务名称</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">起始时间</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">终止时间</td>
														<td width="20%" height="20" align="center"
															bgcolor="#EEEEEE">任务描述</td>
														<td width="20%" align="center" bgcolor="#EEEEEE">上传任务</td>
														<td width="10%" align="center" bgcolor="#EEEEEE">审核状态</td>
													</tr>
											 <s:iterator value="%{#request.phaseMissions}" id="id" status="status">
													<tr align="center">
														<td width="30%" height="20" align="center"
															bgcolor="#FFFFFF">
																<s:property value="%{#request.phaseMissions[#status.index].misName}" />
															</td>
														<td width="10%" align="center" bgcolor="#FFFFFF">
															<s:property value="%{#request.phaseMissions[#status.index].startTime}" />
														</td>
														<td width="10%" align="center" bgcolor="#FFFFFF">
															<s:property value="%{#request.phaseMissions[#status.index].endTime}" />
														</td>
														<td width="20%" align="center" bgcolor="#FFFFFF">
															<s:property value="%{#request.phaseMissions[#status.index].misBrief}" />
														</td>
														<td width="20%" align="center" bgcolor="#FFFFFF">
														<form name="fom" method="post" action="" onsubmit=
															"return checkFile(this,<s:property value="%{#request.phaseMissions[#status.index].missionNo}" />)">
															<input id="<s:property value="%{#request.phaseMissions[#status.index].missionNo}" />" type="file" name="upload" style="width:150px;" />
															<input type="submit" name="uploadPhase" value="上传"/>
														</form>
														</td>
														<td width="10%" align="center" bgcolor="#FFFFFF">
															<s:if test="#request.phaseMissions[#status.index].exameState == 0">
										      			 		未上传
										      			 	</s:if>
										      			 	<s:elseif test="#request.phaseMissions[#status.index].exameState == 1">
										      			 		已通过
										      			 	</s:elseif>
										      			 	<s:elseif test="#request.phaseMissions[#status.index].exameState == 2">
										      			 		审核中
										      			 	</s:elseif>
										      			 	<s:else>
										      			 		未通过
										      			 	</s:else>
														</td>
													</tr>
												</s:iterator>
												</table></td>
										</tr>
									</table></td>
							</tr>
						</table>
						<table width="95%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="6"><img src="<%=basePath%>images/spacer.gif" width="1"
									height="1" />
								</td>
							</tr>
							<tr>
								<td height="33">
								<table width="100%" border="0"
										align="center" cellpadding="0" cellspacing="0"
										class="right-font08">
										<tr>
                <td width="50%">共 <span id="pageNum" class="right-text09">
                	<s:property value="%{#request.pageVo.pageNum}" />
                </span> 第<span id="currentPage" class="right-text09">
                	<s:property value="%{#request.pageVo.currentPage}" />
                </span> 页</td>
                <td width="49%" align="right">[<a class="right-font08" onclick="changePageNum('first',4)">
                                                首页</a> 
                | <a class="right-font08" onclick="changePageNum('fore',4)">上一页</a>
                | <a class="right-font08" onclick="changePageNum('next',4)">下一页</a> 
                | <a class="right-font08" onclick="changePageNum('last',4)">末页</a>] 
                                                转至</td>
                <td width="1%">
                <table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
                      <input id="changeNum" name="changeNum" type="text" class="right-textfield03" size="1" />
                      </td>
                      <td width="87%">
                      <input name="sure" type="button" class="right-button06" onclick="changePageNum('input',4)"/>
                      </td>
                    </tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
</body>
</html>
