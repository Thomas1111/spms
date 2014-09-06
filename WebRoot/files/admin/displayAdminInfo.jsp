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
    
    <title>My JSP 'displayAdminInfo.jsp' starting page</title>
    
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
	font-family: "ËÎÌå";
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

<body onload="on_load()">
<form name="fom" id="fom" method="post" action="">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="<%=basePath%>images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="<%=basePath%>images/ico07.gif" width="20" height="18" /></td>
			<td width="550" class="font051">管理员基本信息</td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"><center>管理员基本信息表</cente></td>
                </tr>
                  <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">姓名</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    <s:property value="#request.adminBasicInfo.adminName" />
                    </td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">性别</td>
                    <td width="5%" align="center" bgcolor="#FFFFFF">
                    <s:if test='%{#request.tutorInfo[#status.index].sex}=="0"'>
                    	女
                    </s:if>
                    <s:else>
                    	男	
                    </s:else>
                    </td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">民族</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    <s:property value="#request.adminBasicInfo.nation" />
                    </td>
                  </tr>
                 <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">学院</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    <s:property value="#request.adminBasicInfo.college" />
                    </td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">职位</td>
                    <td width="5%" align="center" bgcolor="#FFFFFF">
                    <s:property value="#request.adminBasicInfo.rank" />
                    </td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">电话</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                     <s:property value="#request.adminBasicInfo.telephone" />
                    </td>
                  </tr>
				        <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">职称</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                     <s:property value="#request.adminBasicInfo.adminTitle" />
                    </td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">学位</td>
                    <td width="5%" align="center" bgcolor="#FFFFFF">
                     <s:property value="#request.adminBasicInfo.eduBackground" />
                    </td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">邮箱</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	 <s:property value="#request.adminBasicInfo.email" />
                    </td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      </td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
