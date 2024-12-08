package com.doit.shift;


import com.doit.shift.strategies.HandeFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinalResult {

    private final String[] input_files;
    private String[] default_output_files = {"integers.txt", "strings.txt", "floats.txt"};
    private String file_path = "./";
    private final List<HandeFile> strategies;
    private final List<Long> found_integers = new ArrayList<>();
    private final List<Float> found_floats = new ArrayList<>();
    private final List<String> found_strings = new ArrayList<>();

    public FinalResult(String[] inputFiles, List<HandeFile> strategies) {
        this.input_files = inputFiles;
        this.strategies = strategies;
    }

    public String[] getDefault_output_files() {
        return default_output_files;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_path() {
        return file_path;
    }

    public List<Float> getFound_floats() {
        return found_floats;
    }

    public List<Long> getFound_integers() {
        return found_integers;
    }

    public List<String> getFound_strings() {
        return found_strings;
    }

    public void start(){
        handle_files();
        for (HandeFile handeFile : strategies) {
            handeFile.execute(this);
        }
    }

    private void handle_files() {
        for (String input_file : input_files) {
            try(BufferedReader br = new BufferedReader(new FileReader(input_file))) {
                while (br.ready()) {
                    String line = br.readLine().trim();
                    if(isInteger(line)) found_integers.add(Long.parseLong(line));
                    else if (isFloat(line)) found_floats.add(Float.parseFloat(line));
                    else found_strings.add(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean isFloat(String line) {
        try {
            Float.parseFloat(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInteger(String line) {
        try {
            Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
