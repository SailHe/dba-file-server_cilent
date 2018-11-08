/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jiaowu_schema

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-08 17:46:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CId` char(4) NOT NULL,
  `PCId` char(4) DEFAULT NULL,
  `DId` char(2) DEFAULT NULL,
  `CName` char(20) NOT NULL,
  `CCredit` int(11) NOT NULL,
  `CHour` int(11) NOT NULL,
  `CAttr` char(6) NOT NULL,
  `CNum` int(11) NOT NULL,
  PRIMARY KEY (`CId`),
  KEY `FK_Course_Course` (`PCId`),
  KEY `FK_Course_Dept` (`DId`),
  CONSTRAINT `FK_Course_Course` FOREIGN KEY (`PCId`) REFERENCES `course` (`CId`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_Course_Dept` FOREIGN KEY (`DId`) REFERENCES `dept` (`DId`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '5', 'CS', '数据库', '4', '72', '必修', '50');
INSERT INTO `course` VALUES ('10', '9', 'EM', '统计与审计', '5', '90', '必修', '90');
INSERT INTO `course` VALUES ('100', null, 'IT', 'DB', '4', '64', 'bx', '90');
INSERT INTO `course` VALUES ('11', null, 'EL', '刺绣', '1', '18', '选修', '50');
INSERT INTO `course` VALUES ('12', null, 'EL', '家庭保健', '1', '18', '选修', '30');
INSERT INTO `course` VALUES ('2', null, 'SD', '数学', '3', '54', '必修', '90');
INSERT INTO `course` VALUES ('200', null, 'IT', 'DBMS', '5', '40', 'b', '40');
INSERT INTO `course` VALUES ('3', '1', 'CS', '信息系统与数据库', '3', '54', '必修', '50');
INSERT INTO `course` VALUES ('4', '6', 'CS', '操作系统', '4', '72', '必修', '50');
INSERT INTO `course` VALUES ('5', '7', 'CS', '数据结构', '5', '90', '必修', '50');
INSERT INTO `course` VALUES ('6', null, 'CS', '计算机基础', '3', '54', '必修', '70');
INSERT INTO `course` VALUES ('7', '6', 'CS', 'C语言', '2', '36', '必修', '70');
INSERT INTO `course` VALUES ('8', null, 'CS', '计算机组成原理', '3', '54', '选修', '120');
INSERT INTO `course` VALUES ('9', '2', 'EM', '会计学原理', '5', '90', '必修', '90');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `DId` char(2) NOT NULL,
  `DName` varchar(20) NOT NULL,
  `DAddr` varchar(20) DEFAULT NULL,
  `DTele` varchar(16) DEFAULT NULL,
  `DEmail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('CS', '计算机科学与技术系', 'SL604', '87678976', 'cs@nit.com');
INSERT INTO `dept` VALUES ('EL', '外校', null, '62765678', null);
INSERT INTO `dept` VALUES ('EM', '经济管理系', 'SC302', '87464789', 'em@nit.com');
INSERT INTO `dept` VALUES ('FD', '外语分院', 'SA401', '65656798', 'fd@nit.com');
INSERT INTO `dept` VALUES ('IT', '信息科学与技术系', 'SL704', '88767864', 'it@nit.com');
INSERT INTO `dept` VALUES ('SD', '理学院', 'NB309', '67536387', 'sd@nit.com');

-- ----------------------------
-- Table structure for exercise
-- ----------------------------
DROP TABLE IF EXISTS `exercise`;
CREATE TABLE `exercise` (
  `EId` int(11) NOT NULL,
  `EContext` varchar(255) DEFAULT NULL,
  `ELevel` int(11) DEFAULT NULL,
  `EAnswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercise
