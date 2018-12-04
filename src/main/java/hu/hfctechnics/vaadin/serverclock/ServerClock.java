package hu.hfctechnics.vaadin.serverclock;

import hu.hfctechnics.vaadin.serverclock.client.serverclock.ServerClockServerRpc;
import hu.hfctechnics.vaadin.serverclock.client.serverclock.ServerClockState;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ServerClock extends com.vaadin.ui.AbstractComponent {
    
    private final ServerClockServerRpc rpc = new ServerClockServerRpc() {
        private GregorianCalendar cal;
        @Override
        public void getServerTime() {
            cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            getState().time = cal.getTimeInMillis();
        }
    };  

    public ServerClock() {
        registerRpc(rpc);
        rpc.getServerTime();
    }

    @Override
    public ServerClockState getState() {
        return (ServerClockState) super.getState();
    }
}

