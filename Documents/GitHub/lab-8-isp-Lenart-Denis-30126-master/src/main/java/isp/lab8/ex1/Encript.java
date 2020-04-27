package isp.lab8.ex1;


import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

public class Encript {


    /*private String numeFis;

    FileReader inputFileReader;

    public Encript(String numeFis) {
        this.numeFis = numeFis;
    }*/
    FileReader inputFileReader;

    public void encriptare() throws FileNotFoundException, IOException {
        try ( //varianta- try with resources
            final FileReader citire = new FileReader("fisier2.txt.dec");
            final FileWriter scriere = new FileWriter("fisier1.txt.enc");
            ) {//citire date din fisier
            int c;
            while ((c = citire.read()) != -1) {
                c = c - 5;  //shiftare
                scriere.write(c);
            }
        } catch (FileNotFoundException e1) {
            throw new FileNotFoundException("File does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }}}

