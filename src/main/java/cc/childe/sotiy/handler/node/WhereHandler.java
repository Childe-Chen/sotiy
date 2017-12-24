package cc.childe.sotiy.handler.node;

import cc.childe.sotiy.constants.NodeConstant;
import cc.childe.sotiy.node.WhereNode;
import cc.childe.sotiy.statement.AbstractStatement;
import com.google.common.base.CharMatcher;
import org.dom4j.Element;
import org.dom4j.tree.DefaultText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/2 23:26
 **/
public class WhereHandler implements INodeHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(WhereHandler.class);

    @Override
    public Element doHandle(Element element, AbstractStatement statement) {
        List<Element> whereElementList = element.elements(NodeConstant.WHERE);
        if (whereElementList.size() != 1) {
            LOGGER.error("存在多个where节点");
            return element;
        }

        //子节点处理
        Element whereNodeElement = handleChildNode(statement, whereElementList);

        WhereNode whereNode = new WhereNode();
        whereNode.setPreCondition(CharMatcher.WHITESPACE.trimAndCollapseFrom(whereNodeElement.getTextTrim(),' '));

        int index = element.elements().indexOf(whereNodeElement);
        element.elements().add(index,new DefaultText(whereNode.getPretreatmentBuffer().toString()));
        element.elements().remove(index);

        statement.setWhereStatement(whereNode);

        return element;
    }

    private Element handleChildNode(AbstractStatement statement, List<Element> whereElementList) {
        Element whereNodeElement = new ForeachHandler().handle(whereElementList.get(0),statement);
        whereNodeElement = new IncludeHandler().handle(whereNodeElement,statement);
        whereNodeElement = new ForeachHandler().handle(whereNodeElement,statement);
        whereNodeElement = new IfHandler().handle(whereNodeElement,statement);
        return whereNodeElement;
    }
}
