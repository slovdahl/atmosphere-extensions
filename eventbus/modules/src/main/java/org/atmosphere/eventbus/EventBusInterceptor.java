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

import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.cpr.AtmosphereInterceptor;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.interceptor.InvokationOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This interceptor adds an AtmosphereResourceEventListener for all AtmosphereResources.
 * The event listener posts an event on the event bus for every event in the AtmosphereResourceEventListener.
 *
 * @author Sebastian Lövdahl
 */
public class EventBusInterceptor implements AtmosphereInterceptor, InvokationOrder {

    private static final Logger logger = LoggerFactory.getLogger(EventBusInterceptor.class);
    private static final String EVENTBUS_LISTENER_ADDED = "EVENTBUS_ADDED";
    private static final AtmosphereEventBus atmosphereEventBus = AtmosphereEventBus.getInstance();

    @Override
    public PRIORITY priority() {
        return PRIORITY.BEFORE_DEFAULT;
    }

    @Override
    public void configure(AtmosphereConfig atmosphereConfig) {
    }

    @Override
    public Action inspect(AtmosphereResource resource) {
        AtmosphereRequest atmosphereRequest = AtmosphereResourceImpl.class.cast(resource).getRequest(false);
        if (atmosphereRequest.getAttribute(EVENTBUS_LISTENER_ADDED) == null) {
            atmosphereRequest.setAttribute(EVENTBUS_LISTENER_ADDED, true);
            resource.addEventListener(new AtmosphereResourceEventBusListener(atmosphereEventBus));
            logger.trace("Added eventbus listener to {}", resource.uuid());
        }
        return Action.CONTINUE;
    }

    @Override
    public void postInspect(AtmosphereResource resource) {
    }
}
