package com.shu.crm.service;

import com.shu.crm.mapper.BaseDictDao;
import com.shu.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class BaseDictServiceImpl  implements BaseDictService{
    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> selectBaseDictByCode(String code) {
        return baseDictDao.selectBaseDictByCode(code);
    }
}
