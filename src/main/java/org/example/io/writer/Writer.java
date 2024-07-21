package org.example.io.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Writer {
    private String finalIntegerFileName = "integers.txt";
    private String finalFloatFileName = "floats.txt";
    private String finalStringFileName = "string.txt";
    private List<Long> listIntegers;
    private List<Double> listFloats;
    private List<String> listStrings;
    private String pathToResult;
    private boolean overwritingFiles;

    public Writer(String prefix, String pathToResult, boolean overwritingFiles,
                  List<Long> listIntegers, List<Double> listFloats, List<String> listStrings) {
        if (prefix == null)
            prefix = "";
        this.finalIntegerFileName = prefix + this.finalIntegerFileName;
        this.finalFloatFileName = prefix + this.finalFloatFileName;
        this.finalStringFileName = prefix + this.finalStringFileName;
        this.listIntegers = listIntegers;
        this.listFloats = listFloats;
        this.listStrings = listStrings;
        this.pathToResult = pathToResult;
        this.overwritingFiles = overwritingFiles;
    }
    public void determiningThePathForWritingFiles(){

        Path pathToFileWithIntegers = Paths.get(finalIntegerFileName);
        Path pathToFileWithFloats = Paths.get(finalFloatFileName);
        Path pathToFileWithStrings = Paths.get(finalStringFileName);

        if(pathToResult == null){

            writingToAFile(pathToFileWithIntegers, listIntegers);
            writingToAFile(pathToFileWithFloats, listFloats);
            writingToAFile(pathToFileWithStrings, listStrings);

        }else {
            String[] arrayPath = pathToResult.substring(1).split("\\\\");

            Path absolPath = Paths.get(String.valueOf(pathToFileWithIntegers.toAbsolutePath().getParent()));
            for (String el : arrayPath){
                if(!Files.exists(Path.of(absolPath + "\\" + el))){
                    try {
                        Files.createDirectory(Path.of(absolPath + "\\" + el));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                absolPath = Paths.get(absolPath + "\\" + el);
            }

            writingToAFile(Path.of(absolPath + "\\" + finalIntegerFileName), listIntegers);
            writingToAFile(Path.of(absolPath + "\\" + finalFloatFileName), listFloats);
            writingToAFile(Path.of(absolPath + "\\" + finalStringFileName), listStrings);
        }
    }

    private void writingToAFile(Path path, List list){
        if(isEmptyList(list)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path),
                    overwritingFiles))) {
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i) + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isEmptyList(List list){
        if (list.isEmpty() || list == null) return false;
        return true;
    }
}

