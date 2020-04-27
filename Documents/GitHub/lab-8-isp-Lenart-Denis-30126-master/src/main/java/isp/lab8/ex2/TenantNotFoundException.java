package isp.lab8.ex2;

public class TenantNotFoundException extends Exception{

    public TenantNotFoundException() {
    }

    public TenantNotFoundException(String s) {
        System.out.println(s);
    }
}
