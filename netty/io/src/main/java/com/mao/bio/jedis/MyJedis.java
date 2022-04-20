package com.mao.bio.jedis;

public class MyJedis {

    MySocket mySocket = new MySocket("42.192.154.95", 6379);

    public String set(String key, String value) {
        mySocket.send(commandUtil(Resp.command.SET, key.getBytes(), value.getBytes()));
        return mySocket.read();
    }


    public String get(String key) {
        mySocket.send(commandUtil(Resp.command.GET, key.getBytes()));
        return mySocket.read();
    }


    public String incr(String key) {
        mySocket.send(commandUtil(Resp.command.INCR, key.getBytes()));
        return mySocket.read();
    }


    public static String commandUtil(Resp.command command, byte[]... bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Resp.star).append(1 + bytes.length).append(Resp.line);
        stringBuilder.append(Resp.StringLength).append(command.toString().length()).append(Resp.line);
        stringBuilder.append(command.toString()).append(Resp.line);
        for (byte[] aByte : bytes) {
            stringBuilder.append(Resp.StringLength).append(aByte.length).append(Resp.line);
            stringBuilder.append(new String(aByte)).append(Resp.line);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        MyJedis myJedis = new MyJedis();
//        System.out.println(myJedis.set("test", "123456"));
        System.out.println(myJedis.get("test"));
    }

}
