<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'uploadFile.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" rev="stylesheet" href="<%=basePath%>css/style.css" type="text/css" media="all" />
<script src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>
<script language="JavaScript" type="text/javascript">
//获取文件名参数
function fill(){
		var document = $("#document").val();	//获取文件目录	
		var suffix = String(document).split(".").pop();		//获取文件后缀
		if(!(suffix == "doc")){
			alert("文件必须是.doc文档");
		}else{
			//截取文件名，并将文件名赋值与input隐藏域
			$("#fileName").attr("value",String(document).split("\\").pop());
		}
	}
function tishi()
{
  var a=confirm('132');
  if(a!=true)return false;
  window.open("³åÍ»Ò³.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">

.atten {font-size:12px;font-weight:normal;color:#F00;}

</style>
</head>

<body class="ContentBody">
<form action="document/uploadDoc" method="post" enctype="multipart/form-data" name="form">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >文档管理
      </th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<TR>
			<TD width="100%">
				<fieldset style="height:100%;" align="center">
				<legend>上传资料</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="center" width="25%">
					    	 <select name="sendObject">
					    	 	<option checked="true">----发给所有----</option>
					    <s:iterator value="%{#request.stuBasicInfos}" id="id" status="status">
            					<option>
            			<s:property value="%{#request.stuBasicInfos[#status.index].studentName}" />
            					</option>
            			</s:iterator>
         					 </select>
					    </td>
					    <td width="25%" align="left">
					    	 <select name="fileType">
					    	 	<option checked="true">开题报告类</option>
            					<option>毕设文档类</option>
           						<option>其它</option>
         					 </select>
					    </td>
					    <td nowrap align="center" width="25%">
					    	<input type="file" id="document" name="upload" onchange="fill()"/>
					    </td>
					    <td width="25%" align="left">
					    	<input type="hidden" id="fileName" name="fileName" value="测试" />
					    	<input type="submit" name="sure" value="上传" />
					    </td>
					  </tr>
					  </table>
			  		<br />
				</fieldset>			
			</TD>
		</TR>	
		</TABLE>
	 </td>
  </tr>
		</TABLE>
	 </td>
  </tr>
  </table>
</div>
</form>
</body>
</html>
