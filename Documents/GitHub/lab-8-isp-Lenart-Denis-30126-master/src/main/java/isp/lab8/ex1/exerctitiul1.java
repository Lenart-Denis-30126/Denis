package isp.lab8.ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class exerctitiul1 {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            Encript fis = new Encript();
            fis.encriptare();
        }
        else {
                Decript fis1=new Decript();
                fis1.decriptare();
        }

    }
}




