package ua.com.alevel.task1;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File> {


    @Override
    public int compare(File left, File right) {
        if (left.isFile() && right.isDirectory()) {
            return 1;
        } else if (right.isFile() && left.isDirectory()) {
            return -1;
        }
        return left.getName().compareTo(right.getName());
    }
}
