package cc.childe.sotiy.node;

/**
 * where节点
 *
 * @author childe
 * @date 2017/12/2 15:52
 **/
public final class WhereNode extends AbstractNode {

//    private LinkedList<AbstractNode> nodeList = new LinkedList<>();
//
//    public void addNode(AbstractNode node) {
//        nodeList.add(node);
//    }
//
    @Override
    public void setTrim(Boolean trim) {
        super.setTrim(Boolean.TRUE);
    }
//
//    @Override
//    public StringBuffer getPretreatmentBuffer() {
//        setPreCondition(nodeList.parallelStream().map(node -> node.getPretreatmentBuffer()).collect(Collectors.joining()));
//        return super.getPretreatmentBuffer();
//    }
}
