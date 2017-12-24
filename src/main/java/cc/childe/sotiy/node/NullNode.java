package cc.childe.sotiy.node;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/2 23:20
 **/
public final class NullNode extends AbstractNode {

    private static final NullNode NULL_NODE = new NullNode();

    private NullNode() {
    }

    public static NullNode getNullNode() {
        return NULL_NODE;
    }

    @Override
    public boolean isNullObject() {
        return true;
    }
}
