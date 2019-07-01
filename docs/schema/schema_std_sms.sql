/*
 Navicat MySQL Data Transfer

 Source Server         : 148
 Source Server Version : 50545
 Source Host           : 121.43.101.148
 Source Database       : push_std_sms

 Target Server Version : 50545
 File Encoding         : utf-8

 Date: 01/20/2017 16:50:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tjc_company`
-- ----------------------------
DROP TABLE IF EXISTS `tjc_company`;
CREATE TABLE `tjc_company` (
  `code` varchar(32) NOT NULL COMMENT '公司编号',
  `name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `prefix` varchar(255) DEFAULT NULL COMMENT '公司后缀',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tjc_configure`
-- ----------------------------
DROP TABLE IF EXISTS `tjc_configure`;
CREATE TABLE `tjc_configure` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `channel` varchar(255) DEFAULT NULL COMMENT '通道',
  `k` varchar(255) DEFAULT NULL COMMENT 'key',
  `v` varchar(255) DEFAULT NULL COMMENT 'value',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tjc_day_report`
-- ----------------------------
DROP TABLE IF EXISTS `tjc_day_report`;
CREATE TABLE `tjc_day_report` (
  `code` varchar(32) NOT NULL DEFAULT '报表编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `channel` varchar(255) DEFAULT NULL COMMENT '通道',
  `suc_times` int(16) DEFAULT NULL COMMENT '成功次数',
  `fail_times` int(16) DEFAULT NULL COMMENT '失败次数',
  `report_date` datetime DEFAULT NULL COMMENT '报表日期',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tjc_sms_captcha`
-- ----------------------------
DROP TABLE IF EXISTS `tjc_sms_captcha`;
CREATE TABLE `tjc_sms_captcha` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `captcha` varchar(255) DEFAULT NULL COMMENT '验证码',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `send_datetime` datetime DEFAULT NULL COMMENT '发送时间',
  `invalid_datetime` datetime DEFAULT NULL COMMENT '失效时间',
  `check_datetime` datetime DEFAULT NULL COMMENT '验证时间',
  `company_code` varchar(32) DEFAULT NULL COMMENT '所属公司',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tjc_sms_out`
-- ----------------------------
DROP TABLE IF EXISTS `tjc_sms_out`;
CREATE TABLE `tjc_sms_out` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `channel` varchar(255) DEFAULT NULL COMMENT '通道',
  `content` varchar(255) DEFAULT NULL COMMENT '发送内容',
  `error_code` varchar(2) DEFAULT NULL COMMENT '错误编号',
  `error_info` varchar(255) DEFAULT NULL COMMENT '错误信息',
  `send_datetime` datetime DEFAULT NULL COMMENT '发送时间',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tjc_sms_pool`
-- ----------------------------
DROP TABLE IF EXISTS `tjc_sms_pool`;
CREATE TABLE `tjc_sms_pool` (
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '待发短信编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `channel` varchar(255) DEFAULT NULL COMMENT '通道',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `content` varchar(255) DEFAULT NULL COMMENT '发送内容',
  `to_send_datetime` datetime DEFAULT NULL COMMENT '待发时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_items`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_items`;
CREATE TABLE `tstd_items` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `first` varchar(255) DEFAULT NULL COMMENT '问候语',
  `department` varchar(32) DEFAULT NULL COMMENT '审批部门',
  `content` varchar(255) DEFAULT NULL COMMENT '办理事项',
  `telephone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_receiver`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_receiver`;
CREATE TABLE `tstd_receiver` (
  `mobile` varchar(32) NOT NULL COMMENT '手机号',
  `system_code` varchar(32) NOT NULL DEFAULT '' COMMENT '系统编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `level` varchar(32) DEFAULT NULL COMMENT '等级',
  `wechat_id` varchar(255) DEFAULT NULL COMMENT '微信id',
  `jpush_id` varchar(255) DEFAULT NULL COMMENT '极光id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`mobile`,`system_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_sms`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_sms`;
CREATE TABLE `tstd_sms` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `from_system_code` varchar(32) DEFAULT NULL COMMENT 'from系统编号',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '渠道大类',
  `push_type` varchar(32) DEFAULT NULL COMMENT '渠道小类',
  `to_system_code` varchar(32) DEFAULT NULL COMMENT 'to公司编号',
  `to_kind` varchar(32) DEFAULT NULL COMMENT '分组',
  `to_mobile` varchar(32) DEFAULT NULL COMMENT 'to手机号',
  `sms_type` varchar(32) DEFAULT NULL COMMENT '消息类型（即时发,定时发）',
  `sms_title` varchar(255) DEFAULT NULL COMMENT '消息标题（可为空）',
  `sms_content` text COMMENT '消息内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态（未发送，发送成功，发送失败）',
  `create_datetime` datetime DEFAULT NULL COMMENT '生成时间',
  `topush_datetime` datetime DEFAULT NULL COMMENT '拟发送时间',
  `pushed_datetime` datetime DEFAULT NULL COMMENT '发送时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_system_channel`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_system_channel`;
CREATE TABLE `tstd_system_channel` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '渠道大类',
  `push_type` varchar(32) DEFAULT NULL COMMENT '渠道小类',
  `status` varchar(32) DEFAULT NULL COMMENT '状态（启用/不启用）',
  `push_system` varchar(255) DEFAULT NULL COMMENT '渠道给系统的代号',
  `private_key1` varchar(255) DEFAULT NULL COMMENT '秘钥1(账号)',
  `private_key2` varchar(255) DEFAULT NULL COMMENT '秘钥2(密码)',
  `private_key3` varchar(1024) DEFAULT NULL COMMENT '秘钥3(其他，比如uid，product和微信token定时存储)',
  `private_key4` varchar(255) DEFAULT NULL COMMENT '微信token',
  `private_key5` varchar(255) DEFAULT NULL COMMENT '微信aceKey',
  `private_key6` varchar(255) DEFAULT NULL COMMENT '微信关注语',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注(短信前缀)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tstd_system_template`
-- ----------------------------
DROP TABLE IF EXISTS `tstd_system_template`;
CREATE TABLE `tstd_system_template` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  `channel_type` varchar(32) DEFAULT NULL COMMENT '渠道类型',
  `push_type` varchar(32) DEFAULT NULL COMMENT '推送类型',
  `template_id` varchar(255) DEFAULT NULL COMMENT '模板编号',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `key1` varchar(255) DEFAULT NULL COMMENT '样式一',
  `key2` varchar(255) DEFAULT NULL COMMENT '样式二',
  `key3` varchar(255) DEFAULT NULL COMMENT '样式三',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '模板内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  
  `type` char(1) DEFAULT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父key',
  `dkey` varchar(32) DEFAULT NULL COMMENT 'key',
  `dvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS = 1;
