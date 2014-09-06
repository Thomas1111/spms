<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addGroup.jsp' starting page</title>
    
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
      <th class="tablestyle_title" >
      </th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;align=center;">
				<legend>新建分组信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">    
					   <tr>
					    <td  width="11%" nowrap align="right">小组名称</td>
					    <td width="27%"><input name='groupName' type="text" class="text" style="width:250px" value="" />
					    </td>
					   </tr>
					  <tr>
					    <td nowrap align="right" width="11%">小组组长</td>
					    <td width="27%"><input name='groupLeader' type="text" class="text" style="width:250px" value="" />
					    </td>
					   </tr>
					    <tr>
					    <td nowrap align="right" width="11%">小组秘书</td>
					    <td width="27%"><input name='secretary' type="text" class="text" style="width:250px" value="" />
					    </td>
					   </tr>
					   <tr>
					    <td nowrap align="right" width="11%">秘书电话</td>
					    <td width="27%"><input name='phoneNumber' type="text" class="text" style="width:250px" value="" />
					    </td>
					   </tr>
					    <tr>
					    <td nowrap align="right" width="11%">答辩地点</td>
					    <td width="27%"><input name='location' type="text" class="text" style="width:250px" value="" />
					    </td>
					   </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		</TABLE>

	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="modify" value="新建" class="button" onclick="alert('新建成功');"/>
			<input type="button" name="cancel" value="取消" class="button" onclick=""/>
		</TD>
		</TR>
		</TABLE>
	 </td>
  </tr>  
  </table>
</div>
</form>
</body>
</html>
