package com.demo.dubbo.server.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2786507519932795914L;
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "test_name")
    private String testName;
    @Column(name = "test_num")
    private Integer testNum;
    @Column(name = "test_time")
    private Timestamp testTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getTestNum() {
        return testNum;
    }

    public void setTestNum(Integer testNum) {
        this.testNum = testNum;
    }

    public Timestamp getTestTime() {
        return testTime;
    }

    public void setTestTime(Timestamp testTime) {
        this.testTime = testTime;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                ", testNum=" + testNum +
                ", testTime=" + testTime +
                '}';
    }
}
