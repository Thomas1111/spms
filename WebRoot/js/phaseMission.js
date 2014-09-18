
//异步加载阶段任务信息
function loadPhaMisInfo(){
	$.post("student/queryTerm",		//获取当前学期信息
			function(data){
				var terms = JSON.parse(data);		//转换为json格式内容
				var termOptions = document.getElementById("term"); 	//获取select节点
				//循环获取term并创建option节点
				for(var j = 0;j < terms.length;j++){
					var option = document.createElement('option');		//创建option元素
					option.text = terms[j].term;		//赋值option
					termOptions.appendChild(option);	//添加option节点
				}
				//设定option默认值(最新学期)
				termOptions.options[terms.length-1].selected=true;
				var term = termOptions.options[terms.length-1].text;
				//异步加载发送对象信息
				$.get("phaseManage/phaseMissionAys?term="+term,function(data){
					if(data.message == "加载成功"){
						var sendObjects = data.phaseMissionVo;	//获取异步加载数据
						var missionObjects = document.getElementById("missionObject");
						//添加第一个节点
						var first = document.createElement('option');
						first.selected = true;		//设置为默认选项
						first.text = "----全部----";		//赋值option
						missionObjects.appendChild(first);	//添加option节点
						//添加学生姓名
						for(var i = 0;i < sendObjects.length;i++){
							var option = document.createElement('option');		//创建option元素
							option.text = sendObjects[i].studentName;		//赋值option
							missionObjects.appendChild(option);	//添加option节点
						}
					}else{
						alert(data.message);
					}
				});
		});
}
//学期更换--加载发送对象信息
function reloadObjectByTerm(term){
	cancelPhase();	//清空阶段任务信息
	$.get("phaseManage/phaseMissionAys?term="+term,function(data){
		var sendObjects = data.phaseMissionVo;	//获取异步加载数据
		var missionObjects = document.getElementById("missionObject");
		var length = missionObjects.options.length;
		//移除现存节点信息
		for(var j = 0;j < length;j++){
			missionObjects.remove(0);
		}
		if(sendObjects != null){	//判断加载数据是否为空
			//添加第一个节点
			var first = document.createElement('option');
			first.selected = true;		//设置为默认选项
			first.text = "----全部----";		//赋值option
			missionObjects.appendChild(first);	//添加option节点
			//添加发送对象信息
			for(var i = 0;i < sendObjects.length;i++){
				var option = document.createElement('option');		//创建option元素
				option.text = sendObjects[i].studentName;		//赋值option
				missionObjects.appendChild(option);	//添加option节点
			}
		}
		if(data.message != "加载成功"){
			alert(data.message);	
		}
	});	
}
//检查发布阶段任务信息
function checkPhaseInfo(){
	var flag = true;
	//获取任务书信息
	var missionName = document.getElementById("missionName").value;
	var startTime = document.getElementById("startTime").value;
	var deadline = document.getElementById("deadline").value;
	var description = document.getElementById("description").value;
	
	//判断信息是否为空
	if(missionName == ""||startTime == ""
			|| deadline == ""||description == ""){
		alert("信息不能为空!");
		flag = false;
	}else{
		if(startTime > deadline){	//判读时间合理性
			alert("初始时间必须小于截止时间!");
			flag = false;
		}else{
			var missionObjects = document.getElementById("missionObject");
			var length = missionObjects.options.length;
			if(length == 0){	//判断发送对象是够为空
				alert("尚未有人申请选题，不能发布任务书");
				flag = false;
			}
		}
	}
	
	return flag;
}
//重置阶段任务信息
function cancelPhase(){
	document.getElementById("missionName").value = "";
	document.getElementById("startTime").value = "";
	document.getElementById("deadline").value = "";
	document.getElementById("description").value = "";
}

//导师查看阶段任务--更换学期
function reloadPhaseByterm(term){
	window.location.href="phaseMission/phaMisAction!queryPhaseInfo?currentPage=1&flag=reload&term="
		+term+"&currentPage=1";
}

//学生上传阶段任务
function checkFile(form,missionNo){
	var flag = true;
	var file = document.getElementById(missionNo);		//获取file对象
	var filePath = file.value;
	if(filePath == ""){
		alert("请选择文件");
		return false;
	}
	var fileName = filePath.split("\\").pop();	//获取文件名称
	var term = getCurrentTerm();	//获取当前学期
	form.action = "phaseMission/phaMisAction!uploadPhaMission?missionNo="
		+ missionNo + "&term=" + term + "&fileName=" + fileName;
	
	return flag;
}
