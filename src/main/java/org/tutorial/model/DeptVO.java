package org.tutorial.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT2")
@NamedQuery(name = "findAllDEPT", query = "SELECT d FROM DeptVO d")
//@Component
public class DeptVO implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
    private Set<EmpVO> emp = new HashSet<>();

    @Id
//    @SequenceGenerator(name = "deptSeq", sequenceName = "DEPT2_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deptSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "deptVO",cascade = CascadeType.ALL)
    public Set<EmpVO> getEmp() {
        return emp;
    }

    public void setEmp(Set<EmpVO> emp) {
        this.emp = emp;
    }
}
