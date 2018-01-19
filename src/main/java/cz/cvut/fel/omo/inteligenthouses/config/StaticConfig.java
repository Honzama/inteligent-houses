package cz.cvut.fel.omo.inteligenthouses.config;

import cz.cvut.fel.omo.inteligenthouses.factory.ConsumptionFactory;
import java.net.MalformedURLException;

import cz.cvut.fel.omo.inteligenthouses.factory.DeviceFactory;
import cz.cvut.fel.omo.inteligenthouses.factory.EventFactory;
import cz.cvut.fel.omo.inteligenthouses.factory.SpecimenFactory;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.*;

/**
 *
 * @author macekja7
 */
public class StaticConfig extends Config {

    private static final String BEDROOM = "Bedroom";
    private static final String STORAGE_ROOM = "Storage room";
    private static final String KITCHEN = "Kitchen";
    private static final String BATHROOM = "Bathroom";
    private static final String CORRIDOR = "Corridor";
    private static final String KIDS_ROOM = "Kids room";
    private static final String LIVING_ROOM = "Living room";
    private static final String GUEST_ROOM = "Guest room";
    private static final String SECRET_ROOM = "Secret room";

    private static final String HOUSE_ADDRESS1 = "First House Address";
    private static final String HOUSE_ADDRESS2 = "Second House Address";

    public StaticConfig() {
        super();

        //House
        createFirstHouse(HOUSE_ADDRESS1);
        createSecondHouse(HOUSE_ADDRESS2);
    }

    public void createFirstHouse(String houseAddress) {
        Floor first = new Floor(1);

        first.addRoom(new Room(BEDROOM));
        first.addRoom(new Room(KIDS_ROOM));
        first.addRoom(new Room(STORAGE_ROOM));
        first.addRoom(new Room(KITCHEN));
        first.addRoom(new Room(BATHROOM));
        first.addRoom(new Room(CORRIDOR));
        first.addRoom(new Room(LIVING_ROOM));

        House house = new House(houseAddress);

        house.addFloor(first);

        this.addHouse(house);
    	
        //Machines
        createFridge("Fridge", houseAddress, KITCHEN);
        createFridge("Secret Fridge", houseAddress, BEDROOM);
        createWashingMachine("Washing Machine", houseAddress, BATHROOM);
        createNotebook("Wifes Notebook", houseAddress, BEDROOM);
        createNotebook("Husbands Notebook", houseAddress, BEDROOM);
        createNotebook("Older daughters Notebook", houseAddress, KIDS_ROOM);
        createNotebook("Younger daughters Notebook", houseAddress, KIDS_ROOM);
        createNotebook("Sons Notebook", houseAddress, KIDS_ROOM);
        createNotebook("Grandmas Notebook", houseAddress, KITCHEN);
        createVacuumCleaner("Vacuum Cleaner", houseAddress, CORRIDOR);
        createAirConditioner("Bedroom Air Conditioner", houseAddress, BEDROOM);
        createAirConditioner("Storage room Air Conditioner", houseAddress, STORAGE_ROOM);
        createAirConditioner("Kitchen Air Conditioner", houseAddress, KITCHEN);
        createAirConditioner("Bathroom Air Conditioner", houseAddress, BATHROOM);
        createAirConditioner("Corridor Air Conditioner", houseAddress, CORRIDOR);
        createAirConditioner("Kids room Air Conditioner", houseAddress, KIDS_ROOM);
        createMicrowave("Microwave", houseAddress, KITCHEN);
        createDishWasher("Dish Washer", houseAddress, KITCHEN);
        createKettle("Kettle", houseAddress, KITCHEN);
        createTelevision("Living room Television", houseAddress, LIVING_ROOM);
        createTelevision("Kids room Television", houseAddress, KIDS_ROOM);
        createTelevision("Bedroom Television", houseAddress, BEDROOM);

        //Equipment
        createEquipment("Sons Bike", houseAddress);
        createEquipment("Husbands Bike", houseAddress);
        createEquipment("Skies", houseAddress);

        //People
        createPerson("Husband", houseAddress);
        createPerson("Wife", houseAddress);
        createPerson("Older daughter", houseAddress);
        createPerson("Younger daughter", houseAddress);
        createPerson("Son", houseAddress);
        createPerson("Grandma", houseAddress);

        //Animals
        createAnimal("Dog", houseAddress);
        createAnimal("Cat", houseAddress);
        createAnimal("Hamster", houseAddress);
    }

