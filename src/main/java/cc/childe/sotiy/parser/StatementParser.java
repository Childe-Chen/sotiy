package cc.childe.sotiy.parser;

import cc.childe.sotiy.factory.VelocityEngineFactory;
import cc.childe.sotiy.statement.AbstractStatement;
import cc.childe.sotiy.utils.BeanUtil;
import org.apache.velocity.VelocityContext;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/5 20:45
 **/
public class StatementParser {

    public static String parseWhereStatement(AbstractStatement statement, Object paramObject) {
        Map<String,Object> param = BeanUtil.populateMap(new HashMap<>(),paramObject);
        VelocityContext context = new VelocityContext(param);
        return getRenderResult(statement, context);
    }

    private static String getRenderResult(AbstractStatement statement, VelocityContext context) {
        Writer writer = new StringWriter();
        VelocityEngineFactory.getVelocityEngine().evaluate(context,writer,statement.getKey(),statement.getWhereStatement());
        return writer.toString();
    }
}
