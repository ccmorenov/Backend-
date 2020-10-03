package com.SE2.EasyPC.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Log {

    public static void createLog(int level, String text) {
        
        File file = new File("C:\\Users\\Public\\Documents\\logs\\"+LocalDate.now()+".txt");
        try {
            file.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            String lvl = "";
            switch(level){
                case 0:
                    lvl = "Trace";
                    break;
                case 1:
                    lvl = "Debug";
                    break;
                case 2:
                    lvl = "Information";
                    break;
                case 3:
                    lvl = "Warning";
                    break;
                case 4:
                    lvl = "Error";
                    break;
                case 5:
                    lvl = "Critical";
                    break;
            }
            String message = LocalDate.now() + " " + LocalTime.now() + " (" + lvl +") "+ text + "\n";
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
