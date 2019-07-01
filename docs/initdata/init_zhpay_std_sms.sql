INSERT INTO `tjc_company` (`code`,`name`,`prefix`) VALUES ('ZHP1007','正汇科技','正汇科技');
INSERT INTO `tjc_configure` (`company_code`,`channel`,`k`,`v`,`remark`) VALUES ('ZHP1007','Z253','z253_account','N1315527','z253_account');
INSERT INTO `tjc_configure` (`company_code`,`channel`,`k`,`v`,`remark`) VALUES ('ZHP1007','Z253','z253_password','Ps7f18ea','z253_password');
/*
-- Query: SELECT * FROM push_std_sms.tstd_system_channel
LIMIT 0, 50000

-- Date: 2016-11-30 14:06
*/
INSERT INTO `tstd_system_channel` (`system_code`,`channel_type`,`push_type`,`status`,`push_system`,`private_key1`,`private_key2`,`private_key3`,`remark`) VALUES ('CD-CZH000001','1','14','1','','N1315527','Ps7f18ea','','正汇科技');