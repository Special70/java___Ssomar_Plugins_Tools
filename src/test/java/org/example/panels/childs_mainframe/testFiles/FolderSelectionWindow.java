package org.example.panels.childs_mainframe.testFiles;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FolderSelectionWindow {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("Selected folder: " + fileChooser.getSelectedFile());
        }
    }
}