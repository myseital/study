package com.mao.core.design.principle.dependenceinversion;

/**
 * @author maojiawei
 */
public class FECourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("Geely在学习FE课程");
    }

}
