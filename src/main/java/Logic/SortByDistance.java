package Logic;

import DAO.impl.DaoPlaneImpl;
import entity.Cargo_Plane;
import entity.Passangers_Plane;
import entity.Plane;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByDistance implements Comparator<Plane> {

    public List<Passangers_Plane> passangers_planes_sorded_by_distance() {
        DaoPlaneImpl daoPlane = new DaoPlaneImpl();
        List<Passangers_Plane> list_all_passangers = daoPlane.getAll_passangers();
        Collections.sort(list_all_passangers, new SortByDistance());
        return list_all_passangers;
    }
    public List<Cargo_Plane> cargo_planes_sorded_by_distance() {
        DaoPlaneImpl daoPlane = new DaoPlaneImpl();
        List<Cargo_Plane> list_all_cargo = daoPlane.getAll_cargo();
        Collections.sort(list_all_cargo, new SortByDistance());
        return list_all_cargo;
    }


    @Override
    public int compare(Plane firstPlane, Plane secondPlane) {
        if (firstPlane.flight_distance() >= secondPlane.flight_distance()) {
            return 1;
        }
        if (firstPlane.flight_distance() <= secondPlane.flight_distance()) {
            return -1;
        } else
            return 0;
    }
}
