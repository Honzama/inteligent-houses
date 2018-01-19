package cz.cvut.fel.omo.inteligenthouses.config;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import cz.cvut.fel.omo.inteligenthouses.factory.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.EventHandlerPool;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.*;

/**
 * Represents a config of the system
 *
 * @author macekja7
 */
public abstract class Config {

    private List<House> houses;
    private List<Specimen> specimens;
    private TimeFrame timeFrame;
    private EventHandlerPool eventHandlerPool;
    private int state;
    private int cycles;
    private Random random;

    /**
     * Creates new Config
     */
    public Config() {
        houses = new ArrayList<House>();
        specimens = new ArrayList<Specimen>();
        PositionFactory.getInstance().getOutside().clear();
        timeFrame = ConfigFactory.getInstance().createTimeFrame(24, TimeUnit.HOURS);
        eventHandlerPool = ObjectPoolFactory.getInstance().createEventHandlerPool(this);
        random = new Random();
    }

    public List<House> getHouses() {
        return houses;
    }

    public List<Specimen> getSpecimens() {
        return specimens;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public EventHandlerPool getEventHandlerPool() {
        return eventHandlerPool;
    }

    public int getState() {
        return state;
    }

    public int getCycles() {
        return cycles;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public void setSpecimens(List<Specimen> specimens) {
        this.specimens = specimens;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public void setEventHandlerPool(EventHandlerPool eventHandlerPool) {
        this.eventHandlerPool = eventHandlerPool;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public boolean addHouse(House house) {
        return this.houses.add(house);
    }

    /**
     *
     * @param specimen
     * @return true (as specified vy Collections.add
     */
    public boolean addSpecimen(Specimen specimen) {
        return this.specimens.add(specimen);
    }

    /**
     *
     * @param house
     * @return <code>true</code> if this list contained the specified element
     */
    public boolean removeHouse(House house) {
        return this.houses.remove(house);
    }

    /**
     *
     * @param specimen
     * @return <code>true</code> if this list contained the specified element
     */
    public boolean removeAnimal(Specimen specimen) {
        return this.specimens.remove(specimen);
    }

    /**
     *
     * @param adress
     * @return desired houser if the house is in the list of houses,
     * <code>null</code> otherwise
     */
    public House getHouse(String adress) {
        for (House house : houses) {
            if (house.getAddress().equals(adress)) {
                return house;
            }
        }
        return null;
    }

    /**
     * Goes to next state if it should be next
     */
    public void nextState() {
        if (timeFrame.getCycle() > (state + 1)) {
            state++;
        } else {
            state = 0;
            cycles++;
        }
    }

    /**
     * Iterates simulation for given number of cycles
     *
     * @param iterator number of iterations
     */
    public void iterateSimulation(int iterator) {
        for (int i = 0; i < iterator; i++) {
            iterateSimulation();
        }
        System.out.println("Simulation is running: " + cycles + " Days and " + state + " Hours");
        System.out.println("Time in simulation is: " + state + " Hours and " + 0 + " minutes");
    }

    /**
     * Iterates simulation for one cycle
     */
    public void iterateSimulation() {
        //update all persons
        specimens.forEach(s -> s.update(1));
        
        houses.forEach(h -> h.getDevices().forEach(d -> d.updateConsumption(1)));

        //send all specimens to outside if they have to
        for(Specimen s : specimens) {
            if (s.getStrategy().isOutside(state)) {
            	if(s instanceof Person) {
            		if (s.getUsing() != null) {
                        s.getUsing().rollbackState();
                    }
                    s.removeUsing();
            	}

                s.setActualPosition(PositionFactory.getInstance().getOutside());
            } else {
            	if(s instanceof Person) {
            		//equip equipment before going outside
                	List<Device> equipment = getEquipmentFromHouse((House)s.getDefaultPosition());
                	equipment = equipment.parallelStream()
                							.filter(e -> e.getUser() == null)
                							.collect(Collectors.toList());
                	if(!equipment.isEmpty()) {
                		Equipment e = (Equipment) getRandomElement(equipment);
                		s.setUsing(e, 12);
                	}
            	}
            	
                s.setActualPosition(s.getDefaultPosition());
            }
        }

        //event handlering
        eventHandlerPool.handleEvents();

        //random events for free persons
        List<Specimen> freePeople = specimens.parallelStream()
                .filter(s -> s instanceof Person)
                .filter(s -> s.getActualPosition() == s.getDefaultPosition())
                .filter(s -> s.getUsing() == null)
                .collect(Collectors.toList());
        if (!freePeople.isEmpty()) {
            Specimen s = getRandomElement(freePeople);
            eventHandlerPool.handle(EventFactory.getInstance().createInfo(s, getRandomMachine((House) s.getActualPosition())));
        }

        //random alert events
        eventHandlerPool.handle(EventFactory.getInstance().createAlert(getRandomMachine(getRandomHouse())));

        //next state
        nextState();
    }

    /**
     *
     * @param <T> 
     * @param list list of elements 
     * @return random element from given list
     */
    public <T> T getRandomElement(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    public House getRandomHouse() {
        return getRandomElement(houses);
    }
    
    public Room getRandomRoom(House h) {
        return getRandomElement(h.getRooms());
    }

    public Device getRandomDevice(House h) {
        return getRandomElement(h.getDevices());
    }

    public Device getRandomMachine(House h) {
        List<Device> machines = h.getDevices().parallelStream()
                .filter(s -> s instanceof Machine)
                .collect(Collectors.toList());
        return getRandomElement(machines);
    }
    
    public List<Device> getAllDevices() {
    	List<Device> devices = new ArrayList<>();
    	houses.forEach(h -> devices.addAll(h.getDevices()));
    	return devices;
    }
    
    public Device getRandomEquipment(House h) {
        List<Device> equipment = h.getDevices().parallelStream()
                .filter(s -> s instanceof Equipment)
                .collect(Collectors.toList());
        return getRandomElement(equipment);
    }
    
    public List<Device> getEquipmentFromHouse(House h) {
    	List<Device> equipment = h.getDevices().parallelStream()
    			.filter(d -> d instanceof Equipment)
    			.filter(d -> d.getPosition() == h)
    			.collect(Collectors.toList());
    	return equipment;
    }
    
    public Specimen getRandomSpecimen() {
        return getRandomElement(specimens);
    }

    public Specimen getRandomPerson() {
        List<Specimen> people = specimens.parallelStream()
                .filter(s -> s instanceof Person)
                .collect(Collectors.toList());
        return getRandomElement(people);
    }

    public List<Specimen> getPeopleFromHouse(House h) {
        List<Specimen> people = specimens.parallelStream()
                .filter(s -> s instanceof Person)
                .filter(s -> s.getActualPosition() == h)
                .collect(Collectors.toList());
        return people;
    }
    
    public Specimen getRandomAnimal() {
        List<Specimen> animals = specimens.parallelStream()
                .filter(s -> s instanceof Animal)
                .collect(Collectors.toList());
        return getRandomElement(animals);
    }
}
