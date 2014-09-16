
//发布任务书-初始化级联信息
function initCascadeInfo(type){
	var addForm = document.getElementById("addtTask");	//获取添加任务信息的表单元素
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
			var term = termOptions.options[terms.length-1].text;	//获取默认节点的属性值
			$.get("subject/querySubjectAsyc?"+"type="+type+"&subState=1&term="+term,function(data){
				var message = data.message;		
				var subjectInfos = data.subjectInfos;
				if(message == "加载成功"){
					var subject = document.getElementById("subject");
					for(var j = 0;j < subjectInfos.length;j++){
						var option = document.createElement('option');		//创建option元素
						option.text = subjectInfos[j].subName;		//赋值option
						subject.appendChild(option);	//添加option节点
					}
					//设置添加表单的action属性
					addForm.action = "report/manageTask!addTaskInfo?term="+term+"&subName="+subjectInfos[0].subName;
				}else{
					alert(message);
				}
			});
		});
	}
//发布任务书-term改变，加载选题信息
function reloadSubByterm(term,url,type){
	$.get(url+"type="+type+"&subState=1&term="+term,function(data){
		var subject = document.getElementById("subject");	//获取subject节点
		var optLength = subject.options.length;		//之前options数量
		var subjectInfos = data.subjectInfos;		//加载选题信息
		var message = data.message;		
		for(var i = 0;i < optLength;i++){
			subject.remove(0);	//移除subject选项信息
		}
		if(message == "加载成功"){
			for(var j = 0;j < subjectInfos.length;j++){
				var option = document.createElement('option');		//创建option元素
				option.text = subjectInfos[j].subName;		//赋值option
				subject.add(option);	//添加option节点
			}
		}else{
			alert(message);
		}
		
	});
}
//发布任务书--判断添加信息的合理性
function checkTaskInfo(){
	var flag = true;
	var content = document.getElementById("content").value;
	var digram = document.getElementById("digram").value;
	var index = document.getElementById("index").value;
	var schedlue = document.getElementById("schedlue").value;
	var reference = document.getElementById("reference").value;
	//判断信息是否为空
	if(content == " " || digram == " " 
		|| index == " " ||schedlue == " " || reference == " "){
		alert("信息不能为空!");
		flag = false;
	}
	
	return flag;
}
//发布任务书--重置任务书信息
function resetTaskInfo(){
	document.getElementById("content").value = " ";
	document.getElementById("digram").value = " ";
	document.getElementById("index").value = " ";
	document.getElementById("schedlue").value = " ";
	document.getElementById("reference").value = " ";
}
//学生查询任务书
function initTaskInfo(){
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
				var term = termOptions.options[terms.length-1].text;	//获取默认节点的属性值
				alert(term);
				$.get("phaseManage/queryTaskAsyc?term="+term,function(data){	//获取当前学期信息
					if(data.message == "查询成功"){
						var subName = document.getElementById("subName");
						subName.InnerHTML = data.taskInfoVo.subName;	//设置任务书对应选题名称
						//显示任务信息
						document.getElementById("content").innerHTML = data.taskInfoVo.content;
						document.getElementById("diagram").innerHTML = data.taskInfoVo.diagram;
						document.getElementById("indicator").innerHTML = data.taskInfoVo.indicator;
						document.getElementById("schedule").innerHTML = data.taskInfoVo.schedule;
						document.getElementById("reference").innerHTML = data.taskInfoVo.reference;
					}else{
						alert(data.message);
					}
					
				});
	});
}
//学生查询任务书--term改变加载任务书信息
function reloadTaskByTerm(term){
	$.get("phaseManage/queryTaskAsyc?term="+term,function(data){	//获取当前学期信息
		if(data.message == "查询成功"){
			var subName = document.getElementById("subName");
			subName.InnerHTML = data.taskInfoVo.subName;	//设置任务书对应选题名称
			document.getElementById("content").innerHTML = data.taskInfoVo.content;
			document.getElementById("diagram").innerHTML = data.taskInfoVo.diagram;
			document.getElementById("indicator").innerHTML = data.taskInfoVo.indicator;
			document.getElementById("schedule").innerHTML = data.taskInfoVo.schedule;
			document.getElementById("reference").innerHTML = data.taskInfoVo.reference;
		}else{
			alert(data.message);
		}
		
	});
}
//上报选题---初始化学期隐藏域
function initTerm(){
	$.post("student/queryTerm",		//获取当前学期信息
			function(data){
				var terms = JSON.parse(data);		//转换为json格式内容
				var hidTerm = document.getElementById("hidTerm");	//获取隐藏域对象
				hidTerm.value = terms[terms.length - 1].term;		//赋值学期隐藏域
				
	});
}
//上报选题---检查信息合理性
function checkSubInfo(){
	var flag = true;
	var type = false;
	var location = false;
	//获取对象属性
	var subName = document.getElementById("subName").value;
	var subSource = document.getElementsByName("subSource"); 
	var subLocation = document.getElementById("subLocation").value; 
	var subType = document.getElementsByName("subType"); 
	var intruduce = document.getElementById("intruduce").value;
	//检查题目来源内容是否为空
	for(var i = 0;i <subSource.length;i++){
		if(subSource[i].checked == true){
			location = true;
		}
	}
	//检查题目类型内容是否为空
	for(var j = 0;j <subType.length;j++){
		if(subType[j].checked == true){
			type = true;
		}
	}
	//判断必填内容是否为空
	if(subName == "" || 
			subLocation == "" || 
				intruduce == "" || 
					!type || !location){
		alert("您还有必要信息尚未填，请检查");
		flag = false;
	}
	
	return flag;
}
//显示选题基本信息
function displaySubInfo(utility){
	var url = identityUrl(utility,1);
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
				var term = termOptions.options[terms.length-1].text;	//获取默认节点的属性值
				switch(utility){	//调用创建表格方法
				case 1:
					createSubTable(term,url);
					break;
				case 2:
					createVerSubTab(term,url);
					break;
				case 3:
					createApplyTab(term,url);
					break;
				case 4:
					createCancelTab(term,url);
					break;
				case 5:
					createSubResultTab(term,url);
					break;
				case 6:
					createTutSubTab(term,url);
					break;
				default:
					break;
				}
		});
	}
