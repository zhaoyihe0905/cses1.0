insert into tb_sys_users (USERCODE, AREACODE, USERNAME, PASSWORD, COMPANYCODE, COMPANYTYPE, USERGRADE, VALIDSTATUS) values ('s', '510000', 'LIHI接口用户', '03c7c0ace395d80182db07ae2c30f034', 'LIHI', '1', '1', '1');
insert into tb_sys_users (USERCODE, AREACODE, USERNAME, PASSWORD, COMPANYCODE, COMPANYTYPE, USERGRADE, VALIDSTATUS) values ('admin', '510000', 'FPIC接口用户', 'E10ADC3949BA59ABBE56E057F20F883E', 'FPIC', '1', '1', '1');
insert into tb_sys_users (USERCODE, AREACODE, USERNAME, PASSWORD, COMPANYCODE, COMPANYTYPE, USERGRADE, VALIDSTATUS) values ('qwe', '510000', 'qwe', 'E10ADC3949BA59ABBE56E057F20F883E', 'ZYIC', '1', '0', '1');



insert into tb_sysconfig (id, areacode, companycode, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, validstatus) values (1, '420000', 'ALL', '', 'IaciUrl', 'http://172.20.223.130:8080/sinoiaci/commserver', '00', 'http://172.20.223.130:8080/sinoiaci/commserver', '', '1');
insert into tb_sysconfig (id, areacode, companycode, flag, parametercode, parameterdesc, parametertype, parametervalue, remark, validstatus) values (2, '420000', 'ALL', '', 'IacaUrl', 'http://172.20.223.130:8080/sinoiaca/commserver', '00', 'http://172.20.223.130:8080/sinoiaci/commserver', '', '1');
