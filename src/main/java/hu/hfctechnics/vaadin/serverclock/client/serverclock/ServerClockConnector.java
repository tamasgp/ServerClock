package hu.hfctechnics.vaadin.serverclock.client.serverclock;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import hu.hfctechnics.vaadin.serverclock.ServerClock;

@Connect(ServerClock.class)
public class ServerClockConnector extends AbstractComponentConnector {

    ServerClockServerRpc rpc = RpcProxy.create(ServerClockServerRpc.class, this);
    
    private Timer timer = null;
    
    public ServerClockConnector() {
        timer = new Timer() {
            @Override
            public void run() {
                rpc.getServerTime();
            }
        };
        timer.scheduleRepeating(60*1000);
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(ServerClockWidget.class);
    }
    
    @Override
    public ServerClockWidget getWidget() {
        return (ServerClockWidget) super.getWidget();
    }

    @Override
    public ServerClockState getState() {
        return (ServerClockState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        final long time = getState().time;
        getWidget().setTime(time);
    }
    
}
