package Logic;

import DAO.impl.DaoPlaneImpl;
import entity.Cargo_Plane;
import entity.Passangers_Plane;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
public class General_number_of_passangers {

    private int general_number_of_passangers = 0;

    public General_number_of_passangers() {
        this.general_number_of_passangers = get_general_tonnage();
    }

    private int get_general_tonnage() {
        DaoPlaneImpl daoPlane = new DaoPlaneImpl();
        List<Passangers_Plane> list_all_passangers = daoPlane.getAll_passangers();
        for (Passangers_Plane plane : list_all_passangers
        ) {
            general_number_of_passangers += plane.getPassenger_capacity();
        }
        return general_number_of_passangers;
    }

    @Override
    public String toString() {
        return "General_number_of_passangers{" +
                "general_number_of_passangers=" + general_number_of_passangers +
                '}';
    }
}
