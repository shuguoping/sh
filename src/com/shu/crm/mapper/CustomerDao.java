package com.shu.crm.mapper;

import com.shu.crm.pojo.BaseDict;
import com.shu.crm.pojo.Customer;
import com.shu.crm.pojo.QueryVo;

import java.util.List;

/**
 *
 */
public interface CustomerDao {
    //查询总条数
    public Integer customerCount(QueryVo vo);
    //结果集
    public  List<Customer> selectCustomerListByQueryVo(QueryVo vo);
    //根据id查询
    public Customer selectCustomerById(Integer id);
    //通过id修改
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Integer id);
}
