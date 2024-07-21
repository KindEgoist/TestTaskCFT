package org.example.service;

import org.example.io.reader.Reader;
import org.example.io.writer.Writer;
import java.util.ArrayList;
import java.util.List;

public class ControlCenter {

    private String prefix;
    private boolean statistics;
    private List<String> inputFileNames = new ArrayList<>();
    private String pathToResult;
    private boolean overwritingFiles;
    Reader reader = new Reader();
    Sort sort = new Sort();

    public void programLaunch(){
        reader.readFiles(inputFileNames);
        sort.assort(reader.getDataList());
        new Info(sort.getListIntegers(), sort.getListFloats(), sort.getListStrings())
                    .selectingStatisticsType(statistics);
        new Writer(prefix, pathToResult, overwritingFiles,
                    sort.getListIntegers(), sort.getListFloats(), sort.getListStrings())
                    .determiningThePathForWritingFiles();
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public void setStatistics(boolean statistics) {
        this.statistics = statistics;
    }
    public void setInputFileNames(List<String> inputFileNames) {
        this.inputFileNames = inputFileNames;
    }
    public void setPathToResult(String pathToResult) { this.pathToResult = pathToResult; }
    public void setOverwritingFiles(boolean overwritingFiles) { this.overwritingFiles = overwritingFiles; }
}
