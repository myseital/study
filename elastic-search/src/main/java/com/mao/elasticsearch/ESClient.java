package com.mao.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author myseital
 * @date 2021/4/23 14:30
 */
public class ESClient {
    private static volatile RestHighLevelClient client;

    public static RestHighLevelClient instant() {
        if (null == client) {
            synchronized (RestHighLevelClient.class) {
                if (null == client) {
                    client = new RestHighLevelClient(
                            RestClient.builder(new HttpHost("localhost", 9200, "http"))
                    );
                }
            }
        }
        return client;
    }
}
