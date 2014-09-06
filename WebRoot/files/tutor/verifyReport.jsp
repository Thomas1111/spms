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
    
    <title>My JSP 'verifyReport.jsp' starting page</title>
    
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
          <select id="term" name="term" 
      		onchange="reloadByterm(this.options
      			[this.options.selectedIndex].value)">
            <option>2011-2012</option>
            <option>2012-2013</option>
            <option>2013-2014</option>
            <option>2014-2015</option>
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
                  <legend>审核开题报告</legend>
    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td width="30%" height="20" align="center" bgcolor="#EEEEEE">选题名称</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">学生学号</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">学生姓名</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">上传时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">当前状态</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">报告操作</td>
                  </tr>
             <s:iterator value="%{#request.reportInfo}" id="id" status="status">
                  <tr align="center">
				    <td width="30%" height="20" align="center" bgcolor="#FFFFFF">
				    	<s:property value="%{#request.reportInfo[#status.index].subName}" />
				    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.reportInfo[#status.index].studentNo}" />
                    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.reportInfo[#status.index].studentName}" />
                    </td>
                    <td width="20%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.reportInfo[#status.index].uploadTime}" />
                    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    <s:property value="%{#request.reportInfo[#status.index].exameState}" />
                    <s:if test="<s:property value='%{#request.reportInfo[#status.index].exameState}' />==0">
                    	待审核
                    </s:if>
                    </td>
                    <td width="20%" align="center" bgcolor="#FFFFFF">
                        <input type="button" name="download" value="下载" onclick="" /> 
                        &nbsp;
                        <input type="button" name="pass" value="通过" onclick="" /> 
                        &nbsp;
                        <input type="button" name="revoke" value="不通过" onclick="" /> 
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
      </table>
   </fieldset>
  </td>
  </tr>
</table>
</form>
</body>
<SCRIPT language=JavaScript>
//获取对应学期的学生信息
function reloadByterm(term){
	var tutorNo = <s:property value="#session.account" /> ;	//获取导师账号
	//重定位,选择对应学期的学生信息
	window.location.href = "<%=path%>/report/queryReport?tutorNo="+tutorNo+"&currentPage=1&reportTerm="+term;
};
</script>
</html>
