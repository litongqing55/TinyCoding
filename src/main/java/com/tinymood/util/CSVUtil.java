package com.tinymood.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by 哓哓 on 2016/1/14 0014.
 */
public class CSVUtil {

	public static void main(String[] args) {
		File file = new File("D:/New/aa.csv");
		String fileId = format(core(file, "01.01_计算机基础(计算机概述)"));
		System.out.println(fileId);
	}
	
    public static String format(String str) {
        String regex = "[\\s\"]+";
        String res = str.replaceAll(regex, "");

        return res;
    }

    public static String core(File file, String srcTitle) {
        String fileId = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] res = line.split(",");
                String targetTitle = res[1];
                fileId = res[0];
                if (targetTitle.equals(srcTitle)) {
                    break;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileId;
    }
}
