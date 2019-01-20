package com.ex.zl;

import com.ex.zl.enums.UserAgentType;
import com.ex.zl.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexAction {

    @Value("${spring.mail.username}")
    public String TO_MAIL;

    @Autowired
    MailService mailService;

    @RequestMapping("")
    public String index(HttpServletRequest request){
        UserAgentType userAgentType = getUserAgents(request);
        if(UserAgentType.Web.equals(userAgentType)){
            return "index";
        }else{
            return "phone_index";
        }
    }

    @RequestMapping(value = "/ajaxQueryZl", method = RequestMethod.POST)
    @ResponseBody
    public String query(HttpServletRequest request, String user, String mobile, String desc){
        if(StringUtils.isEmpty(user))
            user = "某某某";
        if(StringUtils.isEmpty(desc))
            desc = "客户不知道如何描述";
        StringBuilder sb = new StringBuilder();
        sb.append("称呼：").append(user).append("  ")
                .append("电话：").append(mobile).append("  ")
                .append("描述：").append(desc);
        mailService.sendSimpleMail(TO_MAIL,"专利查询",sb.toString());
        return "ok";
    }

    private UserAgentType getUserAgents(HttpServletRequest request){
        String userAgent = request.getHeader("user-agent");
        if(userAgent.contains("Android") || userAgent.contains("iPhone") || userAgent.contains("iPad")) {
            return UserAgentType.Phone;
        } else {
            return UserAgentType.Web;
        }
    }
}
