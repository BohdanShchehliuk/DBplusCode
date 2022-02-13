package Logic;

import DAO.impl.DaoPlaneImpl;
import entity.Cargo_Plane;
import entity.Passangers_Plane;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SortByDistance sortByDistance = new SortByDistance();

        System.out.println(sortByDistance.cargo_planes_sorded_by_distance());
        System.out.println(sortByDistance.passangers_planes_sorded_by_distance());

        General_tonnage general_tonnage = new General_tonnage();
        System.out.println(general_tonnage.toString());

        General_number_of_passangers general_number_of_passangers = new General_number_of_passangers();
        System.out.println(general_number_of_passangers.toString());


    }
}
