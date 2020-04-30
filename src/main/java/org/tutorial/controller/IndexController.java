package org.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tutorial.model.DeptVO;
import org.tutorial.model.EmpVO;
import org.tutorial.service.DeptService;
import org.tutorial.service.EmpService;

@Controller
public class IndexController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmpService empService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<DeptVO> deptVOs = deptService.getAll();
        List<EmpVO> empVOs = empService.getAll();
        model.addAttribute("deptVOs", deptVOs);
        model.addAttribute("empVOs", empVOs);
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }


    @RequestMapping("/loginerror")
    @ResponseBody
    public String loginerror() {
        return "無此權限";
    }


}
