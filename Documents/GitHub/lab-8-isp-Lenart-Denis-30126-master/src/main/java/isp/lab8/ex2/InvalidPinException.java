package isp.lab8.ex2;

public class InvalidPinException extends Exception {
    public InvalidPinException() {

    }


    public InvalidPinException(String s) {
        System.out.println(s);
    }
}
