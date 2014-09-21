
function initTerm(){
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
		});
}
function reloadVerTutorSubByterm(term){
	var currentPage = document.getElementById("currentPage").innerHTML;
	var tutorNo = document.getElementById("tutorNo").value;
	javascript:window.location.href="subject/displaySubject?currentPage="+currentPage+"&term="+term+"&tutorNo="+tutorNo;
	
}
//管理员审核导师选题
function verifyTutorSub(state,subjectNo){
	var terms = document.getElementById("term");	// 获取学期
	var options = terms.options;
	var term = options[terms.selectedIndex].text;
	var currentPage = document.getElementById("currentPage").innerHTML;
	$.get("subject/opeSubject!verifySubject?exameState="+state+"&subjectNo="+subjectNo+"&term="+term,function(data){
		alert(data.message);		//显示操作信息
		var tutorNo = document.getElementById("tutorNo").value;		//获取隐藏域信息
		javascript:window.location.href="subject/displaySubject?currentPage="+currentPage+"&term="+term+"&tutorNo="+tutorNo;
	});
}
//管理员更换学期，重新加载选题信息
function reloadTutorSubByterm(term){
	var tutorNo = document.getElementById("tutorNo").value;		//获取隐藏域信息
	javascript:window.location.href="subject/displaySubject?flag=reload&currentPage=1&term="+term+"&tutorNo="+tutorNo;
}
//创建审核导师上报选题表
function createTutSubTab(term,url){
	$.get(url+"type=asyc"+"&term="+term,function(data){
		var message = data.message;
		var subjectInfos = data.tutorSubInfos;
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr><td height='20' colspan='13' align='center' bgcolor='#EEEEEE' class='tablestyle_title'>" +
			"<center>彭莹琼导师上报选题信息</center></td></tr><tr>"+
			"<td width='20%' height='20' align='center' bgcolor='#EEEEEE'>题目名称</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>题目来源</td>"+
            "<td width='10%'  align='center' bgcolor='#EEEEEE'>题目类型</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>导师类型</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>审核状态</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>选题操作</td></tr>";
			for(var j = 0;j < subjectInfos.length;j++){
					//获取性别状态并进行转换
					var subState = displayExamState(subjectInfos[j].exameState);
					var subTerm = subjectInfos[j].subTerm.split("-");
					var temp = "<tr align='center'>"+
				    "<td width='20%' height='20' align='center' bgcolor='#FFFFFF'><a href='./tutor/queryTutor?tutorNo="+subjectInfos[j].tutorNo+"'" +
				    "target='mainFrame'>"+subjectInfos[j].subName+"</a></td>"+
				    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subSource+"</td>" +
				    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subType+"</td>" +
				    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].subPosition+"</td>"+
				    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subState+"</td>"+
				    "<td width='15%' height='20' align='center' bgcolor='#FFFFFF'>"+
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
//更改页面，加载信息(非异步加载方式)
function changePageNum(opeType,number){
	var url = "tutor/queryTutor?currentPage=";
	switch(number){
	case 1:		//导师获取学生名单
		var term = getCurrentTerm();	//获取当前学期
		url = "tutor/queryTutor?opeType=adminManifest&flag=reload&term="+term+"&currentPage=";
		break;
	case 2:
		url = "tutor/queryTutor?opeType=verifySub&currentPage=";
		break;
	case 3://导师获取审核开题报告信息
		var term = getCurrentTerm();	//获取当前学期
		url = "report/queryReport?flag=reload&reportTerm="+term+"&currentPage=";
		break;
	case 4:
		var term = getCurrentTerm();	//获取当前学期
		url = "phaseMission/phaMisAction!queryPhaseInfo?flag=reload&term="+term+"&currentPage=";
		break;
	case 5:		//管理员获取导师选题信息
		var term = getCurrentTerm();	//获取当前学期
		var tutorNo = document.getElementById("tutorNo").value;		//获取隐藏域信息
		url = "subject/displaySubject?flag=reload&tutorNo="+tutorNo+"&term="+term+"&currentPage=";
		break;
	default:
		break;
	}
	var maxPage = document.getElementById("pageNum").innerHTML;
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
			return;
		}else{
			currentPage = 1;
		}
	}else if("last" == opeType){
		if(currentPage == maxPage){
			alert("已经是尾页哦");
			return;
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
	window.location.href=url+currentPage;
}
//获取当前学期
function getCurrentTerm(){
	var terms = document.getElementById("term");	// 获取学期
	var options = terms.options;
	var term = options[terms.selectedIndex].text;
	return term;
}
