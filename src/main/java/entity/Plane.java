package entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Plane implements Plane_methods{

    private int id;
    private String type;
    private String producer;
    private String model;
    private double fuel_consumption_per_1000_km;
    private double tank_volume;

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", fuel_consumption_per_1000_km=" + fuel_consumption_per_1000_km +
                ", tank_volume=" + tank_volume +
                '}';
    }

    public Plane(int id, String type, String producer, String model, double fuel_consumption_per_1000_km, double tank_volume) {
        this.id = id;
        this.type = type;
        this.producer = producer;
        this.model = model;
        this.fuel_consumption_per_1000_km = fuel_consumption_per_1000_km;
        this.tank_volume = tank_volume;
    }

    @Override
    public double flight_distance() {
               return tank_volume/fuel_consumption_per_1000_km*100;
    }
}
