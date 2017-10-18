/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.dclfactor.models.QuantImeiByPost;
import br.com.dclfactor.models.gbr.GbrPost;
import java.io.Serializable;

/**
 *
 * @author LimaD01
 */
public class HDTFileReader implements Serializable {

    public static List<QuantImeiByPost> getQuantImeiByPosts(List<GbrPost> posts) {
        List<QuantImeiByPost> list = new ArrayList<>();
        posts.forEach((post) -> {
            String path = "//" + post.getNome() + "/d$/HDT/IMEI/Delivery/";
            list.add(new QuantImeiByPost(post.getNome(), getDiffFromFile(path)));
        });
        return list;
    }

    public static long getDiffFromFile(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            return readModelDir(dir);
        }
        return 0;
    }

    private static int readModelDir(File dir) {
        for (File subDir : dir.listFiles()) {
            File monitorDir = FileUtil.mkDir(subDir.getAbsolutePath() + "/monitor");
            if (subDir.isDirectory()) {
                return readMonitorDir(subDir, monitorDir);
            }
        }
        return 0;
    }

    private static int readMonitorDir(File subDir, File monitorDir) {
        for (File dir : subDir.listFiles()) {
            copyIMI(dir, monitorDir.getAbsolutePath());
        }
        return findImiFile(monitorDir);
    }

    private static void copyIMI(File file, String dir) {
        if (file.isFile() && file.getName().contains(".imi")) {
            Commands.copyFileByMsDOS(file.getAbsolutePath(), dir);
        }
    }

    private static int findImiFile(File monitorDir) {
        for (File fileIMI : monitorDir.listFiles()) {
            String name = fileIMI.getName();
            if (name.contains(".imi")) {
                return HDTFileReader.readFile(fileIMI);
            }
        }
        return 0;
    }

    private static int readFile(File path) {
        if (path.getName().contains(".ini")) {
            return readIniFile(path);
        } else {
            return readImiFile(path);
        }
    }

    private static int readIniFile(File path) {
        List<String> archive = FileUtil.readFile(path);
        String line8Ini = archive.get(8);
        String line20Ini = archive.get(20);
        int max = Integer.parseInt(line8Ini.split(" = ")[1].trim());
        int cur = Integer.parseInt(line20Ini.split(" = ")[1].trim());
        return max - cur;
    }

    private static int readImiFile(File path) {
        List<String> lines = FileUtil.readFile(path);
        if (!lines.isEmpty() && lines.size() > 4) {
            String line4 = lines.get(4);
            String line10 = lines.get(10);
            int current = Integer.parseInt(line4.split(" = ")[1].trim());
            int end = Integer.parseInt(line10.split(" = ")[1].trim());
            return end - current;
        }
        return 0;
    }

}
