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
      <td width="550" class="font051">
          选择学期：
          <select name="term">
            <option>2011-2012</option>
            <option>2012-2013</option>
            <option>2013-2014</option>
          </select>
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
                  <legend>新增阶段任务</legend>
      <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">任务对象：
                        <select name="missionObject">
                            <option checked="true">----全部----</option>
                            <option>赖辉强</option>
                            <option>徐建文</option>
                        </select>
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">任务名称：
                         <input type="text" name="missionName" style="width:400px;" /> 
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF">起始时间：
                         <input type="text" name="startTime" style="width:200px;" /> 
                    </td>
                    <td height="20" align="center" bgcolor="#FFFFFF">终止时间：
                         <input type="text" name="deadline" style="width:200px;" /> 
                    </td>
                  </tr>
                   <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">
                        <fieldset style="height:100%;align=left;">
                            <legend>阶段任务描述</legend>
                            <textarea name="description" rows="4" cols="150" ></textarea>
                        </fieldset>
                    </td>
                  </tr>
                  <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="2">
                         <input type="submit" name="add" value="提交" class="button" />
                         &nbsp;
                        <input type="button" name="cancel" value="返回" class="button" />
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
       </fieldset>
      </td>
     </tr>
      </table>
  </td>
  </tr>
</table>
</form>
</body>
