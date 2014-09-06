
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
			//alert("初始化学期为"+term);
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
		var subjectInfos = data.subjectInfos;
		for(var i = 0;i < optLength;i++){
			subject.remove(i);	//移除subject选项信息
		}
		for(var j = 0;j < subjectInfos.length;j++){
			var option = document.createElement('option');		//创建option元素
			option.text = subjectInfos[j].subName;		//赋值option
			subject.appendChild(option);	//添加option节点
		}
	});
}
