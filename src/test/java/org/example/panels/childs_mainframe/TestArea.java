package org.example.panels.childs_mainframe;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class TestArea {
    public static void main(String[] args) {
        try {
            String path = "E:\\Razer\\Documents\\TempFolder\\tempfolder2\\samu.yml";
            String[] pathArray = path.split("[\\\\/]");
            System.out.println(pathArray[pathArray.length-1]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
