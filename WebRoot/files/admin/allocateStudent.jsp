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
    
    <title>My JSP 'allocateStudent.jsp' starting page</title>
    
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

</SCRIPT>

<body onload="tutorInfoInit()">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="<%=basePath%>images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="<%=basePath%>images/ico07.gif" width="20" height="18" /></td>
			<td width="550" class="font051">
        学期：
         <select id="term" name="term">
         
         </select>
      </td>
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
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"><center>分配导师学生</center></td>
                </tr>
                  <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">学工号</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">姓名</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">性别</td>
                    <td width="15%" align="center" bgcolor="#EEEEEE">学院</td>
                    <td width="15%" align="center" bgcolor="#EEEEEE">系别</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">研究方向</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">导师操作</td>
                  </tr>
           <s:iterator value="%{#request.tutorsInfo}" id="id" status="status"> 
                 <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">
                    	  <a href="<%=path%>/tutor/queryTutor?tutorNo=<s:property value="%{#request.tutorsInfo[#status.index].tutorNo}" />"
                    		target="mainFrame">
                    	<s:property value="%{#request.tutorsInfo[#status.index].tutorNo}" />
                    </a>
                    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.tutorsInfo[#status.index].tutorName}" />
                    </td>
                    <td width="5%" align="center" bgcolor="#FFFFFF">
                   	<s:if test='%{#request.tutorInfo[#status.index].sex}=="0"'>
                    	女
                    </s:if>
                    <s:else>
                    	<s:property value="%{#request.tutorsInfo[#status.index].sex}" />
                    </s:else>
                    </td>
                    <td width="15%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.tutorsInfo[#status.index].college}" />
                    </td>
                    <td width="15%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.tutorsInfo[#status.index].major}" />
                    </td>
                    <td width="20%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.tutorsInfo[#status.index].direction}" />
                    </td>
                    <td width="20%" align="center" bgcolor="#FFFFFF">                        
                    <input type="file" name="input" value="导入名单" style="width:70px;" onclick=""/>
                        &nbsp;
                        <input id="manifest" type="button" name="manifest" value="查看名单" onclick=
                        "javascript:window.location.href='<%=basePath%>/tutor/?tutorNo=<s:property value="%{#request.tutorsInfo[#status.index].tutorNo}" />&operationNo=adminStu&currentPage=1'"/>
                    </td>
                  </tr>
              </s:iterator>
                </table>
                </td>
              </tr>
            </table></td>
        </tr>
      </table>
       <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="<%=basePath%>images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">
                	<s:property value="%{#request.pageVo.pageNum}" />
                </span> 第<span class="right-text09">
                	<s:property value="%{#request.pageVo.currentPage}" />
                </span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08" onclick="getFirstPage()">
                                                首页</a> 
                | <a href="#" class="right-font08" onclick="change('fore')">上一页</a>
                | <a href="#" class="right-font08" onclick="change('next')">下一页</a> 
                | <a href="#" class="right-font08" onclick="change('last')">末页</a>] 
                                                转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
                      <input id="changeNum" name="changeNum" type="text" class="right-textfield03" size="1" />
                      </td>
                      <td width="87%">
                      <input name="sure" type="button" class="right-button06" onclick="change('input')"/>
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
</body>
</html>
