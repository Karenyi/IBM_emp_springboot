package org.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.model.DeptVO;


@Repository
public interface DeptRepository extends JpaRepository<DeptVO, Integer> {

//    void insert(DeptVO deptVO);
//
//    void update(DeptVO deptVO);
//
//    void delete(Integer deptno);
//
//    DeptVO findByPrimaryKey(Integer deptno);
//
//    List<DeptVO> getAll();
//
//    Set<EmpVO> getEmpsByDeptno(Integer deptno);
//
//    List<DeptVO> getLoc(String loc);




}
