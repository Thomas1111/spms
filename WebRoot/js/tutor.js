
//初始化级联信息
function initCascadeInfo(type){
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
			$.get("subject/querySubjectAsyc?"+"type="+type+"&term="+term,function(data){
				var message = data.message;		
				var subjectInfos = data.subjectInfos;
				if(message == "加载成功"){
					var subject = document.getElementById("subject");
					for(var j = 0;j < subjectInfos.length;j++){
						var option = document.createElement('option');		//创建option元素
						option.text = subjectInfos[j].subName;		//赋值option
						subject.appendChild(option);	//添加option节点
					}
				}else{
					alert(message);
				}
			});
		});
	}
//term改变，加载选题信息
function reloadSubByterm(term,url,type){
	$.get(url+"type="+type+"&term="+term,function(data){
		var subject = document.getElementById("subject");	//获取subject节点
		var optLength = subject.options.length;		//之前options数量
		var subjectInfos = data.subjectInfos;		//加载选题信息
		alert("second index is " + subject.options[1].index);
		for(var i = 0;i < optLength;i++){
			subject.remove(i);	//移除subject选项信息
		}
		for(var j = 0;j < subjectInfos.length;j++){
			var option = document.createElement('option');		//创建option元素
			option.text = subjectInfos[j].subName;		//赋值option
			subject.add(option);	//添加option节点
			alert("option index is " + option.index);
		}
		subject.remove(0);		//将第一个元素移除
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
	
	
	var subName = document.getElementById("subName").value;
	var subSource = document.getElementsByName("subSource"); 
	var subLocation = document.getElementById("subLocation").value; 
	var subType = document.getElementsByName("subType"); 
	var intruduce = document.getElementById("intruduce").value;
	
	for(var i = 0;i <subSource.length;i++){
		if(subSource[i].checked == true){
			location = true;
		}
	}
	
	for(var j = 0;j <subType.length;j++){
		if(subType[j].checked == true){
			type = true;
		}
	}
	
	if(subName == "" || 
			subLocation == "" || 
				intruduce == "" || 
					!type || !location){
		alert("您还有必要信息尚未填，请检查");
		flag = false;
	}
	
	return flag;
}
