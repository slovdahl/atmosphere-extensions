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

import com.google.common.eventbus.EventBus;
import org.atmosphere.eventbus.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sebastian Lövdahl
 */
public class AtmosphereEventBus {

    private static final Logger logger = LoggerFactory.getLogger(AtmosphereEventBus.class);

    // Used for synchronizing when an instance of this class is created.
    private static final Object instanceLock = new Object();
    private static volatile AtmosphereEventBus instance;

    private final EventBus eventBus;

    /**
     * Gets the singleton instance of the AtmosphereEventBus.
     *
     * @return singleton instance of AtmosphereEventBus.
     */
    public static AtmosphereEventBus getInstance() {
        // This ensures that the volatile field is only accessed once if it's already initialized
        AtmosphereEventBus result = instance;

        if (result == null) {
            synchronized (instanceLock) {
                result = instance;
                if (result == null) {
                    instance = result = new AtmosphereEventBus();
                }
            }
        }

        return result;
    }

    private AtmosphereEventBus() {
        eventBus = new EventBus("AtmosphereEventBus");
    }

    /**
     * Registers all subscriber methods on {@code object} to receive events.
     *
     * @param object object whose subscriber methods should be registered.
     */
    public void register(Object object) {
        if (object != null) {
            eventBus.register(object);
            logger.info("successfully registered " + object.getClass().getSimpleName() + " to atmosphere-eventbus");
        }
    }

    /**
     * Unregisters all subscriber methods on a registered {@code object}.
     *
     * @param object object whose subscriber methods should be unregistered.
     */
    public void unregister(Object object) {
        if (object != null) {
            try {
                eventBus.unregister(object);
                logger.info("successfully unregistered " + object.getClass().getSimpleName() + " from atmosphere-eventbus");
            } catch (IllegalArgumentException e) {
                logger.error("unregister called for object that was not registered in the atmosphere-eventbus: " + e.getMessage());
            }
        }
    }

    /**
     * Posts an event to all registered subscribers.  This method will return
     * successfully after the event has been posted to all subscribers, and
     * regardless of any exceptions thrown by subscribers.
     *
     * @param event event to post.
     */
    public void post(Event event) {
        eventBus.post(event);
    }
}
