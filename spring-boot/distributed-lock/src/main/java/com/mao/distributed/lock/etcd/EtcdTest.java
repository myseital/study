package com.mao.distributed.lock.etcd;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.GetResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author myseital
 * @date 2022/5/3 16:06
 */
public class EtcdTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // create client using endpoints
        String url = "http://42.192.154.95:2379";
        Client client = Client.builder().endpoints(url).build();

        // create client using target which enable using any name resolution mechanism provided
        // by grpc-java (i.e. dns:///foo.bar.com:2379)
//        String targetUrl = "ip:///etcd0:2379,etcd1:2379,etcd2:2379";
//        Client client2 = Client.builder().target(targetUrl).build();

        KV kvClient = client.getKVClient();
        ByteSequence key = ByteSequence.from("test_key".getBytes());
        ByteSequence value = ByteSequence.from("test_value".getBytes());
        // put the key-value
        kvClient.put(key, value).get();
        // get the CompletableFuture
        CompletableFuture<GetResponse> getFuture = kvClient.get(key);
        // get the value from CompletableFuture
        GetResponse response = getFuture.get();
        System.out.println(response.toString());
        // delete the key
//        kvClient.delete(key).get();
    }
}
