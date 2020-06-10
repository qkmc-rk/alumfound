/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : alumfound

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 10/06/2020 19:38:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alumniinfo
-- ----------------------------
DROP TABLE IF EXISTS `alumniinfo`;
CREATE TABLE `alumniinfo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '校友姓名',
  `college` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院',
  `major` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '专业',
  `clazz` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '班级',
  `contact` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系地址',
  `job` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '目前从事信息',
  `income` double unsigned DEFAULT '0' COMMENT '收入(不需要精确)',
  `corporation` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '目前所在公司',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='前端采集并登记校友信息';

-- ----------------------------
-- Table structure for alumnimien
-- ----------------------------
DROP TABLE IF EXISTS `alumnimien`;
CREATE TABLE `alumnimien` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '校友风采封面url',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `author` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
  `reader` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '审稿人',
  `origin` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '来源',
  `hits` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '点击数',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '校友风采具体内容(富文本)',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_recommend` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='校友风采';

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'banner图的连接',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0新闻 1图片新闻 2校友风采',
  `fid` bigint(20) unsigned NOT NULL COMMENT '外键id',
  `is_visible` tinyint(1) DEFAULT NULL COMMENT '是否可见',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='主页banner';

-- ----------------------------
-- Table structure for beneficiary
-- ----------------------------
DROP TABLE IF EXISTS `beneficiary`;
CREATE TABLE `beneficiary` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件连接(可能是图片.pdf等)',
  `format` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '.png .jpg .pdf',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='受益人信息公示';

