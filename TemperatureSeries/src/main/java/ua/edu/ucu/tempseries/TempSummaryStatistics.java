package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    double avgTemp;
    double devTemp;
    double minTemp;
    double maxTemp;
    public TempSummaryStatistics(double[] temperatureSeries) {
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temperatureSeries);
        avgTemp = analysis.average();
        devTemp = analysis.deviation();
        minTemp = analysis.min();
        maxTemp = analysis.max();

    }
    public String display() {
        String information = ("TEMPERATURE \naverage: "+ avgTemp + "\ndeviation: "+ devTemp + "\nmin: "+ minTemp);
        return information;
    }
    public static void main(String[] args) {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TempSummaryStatistics statistics = new TempSummaryStatistics(temperatureSeries);
        System.out.print(statistics.display());
    }
    
}
