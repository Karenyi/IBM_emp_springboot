package org.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tutorial.model.EmpVO;


@Repository
public interface EmpRepository extends JpaRepository<EmpVO, Integer> {
//
//    void insert(EmpVO empVO);
//
//    void update(EmpVO empVO);
//
//    void delete(Integer empno);
//
//    EmpVO findByPrimaryKey(Integer empno);
//
//    List<EmpVO> getAll();

    @Modifying//
//    @Query(value = "delete EmpVO where empno=?1")
    @Query(value ="delete from EMP2 where empno = :empno",nativeQuery = true)
    public void deleteEmp(@Param("empno")Integer empno);


}
