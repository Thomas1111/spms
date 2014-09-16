
select * from stu_basic_info sb where sb.tutorNo = '1231'; 
##学生登录信息
insert into stu_info values('20111826','123456',1);
insert into stu_info values('20111827','123456',1);
insert into stu_info values('20111828','123456',1);
insert into stu_info values('20111829','123456',1);
insert into stu_info values('20111830','123456',1);
insert into stu_info values('20111831','123456',1);
insert into stu_info values('20111832','123456',1);
insert into stu_info values('20111833','123456',1);
insert into stu_info values('20111834','123456',1);
insert into stu_info values('20111835','123456',1);
insert into stu_info values('20111836','123456',1);
insert into stu_info values('20111837','123456',1);
insert into stu_info values('20111838','123456',1);
##导师登录信息
insert into tutor_info values('1231','123456',1);
insert into tutor_info values('1232','123456',1);
insert into tutor_info values('1233','123456',1);
insert into tutor_info values('1234','123456',1);
insert into tutor_info values('1235','123456',1);
insert into tutor_info values('1236','123456',1);
##管理员登录信息
insert into admin_info values('0791','123456',1);
insert into admin_info values('0792','123456',1);
##导师基本信息
update tutor_basic_info set tutorState = 1;
insert into tutor_basic_info values ('1231','彭莹琼',1,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1232','李佳航',1,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1233','易文龙',0,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1234','苏波',0,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1235','李文奇',0,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1236','欧阳文臣',9,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1237','彭莹琼',1,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1238','李佳航',1,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1239','易文龙',0,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1210','苏波',0,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1211','李文奇',0,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
insert into tutor_basic_info values ('1212','欧阳文臣',9,'汉族','江西萍乡','软件学院','软件工程','中国党员','副教授','硕士','分布式与大数据','18076278908','3543253245@qq.com','3543253245','无',1,'0791');
##管理员基本信息
insert into admin_basic_info values('0791','王映龙',1,'汉族','软件学院','院长','教授','博士','18076890956','324234390@qq.com','无');
insert into admin_basic_info values('0792','杨文军',1,'汉族','软件学院','院长','教授','博士','18076890956','324234390@qq.com','无');
##答辩小组信息
insert into group_info values(null,'第一小组','彭莹琼','徐呈康','18070256724','一教阶二','2014-2015','0791');
insert into group_info values(null,'第二小组','易文龙','潘建涛','18070256724','一教阶三','2014-2015','0791');
##学生基本信息 

insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111826','赖辉强','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',1,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111827','徐建文','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',1,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111828','聂松','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',1,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111829','吴文龙','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',1,'2013-2014');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111830','陈燕','软件工程1111','英语方向','软件学院',1,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111831','徐芳','软件工程1111','英语方向','软件学院',1,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111832','吴志勇','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111833','王伟','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111834','张超','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111835','彭博','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111836','魏浩源','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111837','龚靖淇','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
insert into stu_basic_info(studentNo,studentName,className,major,college,sex,telephone,email,remarks,tutorNo,groupNo,stuTerm) values
('20111838','聂松','软件工程1111','英语方向','软件学院',0,'18070514244','346423152@qq.com','无','1231',2,'2014-2015');
update stu_basic_info set stuState = 1; 
##学院信息
insert into dep_info values('1105','中科软件学院','软件学院','自2003建院，有着大批优秀毕业生',1);
##专业信息	
insert into major_info(majorNo,major,departNo) values('11050101','网络应用方向','1105');
insert into major_info(majorNo,major,departNo) values('11050102','商务与政务应用方向','1105');
insert into major_info(majorNo,major,departNo) values('11050103','数字媒体技术方向','1105');
insert into major_info(majorNo,major,departNo) values('11050104','嵌入式系统方向','1105');
insert into major_info(majorNo,major,departNo) values('11050105','专升本','1105');
insert into major_info(majorNo,major,departNo) values('11050100','应用软件开发方向','1105');
insert into major_info(majorNo,major,departNo) values('11050400','英语方向','1105');
##班级信息
insert into class_info(classNo,className,classBreif,majorNo,classState) values('21050100200903','1102','软件0903','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100200903','软件工程0903','软件0903','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100200904','软件工程0904','软件0904','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100200905','软件工程0905','软件0905','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100200906','软件工程0906','软件0906','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100200907','软件工程0907','软件0907','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201001','软件工程1001','软件1001','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201002','软件工程1002','软件1002','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201003','软件工程1003','软件1003','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201004','软件工程1004','软件1004','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201005','软件工程1005','软件1005','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201101','软件工程1101','软件1101','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201102','软件工程1102','软件1102','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201103','软件工程1103','软件1103','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201104','软件工程1104','软件1104','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201201','软件工程1201','软件1201','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201202','软件工程1202','软件1202','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201203','软件工程1203','软件1203','11050100',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050100201204','软件工程1204','软件1204','11050100',1);
##英语方向
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201012','软件工程1012','软件1012','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201013','软件工程1013','软件1013','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201014','软件工程1014','软件1014','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201111','软件工程1111','软件1111','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201112','软件工程1112','软件1112','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201113','软件工程1113','软件1113','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201114','软件工程1114','软件1114','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201115','软件工程1115','软件1115','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201211','软件工程1211','软件1211','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201212','软件工程1212','软件1212','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201213','软件工程1213','软件1213','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201214','软件工程1214','软件1214','11050400',1);
insert into class_info(classNo,className,classBreif,majorNo,classState) values('11050101201215','软件工程1215','软件1215','11050400',1);
##选题信息
select * from subject_info;
insert into subject_info values(null,'2014-2015','基于B/S架构的飞机航班订票系统的设计与开发','省部级以上','一教阶二','理论研究','校内','必须按规定时间提交','2014-12-04 12:00:00',1,1,1,1,'格式不正确','20111826','1231');
insert into subject_info values(null,'2014-2015','基于B/S架构的毕业设计系统的设计与开发','省部级以上','一教阶二','理论研究','校内','无','2014-12-04 12:00:00',1,1,1,1,'格式不正确','20111827','1231');
insert into subject_info values(null,'2014-2015','基于B/S架构的网上餐厅系统的设计与开发','省部级以上','一教阶二','理论研究','校内','无','2014-12-04 12:00:00',1,1,1,1,'格式不正确','20111828','1231');

##任务信息
insert into task_info values(null,1,'无','无','无','无','无');
insert into task_info values(null,2,'无','无','无','无','无');
insert into task_info values(null,3,'无','无','无','无','无');
##公告信息
insert into notice_info values(null,'0791','2014-08-07','2014届本科生毕业设计（论文）及实习管理制度汇编','4123123124');
##答辩资格信息
insert into qualification_info values(null,0,0,0,10000,0,0,0,0,4,'该生学生态度认真',95,'2014-2015','20111826','1231',0);
insert into qualification_info values(null,0,0,0,10000,0,0,0,0,4,'该生学生态度认真',95,'2014-2015','20111827','1231',0);
insert into qualification_info values(null,0,0,0,10000,0,0,0,0,4,'该生学生态度认真',95,'2014-2015','20111828','1231',0);
insert into qualification_info values(null,0,0,0,10000,0,0,0,0,4,'该生学生态度认真',95,'2014-2015','20111829','1231',0);
##答辩资格审核信息表
insert into qua_verify_info values(1,'0791','2014-08-19 12:00:00',0,'无');
insert into qua_verify_info values(2,'0791','2014-08-19 12:00:00',0,'无');
insert into qua_verify_info values(3,'0791','2014-08-19 12:00:00',0,'无');
insert into qua_verify_info values(4,'0791','2014-08-19 12:00:00',0,'无');
##阶段任务信息表
select * from phase_mission_info;
insert into phase_mission_info values(null,'1231','需求分析','2014-08-19 12:00:00','2014-08-31 12:00:00','完成系统的需求分析任务','2014-2015');
insert into phase_mission_info values(null,'1231','总体设计','2014-09-01 12:00:00','2014-09-9 12:00:00','完成系统的总体设计任务','2014-2015');
##学生阶段信息任务
insert into stu_mission_info values(1,'20111826','2014-08-18 12:00:00',0,'无');
insert into stu_mission_info values(1,'20111827','2014-08-18 12:00:00',0,'无');
insert into stu_mission_info values(2,'20111826','2014-09-08 12:00:00',0,'无');
insert into stu_mission_info values(2,'20111827','2014-09-08 12:00:00',0,'无');
##开题报告
insert into report_info values(null,'20111826','1231','2014-08-15 12:00:00',2,'无','2014-2015','231232131233');
insert into report_info values(null,'20111827','1231','2014-08-15 12:00:00',2,'无','2014-2015','123123213123');
insert into report_info values(null,'20111828','1231','2014-08-15 12:00:00',2,'无','2014-2015','131231231231');
insert into report_info values(null,'20111829','1231','2014-08-15 12:00:00',2,'无','2014-2015','1231231231241');
##论文信息
insert into paper_info values(null,'20111826','1231','2014-08-15 12:00:00',0,'无','2014-2015');
insert into paper_info values(null,'20111827','1231','2014-08-15 12:00:00',0,'无','2014-2015');
insert into paper_info values(null,'20111828','1231','2014-08-15 12:00:00',0,'无','2014-2015');
insert into paper_info values(null,'20111829','1231','2014-08-15 12:00:00',0,'无','2014-2015');
##文档信息
insert into document_info values(null,'1231','2014-08-15 12:00:00','B/S结构下论文结构','开题报告类','123123123123');
insert into document_info values(null,'1231','2014-08-15 12:00:00','B/S结构下论文结构','毕设文档类','123123123123');
##学生下载资料
insert into stu_down_info values(null,1,'20111826','无');
insert into stu_down_info values(null,1,'20111827','无');
insert into stu_down_info values(null,1,'20111828','无');
insert into stu_down_info values(null,1,'20111829','无');

insert into stu_down_info values(null,2,'20111830','无');
insert into stu_down_info values(null,2,'20111831','无');
insert into stu_down_info values(null,2,'20111832','无');
insert into stu_down_info values(null,2,'20111833','无');
##学期信息
insert into term_info values (null,'2013-2014');
insert into term_info values (null,'2014-2015');

