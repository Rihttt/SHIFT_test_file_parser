package ru.riht;

import java.io.IOException;
import java.util.List;

import java.util.Map;

public class Main {

    public static void main(String[] args){
        try {
            Arguments arguments = ArgumentParser.parse(args);

            Map<DataTypes, Stats> stats = StatsCollector.createStats();

            Map<DataTypes, List<String>> data =
                    FileProcess.processFiles(arguments.getInputFiles(),stats);

            OutputWriter.writeData(data,arguments);

            StatsPrinter.printStats(stats,arguments);

        }catch (IllegalArgumentException e) {
            System.err.println("Ошибка в аргументах: " + e.getMessage());
            System.err.println();
            System.exit(1);
        }catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}