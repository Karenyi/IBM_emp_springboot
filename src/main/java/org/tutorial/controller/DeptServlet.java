package org.tutorial.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tutorial.model.DeptVO;
import org.tutorial.service.DeptService;



//url:  http://localhost:8080/IBM_emp/emp.do


//告訴DispatcherServlet相關的容器， 這是一個Controller，


@Controller
//@RequestMapping(value = "/dept/dept.do")
//@WebServlet("/dept/dept.do")
public class DeptServlet extends HttpServlet {

    @Autowired
    DeptService deptSvc;


    @RequestMapping(value = "/dept/listAll", method = RequestMethod.GET)
    public String ListAll(Model model) {
        model.addAttribute("deptall", deptSvc.getAll());
        return "dept/listAll"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }


    @RequestMapping(value = "/dept/listEmps_ByDeptno", method = RequestMethod.POST)
    public String ListOne(Model model, @RequestParam("deptno") Integer deptno) {
//        DeptService deptSvc = new DeptServiceImpl();
        model.addAttribute("listEmps_ByDeptno", deptSvc.getEmpsByDeptno(deptno)); // 傳引數給前端
        return "dept/listEmpsByDeptno"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }

    @RequestMapping(value = "/dept/delete", method = RequestMethod.POST)
    public String Delete(Model model, @RequestParam("deptno") Integer deptno) {
//        DeptService deptSvc = new DeptServiceImpl();
        deptSvc.deleteDept(deptno); // 傳引數給前端
        return "redirect:/dept/listAll"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }

    @RequestMapping(value = "/dept/getOneDisplay", method = RequestMethod.POST)
    public String getOneDisplay(Model model, @RequestParam("deptno") Integer deptno) {
//        DeptService deptSvc = new DeptServiceImpl();
        model.addAttribute("deptVO", deptSvc.getOneDept(deptno)); // 傳引數給前端
        return "dept/update"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }

    @RequestMapping(value = "/dept/update", method = RequestMethod.POST)
    public String Update(Model model, DeptVO deptVO) {
        deptSvc.update(deptVO.getDeptno(), deptVO.getDname(), deptVO.getLoc());
        model.addAttribute("deptVO", deptVO); // 傳引數給前端
        return "dept/listOne"; // 頁面的名稱，根v v 據此字串會去forward名為XXX.jsp的頁面
    }



}