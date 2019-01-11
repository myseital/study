package com.mao.core.design.pattern.creational.abstractfactory;

/**
 * @author maojiawei
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
