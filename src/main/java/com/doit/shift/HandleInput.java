package com.doit.shift;

import com.doit.shift.strategies.*;

import java.util.ArrayList;
import java.util.List;

public class HandleInput {

    private final UsersInput usersInput;

    public HandleInput(UsersInput usersInput) {
        this.usersInput = usersInput;
    }

    public List<HandeFile> create_way_of_strategy() {
        List<HandeFile> way_of_strategy = new ArrayList<>();
        change_file_path(way_of_strategy);
        change_prefix_output_files(way_of_strategy);
        create_short_statistics(way_of_strategy);
        create_full_statistics(way_of_strategy);
        change_way_to_save(way_of_strategy);
        return way_of_strategy;
    }

    private void change_file_path(List<HandeFile> way_of_strategy) {
        try {
            if (!usersInput.outputDirectory().isEmpty())
                way_of_strategy.add(new ChangeFilePathStrategy(usersInput.outputDirectory()));
        } catch (NullPointerException e) {
            System.out.println("Не введена директория вывода. Она будет стандартной");
        }
    }

    private void change_prefix_output_files(List<HandeFile> way_of_strategy) {
        try {
            if (!usersInput.prefix().isEmpty()) way_of_strategy.add(new NewPrefixStrategy(usersInput.prefix()));
        } catch (NullPointerException e) {
            System.out.println("Не введен префикс. Он будет стандартным");
        }
    }

    private void create_short_statistics(List<HandeFile> way_of_strategy) {
        if (usersInput.short_statistic()) way_of_strategy.add(new CreateShortStatistic());
    }

    private void create_full_statistics(List<HandeFile> way_of_strategy) {
        if (usersInput.full_statistic()) way_of_strategy.add(new CreateFullStatistic());
    }

    private void change_way_to_save(List<HandeFile> way_of_strategy) {
        if (usersInput.saveInCreated()) {
            way_of_strategy.add(new SaveInCreatedFilesStrategy());
        } else {
            way_of_strategy.add(new DefaultSaveStrategy());
        }
    }
}
