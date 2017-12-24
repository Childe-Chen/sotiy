package cc.childe.sotiy.handler.node;

import cc.childe.sotiy.constants.AttributeConstant;
import cc.childe.sotiy.constants.NodeConstant;
import cc.childe.sotiy.node.AbstractNode;
import cc.childe.sotiy.node.FromNode;
import cc.childe.sotiy.statement.AbstractStatement;
import com.google.common.base.CharMatcher;
import org.dom4j.Element;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/4 19:52
 **/
public class FromHandler implements INodeHandler {
    @Override
    public Element doHandle(Element element, AbstractStatement statement) {
        Element fromEle = element.element(NodeConstant.FROM);

        AbstractNode fromNode = new FromNode();

        if (fromEle == null) {
            statement.setField(fromNode.getPretreatmentBuffer().toString());
            return element;
        }

        fromNode.setTrim(Boolean.valueOf(fromEle.attributeValue(AttributeConstant.TRIM,"true")));
        fromNode.setPreCondition(CharMatcher.WHITESPACE.removeFrom(fromEle.getText()));

        statement.setCollection(fromNode.getPretreatmentBuffer().toString());

        return element;
    }
}