    public void createSecondHouse(String houseAddress) {
        Floor first = new Floor(1);

        first.addRoom(new Room(BEDROOM));
        first.addRoom(new Room(STORAGE_ROOM));
        first.addRoom(new Room(GUEST_ROOM));
        first.addRoom(new Room(KITCHEN));
        first.addRoom(new Room(BATHROOM));
        first.addRoom(new Room(CORRIDOR));
        first.addRoom(new Room(LIVING_ROOM));
        first.addRoom(new Room(SECRET_ROOM));

        House house = new House(houseAddress);

        house.addFloor(first);

        this.addHouse(house);
    	
        //Machines
        createFridge("Fridge", houseAddress, KITCHEN);
        createFridge("Guest Fridge", houseAddress, GUEST_ROOM);
        createWashingMachine("Washing Machine", houseAddress, BATHROOM);
        createNotebook("Guest Notebook", houseAddress, GUEST_ROOM);
        createVacuumCleaner("Vacuum Cleaner", houseAddress, CORRIDOR);
        createAirConditioner("Bedroom Air Conditioner", houseAddress, BEDROOM);
        createAirConditioner("Storage room Air Conditioner", houseAddress, STORAGE_ROOM);
        createAirConditioner("Kitchen Air Conditioner", houseAddress, KITCHEN);
        createAirConditioner("Bathroom Air Conditioner", houseAddress, BATHROOM);
        createAirConditioner("Corridor Air Conditioner", houseAddress, CORRIDOR);
        createAirConditioner("Guest room Air Conditioner", houseAddress, GUEST_ROOM);
        createMicrowave("Microwave", houseAddress, KITCHEN);
        createDishWasher("Dish Washer", houseAddress, KITCHEN);
        createKettle("Kettle", houseAddress, KITCHEN);
        createTelevision("Living room Television", houseAddress, LIVING_ROOM);
        createTelevision("Bedroom Television", houseAddress, BEDROOM);
        createFridge("Secret Fridge", houseAddress, SECRET_ROOM);
        createWashingMachine("Secret Washing Machine", houseAddress, SECRET_ROOM);
        createNotebook("Secret Notebook", houseAddress, SECRET_ROOM);
        createMicrowave("Secret Microwave", houseAddress, SECRET_ROOM);
        createDishWasher("Secret Dish Washer", houseAddress, SECRET_ROOM);
        createTelevision("Secret Bedroom Television", houseAddress, SECRET_ROOM);

        //Equipment
        createEquipment("Sons Bike", houseAddress);
        createEquipment("Husbands Bike", houseAddress);
        createEquipment("Skies", houseAddress);

        //People
        createPerson("Husband", houseAddress);
        createPerson("Wife", houseAddress);
        createPerson("Guest", houseAddress);
        createPerson("Secret guest", houseAddress);
        createPerson("Grandma", houseAddress);
        createPerson("Grandpa", houseAddress);

        //Animals
        createAnimal("Turtle", houseAddress);
        createAnimal("Snake", houseAddress);
        createAnimal("Baby kangaroo", houseAddress);
    }

