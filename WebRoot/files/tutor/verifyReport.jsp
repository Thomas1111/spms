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
<script src="<%=basePath%>js/report.js"></script>
<script src="<%=basePath%>js/admin.js"></script>
<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
</head>

<body>
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="<%=basePath%>images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="<%=basePath%>images/ico07.gif" width="20" height="18" /></td>
			<td width="550" class="font051">
          选择学期：
          <select id="term" name="term" 
      		onchange="reloadReportByterm(this.options
      			[this.options.selectedIndex].value)">
      			 <s:iterator value="%{#request.terms}" id="id" status="status">
      			 	<s:if test="#request.terms[#status.index].term == #request.reportTerm">
      			 		<option selected=true>
      			 			<s:property value="%{#request.reportTerm}" />
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
                    <s:if test="#request.reportInfo[#status.index].exameState == 2">
                    	待审核
                    </s:if>
                    <s:elseif test="#request.reportInfo[#status.index].exameState == 1">
                    	已通过
                    </s:elseif>
                    <s:else>
                    	未通过
                    </s:else>
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
          <td height="33">
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span id="pageNum" class="right-text09">
                	<s:property value="%{#request.pageVo.pageNum}" />
                </span> 第<span id="currentPage" class="right-text09">
                	<s:property value="%{#request.pageVo.currentPage}" />
                </span> 页</td>
                <td width="49%" align="right">[<a class="right-font08" onclick="changePageNum('first',3)">
                                                首页</a> 
                | <a class="right-font08" onclick="changePageNum('fore',3)">上一页</a>
                | <a class="right-font08" onclick="changePageNum('next',3)">下一页</a> 
                | <a class="right-font08" onclick="changePageNum('last',3)">末页</a>] 
                                                转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
                      <input id="changeNum" name="changeNum" type="text" class="right-textfield03" size="1" />
                      </td>
                      <td width="87%">
                      <input name="sure" type="button" class="right-button06" onclick="changePageNum('input',3)"/>
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
</body>
</html>
