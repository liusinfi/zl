package com.ex.zl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexAction {
    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/queryZL", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public void query(){
        System.out.println("1111");
    }
}
