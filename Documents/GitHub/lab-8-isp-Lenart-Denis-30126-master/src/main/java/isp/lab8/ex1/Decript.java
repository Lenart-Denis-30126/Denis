package isp.lab8.ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Decript {


    public Decript(String numefis) {
        this.numefis = numefis;
    }


    private String numefis;

//nuy stiu sigur daca e corecta rezolvarea, nu reusesc sa testez metoda din cauza erorii de la linia 34, am incercat sa fac metoda "decriptare" statica, dar intra in conflict cu stringbuilder ul
//
    StringBuilder sb = new StringBuilder();

    public Decript() {

    }

    public void decriptare() throws FileNotFoundException, IOException {
        try (       //varianta- try with resources
                final FileReader citire = new FileReader("fisier1.txt.enc");
                final FileWriter scriere = new FileWriter("text.txt");
        ) {//citire date din fisier
            int c;
            while ((c = citire.read()) != -1) {//non-static method read() cannot be referenced from a static context?
                sb.append(c); // Appends characters one by one
                String string = sb.toString();//conversie string
                scriere.write(string);//scriere in fisier
            }
        } catch (FileNotFoundException e1) {
            throw new FileNotFoundException("File does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /* try{
        File myObj=new File("fisier1.txt.enc" );
        File myObj2=new File("Fisier2.txt.dec");
      try {
     File myObj=new File("fisier1.txt.enc" );
        final FileWriter scriere = new FileWriter("text.txt");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String str = myReader.nextLine();
        String str = sb.toString();
       scriere.write(str);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decript decript = (Decript) o;
        return Objects.equals(numefis, decript.numefis) &&
                Objects.equals(sb, decript.sb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numefis, sb);
    }

}
