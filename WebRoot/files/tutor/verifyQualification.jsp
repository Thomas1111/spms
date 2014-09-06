<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'verifyQualification.jsp' starting page</title>
    
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
          选择学生：
          <select name="student">
               <option checked="true">----请选择学生----</option>
               <option>赖辉强</option>
              <option>徐建文</option>
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
                  <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                <tr>
                    <td height="20" colspan="6" align="center" bgcolor="#FFFFFF"class="tablestyle_title"><center>江西农业大学2015届本科生毕业设计（论文）答辩资格审查表</center>
                    </td>
                </tr>
                <tr align="center">
                    <td width="20%" height="20" align="center" bgcolor="#FFFFFF">题目名称</td>
                    <td width="80%" align="center" bgcolor="#FFFFFF" colspan="5"><input name='subName' type="text" class="text" style="width:400px" value="" /></td>
                </tr>
                <tr align="center">
                    <td width="10%" height="20" rowspan="2" align="center" bgcolor="#FFFFFF">学生姓名</td>
                    <td width="10%" rowspan="2" align="center" bgcolor="#FFFFFF"></td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">学院</td>
                    <td width="20%" align="center" bgcolor="#FFFFFF"></td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">系专业</td>
                    <td width="20%" align="center" bgcolor="#FFFFFF"></td>
                </tr>
                <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">专业班级</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF"></td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">学号</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF"></td>
                </tr>
                 <tr align="center">
                    <td width="10%" height="20" rowspan="5" align="center" bgcolor="#FFFFFF">*指导教师检查学生毕业设计（论文）内容</td>
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">任务书</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                        <input type="radio" name="mission" value="yes" />有
                        &nbsp;
                        <input type="radio" name="mission" value="no" />无
                    </td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">开题报告</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF" colspan="2">
                        <input type="radio" name="report" value="yes" />有
                        &nbsp;
                        <input type="radio" name="report" value="no" />无
                    </td>
                </tr>
                <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">正文</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF" colspan="2">
                        <input type="radio" name="body" value="yes" />有
                        &nbsp;
                        <input type="radio" name="body" value="no" />无
                    </td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">字数</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                        <input type="text" name="bodyWords" value="" />
                    </td>
                </tr>
                  <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">中英文摘要</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF" colspan="5">
                        <input type="radio" name="abstract" value="yes" />有
                        &nbsp;
                        <input type="radio" name="abstract" value="no" />无
                    </td>
                </tr>
                  <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">外文资料翻译</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF" colspan="2">
                        <input type="radio" name="translation" value="yes" />有
                        &nbsp;
                        <input type="radio" name="translation" value="no" />无
                    </td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">字数</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                        <input type="text" name="transWords" value="" />
                    </td>
                </tr>
                  <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">软硬件验收</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF" colspan="5">
                        <input type="radio" name="check" value="yes" />完成
                        &nbsp;
                        <input type="radio" name="check" value="no" />未完成
                    </td>
                </tr>
                <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF" colspan="2">毕业设计（论文）期间考勤情况</td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">有无旷课</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                        <input type="radio" name="translation" value="yes" />有
                        &nbsp;
                        <input type="radio" name="translation" value="no" />无
                    </td>
                     <td width="10%" height="20" align="center" bgcolor="#FFFFFF">旷课累计时间</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                        <input type="text" name="transWords" value="" />天
                    </td>
                </tr>
                </tr>
                  <tr align="center">
                    <td width="10%" height="20" align="left" bgcolor="#FFFFFF" colspan="6">指导教师评语（说明是否可进行答辩，并根据学生毕业设计（论文）质量按优秀、良好、中等、及格、不及格评定成绩及给出评定成绩的依据）：</td>
                </tr>
                <tr align="center">
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF" colspan="6">
                      <textarea name="comments" rows="5" cols="150"></textarea>
                    </td>
                </tr>
                <tr align="center">
                    <td width="10%" height="20" align="left" bgcolor="#FFFFFF" colspan="6">
                      成绩：
                      <input type="text" name="score" value="" style="width:50px" />
                    </td>
                </tr>
                  <tr>
                    <td height="20" align="center" bgcolor="#FFFFFF" colspan="10">
                        <input type="submit" name="add" value="提交" class="button" />
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
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
