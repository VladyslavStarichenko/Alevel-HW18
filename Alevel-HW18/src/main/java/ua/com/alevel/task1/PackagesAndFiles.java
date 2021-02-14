package ua.com.alevel.task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PackagesAndFiles {
    public static void main(String[] args) {
        File treeBuilding = new File("C://Users//Влад//IdeaProjects//Alevel-HW18//src");
        String prefix = "   ";
        LinkedList<File> files = createSortedFileList(treeBuilding);
        explore(files, prefix);

    }
    private static LinkedList<File> createSortedFileList(File file) {
        LinkedList<File> files = new LinkedList<>(Arrays.asList(file.listFiles()));
        files.sort(new FileComparator());

        return files;
    }

    private static void explore(LinkedList<File> files, String prefix) {
        for(int i = 0; i < files.size();i++){
            if (files.get(i).isFile()) {
                System.out.println(prefix + prefix + files.get(i).getName());
            } else {
                System.out.println(prefix + "*" + files.get(i).getName());
                files.addAll(createSortedFileList(files.get(i)));
            }
        }
    }

    /*I've  been explaining this algorithm during class, In a nutshell,
     I've tried to use four lists (for ours all files from the directory,
     for counters that counts amount of files those are contained in parent directory,
     list for directories and list for files of particular directory, dividing them by counter.
     This algorithm I realised in the method named "fileDeepSearch", but can't got the reason it doesn't work.
      Coul'd you please check it out*/

//    public static void main(String[] args) {
//        //        String strFormat = "-->";
//////        List<File> files = createSortedList(treeBuilding);
////        List<File> files = Arrays.asList(treeBuilding.listFiles());
////        List<File> fileList = new ArrayList<>();
////        List<Integer> counterList = new ArrayList<>();
////        List<File> dir = new ArrayList<>();
////
////        printTree(fileDeepSearch(fileList, counterList, dir, files),strFormat);
//    }
//    private static List<File> createSortedList(File file) {
//        List<File> files = Arrays.asList(file.listFiles());
//        files.sort(new FileComparator());
//        return files;
//    }

//    public static List<List<?>> fileDeepSearch(List<File> fileList, List<Integer> counterList, List<File> dir, List<File> files) {
//        Integer counter = 0;
//        List<List<?>> listOfLists = new ArrayList<>();
//        for (File file : fileList) {
//            if (file.isFile()) {
//                files.add(file);
//                counter++;
//            } else if (file.isDirectory()) {
//                dir.add(file);
//                counterList.add(counter);
//                counter = 0;
//                fileDeepSearch(dir, counterList, dir, files);
//            }
//        }
//        listOfLists.add(dir);
//        listOfLists.add(fileList);
//        listOfLists.add(counterList);
//        return listOfLists;
//    }
//
//    //    public static  void printTree(List<Integer> counterList, List<File> dir, List<File> fileList, String strFormat){
////
////        for(int i = 0; i < dir.size(); i++){
////            System.out.println(dir.get(i).getName() + strFormat);
////            for(int j = 0; j < counterList.size(); j ++ ){
////                int countPrint = counterList.get(j);
////                for (int k = 0; k < countPrint; k ++){
////                    System.out.println(fileList.get(k).getName());
////                }
////            }
////        }
////
////    }
//    public static void printTree(List<List<?>> listOFLists, String strFormat) {
//        List<Integer> counterList = (List<Integer>) listOFLists.get(2);
//        List<File> dir = (List<File>) listOFLists.get(0);
//        List<File> fileList = (List<File>) listOFLists.get(1);
//        for (int i = 0; i < dir.size(); i++) {
//            System.out.println(dir.get(i).getName() + strFormat);
//            for (int j = 0; j < counterList.size(); j++) {
//                int countPrint = counterList.get(j);
//                for (int k = 0; k < countPrint; k++) {
//                    System.out.println(fileList.get(k).getName());
//                }
//            }
//        }
//
//    }

}
