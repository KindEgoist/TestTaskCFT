package org.example;

import org.example.service.ControlCenter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class KeyController {

    private ControlCenter сontrolСenter = new ControlCenter();
    private List<String> inputFileNames = new ArrayList<>();

    void keyAnalysis(String[] args) {
        boolean Flag = true;

        if (args.length >= 2) {

            for (int i = 0; i < args.length && Flag; i++){
                if (args[i].equals("-o")) {
                        i++;
                        if (args[i].matches("(\\\\([\\w]+([^*|/:\"<>?]*)))*")){
                        сontrolСenter.setPathToResult(args[i]);
                    }
                        else {System.out.println("Некоректный путь для сохранения результата");
                        Flag = false;
                        }
                } else if (args[i].equals("-p")) {
                    i++;
                    if (args[i].matches("([\\w]+([^*|/:\"<>?]*))")){
                        сontrolСenter.setPrefix(args[i]);
                    }
                    else {
                        System.out.println("Некоректный имя префикса");
                        Flag = false;
                    }
                } else if (args[i].equals("-a")) {
                    сontrolСenter.setOverwritingFiles(true);
                } else if (args[i].equals("-s") || args[i].equals("-f")) {
                    if (args[i].equals("-f")) {
                        сontrolСenter.setStatistics(true);
                    }
                } else if (args[i].endsWith(".txt")){
                    if (isExistsFile(args[i]))
                    {
                        if (isEmptyFile(args[i])){
                            inputFileNames.add(args[i]);
                        }
                        else {
                            System.out.println("Файл " + args[i] + " не содержит данных");
                            Flag = false;
                        }
                    }
                    else {
                        System.out.println("Файла " + args[i] + " не существует" );
                        Flag = false;
                    }
                }
                else {
                    System.out.println("Некоректный ввод параметров");
                    Flag = false;
                }
            }
        }
        else{
            System.out.println("Некорректное количество параметров!");
        }
        if (Flag){
            if (inputFileNames.isEmpty() || inputFileNames == null) {System.out.println("Нет входных данных!");}
            else {
                сontrolСenter.setInputFileNames(inputFileNames);
                сontrolСenter.programLaunch();
            }
        }
    }
    private boolean isExistsFile(String str) {
        if (Files.exists(Path.of(str))) return true;
        return false;
    }
    private boolean isEmptyFile(String str){
        if (new File(str).length() == 0) return false;
        return true;
    }
}
