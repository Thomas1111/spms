<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displayStuPaper.jsp' starting page</title>
    
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
	font-size: 15px;
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
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="xiangmu.htm";
   document.getElementById("fom").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="">
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
          <select name="term">
            <option>2011-2012</option>
            <option>2012-2013</option>
            <option>2013-2014</option>
          </select>
          <input type="button" name="return" value="返回" class="font201" onclick="javascript:window.location.href='<%=basePath%>files/admin/verifyStudentPaper.jsp'"/>
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
                  <legend>彭莹琼导师学生答辩项目列表</legend>
    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td width="30%" height="20" align="center" bgcolor="#EEEEEE">答辩资格项目</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">学号</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">姓名</td>
                    <td width="15%" align="center" bgcolor="#EEEEEE">专业</td>
                    <td width="15%" align="center" bgcolor="#EEEEEE">班级</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">答辩资格</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">备注</td>
                  </tr>
                  <tr align="center">
                    <td width="30%" height="20" align="center" bgcolor="#FFFFFF">
                      <a href="<%=basePath%>files/admin/displayStuPapInfo.jsp" target="mainFrame">基于B/S架构的飞机航班订票系统的设计与开发</a>
                    </td>
				            <td width="10%" height="20" align="center" bgcolor="#FFFFFF">20111826</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">赖辉强</td>
                    <td width="15%" align="center" bgcolor="#FFFFFF">软件工程</td>
                    <td width="15%" align="center" bgcolor="#FFFFFF">软件1111班</td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">未审核</td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">无</td>
                  </tr>
                  <tr align="center">
                     <td width="30%" height="20" align="center" bgcolor="#FFFFFF">
                      基于B/S架构的飞机航班订票系统的设计与开发
                    </td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">20111826</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">徐建文</td>
                    <td width="15%" align="center" bgcolor="#FFFFFF">软件工程</td>
                    <td width="15%" align="center" bgcolor="#FFFFFF">软件1111班</td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">审核中</td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">无</td>
                  </tr>
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
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">5</span> 第<span class="right-text09"> 1</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table>
       </fieldset>
      </td>
     </tr>
      </table>
  </td>
  </tr>
</table>
</form>
</body>
</html>
