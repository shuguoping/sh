package com.shu.crm.service;

import com.shu.common.utils.Page;
import com.shu.crm.mapper.CustomerDao;
import com.shu.crm.pojo.Customer;
import com.shu.crm.pojo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CustomerServiceIMpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();
        page.setSize(10);
        vo.setSize(10);
        if (null != vo) {
            //判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            //客户名称


            if(vo.getCustName()!=null&&!"".equals(vo.getCustName().trim())){
                vo.setCustName(vo.getCustName().trim());
            }
            if(vo.getCustSource()!=null&&!"".equals(vo.getCustSource().trim())){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if(vo.getCustIndustry()!=null&&!"".equals(vo.getCustIndustry().trim())){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if(vo.getCustLevel()!=null&&!"".equals(vo.getCustLevel().trim())){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
           //设置总条数
            page.setTotal(customerDao.customerCount(vo));

            page.setRows(customerDao.selectCustomerListByQueryVo(vo));

        }


        return page;
    }

    @Override
    public Customer selectCustomerById(Integer id) {

        return customerDao.selectCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);

    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }
}
