package org.chain.demo.demomybatis.service;

import org.chain.demo.demomybatis.model.Family;

import java.util.List;

/**
 * @author Chain
 * @program demo-mybatis
 * @description family service
 * @date 2019-11-16 15:15
 **/
public interface IFamilyService {
    int add(Family family);
    List<Family> queryAll();
}
