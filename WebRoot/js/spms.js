
/*学生查询模块*/
function stuInfoInit(){
	var url = "student/queryStudentAsyc?";
	init(url);
}
function changeStuPage(opeType){
	var url = "student/queryStudentAsyc?";
	change(opeType,url);
}
//检查修改密码信息
function checkModPass(){
	var flag = true;
	var confirmPass = document.getElementById("confirmPass").value;
	var modifyPass = document.getElementById("modifyPass").value;
	var originPass = document.getElementById("originPass").value;
	
	if(confirmPass == ""
		|| modifyPass == ""
			|| originPass == ""){
		alert("信息不能为空");
		flag = false;
	}else{
		if(modifyPass !=confirmPass){
			alert("前后密码不一致");
			flag = false;
		}
	}
	
	return flag;
}
//取消修改密码信息
function cancelModPass(){
	document.getElementById("confirmPass").value = "";
	document.getElementById("modifyPass").value = "";
	document.getElementById("originPass").value = "";
}
//默认加载学期
function init(url){
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
			//alert("初始化学期为"+term);
			loadInfoAsyc(url,term);
		});
}
function loadInfoAsyc(url,term){
	$.get(url+"currentPage=1&term="+term,function(data){
		createStuInfoTab(data);
	});
}
//移除已存在的数据
function removeExistStuInfo(){
	var stuInfoTab = document.getElementById("stuInfoTab"); 
	var rows = stuInfoTab.rows.length;
	for(var i = 2;i < rows;i++){
		stuInfoTab.deleteRow(-1);
	}
}
//动态创建表格
function createStuInfoTab(data){
	var pageVo = data.pageVo;
	var stuBasicInfo = data.stuBasicInfos;
	setPageInfo(pageVo);	//设置分页信息
	var stuInfoTab = document.getElementById("stuInfoTab"); 	//获取显示信息的table
	var cols = document.getElementById("firstRow").childNodes;		//获取行数的所有节点
		for(var i = 0;i < stuBasicInfo.length;i++){
			var k = 0;		//标记位
			var row = document.createElement("tr");		//创建tr节点
			row.setAttribute('align','center');		//设置tr属性值
			for(var j = 0;j < cols.length;j++){
				if(cols[j].nodeType == 1){		//判断node的类型是否是TD	
					k++;
					col = document.createElement("td");		//创建td节点
					//设置td属性
					col.setAttribute('align','center');
					col.setAttribute('bgcolor','#FFFFFF');
					col.innerHTML= fillStuTabInfo(stuBasicInfo,i,k);	//填写表格属性
					row.appendChild(col);		//添加列
				};	
			};	
			stuInfoTab.appendChild(row);		//添加行
		};
	}
//获取

//设置显示分页内容
function setPageInfo(pageVo){
	var pageNum = document.getElementById("pageNum");	//获取span对象
	var currentPage = document.getElementById("currentPage");	//获取span对象
	pageNum.innerHTML = pageVo.pageNum;		//写入页面总数html属性
	currentPage.innerHTML = pageVo.currentPage;  //写入当前页面html属性
}
//获取下拉选项学期的学生信息
function reloadByterm(term,url){
	$.get(url+"currentPage=1&term="+term,function(data){
				removeExistStuInfo();		//移除已有表格信息
				createStuInfoTab(data);		//创建表格
	});
}
//页面更换,重新加载数据
function change(opeType,url){
		var maxPage = document.getElementById("pageNum").innerHTML;
		var term = document.getElementById("term").value; //获取当前学期
		var currentPage = document.getElementById("currentPage").innerHTML;
		currentPage = new Number(currentPage);		//将字符串转换为数字
		//alert("当前页面"+currentPage);
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
		
		$.get(url+"currentPage="+currentPage+"&term="+term,function(data){
			removeExistStuInfo();
			createStuInfoTab(data);
		});
}
//填充学生基本表格信息
function fillStuTabInfo(stuBasicInfo,i,k){
	var colValue = "";		//列信息
	switch(k)
	{
		case 1:
			colValue =  stuBasicInfo[i].studentNo;
			break;
		case 2:
			colValue =  stuBasicInfo[i].studentName;
			break;
		case 3:
			colValue =  displaySex(stuBasicInfo[i].sex);
			break;
		case 4:
			colValue =  stuBasicInfo[i].college;
			break;
		case 5:
			colValue =  stuBasicInfo[i].major;
			break;
		case 6:
			colValue =  stuBasicInfo[i].className;
			break;
		case 7:
			colValue =  stuBasicInfo[i].telephone;
			break;
		default:
	};
	return colValue;
}

//转换性别
function displaySex(sex){
	var type = "男";
	if(sex == 1){
		type = "女";
	}
	return type;
}
