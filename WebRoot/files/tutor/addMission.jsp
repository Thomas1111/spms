<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addMission.jsp' starting page</title>
    
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
.tdTitle {
  font-size: 20px;
  color: blue;
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
<script src="<%=basePath%>js/xiangmu.js"></script>
<script src="<%=basePath%>js/tutor.js"></script>
<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
</head>
<SCRIPT language=JavaScript>

</SCRIPT>

<body onload="initCascadeInfo('no')">
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
         <select id="term" name="term" 
      		onchange="reloadSubByterm(this.options
      			[this.options.selectedIndex].value,'subject/querySubjectAsyc?','no')">
          </select>
          选题名称：
          <select id="subject">
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
                  <legend>发布任务书</legend>
    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42">
                  <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" align="left" bgcolor="#FFFFFF" class="tdTitle">一、毕业设计的主要内容和基本要求</td>
                  </tr>
                  <tr align="center">
                    <td height="20" align="center" bgcolor="#FFFFFF">
                        <textarea name="content" rows="5" cols="180"> </textarea> 
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="left" bgcolor="#FFFFFF" class="tdTitle">二、毕业设计图纸内容及张数</td>
                  </tr>
                  <tr align="center">
                    <td height="20" align="center" bgcolor="#FFFFFF">
                        <textarea name="digram" rows="5" cols="180"> </textarea> 
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="left" bgcolor="#FFFFFF" class="tdTitle">三、毕业设计应完成的软硬件的名称、内容及主要技术指标</td>
                  </tr>
                  <tr align="center">
                    <td height="20" align="center" bgcolor="#FFFFFF">
                        <textarea name="index" rows="5" cols="180"> </textarea> 
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="left" bgcolor="#FFFFFF" class="tdTitle">四、毕业设计进度计划</td>
                  </tr>
                  <tr align="center">
                    <td height="20" align="center" bgcolor="#FFFFFF">
                        <textarea name="schedlue" rows="5" cols="180"> </textarea> 
                    </td>
                  </tr>
                   <tr>
                    <td height="20" align="left" bgcolor="#FFFFFF" class="tdTitle">五、主要参考资料</td>
                  </tr>
                  <tr align="center">
                    <td height="20" align="center" bgcolor="#FFFFFF">
                        <textarea name="reference" rows="5" cols="180"> </textarea> 
                    </td>
                  </tr>
                  <tr align="center">
                    <td height="20" align="center" bgcolor="#FFFFFF">
                        <input type="submit" name="add" value="发布" class="button" />
                        <input type="button" name="cancel" value="重置" class="button" />
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
</form>
</body>
</html>
