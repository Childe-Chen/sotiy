package cc.childe.sotiy.factory;


import cc.childe.sotiy.handler.node.FieldHandler;
import cc.childe.sotiy.handler.node.FromHandler;
import cc.childe.sotiy.handler.node.INodeHandler;
import cc.childe.sotiy.handler.node.WhereHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * 节点处理器工厂
 *
 * @author childe
 * @date 2017/12/4 19:50
 **/
public class NodeHandlerFactory {

    public static List<INodeHandler> getNodeHandlerList() {
        List<INodeHandler> nodeHandlerList = new LinkedList<>();

        nodeHandlerList.add(new FieldHandler());
        nodeHandlerList.add(new FromHandler());
        //一定在最后
        nodeHandlerList.add(new WhereHandler());

        return nodeHandlerList;
    }
}
