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
    
    <title>My JSP 'displayTutorInfo.jsp' starting page</title>
    
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
<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=basePath%>/js/admin.js"></script>
<script src="<%=basePath%>/js/spms.js"></script>
</head>
<body>
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="<%=basePath%>images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="<%=basePath%>images/ico07.gif" width="20" height="18" /></td>
      <td width="550" class="font051" align="left">
        添加导师：
        <input type="button" name="input" value="导入" />
        <input type="button" name="add" value="增加" onclick="请输入条数"/> 
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
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"><center>导师基本信息表</center></td>
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
                    <td width="10%" height="20" align="center" bgcolor="#FFFFFF">
                    <a href="<%=path%>/tutor/queryTutor?tutorNo=<s:property value="%{#request.tutorsInfo[#status.index].tutorNo}" />"
                    		target="mainFrame">
                    	<s:property value="%{#request.tutorsInfo[#status.index].tutorNo}" />
                    </a>
                    
                    </td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">
                    	<s:property value="%{#request.tutorsInfo[#status.index].tutorName}" />
                    </td>
                    <td width="5%" align="center" bgcolor="#FFFFFF">
                   <s:if test="#request.tutorsInfo[#status.index].sex==0">
						男
					</s:if> 
					<s:else>
						女	
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
                        <input type="button" name="eidt" value="编辑" onclick="javascript:window.location.href='editTutorInfo.html'"/>
                        &nbsp;
                        <input type="button" name="forbid" value="禁用" onclick="modifyState(<s:property value="%{#request.tutorsInfo[#status.index].tutorNo}" />)" />
                    </td>
                  </tr>
            </s:iterator>
                </table>
           <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="<%=basePath%>images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span id="pageNum" class="right-text09">
                	<s:property value="%{#request.pageVo.pageNum}" />
                </span> 第<span id="currentPage" class="right-text09">
                	<s:property value="%{#request.pageVo.currentPage}" />
                </span> 页</td>
                <td width="49%" align="right">[<a class="right-font08" onclick="changePageNum('first',null)">
                                                首页</a> 
                | <a class="right-font08" onclick="changePageNum('fore',null)">上一页</a>
                | <a class="right-font08" onclick="changePageNum('next',null)">下一页</a> 
                | <a class="right-font08" onclick="changePageNum('last',null)">末页</a>] 
                                                转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
                      <input id="changePageNumNum" name="changePageNumNum" type="text" class="right-textfield03" size="1" />
                      </td>
                      <td width="87%">
                      <input name="sure" type="button" class="right-button06" onclick="changePageNum('input')"/>
                      </td>
                    </tr>
                </table>
                </td>
              </tr>
            </table></td>
        </tr>
      </table>
      </td>
        </tr>
      </table></td>
  </tr>
</table>
</td>
</tr>
</table>
</body>

<script language=JavaScript>
	function modifyState(tutorNo){
		$.get("tutor/modifyTutor?tutorNo="+tutorNo+"&method="+"state",function(data){
	    		alert(data);
	     });
	};
</script>
</html>
