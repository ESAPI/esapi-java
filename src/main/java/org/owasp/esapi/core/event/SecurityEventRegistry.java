package org.owasp.esapi.core.event;

public interface SecurityEventRegistry {

    /**
     * Subscribes to listen for {@link SecurityEvent}s specified by the passed in type.
     *
     * @param eventType The type of event this listener subscribes to.
     * @param subscriber The suscriber that is to be notified when the specified event is raised.
     * @param <T> The type of listener - implied by the subscriber parameter.
     */
    <T extends SecurityEventListener> void subscribe(Class<? extends SecurityEvent> eventType, T subscriber);

    /**
     * Removes a subscriber from the registry.
     *
     * @param subscriber The subscriber wishing to be removed
     * @param <T> The type of listener - implied by the subscriber parameter
     */
    <T extends SecurityEventListener> void unsubscribe(T subscriber);

    /**
     * Raises the event which notifies all subscribers to the event type that the event has been fired and invokes the
     * {@link SecurityEventListener#onSecurityEvent(SecurityEvent, Object)} method passing in the event and context
     * supplied to this method.
     *
     * @param event The event being raised.
     * @param context
     * @param <T>
     * @param <C>
     */
    <T extends SecurityEvent, C> void raise(T event, C context);
}
