package isp.lab8.ex2;

import java.time.Clock;
import java.time.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static isp.lab8.ex2.DoorStatus.CLOSE;


public class DoorLockController implements ControllerInterface {


    private Map<Tenant, AccesKey> validAccess;
    private List<AccessLog> accesLogLst = new LinkedList<>();


    private int VerificareincercariPin = 0;
    Door usa = new Door();

    public DoorLockController(Map<Tenant, AccesKey> validAccess, List<AccessLog> accesLogLst, Door usa) {
        this.validAccess = validAccess;
        this.accesLogLst = accesLogLst;
        this.usa = usa;
    }

    public DoorLockController() {
        this.validAccess = new HashMap<>();
    }


    public DoorStatus enterPin(String pin) throws TooManyAttemptsException, InvalidPinException {
        String errormessage = "";
        String operation = "enterPin";
        usa.lockDoor();
        if (pin == ControllerInterface.MASTER_KEY) {
            if (usa.getDoorstatus() == CLOSE)
                usa.unlockDoor();
            else usa.lockDoor();
            VerificareincercariPin = 0;
            operation = "Master Reset";
        }
        if (validAccess.containsKey(new AccesKey(pin)) == true) {


            if (usa.getDoorstatus() == CLOSE)
                usa.unlockDoor();
            else usa.lockDoor();

        } else {
            errormessage = "Wrong PIN";

            VerificareincercariPin++;/* verificareincercaripin va fi 1*/

            if (VerificareincercariPin >= 3)/* 0,1,2,3 */ {
                errormessage = "Too many attempts";
                throw new TooManyAttemptsException(errormessage);
            }
            if (VerificareincercariPin < 3)
                throw new InvalidPinException(errormessage);
        }

        accesLogLst.add(new AccessLog(validAccess.get(pin).toString(), LocalDateTime.now(), usa.getDoorstatus(), operation, errormessage));

        return null;
    }

    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        String errormessage = "";
        Tenant t = new Tenant(name);

        if (validAccess.containsKey(t)) {
            errormessage = "Tenant already exists";
            throw new TenantAlreadyExistsException(errormessage);
        } else {
            validAccess.put(new Tenant(name), new AccesKey(pin));

        }
        accesLogLst.add(new AccessLog(name, LocalDateTime.now(), usa.getDoorstatus(), "addTenant", errormessage));
    }

    public void removeTenant(String name) throws TenantNotFoundException {
        String errormessage = "";
        if (!(validAccess.containsKey(new Tenant(name)))) {
            errormessage = "Tenant not found";
            throw new TenantNotFoundException(errormessage);
        } else {

            validAccess.remove(new Tenant(name));

        }

        accesLogLst.add(new AccessLog(name, LocalDateTime.now(), usa.getDoorstatus(), "removeTenant", errormessage));
    }

    public List<AccessLog> getAccesLog() {
        return this.accesLogLst;
    }


    public void printlogs() {

        for (AccessLog a : accesLogLst) a.print();
        System.out.println();
    }

    public void mapPrint() {
        System.out.println("Door controler:");
        validAccess.forEach((tenant, accessKey) -> {
            System.out.println("Tenant:" + tenant.getName() + " ;pin:" + accessKey.getPin());
        });
    }


}