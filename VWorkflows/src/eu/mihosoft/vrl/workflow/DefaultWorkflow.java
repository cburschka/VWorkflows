/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.workflow;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public final class DefaultWorkflow extends FlowControllerImpl {

    public DefaultWorkflow(FlowNodeSkinFactory flowNodeSkinFactory,
            ConnectionSkinFactory connectionSkinFactory) {

        super(flowNodeSkinFactory, connectionSkinFactory);
        
        FlowFlowNode model = FlowFactory.newFlowModel();
        setNodeLookup(new NodeLookupImpl(model));
        setModel(model);

        addConnections(VConnections.newConnections("control"), "control");
        addConnections(VConnections.newConnections("data"), "data");
        addConnections(VConnections.newConnections("event"), "event");
    }

    public DefaultWorkflow() {

        super(null, null);

        FlowFlowNode model = FlowFactory.newFlowModel();
        setNodeLookup(new NodeLookupImpl(model));
        setModel(model);

        addConnections(VConnections.newConnections("control"), "control");
        addConnections(VConnections.newConnections("data"), "data");
        addConnections(VConnections.newConnections("event"), "event");
    }
}

class DummyFlowNodeSkinFactoryImpl implements FlowNodeSkinFactory<Skin> {

    @Override
    public FlowNodeSkin createSkin(FlowNode n) {
        return null;
    }

    @Override
    public FlowNodeSkinFactory createChild(Skin parent) {
        return new DummyFlowNodeSkinFactoryImpl();
    }
}

class DummyConnectionSkinFactoryImpl implements ConnectionSkinFactory<Skin> {

    @Override
    public ConnectionSkin createSkin(Connection c, FlowController flow, String type) {
        return null;
    }

    @Override
    public ConnectionSkinFactory createChild(Skin parent) {
        return new DummyConnectionSkinFactoryImpl();
    }
}
