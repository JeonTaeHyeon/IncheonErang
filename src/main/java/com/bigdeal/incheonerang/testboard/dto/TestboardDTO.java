package com.bigdeal.incheonerang.testboard.dto;

import java.util.Date;

public class TestboardDTO {

    private String test1;
    private int test2;
    private Date test3;

    public TestboardDTO() {}

    public TestboardDTO(String test1, int test2, Date test3) {
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    @Override
    public String toString() {
        return "TestboardDTO{" +
                "test1='" + test1 + '\'' +
                ", test2=" + test2 +
                ", test3=" + test3 +
                '}';
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public Date getTest3() {
        return test3;
    }

    public void setTest3(Date test3) {
        this.test3 = test3;
    }
}