//创建选题表格
function createSubTable(term,url){
	$.get(url+"type=asyc"+"&term="+term,function(data){
		var message = data.message;		
		var subjectInfos = data.subjectInfos;
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr>"+
			"<td width='30%' height='20' align='center' bgcolor='#EEEEEE'>选题名称</td>"+
            "<td width='5%' align='center' bgcolor='#EEEEEE'>上限人数</td>"+
            "<td width='5%' align='center' bgcolor='#EEEEEE'>现选人数</td>"+
            "<td width='20%' align='center' bgcolor='#EEEEEE'>上报时间</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题状态</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题操作</td></tr>";
			for(var j = 0;j < subjectInfos.length;j++){
				//获取审核状态并进行转换
				var exameState = displayExamState(subjectInfos[j].exameState);
				var temp = "<tr align='center'>"+
			    "<td width='30%' height='20' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subName+"</td>"+
			    "<td width='5%' align='center' bgcolor='#FFFFFF'>1</td>" +
			    "<td width='5%' align='center' bgcolor='#FFFFFF'>1</td>" +
			    "<td width='20%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].applyTime+"</td>"+
			    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+exameState+"</td>"+
			    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+
			    "<input name='edit' type='button' value='编辑' />"+"</td>"
                +"</tr>";
				subInfoHtml = subInfoHtml + temp;
			}
			subject.innerHTML = subInfoHtml;
			setPageInfo(data.pageVo);	//设置分页属性
		}else{
			alert(message);
		};
	});
}
//创建审核选题表格
function createVerSubTab(term,url){
	$.get(url+"type=asyc"+"&term="+term,function(data){
		var message = data.message;		
		var subjectInfos = data.subjectInfos;
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr>"+
			"<td width='30%' height='20' align='center' bgcolor='#EEEEEE'>选题名称</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>学生学号</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>学生姓名</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>通过状态</td>"+
            "<td width='20%' align='center' bgcolor='#EEEEEE'>审核状态</td></tr>";
			for(var j = 0;j < subjectInfos.length;j++){
				//获取审核状态并进行转换
				var exameState = displayExamState(subjectInfos[j].stuExaState);
				var subTerm = subjectInfos[j].subTerm.split("-");
				var temp = "<tr align='center'>"+
			    "<td width='30%' height='20' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subName+"</td>"+
			    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].studentNo+"</td>" +
			    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].studentName+"</td>" +
			    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+exameState+"</td>"+
			    "<td width='20%' align='center' bgcolor='#FFFFFF'><input type='button' name='pass' value='通过' onclick='verifyInfo(1,"+subjectInfos[j].studentNo+","+subTerm+")'/>" +
			    		"&nbsp;"+
                "<input type='button' name='revoke' value='不通过' onclick='verifyInfo(3,"+subjectInfos[j].studentNo+","+subTerm+")'/>" 
                +"</td>"
                +"</tr>";
				subInfoHtml = subInfoHtml + temp;
			}
			subject.innerHTML = subInfoHtml;
			setPageInfo(data.pageVo);	//设置分页属性
		}else{
			alert(message);
		}
	});
}

