package com.mao.core.design.principle.dependenceinversion;

/**
 * @author maojiawei
 */
public class Geely {

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    private ICourse iCourse;


    public void studyImoocCourse() {
        iCourse.studyCourse();
    }


}
