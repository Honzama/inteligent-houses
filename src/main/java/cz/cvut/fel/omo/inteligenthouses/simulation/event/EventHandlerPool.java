package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.config.Config;

/**
 * Represents a pool of <code>EventHandler</code>
 *
 * @author macekja7
 */
public class EventHandlerPool extends ObjectPool<EventHandler> {

    private static EventHandlerPool instance;
    private List<EventHandler> eventHandlers;
    private List<Event> events;
    private List<Event> historyEvents;
    private Config config;

    /**
     * Creates new EventHandlerPool
     */
    public EventHandlerPool() {
        eventHandlers = new ArrayList<EventHandler>();
        events = new ArrayList<Event>();
        historyEvents = new ArrayList<Event>();
    }

    public List<EventHandler> getEventHandlers() {
        return eventHandlers;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> getHistoryEvents() {
        return historyEvents;
    }

    public Config getConfig() {
        return config;
    }

    public void setEventHandlers(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setHistoryEvents(List<Event> historyEvents) {
        this.historyEvents = historyEvents;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public void add(EventHandler eventHandler) {
        this.eventHandlers.add(eventHandler);
    }

    public void remove(EventHandler eventHandler) {
        this.eventHandlers.remove(eventHandler);
    }

    /**
     * Adds event to a list of events
     *
     * @param event event to be handled
     */
    public void handle(Event event) {
        this.events.add(event);
    }

    /**
     * Handles events in the list of events
     */
    public void handleEvents() {
        for (EventHandler eHandler : eventHandlers) {
            if (!events.isEmpty()) {
                Event event = events.get(0);
                //System.out.println("Handle on 0 position before: "+event);
                if (eHandler.handleEvent(event, config)) {
                    events.remove(event);
                    event.setCycles(config.getCycles());
                    event.setState(config.getState());
                    historyEvents.add(event);
                    //if (!events.isEmpty()) System.out.println("Handle on 0 position after"+ ": "+events.get(0));
                }
            }
        }
    }

    public static EventHandlerPool getInstance() {
        if (instance == null) {
            instance = new EventHandlerPool();
        }
        return instance;
    }
}
