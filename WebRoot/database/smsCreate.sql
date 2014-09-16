
drop database spms;
create database spms;
use spms;

/*学生登录信息1*/
create table stu_info
(
	studentNo char(8) primary key,
	studentPass varchar(12) not null,
	stuState tinyint not null default 1
);
/*导师登录信息2*/
create table tutor_info
(
	tutorNo char(4) primary key,
	tutorPass varchar(12) not null,
	tutorState tinyint not null default 1
);
/*管理员登录信息3*/
create table admin_info
(
	adminNo char(8) not null primary key,
	adminPass varchar(12) not null,
	adminState tinyint not null default 1
);
/*导师基本信息表5*/
create table tutor_basic_info(
	tutorNo char(4) primary key,
	tutorName varchar(18) not null,  								
	sex tinyint not null default 1, 														
	nation varchar(30) default '汉族',										
	hometown varchar(84),
	college varchar(30) not null,	
	major varchar(30) not null,								
	political varchar(24) default '不详',	 
	tutorTitle varchar(30) default '不详',  
	eduBackground varchar(30) not null,  
	direction  varchar(90), 
	telephone char(11),
	email varchar(50), 
	qq varchar(25),                            							 										
	remarks varchar(150),
	tutorState tinyint not null default 1,
	adminNo char(4),
	constraint fk_tutor_adminNo foreign key(adminNo) references admin_info(adminNo)						
);

/*管理员基本信息表6*/
create table admin_basic_info(
	adminNo char(4) primary key,
	adminName varchar(18) not null,  								
	sex tinyint not null default 1, 														
	nation varchar(30) default '汉族',										
	college varchar(30) not null,
	rank varchar(24) not null,		
	adminTitle varchar(30) not null,
	eduBackground varchar(30) not null, 							 
	telephone char(11),
	email varchar(50),                           							 										
	remarks varchar(150),
	constraint fk_adminNo foreign key(adminNo) references admin_info(adminNo)						
);
/*答辩小组信息表10*/
 create table group_info(
      groupNo  int auto_increment primary key,
      groupName varchar(60) not null,
      groupLeader varchar(30) not null,
      groSecretary varchar(30) not null,
      telephone	varchar(11) not null,
	  papLocation varchar(30) not null,
      groupTerm varchar(12) not null,
      adminNo char(4),
      constraint fk_group_adminNo foreign key (adminNo) references admin_basic_info(adminNo)
      on delete no action on update cascade
 );
/*学生基本信息表4*/
create table stu_basic_info
(
	studentNo char(8) primary key,
	studentName varchar(18) not null,
	className varchar(30) not null,
	major varchar(30) not null,
	college varchar(30) not null,
	sex int default 0,
	telephone char(11),
	email varchar(50),
	remarks varchar(150) default '',
	stuState int default 1,
	tutorNo char(4),
	groupNo int,
	stuTerm varchar(30) not null,
	constraint fk_studentNo foreign key (studentNo) references stu_info(studentNo),
	constraint fk_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo),
	constraint fk_groupNo foreign key (groupNo) references group_info(groupNo)
);

alter table stu_basic_info add index stuBasicInfoMajor(major);
alter table stu_basic_info add index stuBasicInfoCollege(college);
alter table stu_basic_info add index stuBasicInfoClass(className);

/*部门学院表7*/
 create table dep_info(
 	departNo char(4) primary key,
 	departName varchar(36),
 	departBrief varchar(27),
 	departInfo  varchar(90),
 	depState tinyint not null default 1
 )engine=innodb;

 /*创建 专业信息表 departNo外键关联部门表8*/
 create table major_info(
      majorNo char(8) primary key,
      major     varchar(60),
      majorShort  varchar(45),
      departNo char(4),
      majorInfo varchar(150),
      majorState tinyint not null default 1,
      constraint fk_departNo foreign key (departNo) references dep_info(departNo) on delete no action on update  cascade
 )engine = innodb;
 
alter table major_info add index majorFkIndex(departNo);

/*创建班级信息表,majorNo外键需要关联专业9*/
 create table class_info(
      classNo  char(14) primary key,
      className varchar(45),
      classBreif varchar(30),
      majorNo char(8),
      classState tinyint default 1,
      constraint fk_majorNo foreign key (majorNo) references major_info(majorNo)
      on delete no action on update cascade
 ) ENGINE=innodb; 
 alter table class_info add index classFkIndex(majorNo);
 
