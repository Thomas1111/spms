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
    
    <title>My JSP 'displayFiles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" rev="stylesheet" href="<%=basePath%>css/style.css" type="text/css" media="all" />

<script language="JavaScript" type="text/javascript">
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
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
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
				<fieldset style="height:100%;">
				<legend>已上传文件</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
				<s:iterator value="%{#request.docInfo}" id="id" status="status">
					  <tr>
					    <td nowrap align="left" width="50%">
					    <li>
					    	<a> 
							<s:property value="%{#request.docInfo[#status.index].docName}" />
					    	</a>
					    </li>
					    </td>
					    <td width="20%" align="left">
					    	<s:property value="%{#request.docInfo[#status.index].docType}" />
					    </td>
					    <td width="30%" align="right">
					    	<s:property value="%{#request.docInfo[#status.index].uploadTime}" />
					    </td>
					  </tr>
				</s:iterator>
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
