insert into tb_sys_users (user_code, area_code, username, password, company_code, company_type, user_grade, valid_status) values ('s', '510000', 'LIHI接口用户', '03c7c0ace395d80182db07ae2c30f034', 'LIHI', '1', '1', '1');
insert into tb_sys_users (user_code, area_code, username, password, company_code, company_type, user_grade, valid_status) values ('admin', '510000', 'FPIC接口用户', 'E10ADC3949BA59ABBE56E057F20F883E', 'FPIC', '1', '1', '1');
insert into tb_sys_users (user_code, area_code, username, password, company_code, company_type, user_grade, valid_status) values ('qwe', '510000', 'qwe', 'E10ADC3949BA59ABBE56E057F20F883E', 'ZYIC', '1', '0', '1');



--insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (1, '420000', 'ALL', '', 'IaciUrl', 'http://172.20.223.130:8080/sinoiaci/commserver', '00', 'http://172.20.223.130:8080/sinoiaci/commserver', '', '1');
--insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (2, '420000', 'ALL', '', 'IacaUrl', 'http://172.20.223.130:8080/sinoiaca/commserver', '00', 'http://172.20.223.130:8080/sinoiaci/commserver', '', '1');
insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (1, '510000', 'ALL', '', 'url', '四川的访问路劲', '00', '123.57.216.177', '', '1');
insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (2, '510000', 'ALL', '', 'user', '四川的用户名', '00', 'PICC5100', '', '1');
insert into tb_sysconfig (id, area_code, company_code, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, valid_status) values (3, '510000', 'ALL', '', 'password', '四川的密码', '00', '123456', '', '1');



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

--insert into tb_code (id, code_code, code_flag, code_name, code_type, remark, valid_status) values (37, '<USER>', '0', 'PICC5100', 'GlobalVariable', '', '1');
--insert into tb_code (id, code_code, code_flag, code_name, code_type, remark, valid_status) values (38, '<PASSWORD>', '0', 'e10adc3949ba59abbe56e057f20f883e', 'GlobalVariable', '', '1');
--insert into tb_code (id, code_code, code_flag, code_name, code_type, remark, valid_status) values (39, '<CITYCODE>', '0', '420000', 'GlobalVariable', '', '1');

insert into tb_variable (variable_code, remark, valide_status, variable_name) values ('<C>', '0', 1, '45535');
insert into tb_variable (variable_code, remark, valide_status, variable_name) values ('<CITYCODE>', '0', 1, 'PICC5100');
insert into tb_variable (variable_code, remark, valide_status, variable_name) values ('<PASSWORD>', '0', 1, 'e10adc3949ba59abbe56e057f20f883e');
insert into tb_variable (variable_code, remark, valide_status, variable_name) values ('<USER>', '0', 1, '420000');


--insert into tb_interfaces (bussiness_type, bussiness_desc, inconfig_field, outconfig_field, remark, request_type, valid_status, xml_name) values ('01', '投保查询', '<user>', '<user>', '', '0', '1', 'D:\feiq\AutoRecv Files\许健(1CB72C117CC2)\交强险V6.2.0测试工具sc\XML\insurequery.xml');
--insert into tb_interfaces (bussiness_type, bussiness_desc, inconfig_field, outconfig_field, remark, request_type, valid_status, xml_name) values ('02', '投保预确认', '<user>', '<user>', '', '0', '1', 'D:\feiq\AutoRecv Files\许健(1CB72C117CC2)\交强险V6.2.0测试工具sc\insureconfirm.xml');
--insert into tb_interfaces (bussiness_type, bussiness_desc, inconfig_field, outconfig_field, remark, request_type, valid_status, xml_name) values ('03', '投保查询校验', '<user>', '<user>', '', '0', '1', 'D:\feiq\AutoRecv Files\许健(1CB72C117CC2)\交强险V6.2.0测试工具sc\yuquef.xml');
--insert into tb_interfaces (bussiness_type, bussiness_desc, inconfig_field, outconfig_field, remark, request_type, valid_status, xml_name) values ('04', '投保注销', '<user>', '<user>', '', '0', '1', 'D:\feiq\AutoRecv Files\许健(1CB72C117CC2)\交强险V6.2.0测试工具sc\zhuxiao.xml');

insert into tb_interfaces (id, bussiness_desc, inconfig_field, outconfig_field, remark, valid_status, xml_name, url) values (1, '投保查询', '<user>', '<user>', '', '1', 'C:\\Users\\xj143\\Desktop\\sinoiacitest\\XML\\insurequery.xml', 'http://localhost:8080/sinoiaci/commserver');
insert into tb_interfaces (id, bussiness_desc, inconfig_field, outconfig_field, remark, valid_status, xml_name, url) values (2, '投保预确认', '<user>', '<user>', '', '1', 'C:\\Users\\xj143\\Desktop\\sinoiacitest\\XML\\insureconfirm.xml', 'http://localhost:8080/sinoiaci/commserver');
insert into tb_interfaces (id, bussiness_desc, inconfig_field, outconfig_field, remark, valid_status, xml_name, url) values (3, '投保查询校验', '<user>', '<user>', '', '1', 'C:\\Users\\xj143\\Desktop\\sinoiacitest\\XML\\carquery.xml', 'http://localhost:8080/sinoiaci/commserver');
insert into tb_interfaces (id, bussiness_desc, inconfig_field, outconfig_field, remark, valid_status, xml_name, url) values (4, '投保注销', '<user>', '<user>', '', '1', 'C:\\Users\\xj143\\Desktop\\sinoiacitest\\XML\\endorquery.xml', 'http://localhost:8080/sinoiaci/commserver');

insert into tb_execution (id, orders, process, remark, valid_status) values (1, '投保查询,投保预确认,投保查询校验', '交强险投保查询', '0', '1');
insert into tb_execution (id, orders, process, remark, valid_status) values (2, '投保查询,投保预确认,投保查询校验', '商业险投保查询', '0', '1');
insert into tb_execution (id, orders, process, remark, valid_status) values (3, '投保查询,投保预确认,投保查询校验', '交强险批改查询', '0', '1');
insert into tb_execution (id, orders, process, remark, valid_status) values (4, '投保查询,投保预确认,投保查询校验', '交强险批改查询', '0', '1');


