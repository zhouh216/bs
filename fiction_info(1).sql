/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : fiction_crawler_db

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-04-21 12:44:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fiction_info
-- ----------------------------
DROP TABLE IF EXISTS `fiction_info`;
CREATE TABLE `fiction_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `fiction_name` varchar(128) NOT NULL COMMENT '小说名字',
  `fiction_author` varchar(128) NOT NULL,
  `img` varchar(1024) NOT NULL,
  `is_over` varchar(128) DEFAULT NULL,
  `fiction_size` varchar(128) DEFAULT NULL,
  `fiction_type` int(2) DEFAULT NULL COMMENT '小说类型: 见枚举',
  `sex_type` int(2) DEFAULT NULL COMMENT '男/女',
  `subscription_num` int(4) DEFAULT '0' COMMENT '订阅',
  `collect_num` int(4) DEFAULT '0' COMMENT '收藏',
  `click_num` int(4) DEFAULT '0' COMMENT '点击',
  `ext` varchar(1024) DEFAULT NULL COMMENT '扩展',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='小说信息表';

-- ----------------------------
-- Records of fiction_info
-- ----------------------------
INSERT INTO `fiction_info` VALUES ('35', '2019-04-18 18:03:23', '2019-04-18 18:03:23', '敛财专家', '大秦骑兵', '//bookcover.yuewen.com/qdbimg/349573/c_5787416704875901/90', '已完结', '292.5万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/5787416704875901');
INSERT INTO `fiction_info` VALUES ('36', '2019-04-18 18:03:28', '2019-04-18 18:03:28', '异世妖皇榜', '夏爱君', '//bookcover.yuewen.com/qdbimg/349573/c_21988277000642502/90', '已完结', '172.44万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/21988277000642502');
INSERT INTO `fiction_info` VALUES ('37', '2019-04-18 18:03:35', '2019-04-18 18:03:35', '重生之大文学家', '大江入海', '//bookcover.yuewen.com/qdbimg/349573/c_22298103000527102/90', '已完结', '76万', '1', '1', '0', '45', '1', 'https://www.readnovel.com/book/22298103000527102');
INSERT INTO `fiction_info` VALUES ('38', '2019-04-18 18:03:41', '2019-04-18 18:03:41', '星界归来之都市至尊', '辰风如雪', '//bookcover.yuewen.com/qdbimg/349573/c_11145866903784703/90', '未知', '16.21万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/11145866903784703');
INSERT INTO `fiction_info` VALUES ('39', '2019-04-18 18:03:48', '2019-04-18 18:03:48', '都市荣耀召唤系统', '优雅小狼', '//bookcover.yuewen.com/qdbimg/349573/c_7635995903713003/90', '未知', '23.2万', '1', '1', '24', '5', '8', 'https://www.readnovel.com/book/7635995903713003');
INSERT INTO `fiction_info` VALUES ('40', '2019-04-18 18:03:54', '2019-04-18 18:03:54', '土匪营', '珠江老烟', '//bookcover.yuewen.com/qdbimg/349573/c_26056437000888602/90', '已完结', '87.13万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/26056437000888602');
INSERT INTO `fiction_info` VALUES ('41', '2019-04-18 18:04:00', '2019-04-18 18:04:00', '异界火影战记', '星空光芒', '//bookcover.yuewen.com/qdbimg/349573/c_5248407503778003/90', '未知', '99.27万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/5248407503778003');
INSERT INTO `fiction_info` VALUES ('42', '2019-04-18 18:04:07', '2019-04-18 18:04:07', '开炮吧！魔王', '柏舟C', '//bookcover.yuewen.com/qdbimg/349573/c_6321145003141703/90', '未知', '14.43万', '1', '1', '0', '45', '0', 'https://www.readnovel.com/book/6321145003141703');
INSERT INTO `fiction_info` VALUES ('43', '2019-04-18 18:04:14', '2019-04-18 18:04:14', '风过秦川', '张and焦', '//bookcover.yuewen.com/qdbimg/349573/c_3667205003657703/90', '已完结', '61.31万', '1', '1', '46', '78', '2', 'https://www.readnovel.com/book/3667205003657703');
INSERT INTO `fiction_info` VALUES ('44', '2019-04-18 18:04:20', '2019-04-18 18:04:20', '重生大土豪', '非恒道', '//bookcover.yuewen.com/qdbimg/349573/c_25178362000281102/90', '未知', '24.26万', '1', '1', '0', '0', '1', 'https://www.readnovel.com/book/25178362000281102');
INSERT INTO `fiction_info` VALUES ('45', '2019-04-18 18:04:27', '2019-04-18 18:04:27', '种植天王', '骑马上虚空', '//bookcover.yuewen.com/qdbimg/349573/c_8208057103829503/90', '未知', '14.3万', '1', '1', '0', '0', '1', 'https://www.readnovel.com/book/8208057103829503');
INSERT INTO `fiction_info` VALUES ('46', '2019-04-18 18:04:32', '2019-04-18 18:04:32', '龙牙兵王', '司马鸿飞', '//bookcover.yuewen.com/qdbimg/349573/c_5291962403653801/90', '未知', '12.24万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/5291962403653801');
INSERT INTO `fiction_info` VALUES ('47', '2019-04-18 18:04:39', '2019-04-18 18:04:39', '七权心', '小色漠', '//bookcover.yuewen.com/qdbimg/349573/c_7623581504409303/90', '已完结', '33.18万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/7623581504409303');
INSERT INTO `fiction_info` VALUES ('48', '2019-04-18 18:04:44', '2019-04-18 18:04:44', '爱上地府勾魂女', '何欢亦何妨', '//bookcover.yuewen.com/qdbimg/349573/c_9399712603823803/90', '未知', '16.49万', '1', '1', '0', '48', '3', 'https://www.readnovel.com/book/9399712603823803');
INSERT INTO `fiction_info` VALUES ('49', '2019-04-18 18:04:50', '2019-04-18 18:04:50', '斩仙', '任怨', '//bookcover.yuewen.com/qdbimg/349573/c_6096408404734501/90', '未知', '456.15万', '1', '1', '65', '0', '0', 'https://www.readnovel.com/book/6096408404734501');
INSERT INTO `fiction_info` VALUES ('50', '2019-04-18 18:04:56', '2019-04-18 18:04:56', '史上最强霸主系统', '轻易难料', '//bookcover.yuewen.com/qdbimg/349573/c_8896502004565903/90', '未知', '20.54万', '1', '1', '0', '0', '0', 'https://www.readnovel.com/book/8896502004565903');
INSERT INTO `fiction_info` VALUES ('51', '2019-04-18 18:05:02', '2019-04-18 18:05:02', '那曾经的幸福', '紫雪凝烟', '//bookcover.yuewen.com/qdbimg/349573/c_5287601903414201/90', '已完结', '2807', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/5287601903414201');
INSERT INTO `fiction_info` VALUES ('52', '2019-04-18 18:05:02', '2019-04-18 18:05:02', '重生星海霸主', '你谦儿', '//bookcover.yuewen.com/qdbimg/349573/c_8643881604092803/90', '未知', '13.5万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/8643881604092803');
INSERT INTO `fiction_info` VALUES ('53', '2019-04-18 18:05:09', '2019-04-18 18:05:09', '证道成峰', '九弥之夜', '//bookcover.yuewen.com/qdbimg/349573/c_22335835000514802/90', '已完结', '267.08万', '2', '1', '42', '0', '0', 'https://www.readnovel.com/book/22335835000514802');
INSERT INTO `fiction_info` VALUES ('54', '2019-04-18 18:05:15', '2019-04-18 18:05:15', '降临者之归来的剑鬼', '熊猫王', '//bookcover.yuewen.com/qdbimg/349573/c_9369988004249403/90', '未知', '15.35万', '2', '1', '0', '0', '7', 'https://www.readnovel.com/book/9369988004249403');
INSERT INTO `fiction_info` VALUES ('55', '2019-04-18 18:05:21', '2019-04-18 18:05:21', '我的外婆是九尾狐', '码字成神', '//bookcover.yuewen.com/qdbimg/349573/c_22131107000598502/90', '未知', '6.16万', '2', '1', '0', '0', '1', 'https://www.readnovel.com/book/22131107000598502');
INSERT INTO `fiction_info` VALUES ('56', '2019-04-18 18:05:27', '2019-04-18 18:05:27', '升职宝典', '牛不起', '//bookcover.yuewen.com/qdbimg/349573/c_22393110000010102/90', '未知', '117.04万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/22393110000010102');
INSERT INTO `fiction_info` VALUES ('57', '2019-04-18 18:05:34', '2019-04-18 18:05:34', '真武战帝', '九阶天傀', '//bookcover.yuewen.com/qdbimg/349573/c_7621127604357103/90', '未知', '11.43万', '2', '1', '0', '0', '87', 'https://www.readnovel.com/book/7621127604357103');
INSERT INTO `fiction_info` VALUES ('58', '2019-04-18 18:05:40', '2019-04-18 18:05:40', '盗神', '牛跃', '//bookcover.yuewen.com/qdbimg/349573/c_3643867304181802/90', '未知', '3.03万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/3643867304181802');
INSERT INTO `fiction_info` VALUES ('59', '2019-04-18 18:05:43', '2019-04-18 18:05:43', '我的霸道总裁老婆', '我是老八', '//bookcover.yuewen.com/qdbimg/349573/c_5900966903502203/90', '未知', '3.78万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/5900966903502203');
INSERT INTO `fiction_info` VALUES ('60', '2019-04-18 18:05:47', '2019-04-18 18:05:47', '编造武侠秘籍', '林胡大大', '//bookcover.yuewen.com/qdbimg/349573/c_7831677903116803/90', '未知', '12.97万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/7831677903116803');
INSERT INTO `fiction_info` VALUES ('61', '2019-04-18 18:05:52', '2019-04-18 18:05:52', '末日地铁站', '危险的独狼', '//bookcover.yuewen.com/qdbimg/349573/c_6735801504192703/90', '未知', '33.02万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/6735801504192703');
INSERT INTO `fiction_info` VALUES ('62', '2019-04-18 18:05:57', '2019-04-18 18:05:57', '决战苍穹之斗中斗', '永不停的脚步', '//bookcover.yuewen.com/qdbimg/349573/c_5294064104039601/90', '未知', '18.79万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/5294064104039601');
INSERT INTO `fiction_info` VALUES ('63', '2019-04-18 18:06:04', '2019-04-18 18:06:04', '镇界剑', '伞白', '//bookcover.yuewen.com/qdbimg/349573/c_8208970804924503/90', '未知', '56.97万', '2', '1', '0', '1', '0', 'https://www.readnovel.com/book/8208970804924503');
INSERT INTO `fiction_info` VALUES ('64', '2019-04-18 18:06:10', '2019-04-18 18:06:10', '女总裁的无敌保镖', '九不悔', '//bookcover.yuewen.com/qdbimg/349573/c_4920438404387303/90', '未知', '6.24万', '2', '1', '0', '1', '1', 'https://www.readnovel.com/book/4920438404387303');
INSERT INTO `fiction_info` VALUES ('65', '2019-04-18 18:06:15', '2019-04-18 18:06:15', '无良剑仙', '王少少_起点', '//bookcover.yuewen.com/qdbimg/349573/c_5792599704047501/90', '已完结', '92.07万', '2', '1', '0', '1', '1', 'https://www.readnovel.com/book/5792599704047501');
INSERT INTO `fiction_info` VALUES ('66', '2019-04-18 18:06:21', '2019-04-18 18:06:21', '霸剑问情', '龙嘉子', '//bookcover.yuewen.com/qdbimg/349573/c_8077611903772903/90', '未知', '11.54万', '2', '1', '0', '1', '1', 'https://www.readnovel.com/book/8077611903772903');
INSERT INTO `fiction_info` VALUES ('67', '2019-04-18 18:06:27', '2019-04-18 18:06:27', '这里有仙女', '潮头', '//bookcover.yuewen.com/qdbimg/349573/c_11117266904644003/90', '未知', '8.64万', '2', '1', '0', '1', '1', 'https://www.readnovel.com/book/11117266904644003');
INSERT INTO `fiction_info` VALUES ('68', '2019-04-18 18:06:34', '2019-04-18 18:06:34', '潺潺的岁月', '弦一', '//bookcover.yuewen.com/qdbimg/349573/c_5292159304435801/90', '已完结', '6.26万', '2', '1', '0', '1', '6', 'https://www.readnovel.com/book/5292159304435801');
INSERT INTO `fiction_info` VALUES ('69', '2019-04-18 18:06:40', '2019-04-18 18:06:40', '阴间包工头', '小机机', '//bookcover.yuewen.com/qdbimg/349573/c_8376171304231503/90', '已完结', '15.99万', '2', '1', '0', '1', '2', 'https://www.readnovel.com/book/8376171304231503');
INSERT INTO `fiction_info` VALUES ('70', '2019-04-18 18:06:46', '2019-04-18 18:06:46', '异界江湖游', '一生悠然', '//bookcover.yuewen.com/qdbimg/349573/c_3667300503728202/90', '已完结', '107.45万', '2', '1', '0', '0', '1', 'https://www.readnovel.com/book/3667300503728202');
INSERT INTO `fiction_info` VALUES ('71', '2019-04-18 18:06:52', '2019-04-18 18:06:52', '向异界献上最凶恶的魔女', '7zip', '//bookcover.yuewen.com/qdbimg/349573/c_7936195903308903/90', '未知', '32.22万', '2', '1', '0', '2', '1', 'https://www.readnovel.com/book/7936195903308903');
INSERT INTO `fiction_info` VALUES ('72', '2019-04-18 18:06:59', '2019-04-18 18:06:59', '火眼', '迫击炮', '//bookcover.yuewen.com/qdbimg/349573/c_5293622503204501/90', '未知', '42.79万', '2', '1', '2', '6', '4', 'https://www.readnovel.com/book/5293622503204501');
INSERT INTO `fiction_info` VALUES ('73', '2019-04-18 18:07:04', '2019-04-18 18:07:04', '都市绝品小仙医', '许慢', '//bookcover.yuewen.com/qdbimg/349573/c_8743681403570303/90', '未知', '34.39万', '2', '1', '0', '1', '0', 'https://www.readnovel.com/book/8743681403570303');
INSERT INTO `fiction_info` VALUES ('74', '2019-04-18 18:07:11', '2019-04-18 18:07:11', '重生之超级沙鲁', '懒惰的小明', '//bookcover.yuewen.com/qdbimg/349573/c_7840734903534903/90', '未知', '13.78万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/7840734903534903');
INSERT INTO `fiction_info` VALUES ('75', '2019-04-21 12:16:52', '2019-04-21 12:16:52', '盛世天宠：绝色丹神', '木青夏', '//bookcover.yuewen.com/qdbimg/349573/c_8771859003301301/90', '加载中', '104.5万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/8771859003301301');
INSERT INTO `fiction_info` VALUES ('76', '2019-04-21 12:16:52', '2019-04-21 12:16:52', '唐若你好，我是倘若', '妖兰小小', '//bookcover.yuewen.com/qdbimg/349573/c_6833878403663901/90', '加载中', '10.29万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/6833878403663901');
INSERT INTO `fiction_info` VALUES ('77', '2019-04-21 12:16:52', '2019-04-21 12:16:52', '异能天后：影帝，结婚吧', '安知晓', '//bookcover.yuewen.com/qdbimg/349573/c_12879845203138903/90', '已完结', '13.83万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/12879845203138903');
INSERT INTO `fiction_info` VALUES ('78', '2019-04-21 12:16:52', '2019-04-21 12:16:52', '欢宠99次：高冷警司难招架', '苏宸央', '//bookcover.yuewen.com/qdbimg/349573/c_12698015803508003/90', '已完结', '26.21万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/12698015803508003');
INSERT INTO `fiction_info` VALUES ('79', '2019-04-21 12:16:52', '2019-04-21 12:16:52', '人闲大神落', '篱晚', '//bookcover.yuewen.com/qdbimg/349573/c_12006413804514503/90', '加载中', '20.36万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/12006413804514503');
INSERT INTO `fiction_info` VALUES ('80', '2019-04-21 12:16:58', '2019-04-21 12:16:58', '傲世狂妃：帝尊强势宠！', '婼淼', '//bookcover.yuewen.com/qdbimg/349573/c_9218984704807903/90', '加载中', '4.69万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/9218984704807903');
INSERT INTO `fiction_info` VALUES ('81', '2019-04-21 12:16:58', '2019-04-21 12:16:58', 'EXO邻家的宅女', '安羽莫', '//bookcover.yuewen.com/qdbimg/349573/c_5292759904653501/90', '加载中', '13.3万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/5292759904653501');
INSERT INTO `fiction_info` VALUES ('82', '2019-04-21 12:16:59', '2019-04-21 12:16:59', '重回17岁：绯闻男神，缠上身！', '公子如雪', '//bookcover.yuewen.com/qdbimg/349573/c_8479916103527903/90', '加载中', '66.63万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/8479916103527903');
INSERT INTO `fiction_info` VALUES ('83', '2019-04-21 12:16:59', '2019-04-21 12:16:59', '快穿：极品女神皆美腻！', '帝九夷', '//bookcover.yuewen.com/qdbimg/349573/c_12657679704087703/90', '已完结', '41.93万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/12657679704087703');
INSERT INTO `fiction_info` VALUES ('84', '2019-04-21 12:16:59', '2019-04-21 12:16:59', '亿万强娶：恶魔总裁夜夜来', '南风衍', '//bookcover.yuewen.com/qdbimg/349573/c_7816238803335903/90', '已完结', '2.33万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/7816238803335903');
INSERT INTO `fiction_info` VALUES ('85', '2019-04-21 12:35:37', '2019-04-21 12:35:37', '梦里乔木', '特特卡', '//bookcover.yuewen.com/qdbimg/349573/c_12290760203687203/90', '已完结', '12.55万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/12290760203687203');
INSERT INTO `fiction_info` VALUES ('86', '2019-04-21 12:35:37', '2019-04-21 12:35:37', '那要怎样告诉你', '世沛', '//bookcover.yuewen.com/qdbimg/349573/c_9736124903510403/90', '加载中', '6.79万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/9736124903510403');
INSERT INTO `fiction_info` VALUES ('87', '2019-04-21 12:35:37', '2019-04-21 12:35:37', '魔帝倾宠：毒妃，撩不停！', '苏风辞', '//bookcover.yuewen.com/qdbimg/349573/c_10008633104573403/90', '已完结', '21.47万', '2', '0', '0', '0', '0', 'https://www.readnovel.com/book/10008633104573403');
INSERT INTO `fiction_info` VALUES ('88', '2019-04-21 12:35:37', '2019-04-21 12:35:37', '首席情之所钟', '欧阳阿金', '//bookcover.yuewen.com/qdbimg/349573/c_5293813104974101/90', '已完结', '27.17万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/5293813104974101');
INSERT INTO `fiction_info` VALUES ('89', '2019-04-21 12:35:37', '2019-04-21 12:35:37', '假面之：谁动了天使的面具', '李悦糖', '//bookcover.yuewen.com/qdbimg/349573/c_25450602000407001/90', '已完结', '17.1万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/25450602000407001');
INSERT INTO `fiction_info` VALUES ('90', '2019-04-21 12:35:43', '2019-04-21 12:35:43', '认罪师', '子言倪笑', '//bookcover.yuewen.com/qdbimg/349573/c_13144194504552904/90', '已完结', '4.45万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/13144194504552904');
INSERT INTO `fiction_info` VALUES ('91', '2019-04-21 12:35:44', '2019-04-21 12:35:44', '醉卧君怀：王妃，卖个萌', '有鱼玄凌', '//bookcover.yuewen.com/qdbimg/349573/c_13292959903084504/90', '已完结', '3.75万', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/13292959903084504');
INSERT INTO `fiction_info` VALUES ('92', '2019-04-21 12:35:44', '2019-04-21 12:35:44', '贵妃颜之江山如画', '五月飞羽飘', '//bookcover.yuewen.com/qdbimg/349573/c_7426699203572203/90', '已完结', '6386', '2', '1', '0', '0', '0', 'https://www.readnovel.com/book/7426699203572203');
INSERT INTO `fiction_info` VALUES ('93', '2019-04-21 12:35:44', '2019-04-21 12:35:44', '重生七零：小媳妇，超凶的！', '丁嘉树', '//bookcover.yuewen.com/qdbimg/349573/c_12879450604978903/90', '已完结', '19.42万', '2', '1', '0', '0', '1', 'https://www.readnovel.com/book/12879450604978903');
INSERT INTO `fiction_info` VALUES ('94', '2019-04-21 12:35:44', '2019-04-21 12:35:44', '总裁的霸爱', '凌风追月', '//bookcover.yuewen.com/qdbimg/349573/c_3590747603162501/90', '加载中', '31.63万', '2', '0', '1', '1', '0', 'https://www.readnovel.com/book/3590747603162501');
