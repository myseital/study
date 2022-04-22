package com.mao.netty.protobuf;

import com.mao.protobuf.Info;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<com.mao.protobuf.DataInfo.MyObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, com.mao.protobuf.DataInfo.MyObject myObject) throws Exception {
        com.mao.protobuf.DataInfo.MyObject.DataType dataType = myObject.getDataType();
        if (dataType == com.mao.protobuf.DataInfo.MyObject.DataType.StudentType) {
            Info.Student student = myObject.getStudent();
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getAddress());
        } else if (dataType == com.mao.protobuf.DataInfo.MyObject.DataType.TeacherType) {
            com.mao.protobuf.DataInfo.Teacher teacher = myObject.getTeacher();
            System.out.println(teacher.getAge());
            System.out.println(teacher.getName());
            System.out.println(teacher.getDuty());
        } else if (dataType == com.mao.protobuf.DataInfo.MyObject.DataType.PatriarchType) {
            com.mao.protobuf.DataInfo.Patriarch patriarch = myObject.getPatriarch();
            System.out.println(patriarch.getId());
            System.out.println(patriarch.getName());
        }
    }
}
