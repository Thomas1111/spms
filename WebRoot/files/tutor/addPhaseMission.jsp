<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addPhaseMission.jsp' starting page</title>
    
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
html { overflow-x: auto; overflow-y: auto; border:0;} 

</style>

<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/phaseMission.js"></script>
<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
</head>

<body onload="loadPhaMisInfo()">
<form name="fom" method="post" action="phaseMission/phaMisAction" onsubmit="return checkPhaseInfo()">
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
          <select id="term" name="term" onchange="reloadObjectByTerm(this.options
      			[this.options.selectedIndex].value)">
          </select>
      </td> 
      </tr>
        </table>
        </td>
      </tr>
    </table>
</td>
  </tr>
  <tr>
    <td>
      <fieldset style="height:100%;">
                  <legend>新增阶段任务</legend>
      <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">任务对象：
                        <select id="missionObject" name="missionObject">
                        </select>
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">任务名称：
                         <input id="missionName" type="text" name="missionName" style="width:400px;" value=""/> 
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF">起始时间：
                         <input id="startTime" type="text" name="startTime" style="width:200px;" value=""/> 
                    </td>
                    <td height="20" align="center" bgcolor="#FFFFFF">终止时间：
                         <input id="deadline" type="text" name="deadline" style="width:200px;" value=""/> 
                    </td>
                  </tr>
                  <tr>
                   <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">
                        <fieldset style="height:100%;align=left;">
                            <legend>阶段任务描述</legend>
                            <textarea id="description" name="description" rows="4" cols="150" ></textarea>
                        </fieldset>
                    </td>
                  </tr>
                  <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">
                         <input type="submit" name="add" value="提交" class="button" />
                         &nbsp;
                        <input type="button" name="cancel" value="重置" class="button" onclick="cancelPhase()"/>
                    </td>
                  </tr>
                </table></td>
              </tr>
            </table>
        </td>
        </tr>
      </table>
      </fieldset>
     </td>
              </tr>
          </table>
</form>
</body>
