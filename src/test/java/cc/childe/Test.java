package cc.childe;

import cc.childe.sotiy.assistant.SotiyAssistant;
import cc.childe.sotiy.factory.StatementFactory;
import cc.childe.sotiy.loader.ResourceLoader;
import cc.childe.sotiy.statement.AbstractStatement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/5 19:29
 **/
public class Test {
    public static void main(String[] args) {
        ResourceLoader resourceLoader = new ResourceLoader();
        resourceLoader.load();

        AbstractStatement statement = StatementFactory.getStatement("com.cxd.sotiy.test.Commodity","querySolrSpuWithSkuList");
        System.out.println(statement.getKey());
        System.out.println(statement.getField());
        System.out.println(statement.getCollection());
        System.out.println(statement.getWhereStatement());
        System.out.println("==========");

        Map<String,Object> params = new HashMap<>();
        params.put("entityId","222");
        params.put("valid","true");
        params.put("barCode","00000");
        params.put("adCodes", Arrays.asList("1","12","3"));
        params.put("planNos", Arrays.asList("1","12","3"));
        params.put("sellerEntityIds", Arrays.asList("0","12","3"));
        params.put("isVisibleOnly","10");

        String queryStr = SotiyAssistant.getQuery("com.cxd.sotiy.test.Commodity","querySolrSpuWithSkuList",params);
        System.out.println(queryStr);
    }
}
