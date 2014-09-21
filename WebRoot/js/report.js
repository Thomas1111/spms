
//异步加载上传文件类型、学期信息
function initUplaodInfo(){
	$.get("phaseManage/phaseMissionAys!getDocumentType",function(data){
		alert(data.message);
		var docTypes = data.docType;
		var fileType = document.getElementById("fileType");
		//循环获取fileType建option节点
		for(var j = 0;j < docTypes.length;j++){
			var option = document.createElement('option');		//创建option元素
			option.text = docTypes[j].documentType;		//赋值option
			fileType.appendChild(option);	//添加option节点
		}
		initTerm();		//异步加载学期信息
	});
}
//审核开题报告--更换学期，加载信息
function reloadReportByterm(term){
	window.location.href="report/queryReport?flag=reload&reportTerm="
		+term+"&currentPage=1";
}
//上传开题报告---提交时确定信息
function checkReportInfo(form){
	var flag = true;
	var input = document.getElementById("upload");	//获取input表单
	if(input.value == "" || input.value == null){
		alert("请选择文件");
		return false;
	}
	var file = input.value.split("\\");		//分割文件路径
	var fileName = file[file.length - 1];	//获取文件名
	var url = "report/manageReport?fileName="+fileName;		//拼凑请求路径
	
	form.action = url;		//设置form的action属性
	
	return flag;
}
//审核开题报告
function verifyReport(type,reportNo){
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



