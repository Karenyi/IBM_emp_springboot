package org.tutorial.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tutorial.model.EmpVO;
import org.tutorial.model.EmpVO2;
import org.tutorial.service.DeptService;
import org.tutorial.service.EmpService;

@Controller
public class EmpServlet {

     @Autowired
     EmpService empSvc;
     @Autowired
     DeptService deptSvc;


     @GetMapping("/test")
     @ResponseBody
     public String test() {
         return "Hello";
     }
     @GetMapping("/emp/listAll")
     public String ListOne(Model model) {
         model.addAttribute("empall", empSvc.getAll());
         return "emp/listAll"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
     }

    @RequestMapping(value = "/emp/listOne", method = RequestMethod.POST)
    public String ListOne(Model model, @RequestParam("empno") Integer empno) {
//        EmpService empSvc = new EmpServiceImpl();
        model.addAttribute("empVO", empSvc.getOneEmp(empno)); // 傳引數給前端
        return "emp/listOne"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }

    @RequestMapping(value = "/emp/delete_emp", method = RequestMethod.POST)
    public String Delete(Model model, @RequestParam("empno") Integer empno) {
//        EmpService empSvc = new EmpServiceImpl();
            empSvc.deleteEmp(empno);; // 傳引數給前端
        return "redirect:/emp/listAll"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }

    @RequestMapping(value = "/emp/getOneDisplay", method = RequestMethod.POST)
    public String GetOneDisplay(Model model, @RequestParam("empno") Integer empno) {
//        EmpService empSvc = new EmpServiceImpl();
        model.addAttribute("empVO", empSvc.getOneEmp(empno)); // 傳引數給前端
        model.addAttribute("deptall", deptSvc.getAll());
        return "emp/update"; // 頁面的名稱，根據此字串會去forward名為XXX.jsp的頁面
    }

    @PostMapping("/emp/update")
    public String update(Model model, @ModelAttribute("empVO") EmpVO2 empVO2) {
        EmpVO updatedEmpVO = empSvc.updateEmp(
                empVO2.getEmpno(),
                empVO2.getEname(),
                empVO2.getJob(),
                parse(empVO2.getHiredate()),
                empVO2.getSal(),
                empVO2.getComm(),
                empVO2.getDeptno());
        model.addAttribute("empVO", transformEmpVO(updatedEmpVO));
        return "emp/listOne";
    }

    @GetMapping("/emp/add")
    public String showAddPage(Model model) {
        EmpVO2 empVO2 = new EmpVO2();
        empVO2.setEname("王小明");
        empVO2.setJob("manager");
        empVO2.setHiredate(format(LocalDate.now()));
        empVO2.setSal(10000.0);
        empVO2.setComm(100.0);
        model.addAttribute("empVO", empVO2);
        model.addAttribute("deptall", deptSvc.getAll());
        return "emp/add";
    }


  @RequestMapping(value = "/emp/add", method = RequestMethod.POST)
  public String AddEmp(Model model,  @Valid @ModelAttribute("empVO") EmpVO2 empVO2) {
      empSvc.addEmp(
              empVO2.getEname(),
              empVO2.getJob(),
              parse(empVO2.getHiredate()),
              empVO2.getSal(),
              empVO2.getComm(),
              empVO2.getDeptno());
      return "redirect:/emp/listAll";
  }

  private EmpVO transformEmpVO(EmpVO empVO) {
      EmpVO2 empVO2 = new EmpVO2();
      empVO2.setEmpno(empVO.getEmpno());
      empVO2.setEname(empVO.getEname());
      empVO2.setJob(empVO.getJob());
      empVO2.setHiredate(format(empVO.getHiredate()));
      empVO2.setSal(empVO.getSal());
      empVO2.setComm(empVO.getComm());
      empVO2.setDeptVO(empVO.getDeptVO());
      return empVO;
  }



  private String format(LocalDate localDate) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      return formatter.format(localDate);
  }



  private LocalDate parse(String LocalDataString) {
      return LocalDate.parse(LocalDataString);
  }


}