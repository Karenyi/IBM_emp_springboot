package org.tutorial.service;

import java.util.List;
import java.util.Set;

import org.tutorial.model.DeptVO;
import org.tutorial.model.EmpVO;

public interface DeptService {

    List<DeptVO> getAll();

    DeptVO getOneDept(Integer deptno);

    DeptVO update(Integer deptno, String dname, String loc);

    Set<EmpVO> getEmpsByDeptno(Integer deptno);

    void deleteDept(Integer deptno);

}
