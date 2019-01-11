package com.mao.core.design.pattern.behavioral.iterator;

/**
 * @author maojiawei
 */
public interface CourseAggregate {

    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();


}
