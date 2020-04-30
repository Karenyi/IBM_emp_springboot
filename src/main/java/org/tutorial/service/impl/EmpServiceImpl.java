package org.tutorial.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutorial.dao.EmpRepository;
import org.tutorial.model.EmpVO;
import org.tutorial.service.EmpService;

@Transactional
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;
//    private EmpDAO dao;
//    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    private EmpDAO dao = (EmpDAO)context.getBean("empDAO");

//    public EmpServiceImpl() {
////        dao = new EmpDAOImpl();
//        dao = (EmpDAO)context.getBean("empDAO");
//    }

    @Override
    public EmpVO addEmp(String ename, String job, LocalDate hiredate,
                        Double sal, Double comm, Integer deptno) {

        EmpVO empVO = new EmpVO();

        empVO.setEname(ename);
        empVO.setJob(job);
        empVO.setHiredate(hiredate);
        empVO.setSal(sal);
        empVO.setComm(comm);
        org.tutorial.model.DeptVO deptVO = new org.tutorial.model.DeptVO();
        deptVO.setDeptno(deptno);
        empVO.setDeptVO(deptVO);
//        dao.insert(empVO);

//        return empVO;
        return empRepository.save(empVO);
    }

    @Override
    public EmpVO updateEmp(Integer empno, String ename, String job,
                           LocalDate hiredate, Double sal, Double comm, Integer deptno) {

        EmpVO empVO = new EmpVO();

        empVO.setEmpno(empno);
        empVO.setEname(ename);
        empVO.setJob(job);
        empVO.setHiredate(hiredate);
        empVO.setSal(sal);
        empVO.setComm(comm);
        org.tutorial.model.DeptVO deptVO = new org.tutorial.model.DeptVO();
        deptVO.setDeptno(deptno);
        empVO.setDeptVO(deptVO);
//        dao.update(empVO);

//        return dao.findByPrimaryKey(empno);
        return empRepository.save(empVO);
    }

    @Override
    public void deleteEmp(Integer empno) {
        System.out.println(empno);
        empRepository.deleteEmp(empno);
    }

    @Override
    public EmpVO getOneEmp(Integer empno) {
        return empRepository.getOne(empno);
    }

    @Override
    public List<EmpVO> getAll() {
        return empRepository.findAll();
    }

}
