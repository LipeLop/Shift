package com.doit.shift.strategies;

import com.doit.shift.FinalResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DefaultSaveStrategy implements HandeFile {

    @Override
    public void execute(FinalResult finalResult) {
        write_elements_in_file(finalResult.getFile_path() + finalResult.getDefault_output_files()[0], finalResult.getFound_integers());
        write_elements_in_file(finalResult.getFile_path() + finalResult.getDefault_output_files()[1], finalResult.getFound_strings());
        write_elements_in_file(finalResult.getFile_path() + finalResult.getDefault_output_files()[2], finalResult.getFound_floats());
    }

    public <T> void write_elements_in_file(String file_path, List<T> elements) {
        if (elements.isEmpty()) {return;}
        File file = new File(file_path);
        if (file.exists()) {
            file.delete();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (T element : elements) {
                writer.write(element.toString());
                writer.newLine();
            }
            System.out.println("Данные записаны в " + file_path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
