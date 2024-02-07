package com.floxcat.hooklinspirer.utils;

import android.os.Environment;

import java.io.File;
import java.util.Random;

public class UtilsForHook {
    private static File Macfile;
    public static File getMacTxtFile() {
        if (Macfile == null) {
            Macfile = new File(Environment.getExternalStorageDirectory(), "mac.txt");
        }
        return Macfile;
    }

    public static String getMacaddres() {
        if(getMacTxtFile().exists()){
            return FileIOUtils.readFile2String(UtilsForHook.getMacTxtFile());
        }else{
            Random random = new Random();
            byte[] mac = new byte[6];
            random.nextBytes(mac);
            mac[0] = (byte) (mac[0]&(byte)254);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++){
                sb.append(String.format("%02X%s",mac[i],(i < mac.length -1 )?":":""));
            }
            FileIOUtils.writeFileFromString(UtilsForHook.getMacTxtFile(), sb.toString());
            return sb.toString();
        }
    }
}
