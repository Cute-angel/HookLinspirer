package com.floxcat.hooklinspirer.utils;

import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
            mac[0] = (byte) (mac[0] & (byte) 254);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
            }
            FileIOUtils.writeFileFromString(UtilsForHook.getMacTxtFile(), sb.toString());
            return sb.toString();
        }
    }

    public static class Applist {
        private List<ItemApp> itemList;
        private File AppListfile;

        public Applist(String jsonString) throws JSONException {

        }
        public File getAppListFile() {
            if (this.AppListfile == null) {
                this.AppListfile = new File(Environment.getExternalStorageDirectory(),"applist.json");
            }
            return this.AppListfile;
        }

        private void deFormatJson (String jsonString) throws JSONException {
            this.itemList = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ItemApp item = new ItemApp();
                item.setCanuninstall(jsonObject.getBoolean("canuninstall"));
                item.setException_white_url(jsonObject.getInt("exception_white_url"));
                item.setHide_icon_status(jsonObject.getInt("hide_icon_status"));
                item.setId(jsonObject.getLong("id"));
                item.setIs_trust(jsonObject.getBoolean("is_trust"));
                item.setIsforce(jsonObject.getBoolean("isforce"));
                item.setIsnew(jsonObject.getBoolean("isnew"));
                item.setPackagename(jsonObject.getString("packagename"));
                item.setSha1(jsonObject.getString("sha1"));
                item.setStatus(jsonObject.getInt("status"));
                item.setUpdated_at(jsonObject.getString("updated_at"));
                item.setVersioncode(jsonObject.getInt("versioncode"));
                item.setVersionname(jsonObject.getString("versionname"));
                this.itemList.add(item);
            }
        }


        public List<ItemApp> getItemList() {
            return itemList;
        }
    }
}
