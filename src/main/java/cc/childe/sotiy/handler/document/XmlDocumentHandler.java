package cc.childe.sotiy.handler.document;

import cc.childe.sotiy.constants.AttributeConstant;
import cc.childe.sotiy.constants.NodeConstant;
import cc.childe.sotiy.exception.AbstractSotiyException;
import cc.childe.sotiy.exception.SotiyAttrNotExistsException;
import cc.childe.sotiy.exception.SotiyAttrValueIllegalException;
import cc.childe.sotiy.handler.element.IElementHandler;
import cc.childe.sotiy.handler.element.SelectElementHandler;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;

/**
 * xml
 *
 * @author childe
 * @date 2017/12/2 17:24
 **/
public class XmlDocumentHandler implements IDocumentHandler {

    @Override
    public void doHandle(Document document) throws AbstractSotiyException {

        rootCheck(document.getRootElement());

        List<Element> elements = document.getRootElement().elements(NodeConstant.SELECT);

        IElementHandler elementHandler = new SelectElementHandler();
        for (Element ele : elements) {
            elementHandler.handle(ele);
        }

    }

    private void rootCheck(Element rootEle) throws SotiyAttrNotExistsException, SotiyAttrValueIllegalException {
        Attribute namespaceAttr = rootEle.attribute(AttributeConstant.NAMESPACE);
        if (namespaceAttr == null) {
            throw new SotiyAttrNotExistsException(AttributeConstant.NAMESPACE + "缺失!");
        }

        String namespace = namespaceAttr.getValue();
        if (namespace == null || namespace.length() == 0) {
            throw new SotiyAttrValueIllegalException(AttributeConstant.NAMESPACE + "未配置!");
        }
    }
}
