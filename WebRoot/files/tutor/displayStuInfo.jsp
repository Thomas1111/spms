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
    
    <title>学生论文管理系统——查看学生信息</title>
    
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
<script type="text/javascript" src="<%=basePath%>js/xiangmu.js"></script>
<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=basePath%>/js/spms.js"></script>
</head>

<body onload="stuInfoInit()">
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
      		onchange="reloadByterm(this.options
      			[this.options.selectedIndex].value,'student/queryStudentAsyc?')">
          </select>
      </td> 
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42">
            	<table id="stuInfoTab" width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"><center>学生基本信息表</center></td>
                </tr>
                <tr id="firstRow">
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">学号</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">姓名</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">性别</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">学院</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">专业</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">班级</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
                </tr>
               </table>
                </td>
              </tr>
            </table>
         
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="<%=basePath%>images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span id="pageNum" class="right-text09"></span> 
                	第<span id="currentPage" class="right-text09"></span> 页</td>
                <td width="49%" align="right">[<a class="right-font08" onclick="changeStuPage('first')">
                                                首页</a> 
                | <a class="right-font08" onclick="changeStuPage('fore')">上一页</a>
                | <a class="right-font08" onclick="changeStuPage('next')">下一页</a> 
                | <a class="right-font08" onclick="changeStuPage('last')">末页</a>] 
                                                转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
                      <input id="changeNum" name="changeNum" type="text" class="right-textfield03" size="1" />
                      </td>
                      <td width="87%">
                      <input name="sure" type="button" class="right-button06" onclick="changeStuPage('input')"/>
                      </td>
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
<s:debug></s:debug>
</body>
</html>
