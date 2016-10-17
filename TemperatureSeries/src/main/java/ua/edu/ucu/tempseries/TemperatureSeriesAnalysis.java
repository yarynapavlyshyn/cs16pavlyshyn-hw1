package ua.edu.ucu.tempseries;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class TemperatureSeriesAnalysis {

    double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] TemperatureSeries) {
        temperatureSeries = TemperatureSeries;
    }

    public double average(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        } else {
            double average = 0.0, sum = 0.0;
            for(double num : temperatureSeries) {
                sum += num;
            }
            return (Math.round(sum / temperatureSeries.length * 100)) / 100;
        }
    }

    public double deviation(){
        double average = average();
        double deviat = 0.0;
        for (double num : temperatureSeries) {
            deviat += Math.pow((average - num), 2);
        }
        return Math.round(Math.sqrt(deviat/temperatureSeries.length)*100)/100;
    }


    public double min(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double min = temperatureSeries[0];
        for (double d : temperatureSeries) {
            if (d < min) min = d;
        }
        return min;
    }

    public double max(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double max = temperatureSeries[0];
        for (double d : temperatureSeries) {
            if (d > max) max = d;
        }
        return max;
    }


    public double findTempClosestToZero(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        } // else:
        double closest = Math.abs(temperatureSeries[0]);
        for (double num : temperatureSeries) {
            if (Math.abs(num) <= Math.abs(closest)) {
                closest = num;
                if (num == -closest) {closest = Math.abs(closest);}
            }
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < temperatureSeries.length; i++) {
            temperatureSeries[i] -= tempValue;
        }
        double result = (findTempClosestToZero() + tempValue);

        for (int i = 0; i < temperatureSeries.length; i++) {
            temperatureSeries[i] += tempValue;
        }
        return result;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        double[] numbers = new double[temperatureSeries.length];
        for (double num : temperatureSeries) {
            if (num < tempValue) {
                numbers[i] = num;
                i++;
            }
        }
        double[] result = new double[i];
        for (int j = 0; j < i; j++) {
            result[j] = numbers[j];
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        double[] numbers = new double[temperatureSeries.length];
        for (double num : temperatureSeries) {
            if (num > tempValue) {
                numbers[i] = num;
                i++;
            }
        }
        double[] result = new double[i];
        for (int j = 0; j < i; j++) {
            result[j] = numbers[j];
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics statistics = new TempSummaryStatistics(temperatureSeries);
        return statistics;
    }

    public int addTemps(double[] temps) {
        int freeSpaces = 0;
        double[] newTemps = new double[temperatureSeries.length];
        for (int i = 1; i < temperatureSeries.length; i++){
            if (temperatureSeries[temperatureSeries.length - i] == 0.0) {
                freeSpaces++;
            }
        if (freeSpaces < temps.length) {
            newTemps = new double[temperatureSeries.length + temps.length - freeSpaces];
            }
        }

        for (int i = 0; i < temperatureSeries.length - freeSpaces; i++) {
            newTemps[i] = temperatureSeries[i];
        }

        for (int j = temperatureSeries.length - freeSpaces, k = 0; k < temps.length; j++, k++) {
            if (temps[k] < -273) {
                newTemps = temperatureSeries;
                break;
            }
            newTemps[j] = temps[k];
        }
        temperatureSeries = newTemps;
        double sum = 0.0;
        for (double num : temperatureSeries) {
            sum += num;
        }
        return (int)(sum + 0.5d);
    }
}