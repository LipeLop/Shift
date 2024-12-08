package com.doit.shift;


import com.doit.shift.strategies.*;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {


    @ShellMethod("Save integers, strings, floats in files: integers.txt, strings.txt, floats.txt.")
    public void filter_files(
            @ShellOption(value = "--files", help = "files to filter") String[] files,
            @ShellOption(value = "-o", defaultValue = "", help = "Output directory to save files") String outputDirectory,
            @ShellOption(value = "-p", defaultValue = "", help = "Prefix for output files") String prefix,
            @ShellOption(value = "-s", defaultValue = "false", help = "Short statistic") boolean short_statistic,
            @ShellOption(value = "-f", defaultValue = "false", help = "Full statistic") boolean full_statistic,
            @ShellOption(value = "-a", defaultValue = "false", help = "Save result of filter in created files") boolean saveInCreated){
        UsersInput usersInput = new UsersInput(outputDirectory, prefix, short_statistic, full_statistic, saveInCreated);
        HandleInput handleInput = new HandleInput(usersInput);
        FinalResult finalResult = new FinalResult(files, handleInput.create_way_of_strategy());
        finalResult.start();
    }
}
