package com.doit.shift.strategies;

import com.doit.shift.FinalResult;

public class CreateShortStatistic implements HandeFile {

    private int count_wrote_elements = 0;

    @Override
    public void execute(FinalResult finalResult) {
        count_wrote_elements = finalResult.getFound_floats().size()
                + finalResult.getFound_integers().size()
                + finalResult.getFound_strings().size();
        print_in_console();
    }
    private void print_in_console(){
        System.out.println("Short statistics:");
        System.out.println("Количество элементов записанных в файл: " + count_wrote_elements);
    }
}
