package org.tutorial.service;

import java.time.LocalDate;
import java.util.List;

import org.tutorial.model.EmpVO;


public interface EmpService {

    EmpVO addEmp(String ename, String job, LocalDate hiredate,
                        Double sal, Double comm, Integer deptno);

    EmpVO updateEmp(Integer empno, String ename, String job,
            LocalDate hiredate, Double sal, Double comm, Integer deptno);

    void deleteEmp(Integer empno);

    EmpVO getOneEmp(Integer empno);

    List<EmpVO> getAll();

}
