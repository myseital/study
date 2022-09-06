import com.mao.core.common.util.OKHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author myseital
 * @date 2022/9/5
 */
@Slf4j
public class OKHttpUtilTest {


    @Test
    public void lingxingCountryTest() throws IOException {
        String token = "3f7cKOxTnA5SgLFLriKGbuecFYtDMmEt3su67Dp4l3fO6/+ZdcOatn4TkxlXLpidN5O1FIvuTSMQw7XFqzmT59yUAYPlvSWWLwChsmrzRj6cC9h6rPZ1NuzE/FKL75Wv8/1OLuiATkdr5+GmaohaLBBnB1ox4VdJcWayiOM";
        String url = "https://erp.lingxing.com/api/fba_fulfillment_order/statelist";
        Map<String, String> params = new HashMap<>();
        params.put("country_code", "AD");
//        params.put("req_time_sequence", "/api/fba_fulfillment_order/statelist$$1");
        params.put("req_time_sequence", "%2Fapi%2Ffba_fulfillment_order%2Fstatelist$$1");
        Map<String, String> headers = new HashMap<>();

        headers.put("auth-token", token);
        headers.put("Host", " erp.lingxing.com");
        headers.put("Referer", "https://erp.lingxing.com/erp/mmulti/mpSingleOrder");


        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
        headers.put("X-AK-Request-Source", " erp");
        headers.put("X-AK-Version", "2.9.5.0.0.268");
        headers.put("X-AK-Request-Id", "9dfb4fba-d96a-4559-92bf-cbfbd512f768");
        headers.put("X-AK-ENV-KEY", "SAAS-116");
        headers.put("Connection", "keep-alive");

        String s = OKHttpUtil.get(url);
        log.info(s);
    }
}