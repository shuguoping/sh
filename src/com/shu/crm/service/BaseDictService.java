package com.shu.crm.service;

import com.shu.crm.pojo.BaseDict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */

public interface BaseDictService {
     public List<BaseDict> selectBaseDictByCode(String code);

}
