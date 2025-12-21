package ru.riht;

import java.util.EnumMap;
import java.util.Map;

public class StatsCollector {

    public static Map<DataTypes,Stats> createStats(){
        Map<DataTypes,Stats> stats = new EnumMap<>(DataTypes.class);

        stats.put(DataTypes.INTEGER, new Stats());
        stats.put(DataTypes.FLOAT, new Stats());
        stats.put(DataTypes.STRING, new Stats());
        return stats;
    }
}
