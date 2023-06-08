public class Observation {
    public String observationTimeUtc;
    public double airTemperature;
    public double feelsLikeTemperature;
    public double windSpeed;
    public double windGust;
    public int windDirection;
    public int cloudCover;
    public double seaLevelPressure;
    public int relativeHumidity;
    public double precipitation;
    public String conditionCode;
    public String icon;

    @Override
    public String toString() {
        return """
                %s  %.2f°C  %s
                """.formatted(observationTimeUtc, airTemperature, icon);

//
//        return "Observation{" +
//                "observationTimeUtc='" + observationTimeUtc + '\'' +
//                ", airTemperature=" + airTemperature +
//                ", feelsLikeTemperature=" + feelsLikeTemperature +
//                ", windSpeed=" + windSpeed +
//                ", windGust=" + windGust +
//                ", windDirection=" + windDirection +
//                ", cloudCover=" + cloudCover +
//                ", seaLevelPressure=" + seaLevelPressure +
//                ", relativeHumidity=" + relativeHumidity +
//                ", precipitation=" + precipitation +
//                ", conditionCode='" + conditionCode + '\'' +
//                '}';
    }
}
