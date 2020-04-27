package isp.lab8.ex1;

public class FileNotExistException extends Exception {

    public FileNotExistException(String message) {
        super(message);
    }

    public FileNotExistException() {
    }
}
