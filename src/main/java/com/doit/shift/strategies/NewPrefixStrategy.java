package com.doit.shift.strategies;

import com.doit.shift.FinalResult;

public class NewPrefixStrategy implements HandeFile{

    private final String prefix;

    public NewPrefixStrategy(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void execute(FinalResult finalResult) {
        String[] default_files = finalResult.getDefault_output_files();
        for (int i = 0; i < default_files.length; i++) {
            default_files[i] = prefix + default_files[i];
        }
    }
}
