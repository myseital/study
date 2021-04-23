package com.mao.elasticsearch;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ElasticSearchApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void getIndexTest() throws IOException {
        RestHighLevelClient client = ESClient.instant();

        GetIndexRequest getIndexRequest = new GetIndexRequest("shopping");
        GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        client.close();
    }
}
