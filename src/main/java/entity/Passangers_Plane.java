package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passangers_Plane extends Plane {
    private double passenger_capacity;

    public Passangers_Plane(int id, String type, String producer, String model, double fuel_consumption_per_1000_km, double tank_volume, double passenger_capacity) {
        super(id, type, producer, model, fuel_consumption_per_1000_km, tank_volume);
        this.passenger_capacity = passenger_capacity;
    }

    @Override
    public String toString() {
        return super.toString()+ "Passangers_Plane{" +
                "passenger_capacity=" + passenger_capacity +
                '}';
    }
}
