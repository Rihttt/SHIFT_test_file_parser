package ru.riht;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class FileProcess {

    public static Map<DataTypes, List<String>> processFiles(List<String> inputFiles,
                                                            Map<DataTypes, Stats> stats) {

        Map<DataTypes, List<String>> data = new EnumMap<>(DataTypes.class);
        data.put(DataTypes.INTEGER,new ArrayList<>());
        data.put(DataTypes.FLOAT,new ArrayList<>());
        data.put(DataTypes.STRING,new ArrayList<>());

        for (String inputFile : inputFiles) {
            try{
                processSingleFile(Path.of(inputFile),data,stats);
                System.out.println(inputFile + " успешно обработан");
            } catch (IOException e){
                System.err.println("Ошибка чтения файла " + inputFile + ": " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Ошибка при обработке файла " + inputFile + ": " + e.getMessage());
            }
        }

        return data;
    }

    private static void processSingleFile(Path filePath,
                                         Map<DataTypes, List<String>> data,
                                         Map<DataTypes, Stats> stats) throws IOException {

        List<String> lines = Files.readAllLines(filePath);

        for(String line : lines){
            line = line.trim();

            if(line.isEmpty()){
                continue;
            }

            DataTypes type = determineDataType(line);
            data.get(type).add(line);

            switch (type) {
                case INTEGER: stats.get(DataTypes.INTEGER).addInteger(line); break;
                case FLOAT: stats.get(DataTypes.FLOAT).addFloat(line); break;
                case STRING: stats.get(DataTypes.STRING).addString(line); break;
            }
        }
    }

    private static DataTypes determineDataType(String line) {

        try{
            new java.math.BigInteger(line);
            return DataTypes.INTEGER;
        }catch(NumberFormatException e1){
            try{
                if (line.matches ("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")){
                    Double.parseDouble(line);
                    return DataTypes.FLOAT;
                }
            }catch(NumberFormatException e2){}
        }
        return DataTypes.STRING;
    }
}