-- ----------------------------
INSERT INTO `exercise` VALUES ('1', '显示院系信息表中的所有信息', '1', '');
INSERT INTO `exercise` VALUES ('2', '显示院系信息表中的部门编码、部门名称信息', '1', '');
INSERT INTO `exercise` VALUES ('3', '显示所有女教师的工号、姓名、性别信息', '1', '');
INSERT INTO `exercise` VALUES ('4', '显示CS系的老师所有个人信息', '1', '');
INSERT INTO `exercise` VALUES ('5', '显示CS系与IT系所有老师的全部个人信息', '1', '');
INSERT INTO `exercise` VALUES ('6', '显示女教授的姓名、性别、职称与部门编号信息', '1', '');
INSERT INTO `exercise` VALUES ('7', '显示研究领域为数据库的老师的姓名、研究领域、联系电话、所在部门', '1', '');
INSERT INTO `exercise` VALUES ('8', '显示30岁以下老师的姓名、出生日期', '1', '');
INSERT INTO `exercise` VALUES ('9', '显示5月份出生的姓名、性别、出生日期、联系电话', '1', '');
INSERT INTO `exercise` VALUES ('10', '显示姓李的老师的所有信息', '1', '');
INSERT INTO `exercise` VALUES ('11', '显示选修了1号课程的同学的学号', '1', '');
INSERT INTO `exercise` VALUES ('12', '显示同时选修了1号与3号课程的同学的学号', '2', '');
INSERT INTO `exercise` VALUES ('13', '显示012005002号同学选修的课程号', '1', '');
INSERT INTO `exercise` VALUES ('14', '显示012005002号同学的全部选修信息', '1', '');
INSERT INTO `exercise` VALUES ('15', '显示期末考试成绩不及格的同学的学号、课程号与期末考试成绩', '1', '');
INSERT INTO `exercise` VALUES ('16', '显示选修了1号课程的人数', '1', '');
INSERT INTO `exercise` VALUES ('17', '显示1号课程期末考试成绩的平均分', '1', '');
INSERT INTO `exercise` VALUES ('18', '显示012005002同学的期末成绩的平均分', '1', '');
INSERT INTO `exercise` VALUES ('19', '显示2008年所有课程期末成绩的平均分，显示课程号与平均分，并按降序排列', '1', '');
INSERT INTO `exercise` VALUES ('20', '显示周4有课的教室', '1', '');
INSERT INTO `exercise` VALUES ('21', '显示周4有课的老师的工号', '1', '');
INSERT INTO `exercise` VALUES ('22', '显示NB222教室排课的情况', '1', '');
INSERT INTO `exercise` VALUES ('23', '显示1号课程上课的教室、老师工号、上课时间', '1', '');
INSERT INTO `exercise` VALUES ('24', '显示02004号老师上课的教室与时间', '1', '');
INSERT INTO `exercise` VALUES ('25', '显示第4节有课的教室、课程号、教师工号', '1', '');
INSERT INTO `exercise` VALUES ('26', '统计每个教师每周上课的次数及总时长(每节课45分钟)', '1', '');
INSERT INTO `exercise` VALUES ('27', '统计每个班每周上课的课时数，显示班级编号和课时数，并按降序排列', '1', '');
INSERT INTO `exercise` VALUES ('28', '显示无前导课的课程的全部信息', '1', '');
INSERT INTO `exercise` VALUES ('29', '显示CS系所开课程的课程号与课程名', '1', '');
INSERT INTO `exercise` VALUES ('30', '显示学分大于3的所有课程的课程名与课时', '1', '');
INSERT INTO `exercise` VALUES ('31', '按开课院系统计每个院系开课的学分数，显示院系编号和总学分，并按降序排列', '1', '');
INSERT INTO `exercise` VALUES ('32', '显示学生中所有男生的全部信息', '1', '');
INSERT INTO `exercise` VALUES ('33', '显示01班所有学生的信息', '1', '');
INSERT INTO `exercise` VALUES ('34', '显示03班所有女生的信息', '1', '');
INSERT INTO `exercise` VALUES ('35', '显示刘山同学的电话号码', '1', '');
INSERT INTO `exercise` VALUES ('36', '显示所有女生的学号、姓名与班级编号', '1', '');
INSERT INTO `exercise` VALUES ('37', '统计每个班级的人数，显示班级编号，人数，并按降序排列', '1', '');
INSERT INTO `exercise` VALUES ('38', '显示人数5人以上班级的班级编号和人数，并按升序排列', '1', '');
INSERT INTO `exercise` VALUES ('39', '显示年龄在18岁以下的学生的全部信息', '1', '');
INSERT INTO `exercise` VALUES ('40', '统计18岁以下学生的总人数', '1', '');
INSERT INTO `exercise` VALUES ('41', '统计每个班18岁以下的人数，显示班级编号、人数', '2', '');
INSERT INTO `exercise` VALUES ('42', '统计每个年龄段的人数，按照年龄升序排列', '2', '');
INSERT INTO `exercise` VALUES ('43', '显示姓名中有\"白云\"的同学的所有信息', '1', '');
INSERT INTO `exercise` VALUES ('44', '显示白姓同学的姓名、性别、班级名称、联系电话', '2', '');
INSERT INTO `exercise` VALUES ('45', '显示CS系的班级名称及入学年份', '1', '');
INSERT INTO `exercise` VALUES ('46', '显示没有班导的班级的所有信息', '1', '');
INSERT INTO `exercise` VALUES ('47', '显示2008年入学班级的所有信息', '1', '');
INSERT INTO `exercise` VALUES ('48', '显示所有学生的详细信息，包括学号、姓名、性别、年龄、班级名称，入学年份', '2', '');
INSERT INTO `exercise` VALUES ('49', '显示信息科学与技术系同学的名单，包括学号、姓名、性别、年龄、班级名称、入学年份', '2', '');
INSERT INTO `exercise` VALUES ('50', '显示选修了\"数据库\"的所有同学的学号、姓名', '2', '');
INSERT INTO `exercise` VALUES ('51', '显示白云同学的班主任老师的姓名、联系电话', '2', '');
INSERT INTO `exercise` VALUES ('52', '显示白云同学所在院系的名称、办公地点与联系电话', '2', '');
INSERT INTO `exercise` VALUES ('53', '统计计算机科学与技术系每个同学已经修完的学分，显示学号、姓名、学分总数', '2', '');
INSERT INTO `exercise` VALUES ('54', '显示张飞同学已修课程的课程号，课程名及期末成绩', '2', '');
INSERT INTO `exercise` VALUES ('55', '显示计算机科学与技术系、信息科学与技术系的班级名称、入学年份、班导名称与联系电话', '2', '');
INSERT INTO `exercise` VALUES ('56', '显示2008年入学的同学的学号、姓名、班级名称', '2', '');
INSERT INTO `exercise` VALUES ('57', '显示已修数据库的同学的学号、姓名及期末成绩', '2', '');
INSERT INTO `exercise` VALUES ('58', '显示期末平均成绩75分以上的课程名称与期末平均成绩', '2', '');
INSERT INTO `exercise` VALUES ('59', '显示期末平均成绩80分以上同学的学号、姓名与期末平均成绩', '2', '');
INSERT INTO `exercise` VALUES ('60', '显示一周课时数为5节及以上的教师的姓名与研究领域', '2', '');
INSERT INTO `exercise` VALUES ('61', '按照班级统计期末平均成绩，显示班级名称与平均成绩', '2', '');
INSERT INTO `exercise` VALUES ('62', '按照学期统计计算机科学与技术系学生的期末平均成绩，显示学期名称与平均成绩', '2', '');
INSERT INTO `exercise` VALUES ('63', '统计每个院系一周的课时数，显示院系名称与课时数', '2', '');
INSERT INTO `exercise` VALUES ('64', '显示没有选修任何课程的学生学号、姓名、班级名称', '2', '');
INSERT INTO `exercise` VALUES ('65', '显示上过李飞老师的课的学生的学号、姓名与联系电话', '3', '');
INSERT INTO `exercise` VALUES ('66', '显示一周6节课及以上的课程名称、学分', '2', '');
INSERT INTO `exercise` VALUES ('67', '显示一周6节课及以上班级名称', '2', '');
INSERT INTO `exercise` VALUES ('68', '查询周四上午第3节有课的同学的学号、姓名与班级名称', '3', '');
INSERT INTO `exercise` VALUES ('69', '显示期末成绩没有不及格课程的班级的名称', '3', '');
INSERT INTO `exercise` VALUES ('70', '显示已修数据库的同学信息，包括学号、姓名、班级名称', '3', '');
INSERT INTO `exercise` VALUES ('71', '显示平时成绩不及格1门以上的同学学号、姓名、门数', '3', '');
INSERT INTO `exercise` VALUES ('72', '统计每个班级期末成绩的最高分，显示班级名称、期末最高成绩', '2', '');
INSERT INTO `exercise` VALUES ('73', '显示一周8节课及以上的学生的名单，显示学号、姓名、班级名称', '3', '');
INSERT INTO `exercise` VALUES ('74', '显示计算机科学与技术1班一周上课的时间、地点，课程名称(周几，哪几节课，哪个教室)', '3', '');
INSERT INTO `exercise` VALUES ('75', '统计教授每周上课的课时数，显示姓名、课时数', '3', '');
INSERT INTO `exercise` VALUES ('76', '显示没有班导师的班级名称、院系名称', '2', '');
INSERT INTO `exercise` VALUES ('77', '显示指导过两个班级以上的班导的姓名、所指导的班级名称', '2', '');
INSERT INTO `exercise` VALUES ('78', '为洪玉飞老师(教师编号：03012)安排软件工程1班(班级编号：04)的数据库课程(课程编号：1)，上课教师为NB201', '1', '');
INSERT INTO `exercise` VALUES ('79', '计算机科学与技术3班所有学生都选修了2009-2010-1的操作系统(课程编号为4)，请记录相关信息', '1', '');
INSERT INTO `exercise` VALUES ('80', '理学院新开一门课程“数学建模”，课程编号20, 学分4，学时72，选修课程，最多选课人数为50', '1', '');
INSERT INTO `exercise` VALUES ('81', '将李飞同学的联系方式改为660101', '1', '');
INSERT INTO `exercise` VALUES ('82', '计算所有学生的总评成绩，公式为：总评=平时*20%+实验*20%+期末*60%', '1', '');
INSERT INTO `exercise` VALUES ('83', '将电子信息1班(班级编号：08)的班主任改为洪玉飞老师(无重名)', '1', '');
INSERT INTO `exercise` VALUES ('84', '将课程\"数据库\"的上课教室改为NB111，授课教师改为李飞(教师编号：02001)', '1', '');
INSERT INTO `exercise` VALUES ('85', '将学号为012005001的学生班级改为计算机科学与技术3班', '1', '');
INSERT INTO `exercise` VALUES ('86', '删除所有期末成绩小于60分的选课记录', '1', '');
INSERT INTO `exercise` VALUES ('87', '删除学号为012005001的所有选课记录', '1', '');
INSERT INTO `exercise` VALUES ('88', '删除所有选修了\"数据库\"课程的选课记录', '1', '');
INSERT INTO `exercise` VALUES ('89', '删除李飞老师(教师编号：02001)2008学年的排课记录', '1', '');
INSERT INTO `exercise` VALUES ('90', '删除所有在NB1楼上课的排课记录', '1', '');
INSERT INTO `exercise` VALUES ('91', '删除NB111教室在周四的排课记录', '1', '');
INSERT INTO `exercise` VALUES ('92', '删除选修人数小于5的选课记录', '1', '');
INSERT INTO `exercise` VALUES ('93', '删除未担任班导师并且未安排课程的教师记录', '2', '');
INSERT INTO `exercise` VALUES ('94', '创建一个新的登录，登录名为[alogin]，为登录[alogin]在数据库中创建一个同名数据库用户', '0', '');
INSERT INTO `exercise` VALUES ('95', '授予新建数据库用户对表Student和SC的查询权限', '0', '');
INSERT INTO `exercise` VALUES ('96', '授予新建数据库用户对表Student表Sname列的更新权限', '0', '');
INSERT INTO `exercise` VALUES ('97', '创建一个角色，授予对表Course的查询和更新权限，并将该角色授权给一个新建数据库用户', '0', '');
INSERT INTO `exercise` VALUES ('98', '为Student表增加约束条件，性别字段可能的取值为‘男’，‘女’', '0', '');
INSERT INTO `exercise` VALUES ('99', '为Student表增加约束条件：性别默认为‘男’', '0', '');
INSERT INTO `exercise` VALUES ('100', '为Student表增加约束条件：联系方式至少长度为6', '0', '');
INSERT INTO `exercise` VALUES ('101', '为Student表增加约束条件：出生日期小于当前时间', '0', '');
INSERT INTO `exercise` VALUES ('102', '为Dept表增加约束条件：院系名称必须唯一', '0', '');
INSERT INTO `exercise` VALUES ('103', '为Grade表增加约束条件：入学年份不能大于当前年份', '0', '');
INSERT INTO `exercise` VALUES ('104', '为Dept表增加约束条件：联系电话必须为8位数字', '0', '');
INSERT INTO `exercise` VALUES ('105', '为Information表增加约束条件：学期格式为“xxxx-xxxx-x”，其中xxxx为4位数字表示学年，x为1或者2，表示上下学期。', '0', '');
INSERT INTO `exercise` VALUES ('106', '为SC表增加约束条件：各项成绩都在0-100之间', '0', '');
INSERT INTO `exercise` VALUES ('107', '删除一个已经存在的约束条件，如果没有先建立约束', '0', '');
INSERT INTO `exercise` VALUES ('108', '写一个触发器，使得Course中的记录更新时，课程性质只能为“选修”或者“必修”。否则提醒更新失败', '2', '');
INSERT INTO `exercise` VALUES ('109', '写一个触发器，使得SC表的新增记录满足下述条件： score=score1*20%+score2*60%+score3*20%', '2', '');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `GId` char(2) NOT NULL,
  `DId` char(2) DEFAULT NULL,
  `TId` char(5) DEFAULT NULL,
  `GName` char(20) NOT NULL,
  `GYear` int(11) DEFAULT NULL,
  PRIMARY KEY (`GId`),
  KEY `FK_Grade_Teacher` (`TId`) USING BTREE,
  KEY `FK_Gradet_Dep` (`DId`) USING BTREE,
  CONSTRAINT `FK_FK_Grade_Teacher` FOREIGN KEY (`TId`) REFERENCES `teacher` (`TId`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_FK_Gradet_Dep` FOREIGN KEY (`DId`) REFERENCES `dept` (`DId`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('01', 'CS', '02008', '计算机科学与技术1班', '2006');
INSERT INTO `grade` VALUES ('02', 'CS', '02008', '计算机科学与技术2班', '2006');
INSERT INTO `grade` VALUES ('03', 'CS', '02008', '计算机科学与技术3班', '2006');
INSERT INTO `grade` VALUES ('04', 'CS', '02009', '软件工程1班', '2007');
INSERT INTO `grade` VALUES ('05', 'CS', null, '软件工程2班', '2007');
INSERT INTO `grade` VALUES ('06', 'IT', '03014', '自动化1班', '2008');
INSERT INTO `grade` VALUES ('07', 'IT', '03014', '自动化2班', '2008');
INSERT INTO `grade` VALUES ('08', 'IT', '03012', '电子信息1班', '2008');
INSERT INTO `grade` VALUES ('09', 'IT', null, '电子信息2班', '2008');
INSERT INTO `grade` VALUES ('10', 'IT', null, '电子信息3班', '2008');
INSERT INTO `grade` VALUES ('11', 'EM', '03010', '财务管理', '2006');
INSERT INTO `grade` VALUES ('12', 'EM', '03011', '旅游管理', '2006');
INSERT INTO `grade` VALUES ('13', 'EM', null, '营销管理', '2006');
INSERT INTO `grade` VALUES ('14', 'EM', null, '信息管理', '2006');
INSERT INTO `grade` VALUES ('15', 'FD', '03012', '日语', '2005');
INSERT INTO `grade` VALUES ('16', 'FD', '03013', '德语1班', '2005');
INSERT INTO `grade` VALUES ('17', 'FD', '03013', '德语2班', '2005');
INSERT INTO `grade` VALUES ('18', 'SD', null, '应用数学1班', '2008');
INSERT INTO `grade` VALUES ('20', 'SD', null, '选修混合', null);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `IId` int(11) NOT NULL,
  `CId` char(4) NOT NULL,
  `TId` char(5) NOT NULL,
  `GId` char(2) NOT NULL,
  `IRoom` char(10) DEFAULT NULL,
  `IWeek` int(11) DEFAULT NULL,
  `ITimeseg` char(8) DEFAULT NULL,
  `ITerm` char(12) DEFAULT NULL,
  PRIMARY KEY (`IId`),
  KEY `FK_Information_Course` (`CId`) USING BTREE,
  KEY `FK_Information_Grade` (`GId`) USING BTREE,
  KEY `FK_Information_Teacher` (`TId`) USING BTREE,
  CONSTRAINT `FK_Information_Course` FOREIGN KEY (`CId`) REFERENCES `course` (`CId`),
  CONSTRAINT `FK_Information_Grade` FOREIGN KEY (`GId`) REFERENCES `grade` (`GId`),
  CONSTRAINT `FK_Information_Teacher` FOREIGN KEY (`TId`) REFERENCES `teacher` (`TId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '1', '02001', '01', 'NB111', '4', '123', '2008-2009-1');
