
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

//创建审核导师上报选题表
function createTutSubTab(term,url){
	$.get(url+"type=asyc"+"&term="+term,function(data){
		var message = data.message;
		var number = 1;
		var subjectInfos = data.tutorSubInfos;
		alert(subjectInfos.length);
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr><td height='20' colspan='13' align='center' bgcolor='#EEEEEE' class='tablestyle_title'>" +
			"<center>导师上报选题信息表</center></td></tr><tr>"+
			"<td width='10%' height='20' align='center' bgcolor='#EEEEEE'>学工号</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>姓名</td>"+
            "<td width='5%'  align='center' bgcolor='#EEEEEE'>性别</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>学院</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>系别</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题操作</td></tr>";
			for(var j = 0;j < subjectInfos.length;j++){
					//获取性别状态并进行转换
					var sex = displaySex(subjectInfos[j].sex);
					//var subTerm = subjectInfos[j].subTerm.split("-");
					var temp = "<tr align='center'>"+
				    "<td width='10%' height='20' align='center' bgcolor='#FFFFFF'><a href='./tutor/queryTutor?tutorNo="+subjectInfos[j].tutorNo+"'" +
				    "target='mainFrame'>"+subjectInfos[j].tutorNo+"</a></td>"+
				    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].tutorName+"</td>" +
				    "<td width='5%' align='center' bgcolor='#FFFFFF'>"+sex+"</td>" +
				    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].college+"</td>"+
				    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].major+"</td>"+
				    "<td width='10%' height='20' align='center' bgcolor='#FFFFFF'>"+
	                "<input type='button' name='revoke' value='查看所有选题' onclick='verifyInfo()'/>" 
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
