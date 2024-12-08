package com.doit.shift.strategies;

import com.doit.shift.FinalResult;

public class ChangeFilePathStrategy implements HandeFile{

    private final String filePath;

    public ChangeFilePathStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute(FinalResult finalResult) {
        if (filePath.endsWith("/")){
            finalResult.setFile_path(filePath);
        } else {
            finalResult.setFile_path(filePath+"/");
        }
    }
}
