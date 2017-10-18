package br.com.dclfactor.utils;

import java.io.*;

public class Commands implements Serializable{

    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;

    public static String copyFileByMsDOS(String file, String dir) {
        String command = "cmd /c copy \"" + file + "\"  \"" + dir + "\" /Y";
        return executeCMD(command);
    }

    public static String executeCMD(String command) {
        try {
            pro = run.exec(command);
            read = new BufferedReader(new InputStreamReader(
                    pro.getInputStream()));
            return read.readLine();
        } catch (Exception e) {
            System.err.println(e);
        }
        return "";
    }

}
