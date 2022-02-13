package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cargo_Plane extends Plane{
    private double tonnage;

    public Cargo_Plane(int id, String type, String producer, String model,
                       double fuel_consumption_per_1000_km, double tank_volume, double tonnage) {
        super(id, type, producer, model, fuel_consumption_per_1000_km, tank_volume);
   this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return super.toString()+ "Cargo_Plane{" +
                "tonnage=" + tonnage +
                '}';
    }
}