//创建申请选题表格
function createApplyTab(term,url){
	$.get(url+"type=asyc"+"&term="+term,function(data){
		var message = data.message;		
		var subjectInfos = data.subjectInfos;
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr>"+
			"<td width='30%' height='20' align='center' bgcolor='#EEEEEE'>选题名称</td>"+
            "<td width='5%' align='center' bgcolor='#EEEEEE'>上限人数</td>"+
            "<td width='5%' align='center' bgcolor='#EEEEEE'>剩余人数</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>指导老师</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题操作</td>"+"</tr>";
			for(var j = 0;j < subjectInfos.length;j++){
				//获取审核状态并进行转换
				var exameState = displayExamState(subjectInfos[j].stuExaState);
				var subTerm = subjectInfos[j].subTerm.split("-");
				var button;
				var temp = "<tr align='center'>"+
			    "<td width='30%' height='20' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subName+"</td>"+
			    "<td width='5%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].applyNum+"</td>" +
			    "<td width='5%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].leftNum+"</td>" +
			    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].tutorName+"</td>" 
			    +"<td width='10%' align='center' bgcolor='#FFFFFF'>";
			    if(subjectInfos[j].leftNum == 0){
			    	button = "你来晚了哦";
			    }else{
			    	button = "<input type='button' name='revoke' value='申请' onclick='operateSub(1,"+subjectInfos[j].subjectNo+","+subjectInfos[j].leftNum+","+subTerm+")'/>";
			    }
				button = button + "</td></tr>";
				temp = temp +button;
				subInfoHtml = subInfoHtml + temp;
			}
			subject.innerHTML = subInfoHtml;
			setPageInfo(data.pageVo);	//设置分页属性
		}else{
			alert("***");
			alert(message);
		}
	});
}
//创建退选选题表格
function createCancelTab(term,url){
	$.get(url+"&term="+term,function(data){
		var message = data.message;		
		var subjectInfos = data.subjectInfos;
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr>"+
			"<td width='30%' height='20' align='center' bgcolor='#EEEEEE'>选题名称</td>"+
            "<td width='5%' align='center' bgcolor='#EEEEEE'>上限人数</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>指导老师</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>选题状态</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题操作</td></tr>";
			for(var j = 0;j < subjectInfos.length;j++){
				//获取审核状态并进行转换
				var exameState = displayExamState(subjectInfos[j].stuExaState);
				alert(subjectInfos[j].stuExaState);
				var button;
				var subTerm = subjectInfos[j].subTerm.split("-");
				var temp = "<tr align='center'>"+
			    "<td width='30%' height='20' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subName+"</td>"+
			    "<td width='5%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].applyNum+"</td>" +
			    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].tutorName+"</td>" +
			    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+exameState+"</td>" +"<td width='10%' align='center' bgcolor='#FFFFFF'>";
				if(subjectInfos[j].stuExaState == 1){
					button = "<input type='button' name='revoke' value='退选' disabled=true/>";
				}else{
					button = "<input type='button' name='revoke' value='退选' onclick='operateSub(2,"+subjectInfos[j].subjectNo+","+subjectInfos[j].leftNum+","+subTerm+")'/>";
				}
				button = button + "</td></tr>";
				temp = temp + button;
				subInfoHtml = subInfoHtml + temp;
			}
			subject.innerHTML = subInfoHtml;
			//setPageInfo(data.pageVo);	//设置分页属性
		}else{
			alert(message);
		}
	});
}
//创建导师选题结果
function createSubResultTab(term,url){
	$.get(url+"&term="+term,function(data){
		var message = data.message;		
		var subResult = data.results.subResult;		//获取选题结果信息
		var distribution = data.results.distribution;	//获取已发布任务书选题编号
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr>"+
			"<td width='10%' height='20' align='center' bgcolor='#EEEEEE'>学生学号</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>学生姓名</td>"+
            "<td width='30%' align='center' bgcolor='#EEEEEE'>选题名称</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>任务书状态</td>"+
            "<td width='20%' align='center' bgcolor='#EEEEEE'>操作</td></tr>";
			for(var j = 0;j < subResult.length;j++){
				var button;
				var subTerm = subResult[j].subTerm.split("-");
				var temp = "<tr align='center'>"+
			    "<td width='10%' height='20' align='center' bgcolor='#FFFFFF'>"+subResult[j].studentNo+"</td>"+
			    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subResult[j].studentName+"</td>" +
			    "<td width='30%' align='center' bgcolor='#FFFFFF'>"+subResult[j].subName+"</td>"; 
				if(identifyTaskInfo(distribution,subResult[j].subjectNo)){
					button = "<td width='10%' align='center' bgcolor='#FFFFFF'>已发布任务书</td>" 
				    +"<td width='10%' align='center' bgcolor='#FFFFFF'>"+"<input type='button' name='appriseMission' value='发布任务书' disabled=true/>";
				}else{
					button = "<td width='10%' align='center' bgcolor='#FFFFFF'>未发布任务书</td>" 
				    +"<td width='10%' align='center' bgcolor='#FFFFFF'>"+"<input type='button' name='appriseMission' value='发布任务书' />";
				}
				button = button + "</td></tr>";
				temp = temp + button;
				subInfoHtml = subInfoHtml + temp;
			}
			subject.innerHTML = subInfoHtml;
			setPageInfo(data.pageVo);
		}else{
			alert(message);
		}
	});
}
//检查是否已发布任务书
function identifyTaskInfo(distribution,subjectNo){
	var flag = false;
	for(var i = 0;i < distribution.length;i++){
		if(distribution[i].subjectNo == subjectNo){	//判断选题编号是否一致
			flag = true;
		}
	}
	return flag;
}
//学生操作选题(包括申请、退选)
function operateSub(type,subjectNo,leftNum,subTerm){
	var opeType;
	var term = subTerm+"-"+(subTerm+1);	// 获取学期
	var url;
	var currentPage;
	if(type == 1){		//判断操作类型
		opeType = "apply";
		currentPage = document.getElementById("currentPage").innerHTML;
		currentPage = new Number(currentPage);		//将字符串转换为数字
		url = identityUrl(3,currentPage);
	}else{
		opeType = "cancel";
		url = identityUrl(4,currentPage);
	}
	$.get("subject/opeSubject!opeSubject?opeType="+opeType+"&subjectNo="+subjectNo+"&leftNum="+leftNum+"&term="+term,function(data){
		alert(data.message);
		removeExistSubInfo();		//移除现存信息
		if(type == 1){
			createApplyTab(term,url);	//更新申请选题信息
		}else{
			createCancelTab(term,url);		//更新退选选题信息
		}
		
	});
}
//审核选题信息
function verifyInfo(state,studentNo,subTerm){
	var term = subTerm+"-"+(subTerm+1);	// 获取学期
	var currentPage = document.getElementById("currentPage").innerHTML;
	currentPage = new Number(currentPage);		//将字符串转换为数字
	var url = identityUrl(2,currentPage);	//获取路径
	$.get("subject/opeSubject!verifySubject?stuExaState="+state+"&studentNo="+studentNo+"&term="+term,function(data){
		alert(data.message);		//显示操作信息
		removeExistSubInfo();		//移除现存信息
		createVerSubTab(term,url);	//更新审核信息
	});
}
//移除现存在的信息
function removeExistSubInfo(){
	var subjectTab = document.getElementById("subjectInfo");
	var rows = subjectTab.rows.length;
	for(var i = 1;i < rows;i++){
		subjectTab.deleteRow(-1);
	}
}
//动态加载学期选题信息
function reloadInfoByterm(term,utility){
	var url = identityUrl(utility,1);
	$.get(url+"currentPage=1&type=asyc&term="+term,function(data){
		removeExistSubInfo();		//移除已有表格信息
		switch(utility){	//调用创建表格方法
		case 1:
			createSubTable(term,url);
			break;
		case 2:
			createVerSubTab(term,url);
			break;
		case 3:
			createApplyTab(term,url);
			break;
		case 4:
			createCancelTab(term,url);
			break;
		case 5:
			createSubResultTab(term,url);
			break;
		case 6:
			createTutSubTab(term,url);
			break;
		default:
			break;
		}
});
}
//转换显示审核状态
function displayExamState(examState){
	var state = "未提交";
	switch(examState){
	case 1:
		state = "通过";
		break;
	case 2:
		state = "审核中";
		break;
	case 3:
		state = "未通过";
		break;
	default:
		break;
	}
	return state;
}
function identityUrl(utility,currentPage){
	var url = " ";
	switch(utility){
	case 1:
		url = "subject/querySubjectAsyc?currentPage="+currentPage+"&";	//获取选题基本信息
		break;
	case 2:
		url = "subject/querySubjectAsyc?currentPage="+currentPage+"&utility=stuSubInfo&";
		break;
	case 3:
		url = "subject/querySubjectAsyc?currentPage="+currentPage+"&utility=studentInfo&subState=1&";
		break;
	case 4:
		url = "subject/querySubjectAsyc?currentPage="+currentPage+"&utility=stuCancelInfo&";
		break;
	case 5:
		url = "subject/querySubjectAsyc!querySubResult?currentPage="+currentPage+"&";
		break;
	case 6:
		url = "subject/querySubjectAsyc?currentPage="+currentPage+"&";		//获取导师选题信息
		break;
	default:
		break;
	}
	
	return url;
}
//页面更换,重新加载数据
function changePage(opeType,utility){
		var maxPage = document.getElementById("pageNum").innerHTML;
		//alert("最大页面数量"+maxPage);
		var term = document.getElementById("term").value; //获取当前学期	
		var currentPage = document.getElementById("currentPage").innerHTML;
		currentPage = new Number(currentPage);		//将字符串转换为数字
		//判断是哪种操作，执行相应的逻辑
		if("input" == opeType){
			currentPage = document.getElementById("changeNum").value;	//获取跳转的页码
			if(currentPage <= 0 || currentPage > maxPage)
			{
				alert("输入页面数已超过范围");
				return;
			};
		}else if("first" == opeType){
			if(currentPage == 1){
				alert("已经是首页哦");
			}else{
				currentPage = 1;
			}
		}else if("last" == opeType){
			if(currentPage == maxPage){
				alert("已经是尾页哦");
			}else{
				currentPage = maxPage;
			}
		}else if("fore" == opeType){
			currentPage = currentPage - 1;
			if(currentPage <= 0){
				alert("已经是第一页哦");
				return;
			};
		}else{
			currentPage = currentPage + 1;
			if(currentPage > maxPage){
				alert("已经是最后一页哦");
				return;
			};
		}
		var url = identityUrl(utility,currentPage);
		removeExistSubInfo();		//移除已有表格信息
		switch(utility){	//调用创建表格方法
			case 1:
				createSubTable(term,url);
				break;
			case 2:
				createVerSubTab(term,url);
				break;
			case 3:
				createApplyTab(term,url);
				break;
			case 4:
				createCancelTab(term,url);
				break;
			case 5:
				createSubResultTab(term,url);
				break;
			case 6:
				createTutSubTab(term,url);
				break;
			default:
				break;
		}
}

