<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生论文管理系统——审核阶段任务</title>
    
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
.font051 {font-family: "ËÎÌå";
	font-size: 20px;
	color: #FF0000;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "ËÎÌå";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "ËÎÌå"0
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 

</style>

<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/phaseMission.js"></script>
<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
</head>

<body>
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="<%=basePath%>images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="<%=basePath%>images/ico07.gif" width="20" height="18" /></td>
			<td width="550" class="font051">
           选择学期：
          <select id="term" name="term" 
      		onchange="reloadVerMisInfo(this.options
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
        </table></td>
      </tr>
    </table>
</td>
  </tr>
  <tr>
    <td>
    	<fieldset style="height:100%;">
                  <legend>审核阶段任务</legend>
    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td width="20%" height="20" align="center" bgcolor="#EEEEEE" colspan="2">阶段任务名称</td>
                    <td width="50%" align="center" bgcolor="#FFFFFF" colspan="3">
                  		<s:property value="%{#request.verMissions[0].misName}" />
                    </td>
                  </tr>
                  <tr>
                    <td width="10%" align="center" bgcolor="#EEEEEE">学生学号</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">学生姓名</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">上传时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">当前状态</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">审核操作</td>
                  </tr>
                <s:iterator value="%{#request.verMissions}" id="id" status="status">
                  <tr align="center">
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.verMissions[#status.index].studentNo}" />
                    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.verMissions[#status.index].studentName}" />
                    </td>
                    <td width="20%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.verMissions[#status.index].uploadTime}" />
                    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
	                    <s:if test="#request.verMissions[#status.index].exameState == 2">
	                    	待审核
	                    </s:if>
	                    <s:elseif test="#request.verMissions[#status.index].exameState == 1">
	                    	已通过
	                    </s:elseif>
	                    <s:else>
	                    	未通过
	                    </s:else>
                    </td>
                    <td width="20%" align="center" bgcolor="#FFFFFF">
                        <input type="button" name="download" value="下载" onclick="" /> 
                        &nbsp;
                        <input type="button" name="pass" value="通过" 
                        	onclick="verifyPhaseMission(
	                        	<s:property value="%{#request.verMissions[#status.index].missionNo}" />,
	                        	<s:property value="%{#request.verMissions[#status.index].studentNo}" />,
	                        	'pass')" /> 
                        &nbsp;
                        <input type="button" name="revoke" value="不通过" 
                        	onclick="verifyPhaseMission(
	                        	<s:property value="%{#request.verMissions[#status.index].missionNo}" />,
	                        	<s:property value="%{#request.verMissions[#status.index].studentNo}" />,
	                        	'cancel')" /> 
                    </td>
                  </tr>
                </s:iterator>
                </table>
                </td>
              </tr>
            </table>
        </td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="<%=basePath%>images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="49%" align="right">
                	【共<s:property value='%{#request.missionPageVo.number}' />个】
                	【| <a class="right-font08" onclick="switchVerMission('fore',
                			<s:property value='%{#request.missionPageVo.currentNo}' />,
                			<s:property value='%{#request.missionPageVo.first}' />)">上一个</a> 
                	| <a class="right-font08" onclick="switchVerMission('next',
		                	<s:property value='%{#request.missionPageVo.currentNo}' />,
		                	<s:property value='%{#request.missionPageVo.last}' />)">下一个</a>】</td>
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
