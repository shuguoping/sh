package com.shu.crm.service;

import com.shu.common.utils.Page;
import com.shu.crm.pojo.Customer;
import com.shu.crm.pojo.QueryVo;

/**
 *
 */
public interface CustomerService {
    //通过4个条件查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo);
    public Customer selectCustomerById(Integer id);
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Integer id);
}
