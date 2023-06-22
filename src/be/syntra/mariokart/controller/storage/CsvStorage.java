package be.syntra.mariokart.controller.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvStorage {
    private File csvFile = new File("topscores.csv");

    private PrintWriter out;


            //new PrintWriter(csvFile);

   // out = new PrintWriter(csvFile);
/*
    {
        try {
            out = new PrintWriter(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

 */


}
