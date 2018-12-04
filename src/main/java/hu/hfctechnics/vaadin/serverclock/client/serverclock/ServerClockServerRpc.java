package hu.hfctechnics.vaadin.serverclock.client.serverclock;

import com.vaadin.shared.communication.ServerRpc;

public interface ServerClockServerRpc extends ServerRpc {

    public void getServerTime();
}
