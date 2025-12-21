package ru.riht;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

public class OutputWriter {
    public static void writeData(Map<DataTypes, List<String>> data,
                                 Arguments arguments) throws IOException {
        if(!arguments.getOutputPath().toString().equals(".")){
            Files.createDirectories(arguments.getOutputPath());
        }

        StandardOpenOption writeMode = arguments.isAppendMode() ?
                StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING;

        if (!data.get(DataTypes.INTEGER).isEmpty()) {
            Path intFile = arguments.getOutputPath()
                    .resolve(arguments.getPrefix() + "integers.txt");
            writeToFile(intFile, data.get(DataTypes.INTEGER), writeMode);
        }

        if (!data.get(DataTypes.FLOAT).isEmpty()) {
            Path floatFile = arguments.getOutputPath()
                    .resolve(arguments.getPrefix() + "floats.txt");
            writeToFile(floatFile, data.get(DataTypes.FLOAT), writeMode);
        }

        if (!data.get(DataTypes.STRING).isEmpty()) {
            Path stringFile = arguments.getOutputPath()
                    .resolve(arguments.getPrefix() + "strings.txt");
            writeToFile(stringFile, data.get(DataTypes.STRING), writeMode);
        }
    }

    private static void writeToFile(Path file, List<String> data,
                                   StandardOpenOption writeMode) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file,
                writeMode,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

}
