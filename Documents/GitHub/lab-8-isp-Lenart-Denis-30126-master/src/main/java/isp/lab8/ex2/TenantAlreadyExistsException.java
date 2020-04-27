package isp.lab8.ex2;

public class TenantAlreadyExistsException extends Exception {

    public TenantAlreadyExistsException() {
    }

    public TenantAlreadyExistsException(String message) {
        super(message);
    }
}
