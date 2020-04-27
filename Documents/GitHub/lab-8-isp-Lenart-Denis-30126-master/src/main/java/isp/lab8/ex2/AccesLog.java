package isp.lab8.ex2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

class AccessLog implements Serializable {
//nu am reusit sa fac ex2, in schimb chiar si daca deadline ul este trecut voi face un push ulterior cu exercitiul rezolvat(am copiat saptamanile trecute tema cu lab7 de la colegi, deoarecee nu am avut timp, am avut probleme serioase in familie, dar cel mai important pt mine e ca acum totul e ok) si am avut destul de mult de recuperat vacanta asta, am refacut/si parcurs toate laboratoarele singur-Imi pare rau, nu se va mai repeta!)
//si imi pare rau pentru push ul acela de la laboratorul 7, am fost pus pe piazza ca si contra exemplu. Imi pare rau, nu se va mai repeta.. (:
    String tenantName;
    LocalDateTime DateTime;
    DoorStatus DoorStatus;
    String operation;
    String errormessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, DoorStatus doorStatus, String operation, String errormessage) {
        this.tenantName = tenantName;
        DateTime = dateTime;
        DoorStatus = doorStatus;
        this.operation = operation;
        this.errormessage = errormessage;
    }

    public AccessLog() {

    }
    public void print(){
        System.out.println(tenantName  +"         "+   DateTime.toString()  + "        "  + DoorStatus + "    " + operation +"    "+ errormessage);
    }
}
