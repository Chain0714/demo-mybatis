package org.chain.demo.demomybatis;

import org.chain.demo.demomybatis.common.constant.GenderEnum;
import org.chain.demo.demomybatis.mapper.FamilyMapper;
import org.chain.demo.demomybatis.model.Family;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

@SpringBootTest
class DemoMybatisApplicationTests {

	@Autowired
	private FamilyMapper familyMapper;

	@Test
	void contextLoads() throws Exception{
		Family family = Family.builder()
				.name("任晨")
				.birthday(new SimpleDateFormat("yyyy-MM-dd").parse("1992-07-14"))
				.address("江苏省南京市江宁区天麒路170号")
				.gender(GenderEnum.MALE.getCode())
				.identityId("321081199207140057")
				.salary(Money.of(CurrencyUnit.of("CNY"),18500))
				.tel("18052010714")
				.build();
		int i = familyMapper.insertSelective(family);
		Assertions.assertNotEquals(0,i);
	}

}