INSERT INTO `information` VALUES ('2', '1', '02001', '01', 'NB111', '2', '345', '2008-2009-1');
INSERT INTO `information` VALUES ('3', '2', '02003', '03', 'NB222', '1', '34', '2008-2009-1');
INSERT INTO `information` VALUES ('4', '3', '02004', '01', 'NB223', '5', '678', '2008-2009-1');
INSERT INTO `information` VALUES ('5', '5', '02005', '05', 'NB224', '3', '34', '2008-2009-1');
INSERT INTO `information` VALUES ('6', '6', '02006', '05', 'NB225', '1', '67', '2008-2009-1');
INSERT INTO `information` VALUES ('7', '7', '02007', '03', 'NB226', '4', '89', '2008-2009-1');
INSERT INTO `information` VALUES ('8', '9', '02008', '08', 'NB227', '4', '678', '2008-2009-1');
INSERT INTO `information` VALUES ('9', '11', '02009', '09', 'NB228', '2', 'AB', '2008-2009-1');
INSERT INTO `information` VALUES ('10', '2', '03010', '02', 'NB229', '1', '123', '2008-2009-1');
INSERT INTO `information` VALUES ('11', '4', '02001', '02', 'NB230', '5', '345', '2008-2009-1');
INSERT INTO `information` VALUES ('12', '5', '02002', '03', 'NB231', '3', '123', '2008-2009-1');
INSERT INTO `information` VALUES ('13', '6', '02003', '09', 'NB222', '1', '89', '2008-2009-1');
INSERT INTO `information` VALUES ('14', '7', '02004', '13', 'NB223', '4', '67', '2008-2009-1');
INSERT INTO `information` VALUES ('15', '9', '02005', '15', 'NB224', '4', '345', '2008-2009-1');
INSERT INTO `information` VALUES ('16', '3', '02006', '13', 'NB225', '2', '89', '2008-2009-1');
INSERT INTO `information` VALUES ('17', '4', '02007', '15', 'NB226', '2', '12', '2008-2009-1');
INSERT INTO `information` VALUES ('18', '10', '02008', '03', 'NB227', '5', '123', '2008-2009-1');
INSERT INTO `information` VALUES ('19', '10', '02009', '20', 'NB228', '3', 'AB', '2008-2009-1');
INSERT INTO `information` VALUES ('20', '12', '03010', '20', 'NB229', '1', 'AB', '2008-2009-1');
INSERT INTO `information` VALUES ('21', '4', '02001', '12', 'NB230', '2', '34', '2008-2009-1');
INSERT INTO `information` VALUES ('22', '3', '02002', '09', 'NB231', '4', '345', '2008-2009-1');
INSERT INTO `information` VALUES ('24', '1', '02001', '09', 'NB111', '5', '12', '2008-2009-1');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `SCId` int(11) NOT NULL,
  `CId` char(4) NOT NULL,
  `SId` int(11) NOT NULL,
  `SCTerm` char(12) DEFAULT NULL,
  `SCScore1` float DEFAULT NULL,
  `SCScore2` float DEFAULT NULL,
  `SCScore3` float DEFAULT NULL,
  `SCScore` float DEFAULT NULL,
  PRIMARY KEY (`SCId`),
  KEY `FK_SC_Course` (`CId`) USING BTREE,
  KEY `FK_SC_Student` (`SId`) USING BTREE,
  CONSTRAINT `FK_SC_Course` FOREIGN KEY (`CId`) REFERENCES `course` (`CId`),
  CONSTRAINT `FK_SC_Student` FOREIGN KEY (`SId`) REFERENCES `student` (`SId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('2', '1', '12005002', '2008-2009-1', '72', '89', '87', '0');
INSERT INTO `sc` VALUES ('3', '1', '12005003', '2008-2009-1', '89', '89', '88', '0');
INSERT INTO `sc` VALUES ('4', '1', '12005004', '2008-2009-1', '86', '78', '67', '0');
INSERT INTO `sc` VALUES ('5', '1', '32005005', '2008-2009-1', '80', '65', '87', '0');
INSERT INTO `sc` VALUES ('6', '1', '32005006', '2008-2009-1', '88', '76', '98', '0');
INSERT INTO `sc` VALUES ('7', '1', '32005007', '2008-2009-1', '67', '56', '78', '0');
INSERT INTO `sc` VALUES ('9', '4', '12005002', '2008-2009-1', '36', '78', '86', '0');
INSERT INTO `sc` VALUES ('10', '4', '12005004', '2008-2009-1', '87', '98', '86', '0');
INSERT INTO `sc` VALUES ('11', '4', '32005007', '2008-2009-1', '54', '79', '56', '0');
INSERT INTO `sc` VALUES ('13', '3', '12005002', '2008-2009-2', '78', '48', '87', '0');
INSERT INTO `sc` VALUES ('14', '3', '12005003', '2008-2009-2', '72', '89', '87', '0');
INSERT INTO `sc` VALUES ('15', '3', '12005004', '2008-2009-2', '60', '86', '98', '0');
INSERT INTO `sc` VALUES ('16', '8', '32005005', '2008-2009-2', '60', '80', '76', '0');
INSERT INTO `sc` VALUES ('17', '8', '32005006', '2008-2009-2', '90', '88', '86', '0');
INSERT INTO `sc` VALUES ('18', '8', '32005007', '2008-2009-2', '89', '67', '76', '0');
INSERT INTO `sc` VALUES ('19', '8', '82005008', '2008-2009-2', '93', '65', '86', '0');
INSERT INTO `sc` VALUES ('20', '5', '82005009', '2008-2009-2', '72', '78', '83', '0');
INSERT INTO `sc` VALUES ('21', '5', '92005010', '2008-2009-2', '89', '77', '63', '0');
INSERT INTO `sc` VALUES ('22', '5', '112005011', '2008-2009-2', '86', '90', '74', '0');
INSERT INTO `sc` VALUES ('23', '5', '112005012', '2008-2009-2', '80', '45', '83', '0');
INSERT INTO `sc` VALUES ('24', '5', '112005013', '2008-2009-2', '88', '89', '73', '0');
INSERT INTO `sc` VALUES ('25', '10', '12006001', '2008-2009-2', '67', '67', '73', '0');
INSERT INTO `sc` VALUES ('26', '10', '12006002', '2008-2009-2', '67', '36', '82', '0');
INSERT INTO `sc` VALUES ('27', '10', '12006003', '2008-2009-2', '36', '87', '83', '0');
INSERT INTO `sc` VALUES ('28', '10', '12006004', '2008-2009-2', '87', '54', '73', '0');
INSERT INTO `sc` VALUES ('29', '10', '32006005', '2008-2009-2', '54', '45', '73', '0');
INSERT INTO `sc` VALUES ('30', '10', '32006006', '2008-2009-2', '45', '78', '83', '0');
INSERT INTO `sc` VALUES ('31', '10', '32006007', '2008-2009-2', '78', '72', '84', '0');
INSERT INTO `sc` VALUES ('32', '10', '82006008', '2007-2008-2', '72', '60', '78', '0');
INSERT INTO `sc` VALUES ('33', '12', '82006009', '2007-2008-2', '60', '60', '73', '0');
INSERT INTO `sc` VALUES ('34', '12', '92006010', '2007-2008-2', '60', '90', '83', '0');
INSERT INTO `sc` VALUES ('35', '12', '112006011', '2007-2008-2', '90', '89', '62', '0');
INSERT INTO `sc` VALUES ('36', '12', '112006012', '2007-2008-2', '89', '89', '65', '0');
INSERT INTO `sc` VALUES ('37', '12', '112006013', '2007-2008-2', '93', '78', '65', '0');
INSERT INTO `sc` VALUES ('38', '11', '12007001', '2007-2008-2', '72', '65', '67', '0');
INSERT INTO `sc` VALUES ('39', '11', '12007002', '2007-2008-2', '89', '76', '78', '0');
INSERT INTO `sc` VALUES ('40', '11', '12007003', '2007-2008-2', '86', '56', '79', '0');
INSERT INTO `sc` VALUES ('41', '11', '12007004', '2007-2008-2', '80', '50', '76', '0');
INSERT INTO `sc` VALUES ('42', '11', '32007005', '2007-2008-2', '88', '78', '71', '0');
INSERT INTO `sc` VALUES ('43', '11', '32007006', '2007-2008-2', '67', '98', '81', '0');
INSERT INTO `sc` VALUES ('44', '11', '32007007', '2007-2008-2', '67', '79', '82', '0');
INSERT INTO `sc` VALUES ('45', '9', '82007008', '2007-2008-2', '36', '93', '62', '0');
INSERT INTO `sc` VALUES ('46', '9', '82007009', '2007-2008-2', '87', '72', '63', '0');
INSERT INTO `sc` VALUES ('47', '9', '92007010', '2008-2009-1', '54', '89', '69', '0');
INSERT INTO `sc` VALUES ('48', '9', '112007011', '2008-2009-1', '45', '86', '68', '0');
INSERT INTO `sc` VALUES ('49', '9', '112007012', '2008-2009-1', '78', '80', '76', '0');
INSERT INTO `sc` VALUES ('50', '9', '112007013', '2008-2009-1', '72', '88', '83', '0');
INSERT INTO `sc` VALUES ('52', '9', '12005002', '2008-2009-1', '60', '54', '76', '0');
INSERT INTO `sc` VALUES ('53', '9', '12005003', '2008-2009-1', '90', '78', '76', '0');
INSERT INTO `sc` VALUES ('54', '9', '12005004', '2008-2009-1', '89', '77', '56', '0');
INSERT INTO `sc` VALUES ('55', '2', '32005005', '2008-2009-1', '93', '90', '65', '0');
INSERT INTO `sc` VALUES ('56', '2', '32005006', '2008-2009-1', '72', '45', '65', '0');
INSERT INTO `sc` VALUES ('57', '2', '32005007', '2008-2009-1', '89', '89', '76', '0');
INSERT INTO `sc` VALUES ('58', '2', '82005008', '2008-2009-1', '86', '67', '45', '0');
INSERT INTO `sc` VALUES ('59', '2', '82005009', '2008-2009-1', '80', '36', '84', '0');
INSERT INTO `sc` VALUES ('60', '2', '92005010', '2008-2009-1', '88', '87', '90', '0');
INSERT INTO `sc` VALUES ('61', '2', '112005011', '2008-2009-1', '67', '54', '93', '0');
INSERT INTO `sc` VALUES ('62', '2', '112005012', '2008-2009-1', '67', '45', '67', '0');
INSERT INTO `sc` VALUES ('63', '2', '112005013', '2008-2009-1', '36', '78', '64', '0');
INSERT INTO `sc` VALUES ('64', '2', '12006001', '2008-2009-1', '87', '72', '63', '0');
INSERT INTO `sc` VALUES ('65', '6', '12006002', '2008-2009-1', '54', '60', '48', '0');
INSERT INTO `sc` VALUES ('66', '6', '12006003', '2008-2009-1', '45', '60', '76', '0');
INSERT INTO `sc` VALUES ('67', '6', '12006004', '2008-2009-1', '78', '90', '65', '0');
INSERT INTO `sc` VALUES ('68', '6', '32006005', '2008-2009-1', '72', '89', '76', '0');
INSERT INTO `sc` VALUES ('69', '6', '32006006', '2008-2009-1', '60', '89', '46', '0');
INSERT INTO `sc` VALUES ('70', '6', '32006007', '2008-2009-1', '60', '78', '85', '0');
INSERT INTO `sc` VALUES ('71', '6', '82006008', '2008-2009-1', '90', '65', '65', '0');
INSERT INTO `sc` VALUES ('72', '6', '82006009', '2008-2009-1', '89', '76', '54', '0');
INSERT INTO `sc` VALUES ('73', '6', '92006010', '2007-2008-1', '93', '56', '65', '0');
INSERT INTO `sc` VALUES ('74', '6', '112006011', '2007-2008-1', '72', '50', '65', '0');
INSERT INTO `sc` VALUES ('75', '6', '112006012', '2007-2008-1', '89', '78', '74', '0');
INSERT INTO `sc` VALUES ('76', '6', '112006013', '2007-2008-1', '86', '98', '74', '0');
INSERT INTO `sc` VALUES ('77', '7', '12007001', '2007-2008-1', '80', '79', '83', '0');
INSERT INTO `sc` VALUES ('78', '7', '12007002', '2007-2008-1', '88', '93', '94', '0');
INSERT INTO `sc` VALUES ('79', '7', '12007003', '2007-2008-1', '67', '72', '73', '0');
INSERT INTO `sc` VALUES ('80', '7', '12007004', '2007-2008-1', '67', '89', '83', '0');
INSERT INTO `sc` VALUES ('81', '7', '32007005', '2007-2008-1', '36', '86', '63', '0');
INSERT INTO `sc` VALUES ('82', '7', '32007006', '2007-2008-1', '87', '80', '67', '0');
INSERT INTO `sc` VALUES ('83', '7', '32007007', '2007-2008-1', '54', '88', '84', '0');
INSERT INTO `sc` VALUES ('84', '7', '82007008', '2007-2008-1', '45', '67', '96', '0');
INSERT INTO `sc` VALUES ('85', '7', '82007009', '2007-2008-1', '78', '65', '90', '0');
INSERT INTO `sc` VALUES ('86', '7', '92007010', '2007-2008-1', '72', '78', '92', '0');
INSERT INTO `sc` VALUES ('87', '7', '112007011', '2007-2008-1', '60', '77', '86', '0');
INSERT INTO `sc` VALUES ('88', '7', '112007012', '2007-2008-1', '60', '90', '80', '0');
INSERT INTO `sc` VALUES ('89', '7', '112007013', '2007-2008-1', '90', '45', '80', '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SId` int(11) NOT NULL AUTO_INCREMENT,
  `GId` char(2) NOT NULL,
  `SName` char(8) NOT NULL,
  `SSexy` char(2) NOT NULL DEFAULT '男',
  `SBdate` datetime NOT NULL,
  `STele` char(11) DEFAULT NULL,
  PRIMARY KEY (`SId`),
  KEY `FK_Student_Grade` (`GId`) USING BTREE,
  CONSTRAINT `FK_Student_Grade` FOREIGN KEY (`GId`) REFERENCES `grade` (`GId`)
) ENGINE=InnoDB AUTO_INCREMENT=112007036 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('12005001', '03', '李山', '男', '1998-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('12005002', '03', '张飞', '男', '1997-10-11 00:00:00', '660781');
INSERT INTO `student` VALUES ('12005003', '03', '李玉和', '女', '1999-10-11 00:00:00', '660782');
INSERT INTO `student` VALUES ('12005004', '03', '王一飞', '女', '2000-10-11 00:00:00', '660783');
INSERT INTO `student` VALUES ('12006001', '03', '韦宝', '男', '1998-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('12006002', '03', '李飞', '男', '1997-10-11 00:00:00', '660101');
INSERT INTO `student` VALUES ('12006003', '03', '冯玉', '女', '1999-10-11 00:00:00', '660782');
INSERT INTO `student` VALUES ('12006004', '03', '马观', '女', '2000-10-11 00:00:00', '660783');
INSERT INTO `student` VALUES ('12007001', '03', '李知', '男', '1998-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('12007002', '03', '吴飞', '男', '1997-10-11 00:00:00', '660781');
INSERT INTO `student` VALUES ('12007003', '03', '李凡', '女', '1999-10-11 00:00:00', '660782');
INSERT INTO `student` VALUES ('12007004', '03', '王二飞', '女', '2000-10-11 00:00:00', '660783');
INSERT INTO `student` VALUES ('17005000', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005001', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005002', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005003', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005004', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005005', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005006', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005007', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005008', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('17005009', '01', '张三丰', '男', '1997-10-11 00:00:00', '660780');
INSERT INTO `student` VALUES ('32005005', '03', '徐红', '女', '1998-01-11 00:00:00', '660784');
INSERT INTO `student` VALUES ('32005006', '03', '刘和', '男', '1998-12-11 00:00:00', '660785');
INSERT INTO `student` VALUES ('32005007', '03', '刘山', '男', '1999-10-01 00:00:00', '660786');
INSERT INTO `student` VALUES ('32006005', '03', '徐一红', '女', '1998-01-11 00:00:00', '660784');
INSERT INTO `student` VALUES ('32006006', '03', '刘一和', '男', '1998-12-11 00:00:00', '660785');
INSERT INTO `student` VALUES ('32006007', '03', '马西', '男', '1999-10-01 00:00:00', '660786');
INSERT INTO `student` VALUES ('32007005', '03', '王红', '女', '1998-01-11 00:00:00', '660784');
INSERT INTO `student` VALUES ('32007006', '03', '王一红', '男', '1998-12-11 00:00:00', '660785');
INSERT INTO `student` VALUES ('32007007', '03', '丁西', '男', '1999-10-01 00:00:00', '660786');
INSERT INTO `student` VALUES ('82005008', '03', '刘去山', '女', '2000-01-11 00:00:00', '660787');
INSERT INTO `student` VALUES ('82005009', '03', '白云飞', '女', '2002-10-11 00:00:00', '660788');
INSERT INTO `student` VALUES ('82006008', '03', '刘问计', '女', '2000-01-11 00:00:00', '660787');
INSERT INTO `student` VALUES ('82006009', '03', '白问礼', '女', '2002-10-11 00:00:00', '660788');
INSERT INTO `student` VALUES ('82007008', '03', '刘红丽', '女', '2000-01-11 00:00:00', '660787');
INSERT INTO `student` VALUES ('82007009', '03', '沈学云', '女', '2002-10-11 00:00:00', '660788');
INSERT INTO `student` VALUES ('92005010', '03', '白云', '女', '1998-11-11 00:00:00', '660789');
INSERT INTO `student` VALUES ('92006010', '03', '黑土', '女', '1998-12-11 00:00:00', '660788');
INSERT INTO `student` VALUES ('92007010', '03', '李风', '女', '1998-11-11 00:00:00', '660789');
INSERT INTO `student` VALUES ('112005011', '03', '李红', '女', '1997-12-11 00:00:00', '660790');
INSERT INTO `student` VALUES ('112005012', '03', '周磊', '男', '1996-06-11 00:00:00', '660791');
INSERT INTO `student` VALUES ('112005013', '03', '冯圭', '女', '1997-08-11 00:00:00', '660792');
INSERT INTO `student` VALUES ('112006011', '03', '李玉红', '女', '1997-12-11 00:00:00', '660790');
INSERT INTO `student` VALUES ('112006012', '03', '冯磊', '男', '2006-06-11 00:00:00', '660791');
INSERT INTO `student` VALUES ('112006013', '03', '冯由', '女', '2007-08-11 00:00:00', '660792');
INSERT INTO `student` VALUES ('112007011', '03', '刘好', '女', '1997-12-11 00:00:00', '660790');
INSERT INTO `student` VALUES ('112007012', '03', '周成', '男', '1996-06-11 00:00:00', '660791');
INSERT INTO `student` VALUES ('112007013', '03', '文成', '女', '1997-08-11 00:00:00', '660792');
INSERT INTO `student` VALUES ('112007014', '03', '霍去病', '男', '1999-05-09 00:00:00', '660793');

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `class_code` char(5) NOT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`class_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

-- ----------------------------
-- Records of tb_class
-- ----------------------------

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `course_code` char(5) NOT NULL,
  `course_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程';

-- ----------------------------
-- Records of tb_course
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sc
-- ----------------------------
DROP TABLE IF EXISTS `tb_sc`;
CREATE TABLE `tb_sc` (
  `course_code` char(5) NOT NULL,
  `student_code` char(10) NOT NULL,
  `sc_grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_code`,`student_code`),
  KEY `FK_tb_sc2` (`student_code`),
  CONSTRAINT `FK_tb_sc` FOREIGN KEY (`course_code`) REFERENCES `tb_course` (`course_code`),
  CONSTRAINT `FK_tb_sc2` FOREIGN KEY (`student_code`) REFERENCES `tb_student` (`student_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sc
-- ----------------------------

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `student_code` char(10) NOT NULL,
  `class_code` char(5) DEFAULT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `student_sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_code`),
  KEY `FK_own` (`class_code`),
  CONSTRAINT `FK_own` FOREIGN KEY (`class_code`) REFERENCES `tb_class` (`class_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生';

-- ----------------------------
-- Records of tb_student
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `login_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `login_pwd` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('11', 'ln', '123456', 'un', '男', '2018-11-08 17:43:42', '2018-11-08 17:43:42');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `TId` char(5) NOT NULL,
  `DId` char(2) DEFAULT NULL,
  `TName` char(8) NOT NULL,
  `TSexy` char(2) NOT NULL,
  `TBdate` datetime NOT NULL,
  `TField` char(50) NOT NULL,
  `TProf` char(10) NOT NULL,
  `TTele` char(16) DEFAULT NULL,
  `TQq` char(12) DEFAULT NULL,
  `TEmail` char(30) DEFAULT NULL,
  `TMsn` char(30) DEFAULT NULL,
  PRIMARY KEY (`TId`),
  KEY `FK_Teacher_Dept` (`DId`) USING BTREE,
  CONSTRAINT `FK_Teacher_Dept` FOREIGN KEY (`DId`) REFERENCES `dept` (`DId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('02001', 'CS', '李飞', '男', '1986-05-05 00:00:00', '数据库', '讲师', '660001', null, null, null);
INSERT INTO `teacher` VALUES ('02002', 'CS', '郭山', '男', '1980-06-09 00:00:00', '数据库', '副教授', '660002', null, null, null);
INSERT INTO `teacher` VALUES ('02003', 'CS', '马骊', '女', '1983-03-08 00:00:00', '网络技术与数据库', '教授', '660003', null, null, null);
INSERT INTO `teacher` VALUES ('02004', 'CS', '徐守', '女', '1980-06-09 00:00:00', '面向对象编程', '助教', '660004', null, null, null);
INSERT INTO `teacher` VALUES ('02005', 'CS', '金贵', '女', '1980-06-09 00:00:00', '财务管理', '助教', '660005', null, null, null);
INSERT INTO `teacher` VALUES ('02006', 'IT', '成山云', '男', '1984-11-02 00:00:00', '金融学', '教授', '660006', null, null, null);
INSERT INTO `teacher` VALUES ('02007', 'IT', '张田下', '男', '1977-01-07 00:00:00', '新能源技术', '研究员', '660007', null, null, null);
INSERT INTO `teacher` VALUES ('02008', 'IT', '王一钱', '女', '1965-03-03 00:00:00', '信息管理与数据库', '讲师', '660008', null, null, null);
INSERT INTO `teacher` VALUES ('02009', 'IT', '李远', '女', '1977-01-07 00:00:00', '电工学', '实验师', '660009', null, null, null);
INSERT INTO `teacher` VALUES ('03010', 'IT', '吴天贵', '女', '1984-04-26 00:00:00', '中医学', '主治医师', '660010', null, null, null);
INSERT INTO `teacher` VALUES ('03011', 'EM', '刘了了', '女', '1972-06-12 00:00:00', '近代史', '研究员', '660220', null, null, null);
INSERT INTO `teacher` VALUES ('03012', 'EM', '洪玉飞', '男', '1967-09-29 00:00:00', '哲学', '教授', '660222', null, null, null);
INSERT INTO `teacher` VALUES ('03013', 'EM', '划计成', '女', '1962-09-01 00:00:00', '应用数学', '教授', '660223', null, null, null);
INSERT INTO `teacher` VALUES ('03014', 'EM', '李丽青', '男', '1968-05-09 00:00:00', '应用物理', '讲师', '660233', null, null, null);
INSERT INTO `teacher` VALUES ('03015', 'FD', '李员', '男', '1971-09-15 00:00:00', '统计学', '研究员', '660234', null, null, null);
INSERT INTO `teacher` VALUES ('03016', 'FD', '国威', '女', '1965-04-30 00:00:00', '政治学', '研究员', '660123', null, null, null);
INSERT INTO `teacher` VALUES ('03017', 'FD', '国华', '女', '1989-05-29 00:00:00', '证券投资', '研究员', '660987', null, null, null);
INSERT INTO `teacher` VALUES ('05022', 'SD', '后羿', '女', '1983-06-16 00:00:00', '护理与营养', '主任护理师', '660909', null, null, null);
INSERT INTO `teacher` VALUES ('05023', 'SD', '王飞红', '男', '1975-11-20 00:00:00', '多媒体技术', '讲师', '660938', null, null, null);
INSERT INTO `teacher` VALUES ('05024', 'SD', '李丽青', '男', '1969-03-30 00:00:00', '理论力学', '副教授', '660323', null, null, null);
INSERT INTO `teacher` VALUES ('05025', 'SD', '王红', '女', '1970-06-15 00:00:00', '建筑学', '副教授', '660099', null, null, null);
INSERT INTO `teacher` VALUES ('05026', 'SD', '李飞', '女', '1963-12-22 00:00:00', '流体力学', '讲师', '660987', null, null, null);

-- ----------------------------
-- Procedure structure for pro_five_grade
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_five_grade`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_five_grade`()
BEGIN
-- 需要定义接收游标数据的变量 
  DECLARE A INT DEFAULT 0;
  DECLARE B INT DEFAULT 0;
  DECLARE C INT DEFAULT 0;
  DECLARE D INT DEFAULT 0;
  DECLARE E INT DEFAULT 0;
  DECLARE score FLOAT;
  -- 遍历数据结束标志
  DECLARE done INT DEFAULT FALSE;
  -- 游标
  DECLARE cur CURSOR FOR SELECT SCScore FROM sc;
  -- 将结束标志绑定到游标
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  -- 打开游标
  OPEN cur;
 
  -- 开始循环
  read_loop: LOOP
    -- 提取游标里的数据，这里只有一个，多个的话也一样；
    FETCH cur INTO score;
    -- 声明结束的时候
    IF done THEN
      LEAVE read_loop;
    END IF;

    IF score>90 THEN
      SET A=A+1 ;
    ELSEIF score>80 THEN
      SET B=B+1;
    ELSEIF score>70 THEN
      SET C=C+1;
    ELSEIF score>60 THEN
      SET D=D+1; 
    ELSE
      SET E=E+1; 
    END IF;

  END LOOP;
  -- 关闭游标
  CLOSE cur;

  -- 输出结果  
  SELECT A; 
  SELECT B; 
  SELECT C; 
  SELECT D; 
  SELECT E; 
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_add`;
DELIMITER ;;
CREATE TRIGGER `tri_add` AFTER INSERT ON `course` FOR EACH ROW begin
    select count(*) into @cnum from course;
    update cnum set c_num=@cnum ;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_update_score`;
DELIMITER ;;
CREATE TRIGGER `tri_update_score` BEFORE UPDATE ON `sc` FOR EACH ROW BEGIN

#使用SET赋值
#SET @sName='吴飞';        
#使用SELECT赋值
#SELECT SId into @sId FROM student WHERE SName=@sName; 
#获取学号的最后一位并转换为整形
#SELECT CAST(SUBSTRING(@sId,9,1) AS SIGNED) into @tempNum;
#加减一位获取相邻学生的学号
#SET @nSId= CONCAT(left(@sId,8), CONCAT(@tempNum - 1,''));
#SELECT * FROM student WHERE SId=@nSId; 

   #SET NEW.SCScore = (NEW.SCScore1+NEW.SCScore2+NEW.SCScore3)/3;

END
;;
DELIMITER ;
