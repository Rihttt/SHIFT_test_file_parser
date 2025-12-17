package ru.riht;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Arguments {

    private Path outputPath = Paths.get(".");
    private String prefix = "";
    private boolean appendMode = false;
    private boolean shortStats = false;
    private boolean fullStats = false;
    private final List<String> inputFiles = new ArrayList<>();

}