/*选题信息表11(修改)*/
create table subject_info(
	subjectNo int auto_increment primary key,
	subTerm	varchar(30) not null,
	subName	varchar(90) not null,
	subSource varchar(18) not null,
	papLocation	varchar(18) not null,
	subType	varchar(24) not null,
	subPosition	char(6) not null,
	subBrief text not null,
	applyTime date not null,
	applyNum tinyint not null default 1,
	leftNum tinyint not null default 1,
	exameState tinyint not null default 0,
	stuExaState tinyint not null default 0,
	memo varchar(90),
	studentNo char(8),
	tutorNo	char(4),
	constraint fk_subject_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo),
	constraint fk_subject_studentNo foreign key (studentNo) references stu_basic_info(studentNo)
);
/*任务信息表12*/
create table task_info(
	taskNo int auto_increment primary key,
	subjectNo int,
	content	text not null,
	diagram	text not null,
	indicator text not null,
	schedule text not null,
	reference text not null,
	constraint fk_task_subjectNo foreign key (subjectNo) references subject_info(subjectNo)
);

/*公告信息表13*/
create table notice_info(
	noticeNo int auto_increment primary key,
	adminNo	char(4),
	uploadTime date not null,
	noticeName char(90),
	identifier varchar(30) not null,
	constraint fk_notice_adminNo foreign key (adminNo) references admin_basic_info(adminNo)
);
/*答辩资格信息表14*/
create table qualification_info(
	quaNo int auto_increment primary key,
	mission tinyint not null,
	report tinyint not null,
	body tinyint not null,
	bodywords int not null,
	abstraction tinyint not null,
	transInfo	tinyint not null,
	checking tinyint not null,
	absence tinyint not null,
	absenceDay int not null,
	remarks text not null,
	score tinyint not null,
	quaTerm varchar(30) not null,
	studentNo char(8),
	tutorNo Char(4),
	exameState tinyint default 0,
	constraint fk_qualification_studentNo foreign key (studentNo) references stu_basic_info(studentNo),
	constraint fk_qualification_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo)
);
/*答辩资格审核信息表15*/
create table qua_verify_info(
	quaNo int,
	adminNo char(4),
	time datetime not null,
	exameState tinyint default 0,
	memo varchar(90),
	primary key(quaNo,adminNo),
	constraint fk_qua_verify_adminNo foreign key (adminNo) references admin_basic_info(adminNo),
	constraint fk_qua_verify_quaNo foreign key (quaNo) references qualification_info(quaNo)
);
/*阶段任务信息表16*/
create table phase_mission_info(
	missionNo int auto_increment primary key,
	tutorNo char(4),
	misName	varchar(90) not null,
	startTime datetime not null,
	endTime datetime not null,
	misBrief text,
	phaseTerm varchar(30) not null,
	constraint fk_phase_mission_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo)
);

/*学生阶段任务信息表17*/
create table stu_mission_info(
	missionNo int auto_increment,
	studentNo char(8),
	uploadTime datetime not null,
	exameState tinyint default 0,
	memo varchar(90),
	primary key(missionNo,studentNo),
	constraint fk_phase_mission_MissionNo foreign key (missionNo) references phase_mission_info(missionNo),
	constraint fk_phase_mission_studentNo foreign key (studentNo) references stu_basic_info(studentNo)
);

/*阶段任务信息表18*/
create table report_info(
	reportNo int auto_increment primary key,
	studentNo char(8),
	tutorNo char(4),
	uploadTime datetime not null,
	exameState tinyint default 0,
	memo varchar(90),
	reportTerm varchar(30) not null,
	reportName varchar(30),
	constraint fk_report_studentNo foreign key (studentNo) references stu_basic_info(studentNo),
	constraint fk_report_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo)
);

/*论文信息表19*/
create table paper_info(
	paperNo int auto_increment primary key,
	studentNo char(8),
	tutorNo char(4),
	uploadTime datetime not null,
	exameState tinyint default 0,
	memo varchar(90),
	paperTerm varchar(30) not null,
	constraint fk_paper_studentNo foreign key (studentNo) references stu_basic_info(studentNo),
	constraint fk_paper_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo)
);

/*阶段任务信息表20*/

create table document_info(
	docNo int auto_increment primary key,
	tutorNo char(4),
	uploadTime datetime not null,
	docName	varchar(90),
	docType	varchar(30),
	identifier varchar(30) not null,
	constraint fk_document_tutorNo foreign key (tutorNo) references tutor_basic_info(tutorNo)
);

/*阶段任务信息表21*/
create table stu_down_info(
	downNo int auto_increment primary key,
	docNo int,
	studentNo char(8),
	memo varchar(90),
	constraint fk_stu_down_docNo foreign key (docNo) references document_info(docNo),
	constraint fk_stu_down_studentNo foreign key (studentNo) references stu_basic_info(studentNo)
);
/*学期表*/
create table term_info(
	termNo int auto_increment primary key,
	term varchar(10) not null
);