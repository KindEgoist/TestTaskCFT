package org.example.io.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private List<String> dataList = new ArrayList<>();

    public void readFiles(List<String> inputFileNames) {
        try {
            List<String> tmpList;
            for (String el : inputFileNames){
                    if (dataList.isEmpty() || dataList == null) {
                        dataList = Files.readAllLines(Path.of(el));
                    } else {
                        tmpList = Files.readAllLines(Path.of(el));
                        dataList.addAll(tmpList);
                }
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());;
        }
    }
    public List<String> getDataList() {
        return dataList;
    }

}
