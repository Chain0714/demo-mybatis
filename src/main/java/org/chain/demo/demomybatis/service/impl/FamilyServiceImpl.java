package org.chain.demo.demomybatis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.chain.demo.demomybatis.mapper.FamilyMapper;
import org.chain.demo.demomybatis.model.Family;
import org.chain.demo.demomybatis.model.FamilyExample;
import org.chain.demo.demomybatis.service.IFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chain
 * @program demo-mybatis
 * @description 家人服务实现类
 * @date 2019-11-16 15:16
 **/
@Service
@Slf4j
public class FamilyServiceImpl implements IFamilyService {

    @Autowired
    private FamilyMapper familyMapper;

    @Override
    public int add(Family family) {
        return familyMapper.insertSelective(family);
    }

    @Override
    public List<Family> queryAll() {
        FamilyExample familyExample = new FamilyExample();
        familyExample.createCriteria();
        return familyMapper.selectByExample(familyExample);
    }
}
