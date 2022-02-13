package Logic;

import DAO.impl.DaoPlaneImpl;
import entity.Cargo_Plane;
import lombok.Getter;
import java.util.List;

@Getter

public class General_tonnage {
    private double general_tonnage = 0;

    public General_tonnage() {
        this.general_tonnage = get_general_tonnage();
    }

    private double get_general_tonnage() {
        DaoPlaneImpl daoPlane = new DaoPlaneImpl();
        List<Cargo_Plane> list_all_cargo = daoPlane.getAll_cargo();

        for (Cargo_Plane plane : list_all_cargo
        ) {
            general_tonnage += plane.getTonnage();
        }
        return general_tonnage;
    }

    @Override
    public String toString() {
        return "General_tonnage{" +
                "general_tonnage=" + general_tonnage +
                '}';
    }
}
