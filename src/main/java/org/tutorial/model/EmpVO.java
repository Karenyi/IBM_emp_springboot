package org.tutorial.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMP2")
@Component
public class EmpVO implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
//    private Integer deptno;
    private DeptVO deptVO;


    @Id
//    @SequenceGenerator(name = "empSeq", sequenceName = "EMP2_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	@NotEmpty(message="員工職位: 請勿空白")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

//	public Date getHiredate() {
//		return hiredate;
//	}
//
//	public void setHiredate(Date hiredate) {
//		this.hiredate = hiredate;
//	}
	public Double getSal() {
		return sal;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

//	public Integer getDeptno() {
//		return deptno;
//	}
//
//	public void setDeptno(Integer deptno) {
//		this.deptno = deptno;
//	}

	@ManyToOne
	@JoinColumn(name = "DEPTNO")
    public DeptVO getDeptVO() {
        return deptVO;
    }

    public void setDeptVO(DeptVO deptVO) {
        this.deptVO = deptVO;
    }
}
