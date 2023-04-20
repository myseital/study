//package com.mao.netty.protobuf;
//
//import com.mao.protobuf.Info;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//
//import java.util.Random;
//
//public class TestClientHandler extends SimpleChannelInboundHandler<com.mao.protobuf.DataInfo.MyObject> {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, com.mao.protobuf.DataInfo.MyObject myObject) throws Exception {
//
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        int i = new Random().nextInt(3);
//        com.mao.protobuf.DataInfo.MyObject myObject = null;
//        switch (i) {
//            case 0:
//                myObject = com.mao.protobuf.DataInfo.MyObject.newBuilder().setDataType(com.mao.protobuf.DataInfo.MyObject.DataType.StudentType)
//                        .setStudent(Info.Student.newBuilder().setAge(26).setAddress("长沙").setName("太白").build())
//                        .build();
//                break;
//            case 1:
//                myObject = com.mao.protobuf.DataInfo.MyObject.newBuilder().setDataType(com.mao.protobuf.DataInfo.MyObject.DataType.TeacherType)
//                        .setTeacher(com.mao.protobuf.DataInfo.Teacher.newBuilder().setAge(26).setDuty("讲师").setName("太白").build())
//                        .build();
//                break;
//            case 2:
//                myObject = com.mao.protobuf.DataInfo.MyObject.newBuilder().setDataType(com.mao.protobuf.DataInfo.MyObject.DataType.PatriarchType)
//                        .setPatriarch(com.mao.protobuf.DataInfo.Patriarch.newBuilder().setId(1).setName("太白").build())
//                        .build();
//                break;
//        }
//        ctx.writeAndFlush(myObject);
////        DataInfo.Student student = DataInfo.Student.newBuilder().setName("太白").setAge(25).setAddress("长沙").build();
////        byte[] bytes = student.toByteArray();
////        ByteBuf buf= Unpooled.copiedBuffer(bytes);
////        ctx.writeAndFlush(student);
//    }
//}
