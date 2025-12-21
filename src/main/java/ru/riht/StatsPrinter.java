package ru.riht;


import java.math.RoundingMode;
import java.util.Map;

public class StatsPrinter {

    public static void printStats(Map<DataTypes,Stats> stats, Arguments args) {

        if(args.isFullStats()){
            printFullStats(stats);
        }else if (args.isShortStats()){
            printShortStats(stats);
        }else{
            printShortStats(stats);
        }
    }

    private static void printShortStats(Map<DataTypes,Stats> stats) {
        System.out.println("Краткая статистика:" +
                "\n Целые числа: " + stats.get(DataTypes.INTEGER).getCount() +
                "\n Вещественные числа: " + stats.get(DataTypes.FLOAT).getCount()+
                "\n Строки: " + stats.get(DataTypes.STRING).getCount());
    }

    private static void printFullStats(Map<DataTypes,Stats> stats) {
        System.out.println("Полная статистика: ");

        Stats intStats = stats.get(DataTypes.INTEGER);
        if(intStats.getCount() > 0){
            System.out.println("\n Целые числа: " +
                    "\n Количество:" + intStats.getCount() +
                    "\n Минимальное:" + intStats.getMinInt() +
                    "\n Максимальное:" + intStats.getMaxInt() +
                    "\n Сумма:" + intStats.getSumInt() +
                    "\n Среднее:" + intStats.getAverageInt().setScale(5, RoundingMode.HALF_UP));
        }else{
            System.out.println("\nВ файле не было целых чисел");
        }

        Stats floatStats = stats.get(DataTypes.FLOAT);
        if(floatStats.getCount() > 0){
            System.out.println("\n Вещественные числа: " +
                    "\n Количество:" + floatStats.getCount() +
                    "\n Минимальное:" + floatStats.getMinFloat() +
                    "\n Максимальное:" + floatStats.getMaxFloat() +
                    "\n Сумма:" + floatStats.getSumFloat().setScale(5,RoundingMode.HALF_UP) +
                    "\n Среднее:" + floatStats.getAverageFloat().setScale(5, RoundingMode.HALF_UP));
        }else{
            System.out.println("\nВ файле не было вещественных чисел");
        }

        Stats stringStats = stats.get(DataTypes.STRING);
        if(stringStats.getCount() > 0){
            System.out.println("\n Строки: " +
                    "\n Количество:" + stringStats.getCount() +
                    "\n Минимальная длина:" + stringStats.getMinStringLength() +
                    "\n Максимальная длина:" + stringStats.getMaxStringLength());
        }else{
            System.out.println("\nВ файле не было строк");
        }
    }
}
