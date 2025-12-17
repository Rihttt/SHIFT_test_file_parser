package ru.riht;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Getter
public class Stats {
    private long count = 0;

    private BigInteger minInt = null;
    private BigInteger maxInt = null;
    private BigInteger sumInt = BigInteger.ZERO;

    private Double minFloat = null;
    private Double maxFloat = null;
    private BigDecimal sumFloat = BigDecimal.ZERO;

    private Integer minStringLength = null;
    private Integer maxStringLength = null;

    public void addInteger (String value){
        try{
            BigInteger intValue = new BigInteger(value);
            count++;

            if(minInt == null || intValue.compareTo(minInt)<0){
                minInt = intValue;
            }

            if(maxInt == null || intValue.compareTo(minInt)>0){
                maxInt = intValue;
            }

            sumInt.add(intValue);
        }catch(NumberFormatException e){

        }
    }

    public void addFloat(String value) {
        try {
            double doubleValue = Double.parseDouble(value);
            BigDecimal decimalValue = new BigDecimal(value);
            count++;

            if (minFloat == null || doubleValue < minFloat) {
                minFloat = doubleValue;
            }
            if (maxFloat == null || doubleValue > maxFloat) {
                maxFloat = doubleValue;
            }
            sumFloat.add(decimalValue);
        } catch (NumberFormatException e) {

        }
    }

    public void addString(String value) {
        count++;
        int length = value.length();

        if (minStringLength == null || length < minStringLength) {
            minStringLength = length;
        }
        if (maxStringLength == null || length > maxStringLength) {
            maxStringLength = length;
        }
    }

    public BigDecimal getAverageInt(){
        if (count == 0) return BigDecimal.ZERO;
        return new BigDecimal(sumInt).divide(BigDecimal.valueOf(count), 1, RoundingMode.HALF_UP);
    }

    public BigDecimal getAverageFloat(){
        if (count == 0) return BigDecimal.ZERO;
        return sumFloat.divide(BigDecimal.valueOf(count), 10, RoundingMode.HALF_UP);
    }
}
