package org.tutorial.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutorial.dao.DeptRepository;
import org.tutorial.model.DeptVO;
import org.tutorial.model.EmpVO;
import org.tutorial.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;
//    private DeptDAO dao;
//    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    private DeptDAO dao = (DeptDAO)context.getBean("deptDAOImpl");

//    public DeptServiceImpl() {
//        dao = new DeptDAOImpl();
//        dao = (DeptDAO)context.getBean("deptDAOImpl");
//    }

    @Override
    public List<DeptVO> getAll() {
//        Pageable pageable = PageRequest.of(0, 3, Sort.by(Direction.DESC, "deptno"));
//        Page<DeptVO> pages = dao.findAll(pageable);
//        return pages.getContent();
        return deptRepository.findAll();
    }

    @Override
    public DeptVO getOneDept(Integer deptno) {
//        return dao.findByPrimaryKey(deptno);
//        return dao.getOne(deptno);
        return deptRepository.getOne(deptno);
    }

    @Override
    public DeptVO update(Integer deptno, String dname, String loc) {
        DeptVO deptVO = new DeptVO();
        deptVO.setDeptno(deptno);
        deptVO.setDname(dname);
        deptVO.setLoc(loc);
//        dao.update(deptVO);
//        return dao.findByPrimaryKey(deptno);
        return deptRepository.save(deptVO);
    }

    @Override
    public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
//        return dao.getEmpsByDeptno(deptno);
        return deptRepository.getOne(deptno).getEmp();
    }

    @Override
    public void deleteDept(Integer deptno) {
//        dao.delete(deptno);
        deptRepository.deleteById(deptno);
    }

}
