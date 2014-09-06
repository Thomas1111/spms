<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE .jsp PUBLIC "-//W3C//DTD .jsp 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(<%=basePath%>images/left.gif);
}
-->
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
			<td width="207" height="55" background="<%=basePath%>images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="<%=basePath%>images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02"><s:property value="#session.name"/></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="<%=basePath%>login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
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
				  <td width="9%" height="20" ><img id="xiaotu4" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<%=basePath%>files/tutor/modifyPassword.jsp" target="mainFrame" class="left-font03" onClick="tupian('4');">修改密码</a></td>
				</tr>
      </table>

	  <!--  选题管理-->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >申请选题</a></td>
                </tr>
            </table>
       		</td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
          <td width="9%" height="20" ><img id="xiaotu7" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/student/applySubject.jsp" target="mainFrame" class="left-font03" onClick="tupian('7');">申请选题</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiaotu3" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/student/displaySubject.jsp" target="mainFrame" class="left-font03" onClick="tupian('3');">查看结果</a></td>
        </tr>
      </table>

	  <!--毕设进度管理 -->

	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img3" id="img3" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');">毕设进度管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20" ><img id="xiaotu8" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/student/displayTask.jsp" target="mainFrame" class="left-font03" onClick="tupian('8');">查看任务书</a></td>
        </tr>
		<tr>
          <td width="9%" height="20" ><img id="xiaotu9" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/student/fillPhaseMission.jsp" target="mainFrame" class="left-font03" onClick="tupian('9');">填写阶段任务</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiaotu10" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/student/displayGroup.jsp" target="mainFrame" class="left-font03" onClick="tupian('10');">查看答辩分组</a></td>
        </tr>
      </table>

      <!-- 文档管理-->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%"><img name="img5" id="img5" src="<%=basePath%>images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('5');">文档管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>

	  <table id="subtree5" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20"><img id="xiaotu13" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=basePath%>files/student/uploadFile.jsp" target="mainFrame" class="left-font03" onClick="tupian('13');">上传文档</a></td>
        </tr>
        <tr>
          <td width="9%" height="20"><img id="xiaotu1" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=path%>/document/queryDoc" target="mainFrame" class="left-font03" onClick="tupian('1');">查看文档</a></td>
        </tr>
        <tr>
          <td width="9%" height="20"><img id="xiaotu6" src="<%=basePath%>images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<%=path%>/document/queryDoc" target="mainFrame" class="left-font03" onClick="tupian('6');">
          	资料下载</a></td>
        </tr>
      </table>
	  </TD>
  </tr>
</table>
</body>
</.jsp>