-- ----------------------------
-- Table structure for donationinfo
-- ----------------------------
DROP TABLE IF EXISTS `donationinfo`;
CREATE TABLE `donationinfo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `project` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '捐赠项目(冗余外键)',
  `projectid` bigint(20) unsigned DEFAULT NULL COMMENT '捐赠项目表外键',
  `donator` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '捐赠人姓名',
  `is_lady` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '捐赠人性别',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开,默认公开',
  `amount` decimal(10,0) unsigned NOT NULL COMMENT '捐赠金额',
  `is_schoolfellow` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否是校友,默认是',
  `contact` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系地址',
  `message` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '捐赠留言',
  `clazz` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '曾经班级',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='捐赠信息-校友捐赠后会记录在数据库';

-- ----------------------------
-- Table structure for donationlist
-- ----------------------------
DROP TABLE IF EXISTS `donationlist`;
CREATE TABLE `donationlist` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件连接(可能是图片.pdf等)',
  `format` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '.png .jpg .pdf',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='信息公开-捐赠名单';

-- ----------------------------
-- Table structure for donationproject
-- ----------------------------
DROP TABLE IF EXISTS `donationproject`;
CREATE TABLE `donationproject` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '捐赠项目详细说明',
  `head1` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '一级类别',
  `head2` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '二级类别',
  `code1` int(11) unsigned DEFAULT NULL COMMENT '一级类别代码',
  `code2` int(11) unsigned DEFAULT NULL COMMENT '二级类别代码',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='捐赠项目信息';

-- ----------------------------
-- Records of donationproject
-- ----------------------------
BEGIN;
INSERT INTO `donationproject` VALUES (1, '随着四川农业大学持续推进有特色高水平“211工程”，学校规模的扩大，对校园基础设施建设的要求与规模，必将提升到一个更高的层次。建设和改造的项目包括教学楼、实验楼、办公楼、宿舍楼、实验室、图书馆、学生活动中心、国际交流中心、体育场馆等建筑.', '校园基本建设项目', '校园基础设施建设', 1, 11, '2020-06-10 19:25:00', '2020-06-10 19:32:29');
INSERT INTO `donationproject` VALUES (2, '幽美的校园景观，不仅提供了惬意的学习生活环境，更是四川农业大学校园文化的视觉诠释。捐赠将用于校区道路、园林绿化、人文雕塑等校园景观建设。', '校园基本建设项目', '校园景观建设', 1, 12, '2020-06-10 19:26:08', '2020-06-10 19:32:31');
INSERT INTO `donationproject` VALUES (3, '四川农业大学现拥有博士学位授权一级学科10个、二级学科40个，硕士学位授权一级学科15个、二级学科67个，本科专业86个；国家重点学科和重点培育学科4个，部省重点学科19个。学科建设取得的优异成绩无不与社会各界给予学校的大力支持密切相关。为更好地规划和促进我校的学科建设，学校设立学科建设基金。该基金主要用于资助我校发展急需和有前景的科研创新平台、科研团队建设、人才培养等学科建设。', '校园发展项目', '学科建设', 2, 21, '2020-06-10 19:26:30', '2020-06-10 19:32:33');
INSERT INTO `donationproject` VALUES (4, '在人才培养过程中，四川农业大学涌现了一批优秀的国家级和省部级教学名师及优秀教材著作。这些教学成果的培育需要优秀的师资团队和良好的教学设施给予保证。为促进我校取得更加丰硕的教学成果，学校设立教学成果奖励基金。该基金主要用于资助或奖励学校重点培育专业的教材编写、教学团队以及相关教学设备的购置等。', '校园发展项目', '教学奖励', 2, 22, '2020-06-10 19:26:45', '2020-06-10 19:32:35');
INSERT INTO `donationproject` VALUES (5, '产学研合作促进了学校与政府、学校与企业、学校与社会多方的交流与合作，是一种多赢的合作形式。学校将在产学研合作方面积极探索，特设立产学研合作基金。', '校园发展项目', '产学研合作', 2, 23, '2020-06-10 19:27:05', '2020-06-10 19:32:36');
INSERT INTO `donationproject` VALUES (6, '学校现建有教育部农业部重点实验室6个，农业部科学观测实验站3个，教育部农业部工程(技术)研究中心3个。为使实验室建设更好地服务于学校教学、科研一线，学校将加大投入，设立实验室建设专项基金。该基金主要用于支持学校发展急需学科的实验室建设和已建重点教学及科研实验室的再投入。', '校园发展项目', '实验室建设', 2, 24, '2020-06-10 19:27:26', '2020-06-10 19:32:38');
INSERT INTO `donationproject` VALUES (7, '为使四川农业大学优秀学子和骨干教师有更多机会把握世界科技前沿，培养在全球化背景下的卓越研究能力以及多元文化的适应能力，四川农业大学必须广泛与国际知名大学建立校际交流与合作关系，为此学校设立国际与海外交流合作专项基金。', '校园发展项目', '国际与海外交流合作', 2, 25, '2020-06-10 19:27:38', '2020-06-10 19:32:40');
INSERT INTO `donationproject` VALUES (8, '奖学金，极大地激发了学生的自信心和成就感。目前，四川农业大学奖学金分为两大类：单项奖学金和专项奖学金。其中专项奖学金为捐赠单位和个人出资设立。为奖励我校品学兼优的学生，使其更好更快成才和感恩回馈社会，学校设立优秀学生奖学基金。', '学生发展项目', '优秀学生奖学金', 3, 31, '2020-06-10 19:27:59', '2020-06-10 19:32:44');
INSERT INTO `donationproject` VALUES (9, '为帮助家庭特别困难的大学生顺利完成学业，创造良好学习氛围，学校增设各类助学基金，基金数额不限。该基金主要资助对象为家庭经济困难的全日制在校大学生。', '学生发展项目', '家庭经济困难学生助学金', 3, 32, '2020-06-10 19:28:21', '2020-06-10 19:32:45');
INSERT INTO `donationproject` VALUES (10, '四川农业大学家庭经济困难学生的比例高达38.7%，这些学生一旦突发大病重病，将对他们自身及家庭造成极大的精神和物质压力。为了更好地体现社会各界对贫困大学生的关怀，营造互助友善的校园精神文明氛围，学校设立学生大病、重病救助金。该基金主要资助对象包括：突发大病和重病的学生；需要较长期治疗及康复的患重病学生。', '学生发展项目', '学生大病、重病救助金', 3, 33, '2020-06-10 19:28:39', '2020-06-10 19:32:47');
INSERT INTO `donationproject` VALUES (11, '让更多大学生更好地参与社会实践活动，学校设立社会实践活动基金。该基金用于支持校园反响和社会意义俱佳的精品社团活动及社会实践活动；奖励在组织活动、内部建设方面表现突出的学生社团和社会实践团队；奖励为学生社团做出积极贡献的个人。', '学生发展项目', '社会实践活动', 3, 34, '2020-06-10 19:28:54', '2020-06-10 19:32:49');
INSERT INTO `donationproject` VALUES (12, '为使更多的大学生得到创新精神和实践能力的培养、科研能力的训练，学校设立大学生创新实践基金。该基金用于支持大学生开展创新实践活动，并对学生创新实践的成果予以奖励。', '学生发展项目', '学生创新实践', 3, 35, '2020-06-10 19:29:07', '2020-06-10 19:32:50');
INSERT INTO `donationproject` VALUES (13, '学校与企业联合培养企业所需的综合性专门人才，企业可在我校指定专业设立专项的助学基金，资助学生完成学业；学校根据企业需求对教学计划做相应的调整以适应企业对人才的需求。校企联合培养人才基金由联合培养企业提供，用于资助学生完成四年大学学习生活的学费和基本生活费。采取学生自愿报名，经学校推荐，企业选拔符合条件的学生做为资助对象。受资助的学生毕业后到企业工作。', '学生发展项目', '校企联合培养人才', 3, 36, '2020-06-10 19:29:19', '2020-06-10 19:32:51');
INSERT INTO `donationproject` VALUES (14, '解民生之多艰，育天下之英才，是我校百年不变的追求。做好农业科学技术知识的普及宣传是学校的义务之一。学校为了更好地向广大学生和民众普及农业科技知识，丰富校园文化，学校设立社会科普基金。该基金用于资助学校和学院组织开展的农业科普讲座以及相关活动。', '学生发展项目', '社会科普', 3, 37, '2020-06-10 19:29:32', '2020-06-10 19:32:53');
INSERT INTO `donationproject` VALUES (15, '奖教金用于奖励在师德方面为人师表、在教学一线表现优异、深得学生好评的优秀教师。为发扬四川农业大学卓越的教学传统，激励教师努力进取的治学精神，培育更多优秀学子，学校设立各类教师奖励基金。', '教师发展项目', '教师奖励', 4, 41, '2020-06-10 19:29:55', '2020-06-10 19:32:55');
INSERT INTO `donationproject` VALUES (16, '教席是指捐赠人向四川农业大学的特定教师提供在特定研究领域资助的永久性专用基金项目。教席的设立可对某一领域的科研工作提供长期的资助。捐赠人可指定在四川农业大学某学院（系）、研究中心（所）设立教席基金，每年使用基金收益资助指定学者、教授从事有关领域的专题研究。用于支持设立教席的基金数额可根据所选院系或研究领域的不同而确定。', '教师发展项目', '讲座教席', 4, 42, '2020-06-10 19:30:07', '2020-06-10 19:32:56');
INSERT INTO `donationproject` VALUES (17, '青年教师研究基金用于资助四川农业大学青年教师学术和科学研究工作，奖励教师取得的科研成果。为激励青年教师积极进取、努力钻研，提升学校的整体科研水平，学校设立青年教师研究基金。', '教师发展项目', '青年教师研究', 4, 43, '2020-06-10 19:30:26', '2020-06-10 19:32:57');
INSERT INTO `donationproject` VALUES (18, '选派和鼓励教师赴海外研修不仅对把握学科前沿发展方向，推动跨学科研究，增强科研实力和科研创新能力具有重要意义，对提高师资水平、改善师资队伍也起着非常积极的作用。该基金用于资助教师赴海外进行长期或短期研究和进修。', '教师发展项目', '教师海外研修', 4, 44, '2020-06-10 19:30:44', '2020-06-10 19:32:58');
INSERT INTO `donationproject` VALUES (19, '为构建和谐校园，学校将组织开展各种形式的校园文化活动以及校企文化的交流。该基金的设立主要用于资助学校、各学院和部门组织师生开展的有利于传承中华民族优良文化传统的各项文化活动。', '文化体育活动项目', '文化活动资助', 5, 51, '2020-06-10 19:31:02', '2020-06-10 19:33:02');
INSERT INTO `donationproject` VALUES (20, '资助者可采用捐赠现金、体育器材等方式设立该项基金。该基金主要资助学校、学院及各部门体育健身器材的购置，组织体育比赛项目和其他体育群体活动等。', '文化体育活动项目', '体育活动资助', 5, 52, '2020-06-10 19:31:19', '2020-06-10 19:33:03');
INSERT INTO `donationproject` VALUES (21, '历经近百年的世纪风雨，四川农业大学已经发展成为一所以农为特色和优势的综合性大学，形成了特色鲜明、优势互补的学科群。现设有学院24个，研究所(中心)14个，涵盖农学、理学、工学、经济学、管理学、医学、文学、教育学、法学、艺术学10大学科门类。2012年在全国高校一级学科评估中，6个参评学科有3个、2个和1个分别位居全国第4、第5和第7。\n\n　　每个院系都有自己宏伟的发展规划，每个学科也都有自己特定的发展需求。适应不同院系的需要，四川农业大学教育发展基金会携手各个院系开展筹款活动，以支持院系的发展。如资助院系实验室、会议室的设施设备购置、装修装备；资助专著出版和论文发表；资助举办学术会议或交流活动；资助教师培训；资助学生课外科技制作或课外活动等等', '院系发展项目', '院系发展项目', 6, 61, '2020-06-10 19:31:52', '2020-06-10 19:33:05');
COMMIT;

-- ----------------------------
-- Table structure for elsepubinfo
-- ----------------------------
DROP TABLE IF EXISTS `elsepubinfo`;
CREATE TABLE `elsepubinfo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件连接(可能是图片.pdf等)',
  `format` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '.png .jpg .pdf',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开',
  `theme` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '主题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公开信息- 其它公示';

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件url',
  `size` double unsigned NOT NULL COMMENT '文件大小',
  `format` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '.png .jpg .pdf等',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='下载文件信息';

