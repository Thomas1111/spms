
//创建审核导师上报选题表
function createTutSubTab(term,url){
	$.get(url+"type=asyc"+"&term="+term,function(data){
		var message = data.message;
		var number = 1;
		var subjectInfos = data.tutorSubInfos;
		alert(subjectInfos);
		if(message == "加载成功"){
			var subject = document.getElementById("subjectInfo");
			var subInfoHtml = "<tr>"+
			"<td width='10%' height='20' align='center' bgcolor='#EEEEEE'>学工号</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>姓名</td>"+
            "<td width='5%'  align='center' bgcolor='#EEEEEE'>性别</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>学院</td>"+
            "<td width='15%' align='center' bgcolor='#EEEEEE'>系别</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题数量</td>"+
            "<td width='10%' align='center' bgcolor='#EEEEEE'>选题操作</td>";
			for(var j = 0;j < subjectInfos.length-1;j++){
				if(subjectInfos[j].subjectNo != subjectInfos[j+1].subjectNo){
					//获取审核状态并进行转换
					var exameState = displayExamState(subjectInfos[j].stuExaState);
					var subTerm = subjectInfos[j].subTerm.split("-");
					var temp = "<tr align='center'>"+
				    "<td width='10%' height='20' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].tutorNo+"</td>"+
				    "<td width='10%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].tutorName+"</td>" +
				    "<td width='5%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].sex+"</td>" +
				    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].college+"</td>"+
				    "<td width='15%' align='center' bgcolor='#FFFFFF'>"+subjectInfos[j].major+"</td>"+
				    "<td width='10%' height='20' align='center' bgcolor='#FFFFFF'>"+number+"</td>"+
				    "<td width='10%' height='20' align='center' bgcolor='#FFFFFF'>"+
	                "<input type='button' name='revoke' value='查看所有选题' onclick='verifyInfo(3,"+subjectInfos[j].studentNo+","+subTerm+")'/>" 
	                +"</td>"
	                +"</tr>";
					number = 1;
				}else{
					number++;
				}
				subInfoHtml = subInfoHtml + temp;
			}
			subject.innerHTML = subInfoHtml;
			setPageInfo(data.pageVo);	//设置分页属性
		}else{
			alert(message);
		}
	});
}