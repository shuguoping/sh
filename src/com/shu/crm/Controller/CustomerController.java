package com.shu.crm.Controller;

import com.shu.common.utils.Page;
import com.shu.crm.pojo.BaseDict;
import com.shu.crm.pojo.Customer;
import com.shu.crm.pojo.QueryVo;
import com.shu.crm.service.BaseDictService;
import com.shu.crm.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.util.List;

/**
 * 客户管理
 */
@Controller
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;
    //注解在成员变量上
    @Value("${fromType.Code}")
    private String fromTypeCode;
    @Value("${industryType.Code}")
    private String industryTypeCode;
    @Value("${levelType.Code}")
    private String levelTypeCode;

    //入口
    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model) {
        try {
            // 解决get请求乱码问题
            if (StringUtils.isNotBlank(vo.getCustName())) {
                vo.setCustName(new String(vo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<BaseDict> fromType = baseDictService.selectBaseDictByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictByCode(industryTypeCode);
        List<BaseDict> levelType = baseDictService.selectBaseDictByCode(levelTypeCode);
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        //通过个条件查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);

        model.addAttribute("page", page);
        // 数据回显
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());

        return "customer";
    }

    @RequestMapping(value = "/customer/edit.action")

    public @ResponseBody
    Customer edit(Integer id) {
        System.out.println(id);
        Customer customer = customerService.selectCustomerById(id);
        return customer;
    }

    @RequestMapping(value = "/customer/update.action")

    public @ResponseBody
    String update(Customer customer) {
        //修改

        customerService.updateCustomerById(customer);
       return "OK";
    }
    @RequestMapping(value = "/customer/delete.action")

    public @ResponseBody
    void delete(Integer id) {
        //修改
customerService.deleteCustomerById(id);

    }

}