-- ----------------------------
-- Table structure for lawregulation
-- ----------------------------
DROP TABLE IF EXISTS `lawregulation`;
CREATE TABLE `lawregulation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `editor` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编辑者',
  `content` text COLLATE utf8mb4_general_ci COMMENT '政策法规内容',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='政策法规';

-- ----------------------------
-- Table structure for managesystem
-- ----------------------------
DROP TABLE IF EXISTS `managesystem`;
CREATE TABLE `managesystem` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `editor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编辑者',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '政策法规内容',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理制度';

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `author` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
  `reader` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '审稿人',
  `origin` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '来源',
  `hits` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '点击数',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '新闻具体内容(富文本)',
  `is_foundation` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是基金会新闻吗',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='普通新闻';

-- ----------------------------
-- Table structure for picnews
-- ----------------------------
DROP TABLE IF EXISTS `picnews`;
CREATE TABLE `picnews` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cover` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '封面url',
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `author` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
  `reader` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '审稿人',
  `origin` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '来源',
  `hits` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '点击数',
  `content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '新闻具体内容(富文本)',
  `is_foundation` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是基金会新闻吗',
  `is_recommend` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否长期推荐上主页',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='图片新闻';

-- ----------------------------
-- Table structure for yearlyreport
-- ----------------------------
DROP TABLE IF EXISTS `yearlyreport`;
CREATE TABLE `yearlyreport` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件连接(可能是图片.pdf等)',
  `format` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '.png .jpg .pdf',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否公开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='信息公开 - 年度报告';

SET FOREIGN_KEY_CHECKS = 1;
