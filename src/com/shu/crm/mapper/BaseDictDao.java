package com.shu.crm.mapper;

import com.shu.crm.pojo.BaseDict;

import java.util.List;

/**
 *
 */
public interface BaseDictDao {
    //查询
    public List<BaseDict> selectBaseDictByCode(String code);
}
