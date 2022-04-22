package com.mao.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        com.mao.protobuf.Info.Student student = com.mao.protobuf.Info.Student
                .newBuilder().setName("太白").setAge(100).setAddress("长沙").build();
        byte[] bytes = student.toByteArray();
        com.mao.protobuf.Info.Student student1 = com.mao.protobuf.Info.Student.parseFrom(bytes);
        System.out.println(student1.getName());
        System.out.println(student1.getAddress());
        System.out.println(student1.getAge());
    }
}
