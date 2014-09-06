
body.onload=function(){
	$.post("student/queryTerm",
			function(data){
				var term = JSON.parse(data);
				var termOptions = document.getElementById("term"); 	//获取select节点
				//循环获取term并创建option节点
				for(var j = 0;j < term.length;j++){
					var option = document.createElement('option');		//创建option元素
					option.text = term[j].term;		//赋值option
					termOptions.appendChild(option);	//添加option节点
				}
				//设定option默认值(最新学期)
				termOptions.options[term.length-1].selected = true;
			});
};