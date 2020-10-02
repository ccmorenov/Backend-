package com.SE2.EasyPC.logging;

import java.io.FileWriter;
import java.io.IOException;

public class Log {

    public static void createLog(int level, String text) {
        try {
            FileWriter fw = new FileWriter("log.txt");
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
            String message = "" + lvl +", "+ text + "\n";
            fw.write(message);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
