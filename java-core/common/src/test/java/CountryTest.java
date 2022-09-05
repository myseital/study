import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author myseital
 * @date 2022/9/5
 */
public class CountryTest {


    @Test
    public void getCountriesFromJson() throws IOException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(path);
        String filePath = path + "countries.json";
        System.out.println(filePath);
        File file = new File(filePath);
        readerMethod(file);
    }

    private static void readerMethod(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "Utf-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String jsonStr = sb.toString();
//        System.out.println(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONArray list = (JSONArray) jsonObject.get("list");
//        System.out.println(list.toString());
        String template = "update countries set code = '%s' where name_cn = '%s';";
        List<String> countryCodes = Lists.newArrayList("AW","AF","AO","AI","AX","AL","AD","AE","AR","AM","AS","AQ","TF","AG","AU","AT","AZ","BI","BE","BJ","BF","BD","BG","BH","BS","BA","BY","BZ","BM","BO","BR","BB","BN","BT","BV","BW","CF","CA","CC","CH","CL","CN","CI","CM","CD","CG","CK","CO","KM","CV","CR","CU","CX","KY","CY","CZ","DE","DJ","DM","DK","DO","DZ","EC","EG","ER","ES","EE","ET","FI","FJ","FR","FO","FM","GA","GB","GE","GH","GI","GN","GP","GM","GW","GR","GD","GL","GT","GF","GU","GY","HN","HR","HT","HU","ID","IN","IO","IE","IR","IQ","IS","IL","IT","JM","JE","JO","JP","KZ","KE","KG","KH","KI","KN","KR","KW","LA","LB","LR","LY","LC","LI","LK","LS","LT","LU","LV","MA","MC","MD","MG","MV","MX","MH","MK","ML","MT","MM","MN","MP","MZ","MR","MS","MQ","MU","MW","MY","YT","NA","NC","NE","NG","NI","NU","NL","NO","NP","NR","NZ","OM","PK","PA","PE","PH","PW","PG","PL","PR","KP","PT","PY","PS","PF","QA","RE","RO","RU","RW","SA","SD","SN","SG","SH","SB","SL","SV","SM","SO","PM","ST","SR","SK","SI","SE","SZ","SC","SY","TD","TG","TH","TJ","TK","TM","TL","TO","TT","TN","TR","TV","TZ","UG","UA","UY","US","UZ","VA","VC","VE","VN","VU","WS","YE","ZA","ZM","ZW");
        String template_insert = "insert into countries (`code`, `name_cn`, `name_en`) VALUES ('%s', '%s', '%s');";
        for (Object o : list) {
            JSONObject data = (JSONObject) o;
            if (!countryCodes.contains(data.get("iso_3166_1"))) {
                System.out.println(String.format(template_insert, data.get("iso_3166_1"), data.get("name_cn"), data.get("name_en")));
            }
//            System.out.println(String.format(template, data.get("iso_3166_1"), data.get("name_cn")));

        }
        for (int i = 0; i < list.size(); i++) {

        }
    }

    @Test
    public void getISOCountries() {
        String[] isoCountries = Locale.getISOCountries();
        for (String isoCountry : isoCountries) {
            System.out.println(isoCountry);
        }

//        Set<String> isoCountries_3 = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA3);
//        for (String isoCountry_3 : isoCountries_3) {
//            System.out.println(isoCountry_3);
//        }
    }
}
