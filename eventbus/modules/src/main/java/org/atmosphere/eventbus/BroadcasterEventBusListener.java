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

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterListener;
import org.atmosphere.cpr.Deliver;

/**
 * @author Sebastian Lövdahl
 */
public class BroadcasterEventBusListener implements BroadcasterListener {

    private final AtmosphereEventBus atmosphereEventBus;

    public BroadcasterEventBusListener(AtmosphereEventBus atmosphereEventBus) {
        this.atmosphereEventBus = atmosphereEventBus;
    }

    @Override
    public void onPostCreate(Broadcaster broadcaster) {
    }

    @Override
    public void onComplete(Broadcaster broadcaster) {
    }

    @Override
    public void onPreDestroy(Broadcaster broadcaster) {
    }

    @Override
    public void onAddAtmosphereResource(Broadcaster broadcaster, AtmosphereResource resource) {
    }

    @Override
    public void onRemoveAtmosphereResource(Broadcaster broadcaster, AtmosphereResource resource) {
    }

    @Override
    public void onMessage(Broadcaster broadcaster, Deliver deliver) {
    }
}
