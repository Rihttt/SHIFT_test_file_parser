package ru.riht;

import lombok.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arguments {

    @Setter(AccessLevel.NONE)
    private Path outputPath = Paths.get(".");
    private String prefix = "";
    private boolean appendMode = false;
    private boolean shortStats = false;
    private boolean fullStats = false;
    private final List<String> inputFiles = new ArrayList<>();

    public void setOutputPath(String outputPath) {
        this.outputPath = Paths.get(outputPath);
    }

    public void addInputFile(String inputFile) {
        this.inputFiles.add(inputFile);
    }

    public boolean hasInputFiles() {
        return !inputFiles.isEmpty();
    }
}
