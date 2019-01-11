package com.mao.core.design.principle.demeter;


/**
 * @author maojiawei
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourses();
    }

}
