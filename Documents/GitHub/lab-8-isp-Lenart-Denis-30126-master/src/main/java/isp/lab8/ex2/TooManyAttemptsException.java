package isp.lab8.ex2;

public class TooManyAttemptsException extends Exception {

    public TooManyAttemptsException(){
        System.out.println("Too many attempts");
    }

    public  TooManyAttemptsException(String s)
    {
        System.out.println(s);
    }
}
