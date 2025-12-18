package ru.riht;

public class ArgumentParser {

    public static Arguments parse(String[] args) {
        Arguments arguments = new Arguments();

        for (int i=0; i<args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if(i+1<args.length && !args[i+1].startsWith("-")) {
                        arguments.setOutputPath(args[++i]);
                        System.out.println("Аргумент -о обработан");
                    }else{
                        throw new IllegalArgumentException("Отсутствует путь для файлов вывода");
                    }
                    break;
                case "-p":
                    if(i+1<args.length && !args[i+1].startsWith("-")) {
                        arguments.setPrefix(args[++i]);
                        System.out.println("Аргумент -p обработан");
                    }else{
                        throw new IllegalArgumentException("Отсутствует префикс");
                    }
                    break;
                case "-a":
                    arguments.setAppendMode(true);
                    System.out.println("Аргумент -a обработан");
                    break;
                case "-s":
                    arguments.setShortStats(true);
                    System.out.println("Аргумент -s обработан");
                    break;
                case "-f":
                    arguments.setFullStats(true);
                    System.out.println("Аргумент -f обработан");
                    break;
                default:
                    if(args[i].startsWith("-")){
                        throw new IllegalArgumentException("неизвестная опция: " + args[i]);
                    }
                    arguments.addInputFile(args[i]);
                    System.out.println("Входной файл обработан: " + args[i]);
                    break;
            }
        }

        if(!arguments.hasInputFiles()){
            throw new IllegalArgumentException("Не указаны входные файлы");
        }

        return arguments;
    }
}