    public void createTelevision(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("KD55XE8096", "https://www.sony.co.uk/electronics/support/res/manuals/4684/46845831M.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " KD55XE8096", getHouse(houseAddress), documentation);
            machine.addSensor(DeviceFactory.getInstance().createSensor("Temperature sensor", 25, 18, 45, "°C"));
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(20, 344));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createFridge(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("RB37J5029WW/EF", "http://downloadcenter.samsung.com/content/UM/201611/20161114134507977/DA68-02833J-17.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " RB37J5029WW/EF", getHouse(houseAddress), documentation);
            machine.addSensor(DeviceFactory.getInstance().createSensor("Temperature sensor", 3, 0, 6, "°C"));
            machine.addItem(DeviceFactory.getInstance().createItem("Ice cream"));
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(150, 730));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createWashingMachine(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("WW70K52109W", "http://downloadcenter.samsung.com/content/UM/201709/20170907134701968/WW5600K_DC68-03750C-02_EN_ET_HU_LT_LV.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " WW70K52109W", getHouse(houseAddress), documentation);
            machine.addSensor(DeviceFactory.getInstance().createSensor("Temperature sensor", 30, 30, 90, "°C"));
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(30, 425));
            machine.addConsumption(ConsumptionFactory.getInstance().createWater(0, 40));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createNotebook(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("HP 250 G6", "http://h20195.www2.hp.com/v2/GetDocument.aspx?docname=c05468499&doctype=quickspecs&doclang=EN_US&searchquery=&cc=cz&lc=cs");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " HP 250 G6", getHouse(houseAddress), documentation);
            machine.addSensor(DeviceFactory.getInstance().createSensor("CPU Temperature sensor", 45, 15, 100, "°C"));
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(5, 50));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createVacuumCleaner(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("FC6402", "https://www.download.p4c.philips.com/files/f/fc6401_01/fc6401_01_dfu_ces.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " FC6402", getHouse(houseAddress), documentation);
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(0, 450));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createAirConditioner(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("RAF-25NH5", "http://www.multiklima.cz/wp-content/uploads/File/ke-stazeni/klimatizace-do-bytu/Technische_Katalog-NH5,YH5,G4,QH5-EN.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " RAF-25NH5", getHouse(houseAddress), documentation);
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(0, 114));
            machine.addConsumption(ConsumptionFactory.getInstance().createWater(0, 0.5));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createMicrowave(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("MEE 3150", "http://www.blomberg.cz/productFile/51.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " MEE 3150", getHouse(houseAddress), documentation);
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(25, 1500));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createDishWasher(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("IM690", "http://www.mora.cz/data/zbozi_soubory/dokumenty/IM690cz.PDF");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " IM690", getHouse(houseAddress), documentation);
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(50, 1800));
            machine.addConsumption(ConsumptionFactory.getInstance().createWater(0.5, 12));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createKettle(String name, String houseAddress, String room) {
        try {
            Documentation documentation = DeviceFactory.getInstance().createDocumentation("RK 315x", "https://www.kasa.cz/document/6/2/4/doc_2373426.pdf");
            Machine machine = DeviceFactory.getInstance().createMachine(name + " RK 315x", getHouse(houseAddress), documentation);
            machine.addSensor(DeviceFactory.getInstance().createSensor("Temperature sensor", 20, 0, 100, "°C"));
            machine.addConsumption(ConsumptionFactory.getInstance().createElectricity(1, 190));
            machine.addConsumption(ConsumptionFactory.getInstance().createWater(0, 2));
            getHouse(houseAddress).getRoom(room).addDevice(machine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void createEquipment(String name, String houseAddress) {
        Equipment equipment = DeviceFactory.getInstance().createEquipment(name, getHouse(houseAddress));
        getHouse(houseAddress).getRoom(STORAGE_ROOM).addDevice(equipment);
    }

    public void createPerson(String name, String houseAddress) {
        Person person = SpecimenFactory.getInstance().createPerson(name, getHouse(houseAddress), SpecimenFactory.getInstance().createStrategy(this.getTimeFrame()));
        addSpecimen(person);
        getEventHandlerPool().add(EventFactory.getInstance().createEventHandler());
    }

    public void createAnimal(String name, String houseAddress) {
        Animal animal = SpecimenFactory.getInstance().createAnimal(name, getHouse(houseAddress), SpecimenFactory.getInstance().createStrategy(this.getTimeFrame()));
        addSpecimen(animal);
        getEventHandlerPool().add(EventFactory.getInstance().createEventHandler());
    }
}
