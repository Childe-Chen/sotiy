package cc.childe.sotiy.handler.element;

import cc.childe.sotiy.factory.NodeHandlerFactory;
import cc.childe.sotiy.handler.node.INodeHandler;
import cc.childe.sotiy.statement.AbstractStatement;
import cc.childe.sotiy.statement.SelectStatement;
import org.dom4j.Element;

import java.util.List;

/**
 * select处理
 *
 * @author childe
 * @date 2017/12/4 19:43
 **/
public class SelectElementHandler implements IElementHandler {

    @Override
    public AbstractStatement doHandle(Element ele) {
        AbstractStatement selectStatement = new SelectStatement();

        List<INodeHandler> nodeHandlerList = NodeHandlerFactory.getNodeHandlerList();

        nodeHandlerList.stream().forEach(nodeHandler -> nodeHandler.handle((Element)ele.clone(),selectStatement));

        return selectStatement;
    }
}
