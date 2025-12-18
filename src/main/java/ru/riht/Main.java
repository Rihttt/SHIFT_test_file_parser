package ru.riht;

import java.util.List;
import java.util.Map;

// Все sout'ы чисто на время разработки, в финальном коммите уберу
public class Main {

    public static void main(String[] args) {
        try {
            Arguments arguments = ArgumentParser.parse(args);

            Map<DataTypes, List<String>> data =
                    FileProcess.processFiles(arguments.getInputFiles());
            System.out.println("data в мэйне:" + data);

        }catch (IllegalArgumentException e) {
            System.err.println("Ошибка в аргументах: " + e.getMessage());
            System.err.println();
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}