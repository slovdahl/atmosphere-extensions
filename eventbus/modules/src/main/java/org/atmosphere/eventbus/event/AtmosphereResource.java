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
package org.atmosphere.eventbus.event;

import org.atmosphere.cpr.AtmosphereResourceEvent;

/**
 * @author Sebastian Lövdahl
 */
public abstract class AtmosphereResource extends Event {

    private final AtmosphereResourceEvent atmosphereResourceEvent;

    AtmosphereResource(AtmosphereResourceEvent atmosphereResourceEvent) {
        this.atmosphereResourceEvent = atmosphereResourceEvent;
    }

    /**
     * @return the AtmosphereResourceEvent associated with this event
     */
    public AtmosphereResourceEvent getAtmosphereResourceEvent() {
        return atmosphereResourceEvent;
    }

    public static AtmosphereResource createBroadcast(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceBroadcast(atmosphereResourceEvent);
    }

    public static AtmosphereResource createClose(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceClose(atmosphereResourceEvent);
    }

    public static AtmosphereResource createDisconnect(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceDisconnect(atmosphereResourceEvent);
    }

    public static AtmosphereResource createHeartbeat(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceHeartbeat(atmosphereResourceEvent);
    }

    public static AtmosphereResource createPreSuspend(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourcePreSuspend(atmosphereResourceEvent);
    }

    public static AtmosphereResource createResume(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceResume(atmosphereResourceEvent);
    }

    public static AtmosphereResource createSuspend(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceSuspend(atmosphereResourceEvent);
    }

    public static AtmosphereResource createThrowable(AtmosphereResourceEvent atmosphereResourceEvent) {
        return new AtmosphereResourceThrowable(atmosphereResourceEvent);
    }
}
