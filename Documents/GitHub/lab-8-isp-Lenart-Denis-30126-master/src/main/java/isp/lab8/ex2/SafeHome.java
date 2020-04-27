package isp.lab8.ex2;

public class SafeHome {

    public static void main(String[] args) {
        DoorLockController casa = new DoorLockController();
        AccessLog logs = new AccessLog();
        try {
            casa.addTenant("1234", "Florin");
        } catch (TenantAlreadyExistsException e) {
            System.out.println("You entered an existing tenant");
        }
        try {
            casa.addTenant("1234", "Florin");
        } catch (TenantAlreadyExistsException e) {
            System.out.println("You entered an existing tenant");
        }
        casa.mapPrint();

        try {
            casa.removeTenant("Florin");
        } catch (TenantNotFoundException e) {
            // System.out.println();
        }
        casa.mapPrint();
        // casa.printlogs();

    }
}
