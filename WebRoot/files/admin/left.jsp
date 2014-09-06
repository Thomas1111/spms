<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
	background-image: url(<%=basePath%>images/left.gif);
}

</style>
<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="<%=basePath%>images/ico05.gif";
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="<%=basePath%>images/ico06.gif";}
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="<%=basePath%>images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="<%=basePath%>images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="<%=basePath%>images/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
					<td width="25%" rowspan="2"><img src="<%=basePath%>images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02"><s:property value="#session.name"/></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="<%=basePath%>login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
		</table>
		
		<!-- 公告管理-->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >公告管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20" ><img id="xiaotu20" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/admin/addNotice.jsp" target="mainFrame" class="left-font03" onClick="tupian('20');">发布公告</a></td>
        </tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu20" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=path%>/notice/queryNotice" target="mainFrame" class="left-font03" onClick="tupian('20');">查看公告</a></td>
				</tr>
      </table>
		<!-- 个人信息管理-->

        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >个人信息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu1" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=path%>/admin/queryAdmin" target="mainFrame" class="left-font03" onClick="tupian('1');">查看信息</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu4" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>files/tutor/modifyPassword.jsp" target="mainFrame" class="left-font03" onClick="tupian('4');">修改密码</a></td>
				</tr>
      </table>
		<!-- 导师管理-->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >导师管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
    <tr>
      <td width="9%" height="20" ><img id="xiaotu11" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
      <td width="91%"><a href="<%=path%>/tutor/queryTutor?currentPage=1" target="mainFrame" class="left-font03" onClick="tupian('11');">查看导师信息</a></td>
    </tr>
    <tr>
      <td width="9%" height="20" ><img id="xiaotu2" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
      <td width="91%"><a href="<%=path%>/tutor/queryTutor?opeType=adminManifest&currentPage=1" target="mainFrame" class="left-font03" onClick="tupian('2');">分配导师学生</a></td>
    </tr>
      </table>
<!--  选题管理-->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img3" id="img3" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');" >选题管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
		<tr>
          <td width="9%" height="20" ><img id="xiaotu1" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/admin/verifyTutorSubject.jsp" target="mainFrame" class="left-font03" onClick="tupian('1');">审核导师选题</a></td>
        </tr>
      </table>
<!--毕设管理 -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%"><img name="img5" id="img5" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('5');">毕设管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>

	  <table id="subtree5" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
		<tr>
          <td width="9%" height="20" ><img id="xiaotu12" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/admin/verifyStudentPaper.jsp" target="mainFrame" class="left-font03" onClick="tupian('12');">审核答辩资格</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiaotu10" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/admin/displayManifest.jsp" target="mainFrame" class="left-font03" onClick="tupian('10');">答辩资格名单</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiaotu11" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/admin/displayGroup.jsp" target="mainFrame" class="left-font03" onClick="tupian('11');">答辩分组信息</a></td>
        </tr>
      </table>
	  </TD>
  </tr>
</table>
</body>
</jsp>
