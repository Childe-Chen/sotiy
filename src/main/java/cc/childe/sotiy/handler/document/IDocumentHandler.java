package cc.childe.sotiy.handler.document;

import cc.childe.sotiy.constants.NodeConstant;
import cc.childe.sotiy.exception.AbstractSotiyException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/2 17:18
 **/
public interface IDocumentHandler {

    Logger logger = LoggerFactory.getLogger(IDocumentHandler.class);
    /**
     * 处理文档
     * @param document
     * @param path
     */
    default void handle(Document document, String path) throws AbstractSotiyException {
        if (document == null) {
            logger.error("File of {} load fail");
            return;
        }

        Element root = document.getRootElement();
        if (!root.getName().equals(NodeConstant.SOTIY)) {
            logger.error("File of {} root element is not support", path);
            return;
        }

        doHandle(document);
    }

    /**
     * 执行对文档的处理
     * @param document
     */
    void doHandle(Document document) throws AbstractSotiyException;
}
