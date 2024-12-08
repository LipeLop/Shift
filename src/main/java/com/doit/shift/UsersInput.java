package com.doit.shift;

public record UsersInput(String outputDirectory,
                         String prefix,
                         boolean short_statistic,
                         boolean full_statistic,
                         boolean saveInCreated) {

}
