package cc.childe.sotiy.handler.node;


import cc.childe.sotiy.constants.AttributeConstant;
import cc.childe.sotiy.constants.NodeConstant;
import cc.childe.sotiy.node.AbstractNode;
import cc.childe.sotiy.node.FieldNode;
import cc.childe.sotiy.statement.AbstractStatement;
import com.google.common.base.CharMatcher;
import org.dom4j.Element;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/2 17:25
 **/
public class FieldHandler implements INodeHandler {

    @Override
    public Element doHandle(Element element, AbstractStatement statement) {
        Element fieldEle = element.element(NodeConstant.FIELD);

        AbstractNode fieldNode = new FieldNode();

        if (fieldEle == null) {
            fieldNode.setPreCondition("*");
            statement.setField(fieldNode.getPretreatmentBuffer().toString());
            return element;
        }

        fieldNode.setTrim(Boolean.valueOf(fieldEle.attributeValue(AttributeConstant.TRIM,"true")));
        fieldNode.setPreCondition(CharMatcher.WHITESPACE.removeFrom(fieldEle.getText()));

        statement.setField(fieldNode.getPretreatmentBuffer().toString());

        return element;
    }
}
