package com.ex.zl;

import com.ex.zl.constant.Constant;
import com.ex.zl.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexAction {

    @Autowired
    MailService mailService;

    @RequestMapping(value = "/ajaxQueryZl", method = RequestMethod.POST)
    @ResponseBody
    public String query(String user,String mobile,String desc){
        StringBuilder sb = new StringBuilder();
        sb.append("称呼：").append(user).append("  ")
                .append("电话：").append(mobile).append("  ")
                .append("描述：").append(desc);
        mailService.sendSimpleMail(Constant.TO_MAIL,"专利查询",sb.toString());
        return "ok";
    }
}
