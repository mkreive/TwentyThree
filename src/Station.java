public class Station {
    public String code;
    public String name;
    public Coordinates coordinates;
    public Observation[] observations;


    @Override
    public String toString() {
        return "Station{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}






