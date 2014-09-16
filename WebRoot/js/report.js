
//审核开题报告--更换学期，加载信息
function reloadReportByterm(term){
	window.location.href="report/queryReport?flag=reload&reportTerm="
		+term+"&currentPage=1";
}
//上传开题报告---提交时确定信息
function checkReportInfo(form){
	var flag = true;

	var input = document.getElementById("upload");	//获取input表单
	var file = input.value.split("\\");		//分割文件路径
	var fileName = file[file.length - 1];	//获取文件名
	var url = "report/manageReport!addReport?fileName="+fileName;		//拼凑请求路径
	
	var fileTypes = document.getElementById("fileType");	// 获取fileType
	var options = fileTypes.options;
	var fileType = options[fileTypes.selectedIndex].text;	//获取当前选择的文件类型
	//判断文件类型
	if(fileType == "毕设文档类"){
		url="report";
	}
	form.action = url;		//设置form的action属性
	
	return flag;
}
//审核开题报告
function verifyReport(type,reportNo){
	//alert(reportNo);
	$.get("phaseManage/queryTaskAsyc!verifyReport?type="+type+"&reportNo="+reportNo,function(data){
		alert(data.message);
		var terms = document.getElementById("term");	
		var options = terms.options;
		var term = options[terms.selectedIndex].text;	// 获取学期获取当前学期
		var currentPage = document.getElementById("currentPage").innerHTML;	//获取当前
		
		window.location.href="report/queryReport?flag=reload&reportTerm="
			+term+"&currentPage="+currentPage;
	});
}



