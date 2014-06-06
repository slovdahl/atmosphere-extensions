/*
 * Copyright 2014 Sebastian Lövdahl
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.eventbus;

import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.eventbus.event.AtmosphereResource;
import org.atmosphere.eventbus.event.WebSocket;
import org.atmosphere.websocket.WebSocketEventListener;

/**
 * @author Sebastian Lövdahl
 */
public class WebSocketEventBusListener implements WebSocketEventListener {

    private final AtmosphereEventBus atmosphereEventBus;

    public WebSocketEventBusListener(AtmosphereEventBus atmosphereEventBus) {
        this.atmosphereEventBus = atmosphereEventBus;
    }

    @Override
    public void onHandshake(WebSocketEvent webSocketEvent) {
        atmosphereEventBus.post(WebSocket.createHandshake(webSocketEvent));
    }

    @Override
    public void onMessage(WebSocketEvent webSocketEvent) {
        atmosphereEventBus.post(WebSocket.createMessage(webSocketEvent));
    }

    @Override
    public void onClose(WebSocketEvent webSocketEvent) {
        atmosphereEventBus.post(WebSocket.createClose(webSocketEvent));
    }

    @Override
    public void onControl(WebSocketEvent webSocketEvent) {
        atmosphereEventBus.post(WebSocket.createControl(webSocketEvent));
    }

    @Override
    public void onDisconnect(WebSocketEvent webSocketEvent) {
        atmosphereEventBus.post(WebSocket.createDisconnect(webSocketEvent));
    }

    @Override
    public void onConnect(WebSocketEvent webSocketEvent) {
        atmosphereEventBus.post(WebSocket.createConnect(webSocketEvent));
    }

    @Override
    public void onPreSuspend(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createPreSuspend(atmosphereResourceEvent));
    }

    @Override
    public void onSuspend(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createSuspend(atmosphereResourceEvent));
    }

    @Override
    public void onResume(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createResume(atmosphereResourceEvent));
    }

    @Override
    public void onDisconnect(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createDisconnect(atmosphereResourceEvent));
    }

    @Override
    public void onBroadcast(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createBroadcast(atmosphereResourceEvent));
    }

    @Override
    public void onThrowable(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createThrowable(atmosphereResourceEvent));
    }

    @Override
    public void onClose(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createClose(atmosphereResourceEvent));
    }

    @Override
    public void onHeartbeat(AtmosphereResourceEvent atmosphereResourceEvent) {
        atmosphereEventBus.post(AtmosphereResource.createHeartbeat(atmosphereResourceEvent));
    }
}
