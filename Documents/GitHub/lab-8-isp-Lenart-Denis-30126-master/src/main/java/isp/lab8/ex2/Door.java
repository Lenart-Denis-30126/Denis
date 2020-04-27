package isp.lab8.ex2;

import static isp.lab8.ex2.DoorStatus.*;

public class Door {

    private DoorStatus doorstatus = CLOSE;

    public Door() {

    }

    public Door(DoorStatus doorstatus) {
        this.doorstatus = doorstatus;
    }

    public void lockDoor() {

        doorstatus = CLOSE;
    }

    public void unlockDoor() {

        doorstatus = OPEN;
    }

    public DoorStatus getDoorstatus() {
        return doorstatus;
    }

    public void setDoorstatus(DoorStatus doorstatus) {
        this.doorstatus = doorstatus;
    }

}
