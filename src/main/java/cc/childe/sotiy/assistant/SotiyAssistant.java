package cc.childe.sotiy.assistant;


import cc.childe.sotiy.cache.Item;
import cc.childe.sotiy.factory.StatementFactory;
import cc.childe.sotiy.parser.StatementParser;
import cc.childe.sotiy.statement.AbstractStatement;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * sotiy助手
 *
 * @author childe
 * @date 2017/12/5 20:35
 **/
public class SotiyAssistant {

    public static String getQuery(String nameSpace, String id, Object param) {
        AbstractStatement statement = StatementFactory.getStatement(nameSpace,id);
        return StatementParser.parseWhereStatement(statement,param);
    }

    public static Item getSolrQuery(String nameSpace, String id, Object param) {
        AbstractStatement statement = StatementFactory.getStatement(nameSpace,id);
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setFields(statement.getField());
        solrQuery.setQuery(StatementParser.parseWhereStatement(statement,param));
        return new Item(statement.getCollection(),solrQuery);
    }
}
