insert into tb_sys_users (user_code, area_code, username, password, company_code, company_type, user_grade, valid_status) values ('s', '510000', 'LIHI接口用户', '03c7c0ace395d80182db07ae2c30f034', 'LIHI', '1', '1', '1');
insert into tb_sys_users (user_code, area_code, username, password, company_code, company_type, user_grade, valid_status) values ('admin', '510000', 'FPIC接口用户', 'E10ADC3949BA59ABBE56E057F20F883E', 'FPIC', '1', '1', '1');
insert into tb_sys_users (user_code, area_code, username, password, company_code, company_type, user_grade, valid_status) values ('qwe', '510000', 'qwe', 'E10ADC3949BA59ABBE56E057F20F883E', 'ZYIC', '1', '0', '1');



insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (1, '420000', 'ALL', '', 'IaciUrl', 'http://172.20.223.130:8080/sinoiaci/commserver', '00', 'http://172.20.223.130:8080/sinoiaci/commserver', '', '1');
insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (2, '420000', 'ALL', '', 'IacaUrl', 'http://172.20.223.130:8080/sinoiaca/commserver', '00', 'http://172.20.223.130:8080/sinoiaci/commserver', '', '1');

--34个省市的地区代码
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '110000', '北京',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '120000', '天津',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '130000', '河北',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '140000', '山西',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '150000', '内蒙古',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '210000', '辽宁',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '210200', '大连',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '220000', '吉林',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '230000', '黑龙江',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '310000', '上海',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '320000', '江苏',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '330000', '浙江',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '330200', '宁波',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '340000', '安徽',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '350000', '福建',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '350200', '厦门',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '360000', '江西',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '370000', '山东',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '370200', '青岛',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '410000', '河南',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '420000', '湖北',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '430000', '湖南',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '440000', '广东',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '440300', '深圳',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '450000', '广西',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '460000', '海南',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '500000', '重庆',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '510000', '四川',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '520000', '贵州',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '530000', '云南',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '540000', '西藏',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '610000', '陕西',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '620000', '甘肃',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '630000', '青海',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '640000', '宁夏',  0, '', 1);
insert into tb_code (code_type, code_code, code_name,  code_flag, remark, valid_status) values ('InsurerArea', '650000', '新疆',  0, '', 1);

--insert into DB2INST1.IABIZCODE (CODETYPE, CODECODE, CODENAME, CODEFLAG, REMARK, VALIDSTATUS) values ('InsurerArea', '350200', '厦门', '', 0, '', 1);

